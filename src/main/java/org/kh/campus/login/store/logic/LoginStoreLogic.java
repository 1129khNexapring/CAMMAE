package org.kh.campus.login.store.logic;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.kh.campus.login.store.LoginStore;
import org.kh.campus.manager.domain.Manager;
import org.kh.campus.professor.domain.Professor;
import org.kh.campus.student.domain.Student;
import org.springframework.stereotype.Repository;

@Repository
public class LoginStoreLogic implements LoginStore {

	@Override
	public int selectStudent(SqlSession sqlSession, Student student) {
		int result = sqlSession.selectOne("LoginMapper.studentLogin", student);
		return result;
	}

	@Override
	public int selectProfessor(SqlSession sqlSession, Professor professor) {
		int result = sqlSession.selectOne("LoginMapper.professorLogin", professor);
		return result;
	}

	@Override
	public int selectManager(SqlSession sqlSession, Manager manager) {
		int result = sqlSession.selectOne("LoginMapper.managerLogin", manager);
		return result;
	}

	@Override
	public String selectPwdStd(SqlSession sqlSession, Student std) {
		String result = sqlSession.selectOne("LoginMapper.selectPwdStd", std);
		return result;
	}
	
	// 타입에 따라 비번 일치 여부
	@Override
	public int stdPwdSame(SqlSession sqlSession, HashMap<String, String> map) {
		int result = sqlSession.selectOne("LoginMapper.stdPwdSame", map);
		return result;
	}

	@Override
	public int prfPwdSame(SqlSession sqlSession, HashMap<String, String> map) {
		int result = sqlSession.selectOne("LoginMapper.prfPwdSame", map);
		return result;
	}

	@Override
	public int magPwdSame(SqlSession sqlSession, HashMap<String, String> map) {
		int result = sqlSession.selectOne("LoginMapper.magPwdSame", map);
		return result;
	}

	@Override
	public int stdPwdChange(SqlSession sqlSession, HashMap<String, String> map) {
		int result = sqlSession.update("LoginMapper.stdPwdChange", map);
		return result;
	}

	@Override
	public int prfPwdChange(SqlSession sqlSession, HashMap<String, String> map) {
		int result = sqlSession.update("LoginMapper.prfPwdChange", map);
		return result;
	}

	@Override
	public int magPwdChange(SqlSession sqlSession, HashMap<String, String> map) {
		int result = sqlSession.update("LoginMapper.magPwdChange", map);
		return result;
	}
	
}
