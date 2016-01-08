package inwords;

public class NumberCombiner {

	public String combine(NumberFragment largeDigit, NumberFragment smallDigit) {
		return String.format("%s %s", largeDigit.inWords(), smallDigit.inWords());
	}

}
