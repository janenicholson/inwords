package inwords.fragment;

public class SubThousandsNumberFragment implements NumberFragment {
	private final HundredsNumberFragment hundredsNumberFragment;
	private final SubHundredsNumberFragment subHundredsNumberFragment;
	
	public SubThousandsNumberFragment(Integer number) {
		hundredsNumberFragment = new HundredsNumberFragment(number);
		subHundredsNumberFragment = new SubHundredsNumberFragment(number);
	}

	@Override
	public String inWords() {
		if (hundredsNumberFragment.isPlaceHolder())
			return subHundredsNumberFragment.inWords();
		if (subHundredsNumberFragment.isPlaceHolder())
			return hundredsNumberFragment.inWords();
		return hundredsNumberFragment.inWords() + subHundredsNumberFragment.getPrefix() + subHundredsNumberFragment.inWords();
	}

	@Override
	public String getPrefix() {
		return " ";
	}

	@Override
	public boolean isPlaceHolder() {
		return hundredsNumberFragment.isPlaceHolder() && subHundredsNumberFragment.isPlaceHolder();
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof SubThousandsNumberFragment &&
				((SubThousandsNumberFragment) other).hundredsNumberFragment.equals(this.hundredsNumberFragment) &&
				((SubThousandsNumberFragment) other).subHundredsNumberFragment.equals(this.subHundredsNumberFragment);
	}

	@Override
	public int hashCode() {
		return hundredsNumberFragment.hashCode() * 37 + subHundredsNumberFragment.hashCode();
	}
}
