package org.kh.campus.cart.domain;


public class Cart {
	private int cartNo;
	private int studentNo;
	private String lectureNo;
	private String cartYear;
	private String cartTerm;
	private int lecturePeople;
	private String lectureDivision; 
	private int lectureGrade; 
	private String professorName; 
	private String lectureName; 
	private String lectureDepartment; 
	private String lectureStartTime;
	private String lectureEndTime;
	private String lectureTerm;
	private String lectureStart;
	private String lectureEnd;
	
	public Cart() {}

	public Cart(int cartNo, int studentNo, String lectureNo, String cartYear, String cartTerm, int lecturePeople,
			String lectureDivision, int lectureGrade, String professorName, String lectureName,
			String lectureDepartment, String lectureStartTime, String lectureEndTime, String lectureTerm,
			String lectureStart, String lectureEnd) {
		super();
		this.cartNo = cartNo;
		this.studentNo = studentNo;
		this.lectureNo = lectureNo;
		this.cartYear = cartYear;
		this.cartTerm = cartTerm;
		this.lecturePeople = lecturePeople;
		this.lectureDivision = lectureDivision;
		this.lectureGrade = lectureGrade;
		this.professorName = professorName;
		this.lectureName = lectureName;
		this.lectureDepartment = lectureDepartment;
		this.lectureStartTime = lectureStartTime;
		this.lectureEndTime = lectureEndTime;
		this.lectureTerm = lectureTerm;
		this.lectureStart = lectureStart;
		this.lectureEnd = lectureEnd;
	}

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public String getLectureNo() {
		return lectureNo;
	}

	public void setLectureNo(String lectureNo) {
		this.lectureNo = lectureNo;
	}

	public String getCartYear() {
		return cartYear;
	}

	public void setCartYear(String cartYear) {
		this.cartYear = cartYear;
	}

	public String getCartTerm() {
		return cartTerm;
	}

	public void setCartTerm(String cartTerm) {
		this.cartTerm = cartTerm;
	}

	public int getLecturePeople() {
		return lecturePeople;
	}

	public void setLecturePeople(int lecturePeople) {
		this.lecturePeople = lecturePeople;
	}

	public String getLectureDivision() {
		return lectureDivision;
	}

	public void setLectureDivision(String lectureDivision) {
		this.lectureDivision = lectureDivision;
	}

	public int getLectureGrade() {
		return lectureGrade;
	}

	public void setLectureGrade(int lectureGrade) {
		this.lectureGrade = lectureGrade;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public String getLectureDepartment() {
		return lectureDepartment;
	}

	public void setLectureDepartment(String lectureDepartment) {
		this.lectureDepartment = lectureDepartment;
	}

	public String getLectureStartTime() {
		return lectureStartTime;
	}

	public void setLectureStartTime(String lectureStartTime) {
		this.lectureStartTime = lectureStartTime;
	}

	public String getLectureEndTime() {
		return lectureEndTime;
	}

	public void setLectureEndTime(String lectureEndTime) {
		this.lectureEndTime = lectureEndTime;
	}

	public String getLectureTerm() {
		return lectureTerm;
	}

	public void setLectureTerm(String lectureTerm) {
		this.lectureTerm = lectureTerm;
	}

	public String getLectureStart() {
		return lectureStart;
	}

	public void setLectureStart(String lectureStart) {
		this.lectureStart = lectureStart;
	}

	public String getLectureEnd() {
		return lectureEnd;
	}

	public void setLectureEnd(String lectureEnd) {
		this.lectureEnd = lectureEnd;
	}

	@Override
	public String toString() {
		return "Cart [cartNo=" + cartNo + ", studentNo=" + studentNo + ", lectureNo=" + lectureNo + ", cartYear="
				+ cartYear + ", cartTerm=" + cartTerm + ", lecturePeople=" + lecturePeople + ", lectureDivision="
				+ lectureDivision + ", lectureGrade=" + lectureGrade + ", professorName=" + professorName
				+ ", lectureName=" + lectureName + ", lectureDepartment=" + lectureDepartment + ", lectureStartTime="
				+ lectureStartTime + ", lectureEndTime=" + lectureEndTime + ", lectureTerm=" + lectureTerm
				+ ", lectureStart=" + lectureStart + ", lectureEnd=" + lectureEnd + "]";
	}


	
}
