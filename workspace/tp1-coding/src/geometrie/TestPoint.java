package geometrie;

public class TestPoint {
	
	public TestPoint() {
		
	}
	
	public static void main(String[] args) {
		Point point1 = new Point();
		Point point2 = new Point(10, 12);
		System.out.println(point1);
		System.out.println(point2);
		point1.move(10, 20);
		point2.move(-5, 5);
		System.out.println(point1);
		System.out.println(point2);
	}

}
