package set;

public class D5 extends MaxSet<Integer> {
	public static void main(String[] args) {
		int[] j = { 1, 2, 3, 4, 5, 66, 2, 4, 6, 90, 4 };
		j = uniqueElements(j);
		for (int i : j) {
			System.out.println(i);
		}
	}
	public static int[] uniqueElements(int[] ints) {
		MaxSet<Integer> set = new MaxSet<Integer>();
		int size = 0;
		for (int i : ints) {
			if (set.add(i)) {
				size++;
			}
		}
		int[] out = new int[size];
		for (int i = size - 1; i >= 0; i--) {
			out[i] = (int) set.getMax();
			set.remove(set.getMax());
		}

		return out;

	}

	public static void mina(String[] args) {
		int[] j = { 1, 2, 3, 4, 5, 66, 2, 4, 6, 90, 4 };
		uniqueElements(j);
		for (int i : j) {
			System.out.println(i);
		}
	}
}
