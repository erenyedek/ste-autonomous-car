package com.ste;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	Board board;

	@Before
	public void init() {
		board = new Board();
	}

	@Test
	public void test_initialized_north_direction_is_correct() {
		Direction d = BoardConstants.MAIN_DIRECTONS.get(DirectionType.N);
		assertEquals(DirectionType.N, d.getType());
		assertEquals(DirectionType.W, d.getLeft().getType());
		assertEquals(DirectionType.E, d.getRight().getType());
		assertEquals(1, d.getMoveAmount());
	}

	@Test
	public void test_example() {
		board.play(new String[] { "5 5", "1 2 N", "LMLMLMLMM", "3 3 E", "MMRMMRMRRM" });
		Car car1 = board.getCarList().get(0);
		assertEquals(1, car1.getPoint().getX());
		assertEquals(3, car1.getPoint().getY());
		assertEquals(DirectionType.N, car1.getDirection().getType());
		Car car2 = board.getCarList().get(1);
		assertEquals(5, car2.getPoint().getX());
		assertEquals(1, car2.getPoint().getY());
		assertEquals(DirectionType.E, car2.getDirection().getType());
	}

	@Test
	public void test_x_y_bound() {
		board.play(new String[] { "5 5", "1 2 N", "MMMMRMMMM" });
		Car car1 = board.getCarList().get(0);
		assertEquals(5, car1.getPoint().getX());
		assertEquals(5, car1.getPoint().getY());
		assertEquals(DirectionType.E, car1.getDirection().getType());
	}

	@Test
	public void test_negative_y_bound() {
		board.play(new String[] { "5 5", "1 2 E", "MMMMRMMMMMMM" });
		Car car1 = board.getCarList().get(0);
		assertEquals(5, car1.getPoint().getX());
		assertEquals(0, car1.getPoint().getY());
		assertEquals(DirectionType.S, car1.getDirection().getType());
	}

	@Test
	public void test_negative_x_bound() {
		board.play(new String[] { "5 5", "1 2 W", "MMMMMM" });
		Car car1 = board.getCarList().get(0);
		assertEquals(0, car1.getPoint().getX());
		assertEquals(2, car1.getPoint().getY());
		assertEquals(DirectionType.W, car1.getDirection().getType());
	}

	@Test
	public void test_wrong_car_first_position() {
		board.play(new String[] { "5 5", "6 2 W", "MMMMMM" });
		Car car1 = board.getCarList().get(0);
		assertEquals(0, car1.getPoint().getX());
		assertEquals(0, car1.getPoint().getY());
		assertEquals(DirectionType.W, car1.getDirection().getType());
	}

	@Test
	public void test_wrong_car_movement_commands() {
		board.play(new String[] { "5 5", "1 2 W", "MRM2M0" });
		Car car1 = board.getCarList().get(0);
		assertEquals(0, car1.getPoint().getX());
		assertEquals(4, car1.getPoint().getY());
		assertEquals(DirectionType.N, car1.getDirection().getType());
	}

	@Test
	public void test_more_than_2_car() {
		board.play(new String[] { "5 5", "1 2 N", "LMLMLMLMM", "3 3 E", "MMRMMRMRRM", "1 2 N", "LMLMLMLMM", "3 3 E",
				"MMRMMRMRRM" });
		Car car1 = board.getCarList().get(0);
		assertEquals(1, car1.getPoint().getX());
		assertEquals(3, car1.getPoint().getY());
		assertEquals(DirectionType.N, car1.getDirection().getType());
		Car car2 = board.getCarList().get(1);
		assertEquals(5, car2.getPoint().getX());
		assertEquals(1, car2.getPoint().getY());
		assertEquals(DirectionType.E, car2.getDirection().getType());
		Car car3 = board.getCarList().get(0);
		assertEquals(1, car3.getPoint().getX());
		assertEquals(3, car3.getPoint().getY());
		assertEquals(DirectionType.N, car3.getDirection().getType());
		Car car4 = board.getCarList().get(1);
		assertEquals(5, car4.getPoint().getX());
		assertEquals(1, car4.getPoint().getY());
		assertEquals(DirectionType.E, car4.getDirection().getType());
	}

}
