package demo.collection.set.comparator;

import java.util.Comparator;

public class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2.intValue() - o1.intValue();
	}

}
