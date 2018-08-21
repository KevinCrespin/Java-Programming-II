import java.util.ArrayList;
import java.util.Scanner;

class Dictionary_1 {
	// Public and rechable from all scopes [Data]
	static String[] words = {"I", "HE", "SHE","THEY", "LOVE", "RIDE", "LAUGH", "WALK",
							 "TO" , "IN", "A" , "ON" , "THE", "AN", "CAR", "BICICLE",
							 "MOTORCICLE", "BEACH", "CITY", "TOWN", "HOME", "STREET",
							 "THIS", "SUNNY", "NIGHT", "PARTY", "EAT", "FOOD", "BANANA",
							 "WORLD", "IS", "FIRE", "WATER", "RED", "BLACK", "PEOPLE"};
}

public class Project_2_ArrayList {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		ArrayList<String> sentence = new ArrayList<String>();
		
		System.out.print("Enter the sentence: ");
		String sentences = input.nextLine();
		
		Scanner readWord = new Scanner(sentences);
		
		while (readWord.hasNextLine()) {
			sentence.add(readWord.next());
		}
		
		int nOfWords = sentence.size();
		
		input.close();
		readWord.close();
		wordChecker(sentence, Dictionary_1.words, nOfWords);
	}
	
	public static void wordChecker (ArrayList<String> sentence, String[] words, int nOfWords) {
		int [] index = new int[nOfWords];
		
		System.out.print("These words were found in the dictionary: ");
		for (int i = 0; i < nOfWords; i++) {
			for (int j = 0; j < words.length; j++) {
				if ((sentence.get(i).toUpperCase()).equals(words[j])) {
					System.out.print(" [" + sentence.get(i) + "] ");
					index[i] = 1;
				}
			}
		}
		
		System.out.println();
		System.out.print("These words were NOT found in the dictionary: ");
		
		for (int i = 0; i < index.length; i++) {
			if (index[i] == 0) {
				System.out.print(" [" + sentence.get(i) + "] ");
			}
		}
	}
}