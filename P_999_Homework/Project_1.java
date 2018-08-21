import java.util.Scanner;

public class Project_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Input the number of integers in the sequence: ");
		int quantity = input.nextInt();
		System.out.print("Input the sequence of [" + quantity + "] integers: ");
		int [] sequence = new int[quantity];
		
		for (int i = 0; i < quantity; i++) {
			sequence[i] = input.nextInt();
		}
		input.close();
		searchSecondSmallest(sequence, searchSmallest(sequence));
		searchSecondLargest(sequence, searchLargest(sequence));
	}
	
	public static int searchSmallest(int[] sequence) {
		int smallest = sequence[0];
		for (int i = 0; i < sequence.length; i++) {
			if (smallest > sequence[i]) {
				smallest = sequence[i];
			}
		}
		System.out.println("The smallest integer in the sequence is: " + smallest);
		return smallest;
	}
	
	public static int searchLargest(int[] sequence) { 
		int largest = sequence[0];
		for (int i = 0; i < sequence.length; i++) {
			if (largest < sequence[i]) {
				largest = sequence[i];
			}
		}
		System.out.println("The largest integer in the sequence is: " + largest);
		return largest;
	}
	
	public static void searchSecondSmallest(int[] sequence, int smallest) {
		int secondSmallest = sequence[(int)sequence.length / 2];
		for (int i = 0; i < sequence.length; i++) {
			if (secondSmallest > sequence[i]) {
				if (smallest != sequence[i]) {
					secondSmallest = sequence[i];
				}
			}
		}
		System.out.println("The second smallest integer in the sequence is: " + secondSmallest);
	}
	
	public static void searchSecondLargest(int[] sequence, int largest) {
		int secondLargest = sequence[(int)sequence.length / 2];
		for (int i = 0; i < sequence.length; i++) {
			if (secondLargest < sequence[i]) { 
				if (largest != sequence[i]) {
					secondLargest = sequence[i];
				}
			}
		}
		System.out.println("The second largest integer in the sequence is: " + secondLargest);
	}
}
