package inwords.fragment;

public class OnesNumberFragment implements NumberFragment {
	private final String[] namesOfNumbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	private final Integer digit;
	public OnesNumberFragment(Integer number) {
		this.digit = number%10;
	}
	public String inWords() {
		if (digit < namesOfNumbers.length)
			return namesOfNumbers[digit];
		throw new NumberFormatException(digit + " cannot be represented in English as a single digit");
	}
	public String getPrefix() {
		return " ";
	}
	public boolean isPlaceHolder() {
		return digit == 0;
	}
	@Override
	public boolean equals(Object other) {
		return other instanceof OnesNumberFragment && ((OnesNumberFragment)other).digit == this.digit;
	}
	@Override
	public int hashCode() {
		return digit.hashCode();
	}
}
