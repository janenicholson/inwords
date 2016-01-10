package inwords;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class NumberCombiner {

	public String combine(List<NumberFragment> numberFragments) {
		StringBuilder sb = new StringBuilder();
		for (NumberFragment numberFragment : numberFragments) {
			if (!isFirst(sb))
				sb.append(numberFragment.getPrefix());
			sb.append(numberFragment.inWords());
		}
		return sb.toString();
	}

	private boolean isFirst(StringBuilder sb) {
		return sb.length() == 0;
	}

	public String combine(NumberFragment hundredsDigit, NumberFragment tensDigit, NumberFragment onesDigit) {
		String betweenLargeAndMiddleDigit = hundredsDigit.isPlaceHolder() || Arrays.stream(new NumberFragment[] {tensDigit, onesDigit}).allMatch(new IsPlaceHolderPredicate()) ? "" : " and ";
		String betweenMiddleAndSmallDigit = tensDigit.isPlaceHolder() || onesDigit.isPlaceHolder() ? "" : " ";
		return String.format("%s%s%s%s%s", hundredsDigit.inWords(), betweenLargeAndMiddleDigit, tensDigit.inWords(), betweenMiddleAndSmallDigit, onesDigit.inWords());
	}

	private static class IsPlaceHolderPredicate implements Predicate<NumberFragment> {
		public boolean test(NumberFragment numberFragment) {
			return numberFragment.isPlaceHolder();
		}
	}
}
