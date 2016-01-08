package inwords;

import java.util.Arrays;
import java.util.function.Predicate;

public class NumberCombiner {

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
