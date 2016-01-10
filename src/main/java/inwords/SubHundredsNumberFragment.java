package inwords;

public class SubHundredsNumberFragment implements NumberFragment {
	private final TensNumberFragment tensDigit;
	private final OnesNumberFragment onesDigit;
	
	public SubHundredsNumberFragment(TensNumberFragment tensDigit, OnesNumberFragment onesDigit) {
		this.tensDigit = tensDigit;
		this.onesDigit = onesDigit;
	}

	@Override
	public String inWords() {
		if (tensDigit.isPlaceHolder())
			return onesDigit.inWords();
		if (onesDigit.isPlaceHolder())
			return tensDigit.inWords();
		return tensDigit.inWords() + onesDigit.getPrefix() + onesDigit.inWords();
	}

	@Override
	public String getPrefix() {
		return " and ";
	}

	@Override
	public boolean isPlaceHolder() {
		return tensDigit.isPlaceHolder() && onesDigit.isPlaceHolder();
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof SubHundredsNumberFragment &&
				((SubHundredsNumberFragment) other).tensDigit.equals(this.tensDigit) &&
				((SubHundredsNumberFragment) other).onesDigit.equals(this.onesDigit);
	}

	@Override
	public int hashCode() {
		return tensDigit.hashCode() * 37 + onesDigit.hashCode();
	}
}
