package inwords;

public class ThousandsNumberFragment implements NumberFragment {
	private final SubHundredsNumberFragment subHundredsNumberFragment;

	public ThousandsNumberFragment(Integer digit) {
		subHundredsNumberFragment = new SubHundredsNumberFragment(digit/1000);
	}

	@Override
	public String inWords() {
		return subHundredsNumberFragment.inWords() + " thousand";
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
