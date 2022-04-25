package org.kh.campus.market.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.kh.campus.market.domain.Market;
import org.kh.campus.market.domain.PageInfo;
import org.kh.campus.market.domain.Search;

public interface MarketStore {
	//게시글 전체 리스트 조회
	List<Market> selectAllMarket(SqlSession sqlSession, PageInfo pi);
	
	//게시글 상세 조회
	Market selectOneMarket(SqlSession sqlSession, int marketNo);

	//게시글 검색
	List<Market> selectSearchMarket(Search search, SqlSession sqlSession);
	
	//게시글 등록
	int insertMarket(Market market, SqlSession sqlSession);
	
	//게시글 조회수
	int updateCount(int marketNo, SqlSession sqlSession);

	//게시글 수정
	int updateMarket(Market market, SqlSession sqlSession);

	//게시글 삭제
	int deleteMarket(int marketNo, SqlSession sqlSession);
	
	//페이징
	int selectListCount(SqlSession sqlSession);





}