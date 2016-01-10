package inwords;

import inwords.fragment.NumberFragmentFactory;

public class NumberFormatter {
	public String inWords(Integer number) {
		return new NumberCombiner().combine(NumberFragmentFactory.create(number));
	}
}
