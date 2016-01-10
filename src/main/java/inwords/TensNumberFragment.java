package inwords;

public class TensNumberFragment implements NumberFragment {
	private final String[] namesOfNumbers = { "", "ten", "twenty", "thirty", "forty" };
	private final Integer digit;

	public TensNumberFragment(Integer digit) {
		this.digit = (digit/10) % 10;
	}

	public String inWords() {
		if (digit < namesOfNumbers.length)
			return namesOfNumbers[digit];
		throw new NumberFormatException(digit + " cannot be represented in English as a single digit");
	}

	public boolean isPlaceHolder() {
		return digit == 0;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof TensNumberFragment && ((TensNumberFragment) other).digit == this.digit;
	}

	@Override
	public int hashCode() {
		return digit.hashCode();
	}
}
