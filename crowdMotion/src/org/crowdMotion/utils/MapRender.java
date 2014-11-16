package org.crowdMotion.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.List;

import javax.swing.BoxLayout;
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
	
	private JPanel buttonPanel;
	
	
	
	public MapRender(MapLinesContainer container) 
	{
		super();
		
		mapLinesContainer = container;
		symbolsLine = new JLabel();
		
		
		
		this.setLayout(new GridBagLayout());
		
		top = new JPanel();
		top.setLayout(new GridLayout(mapLinesContainer.getLines().size(), 1));
		displaySymbolsByLine(container.getLines()); 
		
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
		buttonPanel = new JPanel();
		
		buttonPanel.add(run);
		
		bottomRightChild.add(gate1Label);
		bottomRightChild.add(gate2Label);
		bottomRightChild.add(speedLabel);
		bottomRightChild.add(new JLabel(""));
		bottomRightChild.add(gate1);
		bottomRightChild.add(gate2);
		bottomRightChild.add(speed);
		bottomRightChild.add(buttonPanel);
		
		bottom.add(bottomLeftChild, BorderLayout.WEST);
		bottom.add(bottomRightChild, BorderLayout.CENTER);

		
		
		
		this.add(top, topConstraints);
		this.add(bottom, bottomConstraints);
	}
	
	
	/*JPanel north;
	JPanel south;
	public MapRender(MapLinesContainer container) 
	{
		super();
		
		this.setLayout(new BorderLayout());
				
		north = new JPanel();
		north.setBackground(Color.GREEN);
		north.setLayout(new GridLayout(container.getLines().size(),1));
		south = new JPanel();
		south.setBackground(Color.RED);
		
		mapLinesContainer = container;
		
		
		displaySymbolsByLine(container.getLines()); 
		
		//north.add(new JLabel(container.getLines().get(5)));
		
	//	north.add(new JLabel(container.getLines().get(8)));
		
		this.add(north, BorderLayout.CENTER);
		this.add(south, BorderLayout.SOUTH);
	}
	*/
	
	public void displaySymbolsByLine(List<String> lines)
	{
		symbolsLine = null;
		for(String currentLine : lines)
		{
			System.out.println(currentLine);
			symbolsLine = new JLabel();
			symbolsLine.setText(currentLine);
			top.add(symbolsLine);
			symbolsLine = null;
		}
		
		
	}

}
