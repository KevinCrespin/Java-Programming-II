import java.util.Scanner;

class Dictionary {
	// Public and rechable from all scopes [Data]
	static String[] words = {"I", "HE", "SHE","THEY", "LOVE", "RIDE", "LAUGH", "WALK",
							 "TO" , "IN", "A" , "ON" , "THE", "AN", "CAR", "BICICLE",
							 "MOTORCICLE", "BEACH", "CITY", "TOWN", "HOME", "STREET",
							 "THIS", "SUNNY", "NIGHT", "PARTY", "EAT", "FOOD", "BANANA",
							 "DESI"};
}

public class Project_2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of words in the sentence: ");
		int nOfWords = input.nextInt();
		String [] sentence = new String[nOfWords];
		System.out.print("Enter the sentence of [" + nOfWords + "] words: ");
		
		for (int i = 0; i < sentence.length; i++) {
			sentence[i] = input.next();
		}
		
		input.close();
		wordChecker(sentence, Dictionary.words, nOfWords);
	}
	
	public static void wordChecker (String [] sentence, String[] words, int nOfWords) {
		int [] index = new int[nOfWords];
		
		System.out.print("These words were found in the dictionary: ");
		for (int i = 0; i < sentence.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if ((sentence[i].toUpperCase()).equals(words[j])) {
					System.out.print(" [" + sentence[i] + "] ");
					index[i] = 1;
				}
			}
		}
		
		System.out.println();
		System.out.print("These words were NOT found in the dictionary: ");
		
		for (int i = 0; i < index.length; i++) {
			if (index[i] == 0) {
				System.out.print(" [" + sentence[i] + "] ");
			}
		}
	}
}