package inwords;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberFragmentFactory {
	public static List<NumberFragment> create(int number) {
		return Arrays.stream(createFromNumber(number))
				.filter(li -> !li.isPlaceHolder())
				.collect(Collectors.collectingAndThen(Collectors.toList(), placeHolderForZero()));
	}

	private static Function<List<NumberFragment>, List<NumberFragment>> placeHolderForZero() {
		return new Function<List<NumberFragment>, List<NumberFragment>>() {
			@Override
			public List<NumberFragment> apply(List<NumberFragment> t) {
				return (!t.isEmpty()) ? t : Arrays.<NumberFragment>asList(new OnesNumberFragment(0));
			}
		};
	}

	private static NumberFragment[] createFromNumber(int number) {
		return new NumberFragment[] {
				new HundredsNumberFragment(number),
				new SubHundredsNumberFragment(
						new TensNumberFragment(number),
						new OnesNumberFragment(number)
						)
		};
	}
}
