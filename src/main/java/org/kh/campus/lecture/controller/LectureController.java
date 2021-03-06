package org.kh.campus.lecture.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.kh.campus.board.domain.University;
import org.kh.campus.lecture.domain.Lecture;
import org.kh.campus.lecture.service.LectureService;
import org.kh.campus.notice.domain.Notice;
import org.kh.campus.professor.domain.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class LectureController {
	@Autowired
	private LectureService lService;

	// 수강개설 조회
	@RequestMapping(value = "/lecture/list.kh", method = RequestMethod.GET)
	public String lectureListView(Model model) {
		List<Lecture> lList = lService.printAllLecture();
		if (!lList.isEmpty()) {
			model.addAttribute("lList", lList);
			model.addAttribute("menu", "lecture");
			return "lecture/lectureListView";
		} else {
			model.addAttribute("msg", "과목개설 실패");
			return "common/errorPage";
		}

	}

	@ResponseBody
	@RequestMapping(value = "/lecture/list2.kh", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String enrollListView2(@RequestParam(value = "lecturedep", required = false) String lectureDepartment) {
		try {
			if (lectureDepartment.contentEquals("1")) {
				lectureDepartment = "컴퓨터공학과";
			} else if (lectureDepartment.contentEquals("2")) {
				lectureDepartment = "전기전자학과";
			} else if (lectureDepartment.contentEquals("3")) {
				lectureDepartment = "산업디자인학과";
			} else if (lectureDepartment.contentEquals("4")) {
				lectureDepartment = "중국어학과";
			} else if (lectureDepartment.contentEquals("5")) {
				lectureDepartment = "유비쿼터스학과";
			} else if (lectureDepartment.contentEquals("6")) {
				lectureDepartment = "국어국문학과";
			} else {
				lectureDepartment = "전체";
			}
			List<Lecture> lList = lService.printAlllecture2(lectureDepartment);
			if (!lList.isEmpty()) {
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
				System.out.println(lList.toString() + "involve");
				return gson.toJson(lList);

			} else {
				System.out.println("실패했습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	// 수강개설 페이지
	@RequestMapping(value = "/lecture/writeView.kh", method = RequestMethod.GET)
	public String lectureWriteView(Model model) {
		List<Professor> pList = lService.PrintAllUni();

		if (!pList.isEmpty()) {
			model.addAttribute("menu", "lecture");
			model.addAttribute("pList", pList);
		}
		return "lecture/lectureWriteView";
	}

	// 셀렉트박스
	@ResponseBody
	@RequestMapping(value = "/lecture/selectProfessor", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String lectureProList(@RequestParam("lectureDepartment") String lectureDepartment) {
		List<Professor> pList = lService.printAllProName(lectureDepartment);

		if (!pList.isEmpty()) {
			Gson gson = new Gson();
			return gson.toJson(pList);
		}

		return null;
	}

	// 교수번호
	@ResponseBody
	@RequestMapping(value = "/lecture/selectProfessorNo", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String lectureProNo(@RequestParam("professorName") String professorName) {
		List<Professor> pList = lService.printAllProNo(professorName);

		if (!pList.isEmpty()) {
			Gson gson = new Gson();
			return gson.toJson(pList);
		}

		return null;
	}

	// 수강 개설 등록 실행
	@RequestMapping(value = "/lecture/register.kh", method = RequestMethod.POST)
	public String lectureRegister(Model model, @ModelAttribute Lecture lecture) {
		int result = lService.registerLecture(lecture);
		if (result > 0) {

			return "redirect:/lecture/list.kh";
		} else {
			model.addAttribute("msg", "과목개설 실패");
			return "common/errorPage";
		}
	}

	// 강의 수정 페이지
	@RequestMapping(value = "/lecture/modifyView.kh", method = RequestMethod.GET)
	public ModelAndView lectureModify(ModelAndView mv, @RequestParam("lectureNo") int lectureNo) {
		try {
			Lecture lecture = lService.printOneLecture(lectureNo);
			if (lecture != null) {
				List<Professor> pList = lService.PrintAllUni();
				mv.addObject("pList", pList);
				mv.addObject("lecture", lecture);
				mv.addObject("menu", "lecture");
				mv.setViewName("lecture/lectureUpdateView");
			} else {
				System.out.println("데이터 없음");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return mv;
	}

	// 강의 수 정 실 행
	@RequestMapping(value = "/lecture/update.kh", method = RequestMethod.POST)
	public ModelAndView lectureUpdate(ModelAndView mv, @ModelAttribute Lecture lecture, HttpServletRequest request) {
		try {
			int result = lService.modifyLecture(lecture);
			if (result > 0) {
				mv.setViewName("redirect:/lecture/Detail.kh?lectureNo=" + lecture.getLectureNo());
			} else {
				mv.addObject("msg", "수강개설 수정 실패!");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("common/errorPage");
		}

		return mv;
	}

	// 강의 상세 조회
	@RequestMapping(value = "/lecture/Detail.kh", method = RequestMethod.GET)
	public String lectureDetail(Model model, @RequestParam("lectureNo") int lectureNo) {
		Lecture lecture = lService.printOneLecture(lectureNo);
		if (lecture != null) {
			model.addAttribute("lecture", lecture);
			model.addAttribute("menu", "lecture");
			return "lecture/lectureDetailView";
		} else {
			model.addAttribute("msg", "디테일 조회 실패");
			return "common/errorPage";
		}
	}

	// 강의 삭제
	@RequestMapping(value = "/lecture/remove.kh", method = RequestMethod.GET)
	public String lectureRemove(Model model, @RequestParam("lectureNo") int lectureNo) {
		try {
			int result = lService.removeLecture(lectureNo);
			if (result > 0) {
				return "redirect:/lecture/list.kh";
			} else {
				model.addAttribute("msg", "과목 삭제 실패");
				return "common/errorPage";
			}

		} catch (Exception e) {
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}

	// 수강 기간 설정

	@RequestMapping(value = "/lecture/lecturePeriod.kh", method = RequestMethod.POST)
	public ModelAndView lecturePeriod(ModelAndView mv, @ModelAttribute Lecture lecture) {
		int result = lService.modifyPeriod(lecture);
		if (result > 0) {
			mv.setViewName("redirect:/lecture/list.kh");
		} else {
			mv.addObject("msg", "기간 부여 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}

}
