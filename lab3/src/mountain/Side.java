package mountain;

public class Side {
	private Point p1, p2, middlePoint;

	public Side(Point p1, Point p2, Point m) {
		this.p1 = p1;
		this.p2 = p2;
		middlePoint = m;
	}

	private Point calcMiddle() {
		return new Point((p1.getX() + p2.getX()) / 2,
				(p1.getY() + p2.getY()) / 2);
	}

	public Point getp1() {
		return p1;
	}

	public Point getp2() {
		return p2;
	}
	
	public Point getM(){
		return middlePoint;
	}

	public boolean equals(Side s) {
		// TODO Auto-generated method stub
		return p1 == s.getp1() && p2 == s.getp2() || p2 == s.getp1()
				&& p1 == s.getp2();
	}

}
