package inwords;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import inwords.NumberFormatter;

@RunWith(Parameterized.class)
public class NumberFormatterTest {

	@Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{0, "zero"},
			{1, "one"},
			{21, "twenty one"},
			{105, "one hundred and five"},
			{1042, "one thousand and forty two"}
		});
	}

	private final int numberAsInteger;
	private final String numberInWords;

	public NumberFormatterTest(int numberAsInteger, String numberInWords) {
		this.numberAsInteger = numberAsInteger;
		this.numberInWords = numberInWords;
	}

	@Test
	public void test_instance() {
		assertThat(new NumberFormatter().inWords(numberAsInteger), is(numberInWords));
	}
}
