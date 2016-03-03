package fractal;
import javax.swing.*;

import sudokuSolver.OneLetterField;

import java.awt.*;

public class DrawingPanel extends JPanel {
	FractalView view;

	public DrawingPanel(FractalView view) {
		this.view = view;
		setBorder(BorderFactory.createLineBorder(Color.black));
		GridLayout grid = new GridLayout(9, 9, 10, 10);
		setLayout(grid);
		OneLetterField field = new OneLetterField();
		OneLetterField[][] fields = new OneLetterField[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				fields[i][j] = field;
				field = new OneLetterField();
				add(field);
			}
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(600,600);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Fractal fractal = view.getFractal();
		g.drawString(fractal.toString(), 10, 20);
		g.setClip(0, 0, (int) getSize().getWidth(), (int) getSize().getHeight());
		fractal.draw(new TurtleGraphics(g));
	}  
}
