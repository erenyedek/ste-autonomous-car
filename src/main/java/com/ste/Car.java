package com.ste;

public class Car {

	private Point point = new Point(0, 0);
	private Direction direction = BoardConstants.MAIN_DIRECTONS.get(DirectionType.N);

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void turnLeft() {
		Direction leftDirection = direction.getLeft();
		this.setDirection(leftDirection);
	}

	public void turnRight() {
		Direction rightDirection = direction.getRight();
		this.setDirection(rightDirection);
	}

	public void move(int maxXBound, int maxYBound) {
		switch (direction.getType()) {
		case N:
		case S:
			if (this.checkYMovement(maxYBound)) {
				this.setPoint(new Point(this.getPoint().getX(), point.getY() + direction.getMoveAmount()));
			} else {
				String message = String.format("Y movement overflowed bound! max y bound:%d, current y pos:%d",
						maxYBound, point.getY());
				System.out.println(message);
			}
			break;
		case E:
		case W:
			if (this.checkXMovement(maxXBound)) {
				this.setPoint(new Point(point.getX() + direction.getMoveAmount(), this.getPoint().getY()));
			} else {
				String message = String.format("X movement overflowed bound! max x bound:%d, current x pos:%d",
						maxXBound, point.getX());
				System.out.println(message);
			}
			break;
		default:
			break;
		}
	}

	private boolean checkXMovement(int maxXBound) {
		return point.getX() + direction.getMoveAmount() <= maxXBound && point.getX() + direction.getMoveAmount() >= 0;
	}

	private boolean checkYMovement(int maxYBound) {
		return point.getY() + direction.getMoveAmount() <= maxYBound && point.getY() + direction.getMoveAmount() >= 0;
	}

	@Override
	public String toString() {
		return " \"" + this.point.toString() + " " + this.direction.getType().name() + "\" ";
	}

}
