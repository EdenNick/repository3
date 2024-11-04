//Project Name: fun square Game
//Purpose: create a project prototype
//Created by Nicholas Edenfield
//Date: 10/21/2024
package main;


//imported packages
import java.util.*;
import java.awt.*;
import java.awt.event.*;  

import data2.WindowConstructor;
import data2.FormatData;

public class Main extends WindowAdapter{
	
	public Panel Background;
	public Color BackGroundColor;
	
	WindowConstructor xyz = new WindowConstructor();
	FormatData zyx = new FormatData();
	// object of Frame  
    Frame GameWindow;
    
    //loading array
    static int[] newGame2 = null;
    // class constructor  
    public Main() {    
    	
    	
    	// creating the frame  
    	GameWindow = new Frame();    
    	// adding  WindowListener to the frame  
    	GameWindow.addWindowListener (this);    
        
    	// setting the size, layout and visibility of frame  
    	GameWindow.setSize (1000, 800);    
    	
    	GameWindow.setLayout(null);    
    	GameWindow.setVisible (true);
    	
    	TitleScreen();
    }
    public void TitleScreen() {
    	// sets BackGround color to greyblue
    	BackGroundColor = xyz.getColor(115, 147, 179);
    	// Creates The background (a panel)
    	BackgroundPanel();
    	
        // Add title (a label) 
        Label Title;
        Title = new Label ("Fun Square Game");
        Font TitleFont = new Font("Times New Roman", Font.BOLD, 24);
        Title.setFont(TitleFont);
        Title.setBounds(285,250,220,24);
        Background.add(Title);
        
        
        //adds the close game and start game button
        TransferButton(Background,350,600,100,50,"Close Game", 0);
        TransferButton(Background,350,550,100,50,"Load Game", 3);
        TransferButton(Background,350,500,100,50,"Start", 1);
        
    } 
    
    public static int[] arrayValues(){
    	
    	int[] values = new int[] {1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0};
    	
    	return values;
	}

	
	public void TransferButton(Panel BackGround, int a, int b, int c, int d, String x, int y) {
		
		//Creates array to be used
		
		// Creates Button and sets its position
		Button Transfer = new Button(x);
		Transfer.setBounds(a,b,c,d); 
        Background.add(Transfer);
        String g = Transfer.getLabel();
        
        //Determines the action of the button
        if (y == 0) { Transfer.addActionListener( new ActionListener() {
        			public void actionPerformed(ActionEvent e){
        				GameWindow.dispose();
        			}
        		});
        // Calls the gameScreen function, starting the actual game
        } else if (y == 1) {
        	Transfer.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e){
        			
        			GameWindow.remove(Background);
        			
        			int[] newGame = arrayValues();
        			GameScreenControl(newGame);
        		}
        	});
        // returns the game to the title screen
        } else if (y == 2) {
    		Transfer.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e){
    				
    				GameWindow.remove(Background);
    				
    				TitleScreen();
    			}
    		});
    	//loads save game
        } else if (y == 3) {
    		Transfer.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e){
    				
    				GameWindow.remove(Background);
    				
    				int[] newGame2 = zyx.variables();
    		    	GameScreenControl(newGame2);

    			}
    		});
        }else {
        	//closes program to avoid error
        	GameWindow.dispose();
        }
		
	}
	
	public void GameScreenControl(int[] LoadedArray) {
		
		//Creates new panel for game
		GameWindow.remove(Background);
		BackGroundColor = xyz.getColor(162, 173, 156);
		BackgroundPanel();
		
		int[] value = LoadedArray;
		
		Background.setLayout(new BorderLayout());
		xyz.GameScreen(Background, value); // < -- creates button layout from processing using an array that stores game data
		
		TransferButton(Background,350,550,100,50,"Return to Title", 2);
		xyz.SaveButton(Background, value);
	}
	
	//Creates a panel used for the background of the game
	public void BackgroundPanel() {
		
		Panel BackgroundInitialize = new Panel();
		BackgroundInitialize.setBounds(50,50,800,700);   
		BackgroundInitialize.setBackground(BackGroundColor);
        GameWindow.add(BackgroundInitialize);
		
		Background = BackgroundInitialize;
		
		
	}
	
	public static void main (String[] args) {
		
		 new Main();
		 
	}
	
	
	
}