package org.kh.campus.consultant.service;

import java.util.List;

import org.kh.campus.common.PageInfo;
import org.kh.campus.consultant.domain.Consultant;
import org.kh.campus.consultant.domain.ConsultantReply;

public interface ConsultantService {
	
	public List<Consultant>printAllCons(PageInfo pi); // ��� ��ü��ȸ
	public int insertCons(Consultant consultant); //����û
	public Consultant printDetailCons(String consultant_title); //��� ������
	public List<ConsultantReply> printByConReply(PageInfo pi); //��� �����ȸ
	public List<Consultant>printAdminAllCons(PageInfo pi); //������ ����û ��� ��ȸ
	public Consultant printAdminDetailCons(String consultant_title); //������ ����û ������ 
	public int insertAdminConsReply(ConsultantReply consultantReply); //������ ��� �ۼ�
	public int getListCount();
	
	

}
