package inwords;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class NumberCombiner {

	public String combine(List<NumberFragment> numberFragments) {
		HundredsNumberFragment hundredsDigit = new HundredsNumberFragment(0);
		TensNumberFragment tensDigit = new TensNumberFragment(0);
		OnesNumberFragment onesDigit = new OnesNumberFragment(0);
		for (NumberFragment numberFragment : numberFragments) {
			if (numberFragment instanceof HundredsNumberFragment)
				hundredsDigit = (HundredsNumberFragment) numberFragment;
			if (numberFragment instanceof TensNumberFragment)
				tensDigit = (TensNumberFragment) numberFragment;
			if (numberFragment instanceof OnesNumberFragment)
				onesDigit = (OnesNumberFragment) numberFragment;
		}
		return combine(hundredsDigit, tensDigit,onesDigit);
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
