package inwords;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class SubHundredsNumberFragmentTest {
	private OnesNumberFragment zeroOnesDigit = new OnesNumberFragment(0);
	private OnesNumberFragment oneOnesDigit = new OnesNumberFragment(1);
	private TensNumberFragment zeroTensDigit = new TensNumberFragment(0);
	private TensNumberFragment fiveTensDigit = new TensNumberFragment(50);

	@Test
	public void returns_ones_digit_when_only_given_ones_digit() {
		assertThat(new SubHundredsNumberFragment(zeroTensDigit, oneOnesDigit).inWords(), is("one"));
	}

	@Test
	public void returns_tens_digit_when_only_given_tens_digit() {
		assertThat(new SubHundredsNumberFragment(fiveTensDigit, zeroOnesDigit).inWords(), is("fifty"));
	}

	@Test
	public void returns_both_digit_when_given_tens_and_ones_digits() {
		assertThat(new SubHundredsNumberFragment(fiveTensDigit, oneOnesDigit).inWords(), is("fifty one"));
	}
}
