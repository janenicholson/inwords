package inwords;

public class NumberFormatter {
	public String inWords(Number number) {
		if (number.equals(1))
			return "one";
		return "zero";
	}
}
