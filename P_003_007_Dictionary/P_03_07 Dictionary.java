import java.io.File;
import java.util.Scanner;

class Mini_Dictionary {
	String [] wordDB;
	int wordNum = 0;
	Mini_Dictionary() {
	  wordDB = new String[1000];
	  File inputFile = new File("c:\\ttp\\DictionaryData.txt");
	  Scanner sc;
	  try {
		sc = new Scanner(inputFile);
		System.out.println("------------");
		while (sc.hasNext()) {
			String tmp = sc.nextLine();	
			System.out.println(tmp);
			String[] in_words = tmp.split(" ");
			for (int i = 0; i < in_words.length; i++) {
				wordDB[wordNum] = in_words[i];
				wordNum = wordNum + 1;
			}
		}
	  } catch (Exception e) {

	  }
	}

boolean checkWord(String word) {
		for (int i = 0; i < wordNum; i++) {
			if (wordDB[i].equalsIgnoreCase(word)) {
				return true;
			}
		}
		return false;
	}

void outputDictionary() {
		for (int i = 0; i < wordNum; i++) {
			System.out.println(i + " ---> " + wordDB[i]);
		}
	}
}



public class P_03_07 Dictionary {

	public static void main(String[] args) {
		Mini_Dictionary md = new Mini_Dictionary();
		md.outputDictionary();
		System.out.println("\n\n");
		@SuppressWarnings("resource")
		Scanner sct = new Scanner(System.in);
		String input = sct.nextLine();
		System.out.println("this is input: "+ input);
        String[] in_words = input.split(" ");
        
		for (int i = 0; i < in_words.length; i++) {
			if (!(md.checkWord(in_words[i]))) {
				System.out.println("--->  " + in_words[i]);
			}
		}
	}
}

