package com.ste;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private int maxXBound;
	private int maxYBound;
	private List<Car> carList = new ArrayList<Car>();

	public static void main(String[] args) {
		Board board = new Board();
		board.play(args);
		System.out.println(board.toString());
	}

	public void play(String[] parameterList) {
		String boardAreaAsString = parameterList[BoardConstants.BOARD_AREA_INDEX];
		setBound(boardAreaAsString);

		for (int index = 1; index < parameterList.length; index += 2) {
			String carFirstPositionString = parameterList[index];
			Car car1 = createCarObject(carFirstPositionString);
			moveCar(car1, parameterList[index + 1]);
			carList.add(car1);
		}
	}

	private void moveCar(Car car, String commandList) {
		char[] carCommandList = commandList.toCharArray();
		for (char item : carCommandList)
			this.changeCarState(car, item);

	}

	private void changeCarState(Car car, char state) {
		switch (state) {
		case BoardConstants.RIGHT:
			car.turnRight();
			break;
		case BoardConstants.LEFT:
			car.turnLeft();
			break;
		case BoardConstants.MOVE:
			car.move(maxXBound, maxYBound);
			break;
		default:
			break;
		}

	}

	private Car createCarObject(String carFirstPositionString) {
		Car car = new Car();
		String[] carFirstPositionStringArray = carFirstPositionString.split(" ");
		if (carFirstPositionStringArray.length == BoardConstants.CAR_FIRST_DIRECTION_INDEX + 1) {
			int carFirstXPoint = Integer
					.parseInt(carFirstPositionStringArray[BoardConstants.CAR_FIRST_X_POSITION_INDEX]);
			int carFirstYPoint = Integer
					.parseInt(carFirstPositionStringArray[BoardConstants.CAR_FIRST_Y_POSITION_INDEX]);
			if (carFirstXPoint > maxXBound || carFirstYPoint > maxYBound) {
				String message = String.format(
						"Car First Point cannot greater than max x bound:%d or max y bound:%d, x:%d,y:%d", maxXBound,
						maxYBound, carFirstXPoint, carFirstYPoint);
				System.out.println(message);
			} else {
				car.setPoint(new Point(carFirstXPoint, carFirstYPoint));
			}
			car.setDirection(BoardConstants.MAIN_DIRECTONS
					.get(DirectionType.valueOf(carFirstPositionStringArray[BoardConstants.CAR_FIRST_DIRECTION_INDEX])));
		}
		return car;
	}

	private void setBound(String boardAreaAsString) {
		String[] s = boardAreaAsString.split(" ");
		if (s.length == BoardConstants.BOARD_AREA_Y_BOUND + 1) {
			maxXBound = Integer.parseInt(s[BoardConstants.BOARD_AREA_X_BOUND]);
			maxYBound = Integer.parseInt(s[BoardConstants.BOARD_AREA_Y_BOUND]);
		}
	}

	public List<Car> getCarList() {
		return carList;
	}

	@Override
	public String toString() {
		return "{" + this.printCarsInfo() + "}";
	}

	private String printCarsInfo() {
		String result = "";
		for (Car c : carList) {
			result += c.toString() + ",";
		}
		result = result.substring(0, result.length() - 1);
		return result;
	}

}
