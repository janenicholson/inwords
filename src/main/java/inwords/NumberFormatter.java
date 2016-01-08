package inwords;

public class NumberFormatter {
	private final String[] namesOfNumbers = { "zero", "one" };
	public String inWords(Integer number) {
		if (number < namesOfNumbers.length)
			return (namesOfNumbers[number]);
		NumberFragment smallDigit = new OnesNumberFragment(number%10);
		NumberFragment largeDigit = new TensNumberFragment(number/10);
		return new NumberCombiner().combine(largeDigit, smallDigit);
	}
}
