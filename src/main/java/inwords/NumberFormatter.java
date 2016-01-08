package inwords;

public class NumberFormatter {
	private final String[] namesOfNumbers = { "zero", "one" };
	public String inWords(Integer number) {
		return (namesOfNumbers[number]);
	}
}
