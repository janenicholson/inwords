package inwords.fragment;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import inwords.fragment.SubHundredsNumberFragment;

public class SubHundredsNumberFragmentTest {

	@Test
	public void returns_ones_digit_when_only_given_ones_digit() {
		assertThat(new SubHundredsNumberFragment(1).inWords(), is("one"));
	}

	@Test
	public void returns_tens_digit_when_only_given_tens_digit() {
		assertThat(new SubHundredsNumberFragment(50).inWords(), is("fifty"));
	}

	@Test
	public void returns_both_digit_when_given_tens_and_ones_digits() {
		assertThat(new SubHundredsNumberFragment(51).inWords(), is("fifty one"));
	}
}
