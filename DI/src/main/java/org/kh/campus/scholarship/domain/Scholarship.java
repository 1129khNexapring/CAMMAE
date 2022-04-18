package org.kh.campus.scholarship.domain;

public class Scholarship {
	private String scholarship_score; // ����
	private int scholarship_avg_grade; // ����
	private String scholarship_year; //�⵵
	private String scholarship_term; //  �б�
	private String scholarship_status; // ��û����
	private int scholarship_amount; // ���б�
	
	public Scholarship() {}

	public String getScholarship_score() {
		return scholarship_score;
	}

	public void setScholarship_score(String scholarship_score) {
		this.scholarship_score = scholarship_score;
	}

	public int getScholarship_avg_grade() {
		return scholarship_avg_grade;
	}

	public void setScholarship_avg_grade(int scholarship_avg_grade) {
		this.scholarship_avg_grade = scholarship_avg_grade;
	}

	public String getScholarship_year() {
		return scholarship_year;
	}

	public void setScholarship_year(String scholarship_year) {
		this.scholarship_year = scholarship_year;
	}

	public String getScholarship_term() {
		return scholarship_term;
	}

	public void setScholarship_term(String scholarship_term) {
		this.scholarship_term = scholarship_term;
	}

	public String getScholarship_status() {
		return scholarship_status;
	}

	public void setScholarship_status(String scholarship_status) {
		this.scholarship_status = scholarship_status;
	}

	public int getScholarship_amount() {
		return scholarship_amount;
	}

	public void setScholarship_amount(int scholarship_amount) {
		this.scholarship_amount = scholarship_amount;
	}

	@Override
	public String toString() {
		return "Scholarship [scholarship_score=" + scholarship_score + ", scholarship_avg_grade="
				+ scholarship_avg_grade + ", scholarship_year=" + scholarship_year + ", scholarship_term="
				+ scholarship_term + ", scholarship_status=" + scholarship_status + ", scholarship_amount="
				+ scholarship_amount + "]";
	}
	
	

}
