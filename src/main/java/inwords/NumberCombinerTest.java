package inwords;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class NumberCombinerTest {

	private NumberFragment zeroFragment = new TensNumberFragment(0);
	private NumberFragment mockFragment = new MockNumberFragment();

	@Test
	public void provide_ones_digit_when_only_ones_value_is_present() {
		assertThat(new NumberCombiner().combine(zeroFragment, zeroFragment, mockFragment), is("mock"));
	}

	@Test
	public void provide_tens_and_ones_digit_when_only_tens_and_ones_value_is_present() {
		assertThat(new NumberCombiner().combine(zeroFragment, mockFragment, mockFragment), is("mock mock"));
	}

	@Test
	public void provide_tens_digit_when_only_tens_digit_is_present() {
		assertThat(new NumberCombiner().combine(zeroFragment, mockFragment, zeroFragment), is("mock"));
	}

	private static class MockNumberFragment implements NumberFragment {

		public String inWords() {
			return "mock";
		}

		public boolean isPlaceHolder() {
			return false;
		}
		
	}
}
