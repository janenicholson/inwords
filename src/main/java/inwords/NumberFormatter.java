package inwords;

public class NumberFormatter {
	public String inWords(Integer number) {
		NumberFragment smallDigit = new OnesNumberFragment(number%10);
		NumberFragment middleDigit = new TensNumberFragment(number/10);
		NumberFragment largeDigit = new HundredsNumberFragment(number/100);
		return new NumberCombiner().combine(largeDigit, middleDigit, smallDigit);
	}
}
