import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentProcessor {
	
	public static void main(String[] args) {
		String masterFile = "student-master-list.csv";
		List<Student> course1 = new ArrayList<>();
		List<Student> course2 = new ArrayList<>();
		List<Student> course3 = new ArrayList<>();

// 1. read the master csv file and split student by course
	try(BufferedReader bufferedReader = new BufferedReader(new FileReader(masterFile))) {
		String line;
		boolean firstLine = true;
		while ((line = bufferedReader.readLine()) != null) {
			if (firstLine) {
				firstLine = false;
				continue;// skip header row
			}
			String[] data = line.split(",");
			int studentId = Integer.parseInt(data[0].trim());
			String studentName = data[1].trim();
			String course = data[2].trim();
			int grade = Integer.parseInt(data[3].trim());

			Student student = new Student();
			// insert the students into the respective course in sorted order
			if (course.startsWith("COMPSCI")) {
				course1.add(student);
			} else if (course.startsWith("APMTH")) {
				course2.add(student);
			} else if (course.startsWith("STAT")) {
				course3.add(student);
			}
		}
	}catch(IOException e) {
	
		e.printStackTrace();
	}

// sort the students by grade in descending order
	sortStudentByCourse(course1);
	sortStudentByCourse(course2);
	sortStudentByCourse(course3);
	
// write the sorted students into seperate csv files
	writeToFile("course1.csv", course1);
	writeToFile("course2.csv", course2);
	writeToFile("course3.csv", course3);
	}
	
	
private static void sortStudentByCourse(List<Student> course1) {
	
		
	}


private static void sortStudentsByGrade(List<Student> students, int i) {
	int n = students.size();
	for (int i1 = 0; i1 < n - 1; i1++) {
		for (int j = 0; j < n - i1 - 1; j++) {
			if (students.get(j).getGrade() < students.get(j + 1).getGrade()) {
				Student temp = students.get(j);
				students.set(j,  students.get(j + 1));
				students.set(j + 1, temp);
			}
			
		}
	}
	Student newStudent = new Student();
	while (i < students.size() && students.get(i).grade >= newStudent.grade) {
		i++;
	}
	students.add(i, newStudent);
	}
// method to write list of students to a file
private static void writeToFile(String fileName, List<Student> students) {
	try (FileWriter Writer = new FileWriter(fileName)){
		Writer.write("Student ID, Student Name, Course, Grade\n");
		for (Student student : students) {
			Writer.write(student.getStudentId() + "," + student.getStudentName() + student.getCourse() + "," + student.getGrade() + "\n");
		}
	}catch (IOException e) {
		e.printStackTrace();
	}

}

}
