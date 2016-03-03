package fractal;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;

public class OrderUpButton extends JButton implements ActionListener {
	private FractalView view;

	public OrderUpButton(FractalView view) {
		super("8=====0");
		this.view = view;
		addActionListener(this);
		this.setToolTipText("…kar fraktalens ordning.");
	}

	public void actionPerformed(ActionEvent e) {
		Fractal fractal = view.getFractal();
		fractal.setOrder(fractal.getOrder() + 1);
		super.setFont(new Font("Arial", Font.PLAIN, fractal.getOrder() * 10));
		view.updateDrawing();
	}

}