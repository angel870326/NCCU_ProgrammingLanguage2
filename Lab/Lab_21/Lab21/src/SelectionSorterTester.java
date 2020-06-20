import java.util.Arrays;

public class SelectionSorterTester {

	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < 10; i++)
		a[i] = 100 - (i - 5) * (i - 5);
		SelectionSorter s = new SelectionSorter(a);
		s.sort();
		System.out.println(Arrays.toString(a));
		System.out.println("Expected: [100, 99, 99, 96, 96, 91, 91, 84, 84, 75]");
	}

}
