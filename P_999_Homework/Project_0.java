
public class Project_0 {
	public static void main(String[] args) {
		int [] mainLine = {0, 0, 0, 0, 1, 0, 0, 0, 0}; 
		mainLine[4] = 1;
		int [] tempLine = new int[9];
		printLine(mainLine);
		for (int i = 0; i < 3; i ++) {
			  for (int j = 1; j < 8; j++) {
				tempLine[j] = mainLine[j - 1] + mainLine[j + 1];
			  }
			  printLine(tempLine);
			  for (int k = 0; k < mainLine.length; k++) {
				mainLine[k] = tempLine[k];
			  }
		    }
	}
		
	
	public static void printLine (int[] line) { 
		for (int i = 0; i < line.length; i ++) {
			if (line[i] == 0) {
				System.out.print("   ");
			}
			
			else {
				System.out.print(" " + line[i] + " ");
			}
		}
		System.out.println();
	}
}
