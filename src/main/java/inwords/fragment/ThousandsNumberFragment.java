package inwords.fragment;

public class ThousandsNumberFragment implements NumberFragment {
	private final SubThousandsNumberFragment subThousandsNumberFragment;

	public ThousandsNumberFragment(Integer number) {
		subThousandsNumberFragment = new SubThousandsNumberFragment(number/1000);
	}

	@Override
	public String inWords() {
		return subThousandsNumberFragment.inWords() + " thousand";
	}

	@Override
	public String getPrefix() {
		return " ";
	}

	@Override
	public boolean isPlaceHolder() {
		return subThousandsNumberFragment.isPlaceHolder();
	}

}
