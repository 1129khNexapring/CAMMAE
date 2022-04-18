package org.kh.campus.portfolio.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.campus.common.PageInfo;
import org.kh.campus.portfolio.domain.Portfolio;
import org.kh.campus.portfolio.service.PortfolioService;
import org.kh.campus.portfolio.store.PortfolioStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioServiceImpl implements PortfolioService {
	
	@Autowired
	private PortfolioStore pStore;
	@Autowired
	private SqlSession sqlSession;
	@Override
	public List<Portfolio> printAllPort(PageInfo pi) {
		List<Portfolio>pList = pStore.selectAllPort(sqlSession);
		return pList;
	}

	@Override
	public int insertPort(Portfolio portfolio) {
		int result = pStore.insertPort(sqlSession, portfolio);
		return result;
	}

	@Override
	public Portfolio printDetailPort(String port_title) {
		Portfolio portfolio = pStore.selectDetailPort(sqlSession, port_title);
		return portfolio;
	}

	@Override
	public int updatePort(String port_title) {
		int result = pStore.updatePort(sqlSession, port_title);
		return result;
	}

	@Override
	public int deletePort(String port_title) {
		int result = pStore.deletePort(sqlSession, port_title);
		return result;
	}

	@Override
	public List<Portfolio> printAdminAllPort(PageInfo pi) {
		List<Portfolio> pList = pStore.selectAdminAllPort(sqlSession);
		return pList;
	}

	@Override
	public Portfolio printAdminDetailPort(String port_title) {
		Portfolio portfolio = pStore.selectprintAdminDetailPort(sqlSession, port_title);
		return portfolio;
	}

	@Override
	public int getListCount() {
		int totalCount = pStore.selectListCount(sqlSession);
		return totalCount;
		
	}

}