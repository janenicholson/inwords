package inwords;

public class MillionsNumberFragment implements NumberFragment {
	private final SubThousandsNumberFragment subThousandsNumberFragment;
	public MillionsNumberFragment(Integer number) {
		subThousandsNumberFragment = new SubThousandsNumberFragment(number/1000000);
	}

	@Override
	public String inWords() {
		return subThousandsNumberFragment.inWords() + " million";
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
