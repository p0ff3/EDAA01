package mountain;

import fractal.*;

public class Mountain extends Fractal {
	Point p1, p2, p3;

	/**
	 * Creates an object that handles Koch's fractal.
	 * 
	 * @param length
	 *            the length of the triangle side
	 */
	public Mountain(Point p1, Point p2, Point p3) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	/**
	 * Returns the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return "BERGSMASSA";
	}

	/**
	 * Draws the fractal.
	 * 
	 * @param turtle
	 *            the turtle graphic object
	 */
	public void draw(TurtleGraphics turtle) {
		turtle.moveTo(p1.getX(), p1.getY());
		fractalTriangle(turtle, p1, p2, p3, order);
		/*
		 * turtle.moveTo(p1.getX(), p1.getY()); turtle.forwardTo(p2.getX(),
		 * p2.getY()); turtle.forwardTo(p3.getX(), p3.getY());
		 */
	}

	/*
	 * Reursive method: Draws a recursive line of the triangle.
	 */
	private void fractalTriangle(TurtleGraphics turtle, Point p1, Point p2,
			Point p3, int order) {
		if (order == 0) {
			turtle.moveTo(p1.getX(), p1.getY());
			turtle.forwardTo(p2.getX(), p2.getY());
			turtle.forwardTo(p3.getX(), p3.getY());
			turtle.forwardTo(p1.getX(), p1.getY());
		} else {
			fractalTriangle(turtle,new Point((p1.getX()+p2.getX())/2,(p1.getY()+p2.getY())/2),new Point((p2.getX()+p3.getX())/2,(p2.getY()+p3.getY())/2),new Point((p3.getX()+p1.getX())/2,(p3.getY()+p1.getY())/2),order -1);
			fractalTriangle(turtle,p1,new Point((p1.getX()+p2.getX())/2,(p1.getY()+p2.getY())/2),new Point((p3.getX()+p1.getX())/2,(p3.getY()+p1.getY())/2),order -1);
			fractalTriangle(turtle,p2,new Point((p2.getX()+p3.getX())/2,(p2.getY()+p3.getY())/2),new Point((p2.getX()+p1.getX())/2,(p2.getY()+p1.getY())/2),order -1);
			fractalTriangle(turtle,p3,new Point((p2.getX()+p3.getX())/2,(p2.getY()+p3.getY())/2),new Point((p3.getX()+p1.getX())/2,(p3.getY()+p1.getY())/2),order -1);
			/*fractalTriangle(turtle, new Point(p1.getX()+p2.getX()/2, (p1.getY()+p2.getY())/2), new Point((p2.getX()+p3.getX())/2, (p2.getY()+p3.getY())/2), p3, order - 1);*/
			

			/*
			 * fractalLine(turtle, order - 1, length / 3, alpha);
			 * fractalLine(turtle, order - 1, length / 3, alpha - 60);
			 * fractalLine(turtle, order - 1, length / 3, alpha + 60);
			 * fractalLine(turtle, order - 1, length / 3, alpha);
			 */
		}
	}
}
