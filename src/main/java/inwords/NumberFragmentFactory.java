package inwords;

import java.util.Arrays;
import java.util.List;

public class NumberFragmentFactory {
	public static List<NumberFragment> create(int number) {
		return Arrays.<NumberFragment>asList(new OnesNumberFragment(number));
	}
}
