import java.util.Arrays;

public class CustomSort {

	public static void main(String[] args) {
		String sort[] = { "P", "A", "R", "V", "I", "S", "E" };

		for (int i = 0; i < sort.length; i++) {
			for (int j = i + 1; j < sort.length; j++) {

				if (new StringComparator(false).compare(sort[i], sort[j]) > 0) {
					String temp = sort[i];
					sort[i] = sort[j];
					sort[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(sort));
	}

}

interface ValueComparator<T> {
	public int compare(T o1, T o2);
}

class StringComparator implements ValueComparator<String> {

	boolean asc = false;

	StringComparator(boolean asc) {
		this.asc = asc;
	}

	@Override
	public int compare(String o1, String o2) {
		if (asc)
			return o1.compareTo(o2);
		else
			return o2.compareTo(o1);
	}

}