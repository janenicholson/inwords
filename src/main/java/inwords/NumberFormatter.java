package inwords;

public class NumberFormatter {
	public String inWords(Integer number) {
		NumberFragment smallDigit = new OnesNumberFragment(number);
		NumberFragment middleDigit = new TensNumberFragment(number);
		NumberFragment largeDigit = new HundredsNumberFragment(number);
		return new NumberCombiner().combine(largeDigit, middleDigit, smallDigit);
	}
}
