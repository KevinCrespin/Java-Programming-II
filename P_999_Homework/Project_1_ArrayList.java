import java.util.ArrayList;
import java.util.Scanner;

public class Project_1_ArrayList {
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

		searchSecondSmallest(sequence, searchSmallest(sequence));
		searchSecondLargest(sequence, searchLargest(sequence));
	}
	
	public static int searchSmallest(ArrayList<Integer> sequence) {
		int smallest = sequence.get(0);
		for (int i = 0; i < sequence.size(); i++) {
			if (smallest > sequence.get(i)) {
				smallest = sequence.get(i);
			}
		}
		System.out.println("The smallest number in the sequence is: " + smallest);
		return smallest;
	}
	
	public static int searchLargest(ArrayList<Integer> sequence) { 
		int largest = sequence.get(0);
		for (int i = 0; i < sequence.size(); i++) {
			if (largest < sequence.get(i)) {
				largest = sequence.get(i);
			}
		}
		System.out.println("The largest number in the sequence is: " + largest);
		return largest;
	}
	
	public static void searchSecondSmallest(ArrayList<Integer> sequence, int smallest) {
		int secondSmallest = sequence.get((int)sequence.size() / 2);
		for (int i = 0; i < sequence.size(); i++) {
			if (secondSmallest > sequence.get(i)) {
				if (smallest != sequence.get(i)) {
					secondSmallest = sequence.get(i);
				}
			}
		}
		System.out.println("The second smallest number in the sequence is: " + secondSmallest);
	}
	
	public static void searchSecondLargest(ArrayList<Integer> sequence, int largest) {
		int secondLargest = sequence.get((int)sequence.size() / 2);
		for (int i = 0; i < sequence.size(); i++) {
			if (secondLargest < sequence.get(i)) { 
				if (largest != sequence.get(i)) {
					secondLargest = sequence.get(i);
				}
			}
		}
		System.out.println("The second largest number in the sequence is: " + secondLargest);
	}
}