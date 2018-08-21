import java.io.*;


@SuppressWarnings("serial")
class Student implements Serializable {
	
	int cin;
	String name;
	int age;
	String major;


    public Student(int cin, String name, int age, String major) {
    	
		this.cin = cin;
		this.name = name;
		this.age = age;
		this.major = major;

	}
    
}


public class P_24 Binary_IO_File {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("myData.dat");
			DataOutputStream DataOS = new DataOutputStream(fos);

			DataOS.writeInt(12345);
			DataOS.writeUTF("Mike");
			DataOS.writeInt(19);
			DataOS.writeUTF("Electrical");

			FileInputStream fis = new FileInputStream("myData.dat");
			DataInputStream DataIS = new DataInputStream(fis);

			int cin = DataIS.readInt();
			String name = DataIS.readUTF();
			int age = DataIS.readInt();
			String major = DataIS.readUTF();
			System.out.println(" cin -> " + cin + " name -> " + name + " age -> " + age + " major - >" + major);
			
			
			FileOutputStream oFos = new FileOutputStream("myStudent.dat");
			ObjectOutputStream ObjectOS = new ObjectOutputStream(oFos);

			Student s1 = new Student(123, "Bobby", 21, "Computer");
			ObjectOS.writeObject(s1);
			
			System.out.println(" cin -> " + s1.cin + " name -> " + s1.name + " age -> " + s1.age + " major - >" + s1.major);

			FileInputStream oFis = new FileInputStream("myStudent.dat");
			ObjectInputStream ObjectIS = new ObjectInputStream(oFis);
			
			Student s2 = (Student) ObjectIS.readObject();
			s2.cin = 99;
			
			System.out.println(" cin -> " + s2.cin + " name -> " + s2.name + " age -> " + s2.age + " major - >" + s2.major);
			
			DataOS.close();
			DataIS.close();
			ObjectOS.close();
			ObjectIS.close();

		} catch (Exception e) 

		{ 		}

	}

}