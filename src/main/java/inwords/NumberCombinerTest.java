package inwords;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class NumberCombinerTest {

	@Test
	public void provide_ones_digit_when_only_ones_value_is_present() {
		assertThat(new NumberCombiner().combine(Arrays.asList(mockFragment)), is("mock"));
	}

	@Test
	public void provide_tens_and_ones_digit_when_only_tens_and_ones_value_is_present() {
		assertThat(new NumberCombiner().combine(Arrays.asList(mockFragment, mockFragment)), is("mock mock"));
	}

	@Test
	public void provide_hundreds_digit_when_only_hundreds_digit_is_present() {
		assertThat(new NumberCombiner().combine(Arrays.asList(mockHundredFragment)), is("mock hundred"));
	}

	@Test
	public void provide_hundreds_and_tens_digit_when_hundreds_and_ones_digits_are_present() {
		assertThat(new NumberCombiner().combine(Arrays.asList(mockHundredFragment, new SubHundredsNumberFragment(5))), is("mock hundred and five"));
	}

	@Test
	public void provide_hundreds_and_tens_digit_when_hundreds_and_tens_digits_are_present() {
		assertThat(new NumberCombiner().combine(Arrays.asList(mockHundredFragment, new SubHundredsNumberFragment(30))), is("mock hundred and thirty"));
	}

	@Test
	public void provide_hundreds_tens_and_ones_digit_when_hundreds_tens_and_ones_digits_are_present() {
		assertThat(new NumberCombiner().combine(Arrays.asList(mockHundredFragment, new SubHundredsNumberFragment(35))), is("mock hundred and thirty five"));
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
