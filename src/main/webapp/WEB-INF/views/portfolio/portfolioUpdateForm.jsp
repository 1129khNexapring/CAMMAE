<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="content_box">
		<div class="notice_page_title">
			<h2 class="tit_page">공지사항 관리</h2>

		</div>
		<div class="section">
			<div class="bbs">
				<form action="/portfolio/modify.kh" method="post">
					제목 <input type="text" name="port_title"
						value="${portfolio.port_title}"><br> 이름 <input
						type="text" name="port_name" value="${portfolio.port_nmae}"><br>
					학번 <input type="text" name="port_student_no"
						value="${portfolio.port_student_no}"><br> 학과명 <input
						type="text" name="port_college" value="${portfolio.port_college}"><br>
					전화번호 <input type="text" name="port_student_number"
						value="${portfolio.port_student_number}"><br> 자격증 첨부
					<input type="text" name="port_license"
						value="${portfolio.port_license}"> 수상이력 첨부 <input
						type="text" name="port_award_history"
						value="${portfolio.port_award_history}"><br> 작성날짜 <input
						type="text" name="port_writerDate"
						value="${portfolio.port_writerDate}"> 내용 <input
						type="text" name="port_content" value="${portfolio.port_content}"><br>
					<div class="enr_btn">
						<div class="input-btn">
							<input type="submit" id="btn1" value="수정"> <input
								type="button" id="btn2"
								onclick="location.href='/portfolio/delete.kh?port_no=${portfolio.port_no}'"
								value="삭제">
						</div>
						<div class="a-btn">
							<a href="/portfolio/listView.kh" id="list_l">목록</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>