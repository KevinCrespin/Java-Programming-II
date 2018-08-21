public class P_00 Sort {

	public static void main(String[] args) {
		int[] data = {2, 5, 6, 10, 4, 7, 1, 8};
		int biggestIndex;
		int tmp;
		for (int i = 0; i < data.length; i++) {
			biggestIndex = maxNumber(i, data);
			tmp = data[i]; 
			data[i] = data[biggestIndex];
			data[biggestIndex] = tmp;
		}
		System.out.print("Sorted Data:");
		for (int i = 0; i < data.length; i++) {
			System.out.print(" "+ data[i]);
		}
	}
	
	static int maxNumber(int startIndex, int[] data) {
		int biggest;
		int index;
		biggest = data[startIndex];
		index = startIndex;
		for (int i = startIndex; i < data.length; i++) {
			if (biggest < data[i]) {
				biggest = data[i];
				index = i;
			}
		}
		return index;
	}
}
