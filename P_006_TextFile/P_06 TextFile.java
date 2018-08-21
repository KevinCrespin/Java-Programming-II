import java.io.*;
import java.util.*;


public class P_06 TextFile {

	public static void main(String[] args) {
		try {
			PrintWriter pw = new PrintWriter("data.txt");
			@SuppressWarnings("resource")
			Scanner inputScanner = new Scanner(System.in);
			for (int i = 0; i < 10; i++) {
				System.out.println("Please input something:");
				String inString = inputScanner.nextLine();
				pw.println(inString);
			}
			pw.flush();
			pw.close();
			
		} catch (Exception e) {
			
		} 
		File inputFile = new File("data.txt");
		Scanner sc;
		try {
			sc = new Scanner(inputFile);
			while (sc.hasNext()) {
				String tmp = sc.nextLine();	
				System.out.println(tmp);
			}
		} catch (Exception e) {		
	
		}
	}
}