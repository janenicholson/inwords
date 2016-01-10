package inwords;

public class ThousandsNumberFragment implements NumberFragment {
	private final HundredsNumberFragment hundredsNumberFragment;
	private final SubHundredsNumberFragment subHundredsNumberFragment;

	public ThousandsNumberFragment(Integer number) {
		hundredsNumberFragment = new HundredsNumberFragment(number/1000);
		subHundredsNumberFragment = new SubHundredsNumberFragment(number/1000);
	}

	@Override
	public String inWords() {
		StringBuilder sb = new StringBuilder();
		if (hundredsNumberFragment.isPlaceHolder())
			sb.append(subHundredsNumberFragment.inWords());
		else if (subHundredsNumberFragment.isPlaceHolder())
			sb.append(hundredsNumberFragment.inWords());
		else
			sb.append(hundredsNumberFragment.inWords() + " and " + subHundredsNumberFragment.inWords());
		if (sb.length() > 0)
			sb.append(" thousand");
		return sb.toString();
	}

	@Override
	public String getPrefix() {
		return " ";
	}

	@Override
	public boolean isPlaceHolder() {
		return hundredsNumberFragment.isPlaceHolder() && subHundredsNumberFragment.isPlaceHolder();
	}

}
