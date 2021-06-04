package com.ste;

public class Direction {

	private Direction left;
	private Direction right;
	private int moveAmount;
	private DirectionType type;

	public Direction(DirectionType type) {
		super();
		this.type = type;
	}

	public Direction getLeft() {
		return left;
	}

	public void setLeft(Direction left) {
		this.left = left;
	}

	public Direction getRight() {
		return right;
	}

	public void setRight(Direction right) {
		this.right = right;
	}

	public int getMoveAmount() {
		return moveAmount;
	}

	public void setMoveAmount(int value) {
		this.moveAmount = value;
	}

	public DirectionType getType() {
		return type;
	}

	public void setType(DirectionType type) {
		this.type = type;
	}

}
