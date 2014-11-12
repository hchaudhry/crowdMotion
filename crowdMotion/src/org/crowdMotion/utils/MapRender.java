package org.crowdMotion.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MapRender extends JPanel
{
	 
	private JPanel top;
	private JPanel bottom;
	private JPanel bottomLeftChild;
	private JPanel bottomRightChild;
	private JLabel displacement;
	private JLabel round;
	private JLabel displacementMouseNumber;
	private JLabel arrivedMouseNumber;
	
	private JLabel gate1Label;
	private JLabel gate2Label;
	private JLabel speedLabel;
	
	private JTextField gate1;
	private JTextField gate2;
	private JTextField speed;
	
	private GridBagConstraints topConstraints;
	private GridBagConstraints bottomConstraints;
	
	private JButton run;
	
	private MapLinesContainer mapLinesContainer;
	private JLabel symbolsLine;
	
	
	public MapRender(MapLinesContainer container) 
	{
		super();
		
		mapLinesContainer = container;
		symbolsLine = new JLabel();
		
		
		this.setLayout(new GridBagLayout());
		
		top = new JPanel();
	//	top.setBackground(Color.BLUE);
		displaySymbolsByLine(container.getLines()); //added
		
		topConstraints = new GridBagConstraints();
		topConstraints.fill = GridBagConstraints.HORIZONTAL;
		topConstraints.gridx = 0;
		topConstraints.gridy = 0;
		topConstraints.ipady = 380;
		topConstraints.weightx = 1.0;

		bottom = new JPanel();
		bottom.setBackground(Color.RED);
		bottom.setLayout(new BorderLayout());
		
		bottomConstraints = new GridBagConstraints();
		bottomConstraints.fill = GridBagConstraints.HORIZONTAL;
		bottomConstraints.gridx = 0;
		bottomConstraints.gridy = 1;
		bottomConstraints.ipady = 50;
		
		bottomLeftChild = new JPanel();
		bottomLeftChild.setBackground(Color.GREEN);
		bottomLeftChild.setLayout(new GridLayout(1, 4));
		
		bottomRightChild = new JPanel();
		bottomRightChild.setBackground(Color.YELLOW);
		bottomRightChild.setLayout(new GridLayout(2, 4));

		
		
		displacement = new JLabel(Constants.DEPLACEMENTS);
		round = new JLabel(Constants.TOUR);
		displacementMouseNumber = new JLabel(Constants.SOURIS_EN_DEPLACEMENT);
		arrivedMouseNumber = new JLabel(Constants.SOURIS_ARRIVEES);
		
		bottomLeftChild.add(displacement);
		bottomLeftChild.add(round);
		bottomLeftChild.add(displacementMouseNumber);
		bottomLeftChild.add(arrivedMouseNumber);
	
		
		
		gate1Label = new JLabel(Constants.PORTE_1);
		gate2Label =  new JLabel(Constants.PORTE_2);
		speedLabel = new JLabel(Constants.VITESSE) ;
		gate1 = new JTextField();
		gate2 = new JTextField();
		speed = new JTextField();
		run = new JButton(Constants.LANCER);
		
		
		bottomRightChild.add(gate1Label);
		bottomRightChild.add(gate2Label);
		bottomRightChild.add(speedLabel);
		bottomRightChild.add(run);
		bottomRightChild.add(gate1);
		bottomRightChild.add(gate2);
		bottomRightChild.add(speed);
	
		
		bottom.add(bottomLeftChild, BorderLayout.WEST);
		bottom.add(bottomRightChild, BorderLayout.CENTER);

		
		
		
		this.add(top, topConstraints);
		this.add(bottom, bottomConstraints);
		
		
	}
	
	
	public void displaySymbolsByLine(List<String> lines)
	{
		for(String currentLine : lines)
		{
			System.out.println(currentLine);
			symbolsLine.setText(currentLine);
			top.add(symbolsLine);
			
			
			
		}
	}

}
