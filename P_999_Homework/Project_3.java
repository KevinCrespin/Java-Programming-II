class student {
	int CIN;
	String name;
	int age;
	String major;
	
	public student(int CIN, String name, int age, String major) {
		this.CIN = CIN;
		this.name = name;
		this.age = age;
		this.major = major;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getName() {
		return this.name;
	}

}

public class Project_3 {
	public static void main(String[] args) {
		student[] studentList = new student[7];
		studentList[0] = new student(305469273, "Kevin Crespin", 19, "Computer Science");
		studentList[1] = new student(305685425, "Deserie Trejo", 20, "Graphic Design");
		studentList[2] = new student(308956524, "Juana Martinez", 21, "Graphic Design");
		studentList[3] = new student(307525653, "Tanzie Harris", 20, "Civil Engineer");
		studentList[4] = new student(309856241, "Miguel Crespin", 27, "Mechanical Engineer");
		studentList[5] = new student(305465846, "Joseph Mark", 29, "Electrical Engineer");
		studentList[6] = new student(300232000, "Cristian Crespin", 15, "Mathematics");
		
		System.out.println("Based on the data... ");
		getYoungest(studentList);
		getOldest(studentList);
	}
	
	public static void getYoungest(student[] studentList) {	
		int youngest = studentList[(int)studentList.length/2].getAge();
		int index = 0;
		for (int i = 0; i < studentList.length; i++) {
			if (youngest > studentList[i].getAge()) {
				youngest = studentList[i].getAge();
				index = i;
			}
		}
		System.out.println("[" +studentList[index].getName() + "] is the youngest student. [" + youngest + " years old]");
	}
	
	public static void getOldest(student[] studentList) {	
		int oldest = studentList[(int)studentList.length/2].getAge();
		int index = 0;
		for (int i = 0; i < studentList.length; i++) {
			if (oldest < studentList[i].getAge()) {
				oldest = studentList[i].getAge();
				index = i;
			}
		}
		System.out.println("[" +studentList[index].getName() + "] is the oldest student. [" + oldest + " years old]");
	}
	
}