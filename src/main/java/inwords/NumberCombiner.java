package inwords;

import java.util.List;

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
}
