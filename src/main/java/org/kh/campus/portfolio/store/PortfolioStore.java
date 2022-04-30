package org.kh.campus.portfolio.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.campus.portfolio.domain.Portfolio;

public interface PortfolioStore {

	public List<Portfolio> selectAllPort(SqlSession sqlSession);
	public int insertPort(SqlSession sqlSession, Portfolio portfolio);
	public Portfolio selectDetailPort(SqlSession sqlSession, String port_title);
	public int updatePort(SqlSession sqlSession, String port_title);
	public int deletePort(SqlSession sqlSession, String port_title);
	public List<Portfolio> selectAdminAllPort(SqlSession sqlSession);
	public Portfolio selectprintAdminDetailPort(SqlSession sqlSession, int port_no);
	public int selectListCount(SqlSession sqlSession);
	public Portfolio selectprintDetailPort(SqlSession sqlSession, int port_no);
	public Portfolio selectprintOneByNo(SqlSession sqlSession, Integer port_no);
	public int updatePortfolio(SqlSession sqlSession);
	public int deletePortfolio(SqlSession sqlSession, int port_no);
	public Portfolio selectBySt(SqlSession sqlSession, int studentNo);
	

}
