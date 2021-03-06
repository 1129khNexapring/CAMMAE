package org.kh.campus.login.store;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.kh.campus.manager.domain.Manager;
import org.kh.campus.professor.domain.Professor;
import org.kh.campus.student.domain.Student;

public interface LoginStore {

	public Student selectStudent(SqlSession sqlSession, Student student);

	public Professor selectProfessor(SqlSession sqlSession, Professor professor);

	public Manager selectManager(SqlSession sqlSession, Manager manager);

	// 이메일 가져오기
	public String selectPwdStd(SqlSession sqlSession, HashMap<String, String> userInfo);
	public String selectPwdPrf(SqlSession sqlSession, HashMap<String, String> userInfo);
	public String selectPwdMag(SqlSession sqlSession, HashMap<String, String> userInfo);


	public int stdPwdSame(SqlSession sqlSession, HashMap<String, String> map);

	public int prfPwdSame(SqlSession sqlSession, HashMap<String, String> map);

	public int magPwdSame(SqlSession sqlSession, HashMap<String, String> map);

	public int stdPwdChange(SqlSession sqlSession, HashMap<String, String> map);

	public int prfPwdChange(SqlSession sqlSession, HashMap<String, String> map);

	public int magPwdChange(SqlSession sqlSession, HashMap<String, String> map);
}
