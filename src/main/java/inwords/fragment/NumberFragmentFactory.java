package inwords.fragment;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberFragmentFactory {
	public static List<NumberFragment> create(int number) {
		return Arrays.stream(createFromNumber(number))
				.filter(numberFragment -> !numberFragment.isPlaceHolder())
				.collect(Collectors.collectingAndThen(Collectors.toList(), placeHolderForZero()));
	}

	private static Function<List<NumberFragment>, List<NumberFragment>> placeHolderForZero() {
		return new Function<List<NumberFragment>, List<NumberFragment>>() {
			@Override
			public List<NumberFragment> apply(List<NumberFragment> list) {
				return (!list.isEmpty()) ? list : Arrays.<NumberFragment>asList(new OnesNumberFragment(0));
			}
		};
	}

	private static NumberFragment[] createFromNumber(int number) {
		return new NumberFragment[] {
				new MillionsNumberFragment(number),
				new ThousandsNumberFragment(number),
				new HundredsNumberFragment(number),
				new SubHundredsNumberFragment(number)
		};
	}
}
