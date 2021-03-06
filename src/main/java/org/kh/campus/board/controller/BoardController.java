package org.kh.campus.board.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.campus.board.domain.Board;
import org.kh.campus.board.domain.BoardReply;
import org.kh.campus.board.domain.PageInfo;
import org.kh.campus.board.domain.Pagination;
import org.kh.campus.board.domain.University;
import org.kh.campus.board.service.BoardService;
import org.kh.campus.professor.domain.Professor;
import org.kh.campus.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;

	// 게시판 목록 조회
	@RequestMapping(value = "/board/list.kh", method = RequestMethod.GET)
	public ModelAndView boardListView(ModelAndView mv, @RequestParam(value = "page", required = false) Integer page
			,HttpSession session
			, @RequestParam(value = "universityCode", required = false) String universityCode
			, @ModelAttribute PageInfo pageInfo) {
		/*
		 * Student student = (Student)session.getAttribute("loginUser"); Professor
		 * professor = (Professor)session.getAttribute("loginProfessor");
		 */
		
		if(session.getAttribute("loginUser")!=null) {
			String universityCodeStd = ((Student)(session.getAttribute("loginUser"))).getUniversityCode();
			universityCode = (universityCode != null) ? universityCode : universityCodeStd;	
		} else if(session.getAttribute("loginProfessor")!=null) {
			String universityCodePrf = ((Professor)(session.getAttribute("loginProfessor"))).getUniversityCode();
			universityCode = (universityCode != null) ? universityCode : universityCodePrf;	
		}
		
		
		int currentPage = (page != null) ? page : 1;
		System.out.println(universityCode+"test");
		int totalCount = service.getListCount(pageInfo);
		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
		List<University> uList = service.printAllUniversity();
		pi.setUniversityCode(universityCode);
		pi.setSearchCondition(pageInfo.getSearchCondition());
		pi.setSearchValue(pageInfo.getSearchValue());
		try {
			List<Board> bList = service.printAllBoard(pi);
			if (!bList.isEmpty()) {
				mv.addObject("bList", bList);
				mv.setViewName("board/boardList");
				mv.addObject("menu", "board");
				mv.addObject("currentPage", currentPage);
				mv.addObject("pi", pi);
				mv.addObject("uList", uList);
				mv.addObject("universityCode", universityCode);

			} else {
				mv.setViewName("board/boardList");
			}
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("commmon/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value = "/board/unlist.kh", method = RequestMethod.GET)
	public ModelAndView boarUnList(ModelAndView mv,
			HttpSession session ) {
			
		try {
			if (session.getAttribute("loginUser")!=null) {
				String universityCodeStd = ((Student)(session.getAttribute("loginUser"))).getUniversityCode();
				mv.setViewName("redirect:/board/list.kh?universityCode="+universityCodeStd);
				
			} else if (session.getAttribute("loginProfessor")!=null){
				String universityCodePrf = ((Professor)(session.getAttribute("loginProfessor"))).getUniversityCode();
				mv.setViewName("redirect:/board/list.kh?universityCode="+universityCodePrf);
			} 
			
			else {
			List<University> uList = service.printAllUniversity();
			if (!uList.isEmpty()) {
				mv.addObject("uList", uList);
				mv.setViewName("board/boardUnList2");
				mv.addObject("menu", "board");
			} else {
				mv.addObject("msg", "학과게시판 조회 실패");
				mv.setViewName("common/errorPage");
			}
			}
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("commmon/errorPage");
		}
		return mv;
	
	}
	// 게시판 상세 조회
	@RequestMapping(value = "/board/detail.kh", method = RequestMethod.GET)
	public ModelAndView boardOneView(ModelAndView mv
			, @RequestParam("boardNo") int boardNo
			, @RequestParam(value = "universityCode", required = false) String universityCode) {
		try {
			Board board = service.printOneBoard(boardNo);
			if (board != null) {
				service.boardCountUpdate(board.getBoardNo());
				mv.addObject("menu", "board");
				mv.addObject("universityCode", universityCode);
				mv.addObject("board", board);
				mv.setViewName("board/board");
				
			} else {
				mv.addObject("msg", " 학과게시판 상세조회 실패");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}

	// 학과게시판 검색기능

	/*
	 * @RequestMapping(value = "/board/search.kh", method = RequestMethod.GET)
	 * public ModelAndView boardSearchList(ModelAndView mv, @ModelAttribute Search
	 * search) { try { List<Board> searchList = service.printSearchBoard(search); if
	 * (!searchList.isEmpty()) { mv.addObject("bList", searchList);
	 * mv.setViewName("board/boardList"); } } catch (Exception e) {
	 * mv.addObject("msg", e.toString()); mv.setViewName("common/errorPage"); }
	 * return mv; }
	 */
	// 학과게시판 등록화면
	@RequestMapping(value = "/board/writeView.kh")
	public String boardWriteView(Model model) {
		model.addAttribute("menu", "board");
		return "board/boardWriteForm";
	}

	// 게시판(DB)
	@RequestMapping(value = "/board/register.kh", method = RequestMethod.POST)
	public ModelAndView boardRegister(ModelAndView mv, @ModelAttribute Board board,
			@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile,
			HttpServletRequest request, HttpSession session) {
		try {
			if (uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
				HashMap<String, String> fileMap = saveFile(uploadFile, request);
				String filePath = fileMap.get("filePath");
				String fileRename = fileMap.get("fileName");
				if (filePath != null && !filePath.equals("")) {
					board.setBoardFilename(uploadFile.getOriginalFilename());
					board.setBoardFilerename(fileRename);
					board.setBoardFilepath(filePath);
				}

			}
			String universityCode = ((Student)(session.getAttribute("loginUser"))).getUniversityCode();
			board.setUniversityCode(universityCode);
			int result = service.registerBoard(board);
			if (result > 0) {
				mv.setViewName("redirect:/board/list.kh?universityCode="+universityCode);
			} else {
				mv.addObject("msg", "게시글 등록 실패");
				mv.setViewName("common.errorPage");
			}
		} catch (Exception e) {
			mv.setViewName("common/errorPage");
			mv.addObject("msg", e.toString());
		}
		return mv;

	}

	private HashMap<String, String> saveFile(MultipartFile uploadFile, HttpServletRequest request) {
		String filePath = "";
		HashMap<String, String> fileMap = new HashMap<String, String>();
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\boardUploadFiles";
		File folder = new File(savePath);
		if (!folder.exists())
			folder.mkdir();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originalFileName = uploadFile.getOriginalFilename();
		String extensionName = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
		String renameFileName = sdf.format(new Date(System.currentTimeMillis())) + "." + extensionName;
		filePath = folder + "\\" + renameFileName;
		fileMap.put("filePath", filePath);
		fileMap.put("fileName", renameFileName);
		try {
			uploadFile.transferTo(new File(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileMap;
	}

	// 게시판 수정(화면)
	@RequestMapping(value = "/board/modifyView.kh", method = RequestMethod.GET)
	public String boardModifyView(Model model, @RequestParam("boardNo") int boardNo) {
		try {
			Board board = service.printOneBoard(boardNo);
			if (board != null) {
				model.addAttribute("menu","board");
				model.addAttribute("board", board);
				return "board/boardUpdateView";
			} else {
				model.addAttribute("msg", "No Data Found!");
				return "common/errorPage";
			}

		} catch (Exception e) {
			model.addAttribute("msg", e.toString());
			return "common.errorPage";
		}
	}

	// 수정
	@RequestMapping(value="/board/update.kh", method=RequestMethod.POST)
	public ModelAndView boardUpdate(
			ModelAndView mv
			, @ModelAttribute Board board
			, @RequestParam(value="reloadFile", required=false) MultipartFile reloadFile
			, HttpServletRequest request) {
		try {
			if(reloadFile != null && !reloadFile.isEmpty()) {
			deleteFile(board.getBoardFilepath(), request);
			HashMap<String, String> fileMap = saveFile(reloadFile, request);
			String savePath = fileMap.get("filePath");
			String fileRename = fileMap.get("fileName");
			if(savePath != null) {
				board.setBoardFilename(reloadFile.getOriginalFilename());
				board.setBoardFilerename(fileRename);
				board.setBoardFilepath(savePath);
			}
			}
		int result = service.modifyBoard(board);
		if(result > 0) {
			mv.setViewName("redirect:/board/detail.kh?boardNo="+board.getBoardNo());
		}else {
			mv.addObject("msg", "공지사항 수정실패");
			mv.setViewName("common/errorPage");
		}
		}catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}
		return mv;
			}

	private void deleteFile(String boardFilepath, HttpServletRequest request) {
		File deleteFile = new File(boardFilepath);
		if(deleteFile.exists()) {
			deleteFile.delete();
		}
	}
	@RequestMapping(value="/board/delete.kh", method=RequestMethod.GET)
	public String boardDelete(
			Model model
			, @RequestParam("boardNo") int boardNo) {
		try {
			int result = service.removeBoard(boardNo);
			if(result > 0) {
				return "redirect:/board/list.kh";
			}else {
				model.addAttribute("msg", "게시판 삭제 실패");
				return "common/errorPage";
			}
		}catch(Exception e) {
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	//게시판 댓글 입력
	@ResponseBody
	@RequestMapping(value="/board/replyAdd.kh", method=RequestMethod.POST)
	public String boardReplyAdd(
			@ModelAttribute BoardReply boardReply) {
		
		int result = service.registerBoardReply(boardReply);
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
	}
	//댓글 삭제
	@ResponseBody
	@RequestMapping(value="/board/deleteAdd.kh", method=RequestMethod.GET)
	public String boardReplyDelete(@ModelAttribute BoardReply boardReply) {
		int result = service.removeBoardReply(boardReply);
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/board/replyList.kh", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String boardReplyList(@RequestParam("boardNo") int boardNo) {
		List<BoardReply> bList = service.printAllBoardReply(boardNo);
		if (!bList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			return gson.toJson(bList);
		}
		return null;
	}

	//댓글 수정
	@ResponseBody
	@RequestMapping(value = "/board/replyModify", method = RequestMethod.POST)
	public String boardReplyModify(@ModelAttribute BoardReply boardReply) {
		int result = service.modifyBoardReply(boardReply);
		if (result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}
}