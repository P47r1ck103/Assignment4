
class Student {

	int studentId;
	String studentName;
	String course;
	int grade;
	
	public Student(int studentId, String studentName, String course, int grade) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.course = course;
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return studentId + "," + studentName + "," + course + "," + grade;
		
	}

	public String getStudentId() {
		
		return studentId;
	}

	public int getGrade() {
		
		return grade;
	}

	public String getStudentName() {
		
		return studentName;
	}

	public String getCourse() {
		
		return course;
	}

}


