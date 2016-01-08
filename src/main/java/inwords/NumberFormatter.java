package inwords;

public class NumberFormatter {
	private final String[] namesOfNumbers = { "zero", "one" };
	public String inWords(Integer number) {
		if (number < namesOfNumbers.length)
			return (namesOfNumbers[number]);
		return "NYI";
	}
}
