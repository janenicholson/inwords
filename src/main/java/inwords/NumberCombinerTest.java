package inwords;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class NumberCombinerTest {

	private NumberFragment zeroFragment = new TensNumberFragment(0);

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

	@Test
	public void provide_hundreds_digit_when_only_hundreds_digit_is_present() {
		assertThat(new NumberCombiner().combine(mockFragment, zeroFragment, zeroFragment), is("mock"));
	}

	@Test
	public void provide_hundreds_and_tens_digit_when_hundreds_and_tens_digits_are_present() {
		assertThat(new NumberCombiner().combine(mockHundredFragment, mockFragment, zeroFragment), is("mock hundred and mock"));
	}

	@Test
	public void provide_hundreds_and_ones_digit_when_hundreds_and_ones_digits_are_present() {
		assertThat(new NumberCombiner().combine(mockHundredFragment, zeroFragment, mockFragment), is("mock hundred and mock"));
	}

	@Test
	public void provide_hundreds_tens_and_ones_digit_when_hundreds_tens_and_ones_digits_are_present() {
		assertThat(new NumberCombiner().combine(mockHundredFragment, mockFragment, mockFragment), is("mock hundred and mock mock"));
	}

	private NumberFragment mockFragment = new NumberFragment() {
		public String inWords() {
			return "mock";
		}
		public String getPrefix() {
			return " ";
		}
		public boolean isPlaceHolder() {
			return false;
		}
	};

	private NumberFragment mockHundredFragment = new NumberFragment() {
		public String inWords() {
			return "mock hundred";
		}

		public String getPrefix() {
			return " ";
		}

		public boolean isPlaceHolder() {
			return false;
		}
	};
}
