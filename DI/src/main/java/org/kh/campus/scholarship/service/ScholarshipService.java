package org.kh.campus.scholarship.service;

import java.util.List;

import org.kh.campus.scholarship.domain.Scholarship;

public interface ScholarshipService {
	
	public List<Scholarship>printAllScholar(); //������ ��û���б� ��� ��ȸ
	public int insertScholar(Scholarship scholarship); //�������б� ��û
	public List<Scholarship> printScholarResult(); //��û���б� �����ȸ
	public int registerScholar(Scholarship scholarship); //������ �������б� ��� 


	

}
