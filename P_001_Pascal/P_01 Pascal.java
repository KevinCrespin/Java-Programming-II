public class P_01 Pascal {
	
	public static void main(String[] args) {
		int[] arrayA = {0, 0, 0, 0, 1, 0, 0, 0, 0};
		int[] arrayB = new int[9];
		arrayPrint(arrayA);
	    for (int j = 0; j < 3; j ++) {
		  for (int i = 1; i < 8; i++) {
			arrayB[i] = arrayA[i-1] + arrayA[i+1];
		  }
		  arrayPrint(arrayB);
		  for (int k = 0; k < arrayA.length; k++) {
			arrayA[k] = arrayB[k];
		  }
	    }
	}
	
	static void arrayPrint(int[] arrayA) {
		for (int i = 0; i < arrayA.length; i++) {
			if (arrayA[i] == 0) {
				System.out.print(" " + " ");
			}
			else {
				System.out.print(" " + arrayA[i]);
			}
		}
		System.out.println();
	}
}