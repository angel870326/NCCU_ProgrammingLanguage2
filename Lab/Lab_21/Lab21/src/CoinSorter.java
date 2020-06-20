
public class CoinSorter {

	private Coin[] a;
	
	public CoinSorter(Coin[] anArray) {
		this.a = anArray;
	}
	
	public void sort() {
		for(int i = 0; i < a.length - 1; i++) {
			int minPos = minimumPosition(i);
			swap(minPos, i);

		}
	}
	
	private int minimumPosition(int from) {  
        int minPos = from;
        for (int i = from + 1; i < a.length; i++)
           if (a[i].getValue() < a[minPos].getValue()) minPos = i;
        return minPos;
    }

	
	private void swap(int i, int j) {
        Coin temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

	
	
	
}
