import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Project_1_ArrayListSimple {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> sequence = new ArrayList<Integer>();
		System.out.print("Input a sequence of integers: ");
		String sequenceString = input.nextLine();
		Scanner numberReader = new Scanner(sequenceString);
		
		while(numberReader.hasNextInt()){
	         sequence.add((numberReader.nextInt()));
	    }
		
		input.close();
		numberReader.close();
		
		Collections.sort(sequence);
		System.out.println("The smallest number in the sequence is: " + sequence.get(0));
		System.out.println("The second smallest number in the sequence is: " + sequence.get(1));
		
		Collections.reverse(sequence);
		System.out.println("The biggest number in the sequence is: " + sequence.get(0));
		System.out.println("The second biggest number in the sequence is: " + sequence.get(1));
	}
}