package inwords;

public class ThousandsNumberFragment implements NumberFragment {
	private final OnesNumberFragment onesNumberFragment;

	public ThousandsNumberFragment(Integer digit) {
		onesNumberFragment = new OnesNumberFragment(digit/1000);
	}

	@Override
	public String inWords() {
		return onesNumberFragment.inWords() + " thousand";
	}

	@Override
	public String getPrefix() {
		return " ";
	}

	@Override
	public boolean isPlaceHolder() {
		return onesNumberFragment.isPlaceHolder();
	}

}
