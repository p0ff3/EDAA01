package fractal;

import mountain.Point;

import koch.Koch;
import mountain.*;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[3];
		fractals[0] = new Koch(300);
		fractals[1] = new Mountain(new Point(100, 200), new Point(400, 350), new Point(200,400));
		fractals[2] = new FixedMountain(new Point(100, 200), new Point(250, 450), new Point(500,300), 25);
	    new FractalView(fractals, "Fraktaler");
	}

}