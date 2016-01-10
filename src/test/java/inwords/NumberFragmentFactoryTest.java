package inwords;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NumberFragmentFactoryTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{0, new NumberFragment[] {new OnesNumberFragment(0)}}
			});
	}

	private final int number;
	private final NumberFragment[] fragments;

	public NumberFragmentFactoryTest(int number, NumberFragment ... fragments) {
		this.number = number;
		this.fragments = fragments;
	}

	@Test
	public void test_instance() {
		assertThat(NumberFragmentFactory.create(number), contains(fragments.length == 1 ? fragments[0] : fragments));
	}
}
