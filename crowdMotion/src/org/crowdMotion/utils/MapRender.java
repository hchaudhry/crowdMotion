package org.crowdMotion.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
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
	private JLabel symbolsLine;
	private JPanel buttonPanel;
	private BufferedImage buff; //get buggy if put it in local inside convertCharToSprite() ==> I don't know why
	private MapLinesContainer linesContainer;
	
	
	public MapRender(MapLinesContainer container) 
	{
		super();
		linesContainer = container;
		int rowsNumber = linesContainer.getSize();
		configureRenderLayout(rowsNumber);
		
		
		displayMap(linesContainer.getLines());
		
		
		
	}	
	
	
	public void configureRenderLayout(int rowsNumber)
	{
		this.setLayout(new GridBagLayout());
		
		top = new JPanel();
		top.setLayout(new GridLayout(rowsNumber, 1));
		
		topConstraints = new GridBagConstraints();
		topConstraints.fill = GridBagConstraints.HORIZONTAL;
		topConstraints.gridx = 0;
		topConstraints.gridy = 0;
//		topConstraints.ipady = 380;
		topConstraints.weightx = 1.0;

		bottom = new JPanel();
		bottom.setBackground(Color.RED);
		bottom.setLayout(new BorderLayout());
		
		bottomConstraints = new GridBagConstraints();
		bottomConstraints.fill = GridBagConstraints.HORIZONTAL;
		bottomConstraints.gridx = 0;
		bottomConstraints.gridy = 1;
//		bottomConstraints.ipady = 50;
		
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
		run.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("clic");
				List<ArrayList<Integer>>gatesCoordinates = getCoordinatesOfAppearancePoints(linesContainer.getLines());
				
				
				Map<Integer,String> firstlinesToRefresh = getAllContiguousAdjacentPlaces(linesContainer.getLines(), gatesCoordinates.get(0).get(0), gatesCoordinates.get(0).get(1));
				Map<Integer,String> secondlinesToRefresh = getAllContiguousAdjacentPlaces(linesContainer.getLines(), gatesCoordinates.get(1).get(0), gatesCoordinates.get(1).get(1));
				
				refreshMapAtIndexLine(linesContainer.getLines(), firstlinesToRefresh);
				refreshMapAtIndexLine(linesContainer.getLines(), secondlinesToRefresh);
				System.out.println("clic2");
				
			}
		});
		
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
	
	public String replaceCharAtWith(String line, int index, char replacement)
	{
		char[] lineAsCharsArray = line.toCharArray();
		
		lineAsCharsArray[index] = replacement;
		
		return new String(lineAsCharsArray);
		
	}
	
	public Map<Integer,String> getAllContiguousAdjacentPlaces(List<String> lines, int row, int column)
	{
		Map<Integer,String> linesToRefresh =  new HashMap<Integer, String>();
		
		
		if(lines.get(row).charAt(column + 1) == Constants.ZONE_DEPLACEMENT)
		{
			String line = replaceCharAtWith(lines.get(row), column + 1, 'S');
			linesToRefresh.put(row,line);
			
		}
		
		
		/*if(lines.get(row).charAt(column - 1) == Constants.ZONE_DEPLACEMENT)
		{
			String line = replaceCharAtWith(lines.get(row), column - 1, 'S');
			linesToRefresh.put(row,line);
		}
		
		if(lines.get(row - 1).charAt(column) == Constants.ZONE_DEPLACEMENT)
		{
			String line = replaceCharAtWith(lines.get(row - 1), column, 'S');
			linesToRefresh.put(row - 1,line);
		}
		
		
		if(lines.get(row - 1).charAt(column + 1) == Constants.ZONE_DEPLACEMENT)
		{
			String line = replaceCharAtWith(lines.get(row - 1), column + 1, 'S');
			linesToRefresh.put(row - 1,line);
		}
		
		
		if(lines.get(row - 1).charAt(column -1) == Constants.ZONE_DEPLACEMENT)
		{
			String line = replaceCharAtWith(lines.get(row - 1), column - 1, 'S');
			linesToRefresh.put(row - 1,line);
		}
		
		
		if(lines.get(row + 1).charAt(column) == Constants.ZONE_DEPLACEMENT)
		{
			String line = replaceCharAtWith(lines.get(row + 1), column, 'S');
			linesToRefresh.put(row + 1,line);
		}
		
		
		if(lines.get(row + 1).charAt(column + 1) == Constants.ZONE_DEPLACEMENT)
		{
			String line = replaceCharAtWith(lines.get(row + 1), column + 1, 'S');
			linesToRefresh.put(row + 1,line);
		}
		
		
		if(lines.get(row + 1).charAt(column -1) == Constants.ZONE_DEPLACEMENT)
		{
			String line = replaceCharAtWith(lines.get(row + 1), column - 1, 'S');
			linesToRefresh.put(row + 1,line);
		}
		
		System.out.println(linesToRefresh);*/
		return linesToRefresh;
	}
	
	public List<ArrayList<Integer>> getCoordinatesOfAppearancePoints(List<String> lines)
	{
		char[] lineAsArray = null;
		List<ArrayList<Integer>> gateIndexes =  new ArrayList<ArrayList<Integer>>(2);
		
		for(String currentLine : lines)
		{
			lineAsArray = currentLine.toCharArray();
			
			for(int i=0; i<lineAsArray.length; i++)
			{
				if(lineAsArray[i] == Constants.POINT_APPARITION)
				{
					ArrayList<Integer> coordinates = new ArrayList<Integer>(2);
					coordinates.add(lines.indexOf(currentLine)); // y
					coordinates.add(i); // x
					gateIndexes.add(coordinates);
				}
			}
		}
		
		return gateIndexes;
	}
	
	
	public void refreshMapAtIndexLine(List<String> previousLines ,Map<Integer,String> linesToRefreshWithIndex)
	{
		System.out.println(previousLines);
		
		for(Integer currentInt : linesToRefreshWithIndex.keySet())
		{
			String toRevove = previousLines.get(currentInt);
			previousLines.remove(toRevove);
			previousLines.add(currentInt, linesToRefreshWithIndex.get(currentInt));
			
			//BEGIN TEST
			List<ImageIcon> icons = convertCharsLineToIconsLine(previousLines.get(currentInt));
			
			symbolsLine = null;
			for (ImageIcon currentIcon : icons) 
			{
				symbolsLine = new JLabel(currentIcon);
				top.add(symbolsLine);
				symbolsLine = null;
			}
			//END TEST
		
		}
		
		System.out.println(previousLines);
		//displayMap(previousLines);
		
		
		
		this.validate();
		
	}
	
	public void displayMap(List<String> lines)
	{
		symbolsLine = null;
		for(String currentLine : lines)
		{
			List<ImageIcon> icons = convertCharsLineToIconsLine(currentLine);
		
			for (ImageIcon currentIcon : icons) 
			{
				symbolsLine = new JLabel(currentIcon);
				top.add(symbolsLine);
				symbolsLine = null;
			}
		}
	}
	
	
	public List<ImageIcon> convertCharsLineToIconsLine(String line)
	{
		List<ImageIcon> icons = new ArrayList<ImageIcon>();
		
		char[] lineAsArray = line.toCharArray();
		
		for(char currentChar :lineAsArray)
		{
			BufferedImage bufferedImage = convertCharToSprite(currentChar);
			icons.add(new ImageIcon(bufferedImage));
		}
		
		return icons;
	}
	
	
	public BufferedImage convertCharToSprite(Character character)
	{
		Sprite sprit = new Sprite();
		
		if(character.equals(Constants.MUR))
		{
			buff = sprit.getSpriteFile("/home/neimad/Bureau/sprite.png", 0, 1);
		}
		
		
		if(character.equals(Constants.ZONE_HERBE))
		{
			buff = sprit.getSpriteFile("/home/neimad/Bureau/sprite.png", 0, 2);
		}
		
		
		if(character.equals(Constants.ZONE_DEPLACEMENT))
		{
			buff = sprit.getSpriteFile("/home/neimad/Bureau/sprite.png", 0, 0);
		}
		
		
		if(character.equals(Constants.POINT_APPARITION))
		{
			buff = sprit.getSpriteFile("/home/neimad/Bureau/sprite.png", 0, 3);
		}
		
		
		if(character.equals(Constants.POINT_ARRIVEE))
		{
			buff = sprit.getSpriteFile("/home/neimad/Bureau/sprite.png", 0, 5);
		}
		
		
		if(character.equals(Constants.SOURIS))
		{
			buff = sprit.getSpriteFile("/home/neimad/Bureau/sprite.png", 0, 4);
		}
		
		return buff;
		
	}
	
	
	
	
	

}
