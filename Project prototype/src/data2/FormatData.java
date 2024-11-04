
//meant to retrieve data from FunsquareGameData.txt and organize it for use by the UI

package data2;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FormatData {
	
	//private static int ArrayNumber;
	
	private int[] Slot1 = {1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0};
	// Filled with a standard layout to insure the load button always functions.
	
	//
	//private int[] Slot1 = new int[40];
	
	public int[] variables() {
		
		
		try {
			File File3 = new File("src/data2/FunSquareGameData.txt");
		
			BufferedReader READER3 = new BufferedReader(new FileReader(File3));
			
			
			String data3 = READER3.readLine();
			//will be changed to a dynamic value later on
			
			
			while(data3 != null) {
				
				
				if ((data3.equals("[1]") == true)) {
					
					data3 = READER3.readLine();
					int[] place = new int[40];
					for (int i = 0; i < 40; i++) {
						
						//B = Integer.valueOf(data3);
						
						Slot1[i] = Character.getNumericValue(data3.charAt(i));
					
					}
					break;
				}
				data3 = READER3.readLine();
			
			}
			READER3.close();
			
		} catch (IOException e1) {
			System.out.println("An error occurred.");
		}
		
		return Slot1;
	}
	
	
	
	
	
	
	
}
