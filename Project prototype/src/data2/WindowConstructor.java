package data2;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.*;

public class WindowConstructor extends WindowAdapter{
	
	private Color BackGroundColorB;
	private Panel Button;
	
	//creates a color based of rgb color scale and returns it
	public Color getColor( int x, int y, int z) {
		
		Color ColorSet = new Color(x, y, z);
		
		BackGroundColorB = ColorSet;
		
		return BackGroundColorB;
		
	}
	
	// creates a panel with a single button
	public Panel GameScreen(Panel setpanel, int[] array) {

		
		//int[] values = new int[] {1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0};
		
		Panel gameControl = new Panel();
		gameControl.setBackground(Color.darkGray);
	    
		gameControl.setBounds(100,150,600,200);
		int i = 1;
		
		// For loop for creating buttons along the y an x axis
		for (int y = 10; y < 210; y+=50) {
			for (int x = 50; x < 550; x+=50) {
				Button square = new Button("" + i);
				square.setBounds(x,y,30,30); 
				
				square.setBackground(Color.GREEN);
				
				if ( array[i-1] == 1) {
					square.setBackground(Color.RED);
					square.setActionCommand("1");
					
				} else if ( array[i-1] == 0) {
					square.setBackground(Color.GREEN);
					square.setActionCommand("0");
				} else {
					square.setBackground(Color.LIGHT_GRAY);
				}
				
				//square.setActionCommand("1");
				
				gameControl.add(square);
			
				i++;
				
				// actions that occur when a button is pressed, if green it becomes red and vice versa its the same with 1 and 0
				// array values will be used to store the state of the game along with deciding the games functionality when thats completed
				square.addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{ 
						
						if (square.getBackground() == (Color.GREEN)) {
							square.setBackground(Color.RED);
							
						} else if (square.getBackground() == (Color.RED)) {
							square.setBackground(Color.GREEN);
						}
						
						int x = Integer.valueOf(e.getActionCommand());
						int y = Integer.valueOf(square.getLabel());
						
						if (x == 1) {
							square.setActionCommand("0");
							
							array[y - 1] = 0;
							
						} else if (x == 0) {
							square.setActionCommand("1");
							
							array[y - 1] = 1;
						}
						
					}
				});
			}
		}
		// attaches button to panel
		
		setpanel.add(gameControl);
		return gameControl;//returns pannel to UI to be attached
	}
	
	
	public void SaveButton(Panel setpanel, int[] Transferarray) {
		
		
		Button SAVE = new Button("SAVE GAME");
		SAVE.setBounds(350,500,100,50); 
		setpanel.add(SAVE);
        
        
		
		// button to test saving data to FunSquareGameData.txt file.
		SAVE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				
				try {
				
				//}
				File File1 = new File("src/data2/FunSquareGameData.txt");
				File SaveFile = new File("src/data2/TransferData.txt");
				//Scanner scanner1 = new Scanner(SaveFile);
				BufferedReader READER = new BufferedReader(new FileReader(File1));
				BufferedWriter WRITER = new BufferedWriter(new FileWriter(SaveFile));
				
				//while (READER.hasNextLine()) {
					
					String data = READER.readLine();
					String check = "[OPEN]";
					int A = 0;
					while(data != null) {
						
						//checks to see if ther'es an open slot, if there is data is saved and A is changed so it doesn't override other open spaces
						if ((data.equals(check) == true) && (A == 0)) {
							
							// Value used to retrieve data, it is static right now for testing but will be dynamic later on.
							WRITER.write("[1]");
							WRITER.write("\n");
							for(int i = 0; i < 40; i++) {
								WRITER.write(String.valueOf(Transferarray[i]));
							
							}
							
							WRITER.write("\n");
							WRITER.flush();
							A = 1;
							
						} else {
						//writes the rest of the data over
						WRITER.write(data);
						WRITER.write("\n");
						WRITER.flush();
						}
						
						data = READER.readLine();
					}
					
					WRITER.close();
					READER.close();
		
				//}
				
				
				} catch (IOException e1) {
			      System.out.println("An error occurred.");
			    }
				
				// reWrites FunSquareGameData.txt using the temporary file TransferData.txt
				try {
					
					//}
					File File2 = new File("src/data2/TransferData.txt");
					File SaveFile2 = new File("src/data2/FunSquareGameData.txt");
					
					
					BufferedReader READER2 = new BufferedReader(new FileReader(File2));
					BufferedWriter WRITER2 = new BufferedWriter(new FileWriter(SaveFile2));
					
						
						String data2;
						while((data2 = READER2.readLine()) != null) {
							
							WRITER2.write(data2);
							WRITER2.write("\n");
							WRITER2.flush();
						}
						
						WRITER2.close();
						READER2.close();
						
				} catch (IOException e1) {
					System.out.println("An error occurred.");
				}

			}
		});
		
		
	}
	
	
	
}
