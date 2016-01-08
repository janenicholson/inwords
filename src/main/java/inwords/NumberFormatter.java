package inwords;

public class NumberFormatter {
	public String inWords(Integer number) {
		NumberFragment smallDigit = new OnesNumberFragment(number%10);
		NumberFragment largeDigit = new TensNumberFragment(number/10);
		return new NumberCombiner().combine(largeDigit, smallDigit);
	}
}
