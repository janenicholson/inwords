package inwords;

public class OnesNumberFragment implements NumberFragment {
	private final String[] namesOfNumbers = { "zero", "one", "two", "three", "four", "five" };
	private final Integer digit;
	public OnesNumberFragment(Integer digit) {
		this.digit = digit;
	}
	public String inWords() {
		if (digit < namesOfNumbers.length)
			return namesOfNumbers[digit];
		throw new NumberFormatException(digit + " cannot be represented in English as a single digit");
	}
	public boolean isPlaceHolder() {
		return digit == 0;
	}
}
