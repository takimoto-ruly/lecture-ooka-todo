package ruly.lecture.ooka.practice.basic;

public class FortuneUtil {

	public String getConstellation(int month, int day) {

		String zodiac = "";

		if (month == 1 && day <= 19 || 12 == month && day >= 22) {
			zodiac = "山羊座";
		} else if (month == 2 && day <= 18 || 1 == month && day >= 20) {
			zodiac = "水瓶座";
		} else if (month == 3 && day <= 20 || 2 == month && day >= 19) {
			zodiac = "魚座";
		} else if (month == 4 && day <= 19 || month == 3 && day >= 21) {
			zodiac = "牡羊座";
		} else if (month == 5 && day <= 20 || month == 4 && day >= 20) {
			zodiac = "牡牛座";
		} else if (month == 6 && day <= 21 || month == 5 && day >= 21) {
			zodiac = "双子座";
		} else if (month == 7 && day <= 22 || month == 6 && day >= 22) {
			zodiac = "蟹座";
		} else if (month == 8 && day <= 22 || month == 7 && day >= 23) {
			zodiac = "獅子座";
		} else if (month == 9 && day <= 22 || month == 8 && day >= 23) {
			zodiac = "乙女座";
		} else if (month == 10 && day <= 23 || month == 9 && day >= 23) {
			zodiac = "天秤座";
		} else if (month == 11 && day <= 22 || month == 10 && day >= 24) {
			zodiac = "蠍座";
		} else if (month == 12 && day <= 21 || month == 11 && day >= 23) {
			zodiac = "射手座";
		}
		// 月(month)日(day)から星座を判定

		return zodiac;
	}
}
