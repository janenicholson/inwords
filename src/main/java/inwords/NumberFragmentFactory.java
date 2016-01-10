package inwords;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberFragmentFactory {
	public static List<NumberFragment> create(int number) {
		if (number == 0)
			return Arrays.asList(new OnesNumberFragment(0));
		return Arrays.stream(createFromNumber(number))
				.filter(li -> !li.isPlaceHolder())
				.collect(Collectors.toList());
	}

	private static NumberFragment[] createFromNumber(int number) {
		return new NumberFragment[] {
				new HundredsNumberFragment(number),
				new TensNumberFragment(number),
				new OnesNumberFragment(number)
		};
	}
}
