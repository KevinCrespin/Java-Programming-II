public class P_05 Palindrom {
	
	static String testString = "abcdba";
	
	static boolean charCheck(int index1, int index2) {
		if(testString.charAt(index1) ==  testString.charAt(index2)) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		boolean isPalindrom = true;
        int startPosition = 0;
        int endPosition = testString.length()-1;
        while(startPosition < endPosition) {
        	if (charCheck(startPosition, endPosition)) {
        		startPosition = startPosition + 1;
        		endPosition = endPosition - 1;
        	}
        	else {
        		isPalindrom = false;
        		break;
        	}
        }
        
        if(isPalindrom) {
    	    System.out.println("It is a Palindrom");
        }
        else {
    		System.out.println("It is not a Palindrom");
        }
	}

}