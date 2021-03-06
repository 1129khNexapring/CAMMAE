package org.kh.campus.attendance.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.campus.attendance.domain.Attendance;
import org.kh.campus.attendance.store.AttendanceStore;
import org.springframework.stereotype.Repository;

@Repository
public class AttendanceStoreLogic implements AttendanceStore {

	@Override
	public List<Attendance> selectAttStudent(SqlSession sqlSession, HashMap<String, String> attInfo) {
		List<Attendance>aList = sqlSession.selectList("AttendanceMapper.selectAttStudent", attInfo);
		return aList;
	}

	@Override
	public List<Attendance> selectAttProf(SqlSession sqlSession, HashMap<String, String> attInfo) {
		List<Attendance>aList = sqlSession.selectList("AttendanceMapper.selectAttProf", attInfo);
		return aList;
	}

	@Override
	public List<Attendance> selectAttProfSearchStu(SqlSession sqlSession, HashMap<String, String> attInfo) {
		List<Attendance>aList = sqlSession.selectList("AttendanceMapper.selectAttProfSearchStu", attInfo);
		return aList;
	}

	@Override
	public int insertAttendance(SqlSession sqlSession, Attendance attendance) {
		int result = sqlSession.insert("AttendanceMapper.insertAttendance", attendance);
		return result;
	}

	@Override
	public List<Attendance> selectAttendanceStuInfo(SqlSession sqlSession, HashMap<String, String> attInfo) {
		 List<Attendance> aList = sqlSession.selectList("AttendanceMapper.selectAttendanceStuInfo", attInfo);
		return aList;
	}

	@Override
	public List<Attendance> selectAttProfIssue(SqlSession sqlSession, HashMap<String, String> attInfo) {
		 List<Attendance> aList = sqlSession.selectList("AttendanceMapper.selectAttProfIssue", attInfo);
		 return aList;
	}

	@Override
	public int updateObjectChange(SqlSession sqlSession, int attNo) {
		int result = sqlSession.update("AttendanceMapper.updateObjectChange", attNo);
		return result;
	}

	@Override
	public int updateStatus(SqlSession sqlSession, Attendance attendance) {
		int result = sqlSession.update("AttendanceMapper.updateStatus", attendance);
		return result;
	}

	@Override
	public int selectCount(SqlSession sqlSession, Attendance attendance) {
		int result = sqlSession.selectOne("AttendanceMapper.selectCount", attendance);
		return result;
	}

	@Override
	public List<Attendance> selectAttProfAllSearchStu(SqlSession sqlSession, HashMap<String, String> attInfo) {
		List<Attendance> aList= sqlSession.selectList("AttendanceMapper.selectAttProfAllSearchStu", attInfo);
		return aList;
	}

}
