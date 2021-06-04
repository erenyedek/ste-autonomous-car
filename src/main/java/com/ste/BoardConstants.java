package com.ste;

import java.util.HashMap;
import java.util.Map;

public class BoardConstants {

	public static Map<DirectionType, Direction> MAIN_DIRECTONS = new HashMap<DirectionType, Direction>();

	static {
		Direction north = new Direction(DirectionType.N);
		Direction south = new Direction(DirectionType.S);
		Direction east = new Direction(DirectionType.E);
		Direction west = new Direction(DirectionType.W);

		north.setLeft(west);
		north.setRight(east);
		north.setMoveAmount(1);

		south.setLeft(east);
		south.setRight(west);
		south.setMoveAmount(-1);

		east.setLeft(north);
		east.setRight(south);
		east.setMoveAmount(1);

		west.setLeft(south);
		west.setRight(north);
		west.setMoveAmount(-1);

		MAIN_DIRECTONS.put(DirectionType.N, north);
		MAIN_DIRECTONS.put(DirectionType.S, south);
		MAIN_DIRECTONS.put(DirectionType.E, east);
		MAIN_DIRECTONS.put(DirectionType.W, west);
	}

	public static final int BOARD_AREA_INDEX = 0;
	public static final int CAR1_FIRST_POSITION_STRING = 1;
	public static final int CAR1_COMMAND_LIST = 2;
	public static final int CAR_FIRST_X_POSITION_INDEX = 0;
	public static final int CAR_FIRST_Y_POSITION_INDEX = 1;
	public static final int CAR_FIRST_DIRECTION_INDEX = 2;
	public static final int BOARD_AREA_X_BOUND = 0;
	public static final int BOARD_AREA_Y_BOUND = 1;
	public static final char RIGHT = 'R';
	public static final char LEFT = 'L';
	public static final char MOVE = 'M';

}
