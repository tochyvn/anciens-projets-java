package geometrie;

public class Point {
	
	private static int DFL_X = 0;
	private static int DFL_Y = 0;
	
	private double x;
	private double y;

	public Point() {
		
	}
	
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public void move(int x, int y) {
		this.setX(this.getX() + x);
		this.setY(this.getX() + y);
	}
	
	@Override
	public String toString() {
		return "("+this.x+", "+this.y+")";
	}

}
