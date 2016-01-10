package inwords;

public class MillionsNumberFragment implements NumberFragment {
	private final SubHundredsNumberFragment subHundredsNumberFragment;
	public MillionsNumberFragment(Integer number) {
		subHundredsNumberFragment = new SubHundredsNumberFragment(number/1000000);
	}

	@Override
	public String inWords() {
		return subHundredsNumberFragment.inWords() + " million";
	}

	@Override
	public String getPrefix() {
		return " ";
	}

	@Override
	public boolean isPlaceHolder() {
		return subHundredsNumberFragment.isPlaceHolder();
	}

}
