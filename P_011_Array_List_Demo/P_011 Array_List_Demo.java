import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Object> {
	String name;
	int age;

	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void output() {
		
		System.out.println(name + " || " + age);
	}

	public int compareTo(Object o) {
	    int result = age - ((Student)o).age;
		return result;

	}
}



class StudentList {
	ArrayList<Student> studentList = new ArrayList<Student>();

	StudentList() {
		studentList.add(new Student("Miguel Crespin", 55));
		studentList.add(new Student("Bobby Robert", 20));
		studentList.add(new Student("Mary Jhonson", 25));

	}

	public void sort() {
		Collections.sort(studentList);

	}

	public void output() {
		for (Student s: studentList)

	{
	s.output(); 
	}
	}

}

public class P_011 Array_List_Demo {

	public static void main(String[] args) {
		System.out.println("Student Name || Age");
		System.out.println();
		
		StudentList cs2012 = new StudentList();
		cs2012.sort();
		cs2012.output();
	}
}