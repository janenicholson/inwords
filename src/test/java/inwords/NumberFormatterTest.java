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

}
