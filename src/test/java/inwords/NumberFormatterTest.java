package inwords;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import inwords.NumberFormatter;

public class NumberFormatterTest {

	@Test
	public void provideZeroWhenGivenZero() {
		NumberFormatter numberFormatter = new NumberFormatter();
		String formattedNumber = numberFormatter.inWords(0);
		assertThat(formattedNumber, is("zero"));
	}

	@Test
	public void provideOneWhenGivenOne() {
		NumberFormatter numberFormatter = new NumberFormatter();
		String formattedNumber = numberFormatter.inWords(1);
		assertThat(formattedNumber, is("one"));
	}

	@Test
	public void provideTwentyOneWhenGivenTwentyOne() {
		NumberFormatter numberFormatter = new NumberFormatter();
		String formattedNumber = numberFormatter.inWords(21);
		assertThat(formattedNumber, is("twenty one"));
	}
}
