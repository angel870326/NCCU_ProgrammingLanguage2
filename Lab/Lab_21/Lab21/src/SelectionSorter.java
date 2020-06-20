
public class SelectionSorter {
	
	private int[] a;
	
	public SelectionSorter(int[] anArray) {
		a = anArray;
	}
	
	public void sort() {
		for(int i = 0; i < a.length - 1; i++) {
			int minPos = maxPosition(i);
			swap(minPos, i);

		}
	}
	
	private int maxPosition(int from) {  
        int maxPos = from;
        for (int i = from + 1; i < a.length; i++)
           if (a[i] > a[maxPos]) maxPos = i;
        return maxPos;
    }

	
	private void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
