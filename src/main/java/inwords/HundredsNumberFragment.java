package inwords;

public class HundredsNumberFragment implements NumberFragment {

	private final OnesNumberFragment digitNameRetriever;

	public HundredsNumberFragment(Integer digit) {
		digitNameRetriever = new OnesNumberFragment(digit);
	}

	public String inWords() {
		if (!isPlaceHolder())
			return digitNameRetriever.inWords() + " hundred";
		return "";
	}

	public boolean isPlaceHolder() {
		return digitNameRetriever.isPlaceHolder();
	}

}
