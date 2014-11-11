package org.crowdMotion.utils;

import java.awt.Color;
import java.awt.GridLayout;

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
	
	
	
	public MapRender() 
	{
		super();
		
		this.setLayout(new GridLayout(2, 1));
		
		top = new JPanel();
		top.setBackground(Color.BLUE);
		
		
		bottom = new JPanel();
		bottom.setBackground(Color.RED);
		bottom.setLayout(new GridLayout(1, 2));
		
		bottomLeftChild = new JPanel();
		bottomLeftChild.setBackground(Color.GREEN);
		bottomLeftChild.setLayout(new GridLayout(1, 4));
		
		bottomRightChild = new JPanel();
		bottomRightChild.setBackground(Color.YELLOW);
		bottomRightChild.setLayout(new GridLayout(2, 3));
		
		
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
		
		bottomRightChild.add(gate1Label);
		bottomRightChild.add(gate2Label);
		bottomRightChild.add(speedLabel);
		bottomRightChild.add(gate1);
		bottomRightChild.add(gate2);
		bottomRightChild.add(speed);
		
		
		bottom.add(bottomLeftChild);
		bottom.add(bottomRightChild);
		
		this.add(top);
		this.add(bottom);
		
	}

}
