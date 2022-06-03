package org.kh.campus.consultant.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.campus.consultant.domain.Consultant;
import org.kh.campus.consultant.domain.ConsultantReply;
import org.kh.campus.consultant.domain.PageInfo;
import org.kh.campus.consultant.domain.Pagination;
import org.kh.campus.consultant.service.ConsultantService;
import org.kh.campus.manager.domain.Manager;
import org.kh.campus.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class ConsultantController {
	@Autowired
	private ConsultantService cService;
	
	//�л� ����û ��� ��ȸ
	@RequestMapping(value="/consultant/list.kh", method=RequestMethod.GET)
	public String consultantListView(Model model, HttpServletRequest request, @RequestParam(value = "page", required = false) Integer page) {
		try {
		HttpSession session = request.getSession();
		int cons_student_no = ((Student)(session.getAttribute("loginUser"))).getStudentNo();
		int currentPage = (page != null) ? page : 1;
		int totalCount = cService.getListCount();
		
		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
		List<Consultant> cList = cService.printAllCons(cons_student_no , pi);
		
		if(!cList.isEmpty()) {
			model.addAttribute("cList", cList);
			model.addAttribute("pi", pi);
			model.addAttribute("menu", "consultant");
			model.addAttribute("currentPage", currentPage);
		
		}else {
			model.addAttribute("cList", null);
			}
			return "consultant/consultantListView";
		}catch(Exception e) {
			model.addAttribute("msg", "�����ȸ ����");
			return "common/errorPage";
		}
		
	}
	
	//�л� ����û ���
	@RequestMapping(value="/consultant/writeView.kh", method=RequestMethod.GET)
	public String consultantWriteView(Model model) {
		model.addAttribute("menu", "consultant");
		return "consultant/consultantWriteForm";
		
	}

	//�л� ����û ��� ����
	@RequestMapping(value="/consultant/register.kh", method=RequestMethod.POST)
	public String consultantRegister(Model model, @ModelAttribute Consultant consultant,
			HttpServletRequest request) {
		
		int result = cService.insertCons(consultant);
	
		if(result >0) {
			HttpSession session = request.getSession();
			int studentNo = ((Student)(session.getAttribute("loginUser"))).getStudentNo();
		
		Consultant studentOne = cService.printOneByStNo(studentNo);
			if(studentOne != null) {
			model.addAttribute("consultant", studentOne);
			return "redirect:/consultant/list.kh";	
			}else {
				model.addAttribute("msg", "��Ͻ���");
				return "common/errorPage";
			}
		  }else {
			model.addAttribute("msg", "����û ��� ����");
			return "common/errorPage";
	
		}
		
	}
	
	//�л� ����û ����ȸ
	@RequestMapping(value="/consultant/Detail.kh", method=RequestMethod.GET)
	public String consultantDetailView(Model model, @RequestParam("cons_student_no")int cons_student_no, @RequestParam("cons_no") int cons_no) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("cons_student_no", cons_student_no);
		map.put("cons_no", cons_no);
		Consultant consultant = cService.printDetailCons(map);
		if(consultant != null) {
			model.addAttribute("consultant", consultant);
			model.addAttribute("menu", "consultant");
			return "consultant/consultantDetailView";		
		}else {
			model.addAttribute("msg", "������ ��� ��ü ��ȸ ����");
			return "common/errorPage";
		}
	}
	
	//�л� ����û ���
	@RequestMapping(value="/consultant/cancel.kh", method=RequestMethod.GET)
	public String consultantCancel(Model model, @RequestParam("cons_no") int cons_no,
			HttpServletRequest request) {
		
		int consultantReply = cService.countReply(cons_no);
		if(consultantReply < 1) {
			int result = cService.printByNo(cons_no);
		 if(result >0) {
			 
			 return "redirect:/consultant/list.kh";
		 }else {
			 model.addAttribute("msg", "������ ����");
				return "common/errorPage";
		 }
		 
		}else {
			request.setAttribute("message", "�����Ҹ� �� �� �����ϴ�."); 
			request.setAttribute("url", "/consultant/list.kh");
			return "common/message";
		}
	}
	
	//������ ����û ��� ��ȸ
	@RequestMapping(value="/consultant/adlist.kh", method=RequestMethod.GET)
	public String consultantAdminListView(Model model, @RequestParam(value = "page", required = false) Integer page,  HttpServletRequest request) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = cService.getListCount();
		HttpSession session = request.getSession();
		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
		int studentNo = ((Manager)(session.getAttribute("loginManager"))).getManagerNo();
		List<Consultant>cList = cService.printAdminAllCons(pi, studentNo);
		if(!cList.isEmpty()) {
			model.addAttribute("cList", cList);
			model.addAttribute("pi", pi);
			model.addAttribute("menu1", "consultant1");
			model.addAttribute("currentPage", currentPage);
			return "consultant/consultantAdminListView";
		}else {
			model.addAttribute("msg", "��� ��ü ��ȸ ����");
			return "common/errorPage";
		}
	}
	
	//������ ����û ����ȸ
	@RequestMapping(value="/consultant/adDetail.kh", method=RequestMethod.GET)
	public String consultantAdminDetailView(Model model,  @RequestParam("consultant_no")Integer consultant_no) {	
		Consultant consultant = cService.printAdminDetailCons(consultant_no);
		if(consultant != null) {
			model.addAttribute("consultant", consultant);
			model.addAttribute("menu1", "consultant1");
			return "consultant/consultantAdminDetailView";		
		}else {
			model.addAttribute("msg", "������ ��� ������ ��ȸ ����");
			return "common/errorPage";
		}
		
		
	}
	
	//������ ����û ��� ���
	@ResponseBody
	@RequestMapping(value="/consultant/replyAdd.kh", method=RequestMethod.POST) 
	public String consultantAdminWriteReply(Model model, @ModelAttribute ConsultantReply consultantreply) {
		int result = cService.insertAdminConsReply(consultantreply);
		if(result >0) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	//������ �� �л� ����û ��� ��ȸ
	@ResponseBody
	@RequestMapping(value="/consultant/replyList.kh", method=RequestMethod.GET,
		produces="application/json;charset=utf-8")
	public String consultantAdminReplyList(@RequestParam("cons_no")int cons_no) {
		List<ConsultantReply>crList = cService.printAllAdminReply(cons_no);
		if(!crList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			return gson.toJson(crList);
		}
		return null;
	}
	
	//������ �����Ȳ ����
	@ResponseBody
	@RequestMapping(value="/consultant/statusChange.kh" , method=RequestMethod.POST)
	 	public String consultantStatusUpdate(@RequestParam("cons_no") int cons_no, Model model) {
		int result = cService.modifyStatus(cons_no);
		if(result >0) {
			return "success";
		}else {
			
			return "fail";
		}
	}
	
	//����  ���� ��������
		@ResponseBody
		@RequestMapping(value = "/consultant/JoinViewCounselor.kh", method=RequestMethod.GET, produces="application/json;charset=utf-8")
		public String consJoinViewCounselor(Model model) throws UnsupportedEncodingException {
			List<Manager> mList = cService.printAllManager();
			if(!mList.isEmpty()) {
				
				
				return new Gson().toJson(mList);
			}
			
			return null;
		}
		
		
		
}
