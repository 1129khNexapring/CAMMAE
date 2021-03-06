package org.kh.campus.question.service;

import java.util.List;

import org.kh.campus.lecture.domain.Lecture;
import org.kh.campus.question.domain.PageInfo;
import org.kh.campus.question.domain.Question;
import org.kh.campus.question.domain.QuestionReply;

public interface QuestionService {

	// 게시글 조회
	public List<Question> printAllQuestion(PageInfo pi);

	// 게시글 상세 조회
	public Question printOneQuestion(int questionNo);

	// 게시글 등록
	public int registerQuestion(Question question);

	// 게시글 등록(교수선택)
	public List<Lecture> printAllPro();

	// 게시글 등록 (수업 선택)
	public List<Lecture> printAllLec(String professorName);

	// 게시글 수정
	public int modifyQuestion(Question question);

	// 게시판 조회수
	public int questionCountUpdate(int questionNo);

	// 게시글 삭제
	public int removeQuestion(int questionNo);

	// 페이징
	public int getListCount(PageInfo pageInfo);

	// 댓글
	// 댓글 조회
	public List<QuestionReply> printAllQuetionReply(int questionNo);

	// 댓글 등록
	public int registerReply(QuestionReply questionReply);

	// 댓글 수정
	public int modifyQuestionReply(QuestionReply questionReply);

	// 댓글 삭제
	public int removeQuestionReply(QuestionReply questionReply);

}
