package ruly.lecture.ooka.practice.instance.hige_level.c14;

/**
 * 航空券の発券可否を判定するクラスです。
 * 
 * <p>
 * 【利用クラス（DTO）の設計仕様】
 * </p>
 * <ul>
 * <li>PassportDTO: String passportNumber, boolean isExpired</li>
 * <li>TicketDTO: String passengerName, String flightNumber</li>
 * <li>PassengerDTO: String name, PassportDTO passport</li>
 * </ul>
 * 
 * <p>
 * 【判定ロジック仕様】
 * </p>
 * <ul>
 * <li>引数の passenger または ticket が null の場合は false を返す。</li>
 * <li>乗客が持つ passport が null の場合は false を返す。</li>
 * <li>パスポートが有効期限切れ(isExpired)の場合は false を返す。</li>
 * <li>乗客の名前(PassengerDTO.name)と航空券の氏名(TicketDTO.passengerName)が一致しない場合は false
 * を返す。</li>
 * <li>上記をすべてクリアした場合のみ true を返す。</li>
 * </ul>
 */
public class TicketingService {

	public boolean canIssue(PassengerDTO passenger, TicketDTO ticket) {
		if (passenger == null || ticket == null || passenger.getPassport() == null) {
			return false;
		}

		if (passenger.getPassport().isExpired()) {
			return false;
		}

		if (!passenger.getName().equals(ticket.getPassengerName())) {
			return false;
		}

		return true;
	}
}
