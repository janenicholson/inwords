package inwords;

import java.util.Optional;

public class SubHundredsNumberFragment implements NumberFragment {
	private final TensNumberFragment tensDigit;
	private final OnesNumberFragment onesDigit;
	private final Optional<TeenNumberFragment> teenDigit;
	
	public SubHundredsNumberFragment(Integer number) {
		this.tensDigit = new TensNumberFragment(number);
		this.onesDigit = new OnesNumberFragment(number);
		this.teenDigit = tensDigit.isTeen() ? Optional.of(new TeenNumberFragment(number)) : Optional.empty();
	}

	@Override
	public String inWords() {
		if (tensDigit.isTeen())
			return teenDigit.get().inWords();
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
