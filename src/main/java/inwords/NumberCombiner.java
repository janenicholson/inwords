package inwords;

public class NumberCombiner {

	public String combine(NumberFragment largeDigit, NumberFragment smallDigit) {
		String largeDigitInWords = largeDigit.inWords();
		String separator = largeDigitInWords.equals("") ? "" : " ";
		return String.format("%s%s%s", largeDigit.inWords(), separator, smallDigit.inWords());
	}

}
