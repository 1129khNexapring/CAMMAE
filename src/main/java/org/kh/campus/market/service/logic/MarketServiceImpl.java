package org.kh.campus.market.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.kh.campus.market.domain.Market;
import org.kh.campus.market.domain.PageInfo;
import org.kh.campus.market.domain.Search;
import org.kh.campus.market.service.MarketService;
import org.kh.campus.market.store.MarketStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketServiceImpl implements MarketService {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private MarketStore mStore;
	
	@Override
	public List<Market> printAllMarket(PageInfo pi) {
		List<Market> mList = mStore.selectAllMarket(sqlSession, pi);
		return mList;
	}
	
	@Override
	public Market printOneMarket(int marketNo) {
		Market market = mStore.selectOneMarket(sqlSession, marketNo);
		return market;
	}
	
	@Override
	public List<Market> printSearchMarket(Search search) {
		List<Market> mList = mStore.selectSearchMarket(search, sqlSession);
		return mList;
	}
	
	@Override
	public int registerMarket(Market market) {
		int result = mStore.insertMarket(market, sqlSession);
		return result;
	}

	@Override
	public int marketCountUpdate(int marketNo) {
		int result = mStore.updateCount(marketNo, sqlSession);
		return result;
	}
	
	@Override
	public int modifyMarket(Market market) {
		int result = mStore.updateMarket(market, sqlSession);
		return result;
	}

	@Override
	public int removeMarket(int marketNo) {
		int result = mStore.deleteMarket(marketNo, sqlSession);
		return result;
	}
	
	//페이징
	@Override
	public int getListCount() {
		int totalCount = mStore.selectListCount(sqlSession);
		return totalCount;
	}









}
