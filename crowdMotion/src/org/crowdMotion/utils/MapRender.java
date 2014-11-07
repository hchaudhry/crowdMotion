package org.crowdMotion.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class MapRender extends JPanel{

	JPanel panelTop;
	JPanel panelMainBottomContainer;
	JPanel panelBottomLeft;
	JPanel panelBottomRight;

	public MapRender() {
		super();

		this.setLayout(new BorderLayout());
		
		panelTop = new JPanel();
		panelMainBottomContainer = new JPanel();
		panelBottomLeft = new JPanel();
		panelBottomRight = new JPanel();
		
		panelBottomLeft.setPreferredSize(new Dimension(this.getWidth() / 2, 100));
		
		panelMainBottomContainer.add(panelBottomLeft, BorderLayout.WEST);
		panelMainBottomContainer.add(panelBottomRight, BorderLayout.EAST);
		
		panelTop.setBackground(Color.blue);
		panelBottomLeft.setBackground(Color.green);
		panelBottomRight.setBackground(Color.RED);
		
		
		this.add(panelTop, BorderLayout.CENTER);
		this.add(panelMainBottomContainer, BorderLayout.SOUTH);
		
		
	}

}
