package mountain;

import java.util.LinkedList;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class FixedMountain extends Fractal {
	private Point p1, p2, p3;
	private double dev;
	private LinkedList<Side> sides;

	public FixedMountain(Point p1, Point p2, Point p3, double dev) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.dev = dev;
		sides = new LinkedList<Side>();
	}

	public void draw(TurtleGraphics turtle) {
		turtle.moveTo(p1.getX(), p1.getY());
		fractalTriangle(turtle, p1, p2, p3, order, dev);
	}

	private void fractalTriangle(TurtleGraphics turtle, Point p1, Point p2,
			Point p3, int order, double dev) {
		if (order == 0) {
			turtle.moveTo(p1.getX(), p1.getY());
			turtle.forwardTo(p2.getX(), p2.getY());
			turtle.forwardTo(p3.getX(), p3.getY());
			turtle.forwardTo(p1.getX(), p1.getY());
		} else {
			double temp = RandomUtilities.randFunc(dev);
			Point p12 = getNewMidPoint(p1,p2,temp);
			Point p23 = getNewMidPoint(p2, p3, temp);
			Point p31 = getNewMidPoint(p3, p1, temp);
			
			fractalTriangle(turtle, p12, p23, p31, order - 1, dev / 2);
			fractalTriangle(turtle, p2, p23, p12, order - 1, dev / 2);
			fractalTriangle(turtle, p3, p23, p31, order - 1, dev / 2);
			fractalTriangle(turtle, p1, p12, p31, order - 1, dev / 2);
		}
	}

	@Override
	public String getTitle() {
		return "FixedMountain";
	}

	private Point getNewMidPoint(Point p1, Point p2, double temp) {
		Point p = new Point((p1.getX() + p2.getX()) / 2, temp
				+ (p1.getY() + p2.getY()) / 2);
		Side tempS = new Side(p1, p2, p);
		boolean contains = false;
		for (Side s : sides) {
			if (s.equals(tempS)) {
				p = s.getM();
				sides.remove(s);
				contains = true;
				break;
			}
		}
		if (!contains) {
			sides.add(new Side(p1, p2, p));
		}
		return p;
	}
}