package inwords;

public class TensNumberFragment implements NumberFragment {
	private final String[] namesOfNumbers = { "", "ten", "twenty" };
	private final Integer digit;
	public TensNumberFragment(Integer digit) {
		this.digit = digit;
	}
	public String inWords() {
		if (digit < namesOfNumbers.length)
			return namesOfNumbers[digit];
		throw new NumberFormatException(digit + " cannot be represented in English as a single digit");
	}
}
