package inwords;

public class TensNumberFragment implements NumberFragment {
	private final String[] namesOfNumbers = { "", "ten", "twenty" };
	private final Integer digit;
	public TensNumberFragment(Integer digit) {
		this.digit = digit;
	}
	public String inWords() {
		return namesOfNumbers[digit];
	}
}
