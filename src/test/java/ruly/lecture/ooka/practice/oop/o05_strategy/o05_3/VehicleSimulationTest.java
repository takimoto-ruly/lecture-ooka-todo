package ruly.lecture.ooka.practice.oop.o05_strategy.o05_3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("乗り物料金シミュレーターの包括テスト")
class VehicleSimulationTest {

	@Test
	@DisplayName("多態性とStrategy：一般道における各車種の料金検証（一律0円）")
	void testGeneralRoad() {
		DrivingRouteStrategy general = new GeneralRoad();
		Vehicle car = new Car("12-34", general);
		Vehicle truck = new LargeTruck("56-78", general);

		assertEquals(0, car.calculatePrice(100));
		assertEquals(0, truck.calculatePrice(100), "トラックでも一般道は0円であるべき");
	}

	@Test
	@DisplayName("多態性とStrategy：高速道路における車種ごとの倍率計算の網羅検証")
	void testHighway() {
		DrivingRouteStrategy highway = new HighwayRoad();
		Vehicle car = new Car("12-34", highway);
		Vehicle truck = new LargeTruck("56-78", highway);

		// 乗用車: 100km × 20 = 2000円
		assertEquals(2000, car.calculatePrice(100));

		// 大型トラック: (100km × 20) × 1.5倍 = 3000円 (オーバーライドによる多態性)
		assertEquals(3000, truck.calculatePrice(100));
	}
}