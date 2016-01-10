package inwords;

public class TeenNumberFragment implements NumberFragment {
	private final String[] namesOfNumbers = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
	private final Integer digit;
	public TeenNumberFragment(Integer number) {
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
		return other instanceof TeenNumberFragment && ((TeenNumberFragment)other).digit == this.digit;
	}
	@Override
	public int hashCode() {
		return digit.hashCode();
	}
}
