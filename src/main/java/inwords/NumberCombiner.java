package inwords;

public class NumberCombiner {

	public String combine(NumberFragment largeDigit, NumberFragment middleDigit, NumberFragment smallDigit) {
		String betweenLargeAndMiddleDigit = largeDigit.isPlaceHolder() ? "" : " and ";
		String betweenMiddleAndSmallDigit = middleDigit.isPlaceHolder() ? "" : " ";
		return String.format("%s%s%s%s%s", largeDigit.inWords(), betweenLargeAndMiddleDigit, middleDigit.inWords(), betweenMiddleAndSmallDigit, smallDigit.inWords());
	}

}
