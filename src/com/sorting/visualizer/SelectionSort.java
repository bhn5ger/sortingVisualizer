package com.sorting.visualizer;

import java.awt.Color;

import javax.swing.JPanel;

public class SelectionSort{
	
	public static Color darkGreen = new Color(0 , 153, 0);
	public static int speed = 500;

	
	
	
    public static void sort(Cycle arr[]) 
    { 
        int n = arr.length; 
  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 	

			if(Cycle.cycles[i] != null) { //Highlight new index i green
				Cycle.cycles[i].setColor(darkGreen);
				Cycle.cycles[i].repaint();
			}

        	
            // Find the minimum element in unsorted array 
            int min_idx = i; 
           
          
            
            for (int j = i+1; j < n; j++) {
            	
            	if(arr[j] == null) {
            		break;
            	}
            	
			
				try {
					Sort.displayLoadingCaption(0, "selection sort");
					Thread.sleep(speed); 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
				Cycle.cycles[j].setColor(Color.red); //Highlight new index j red
				Cycle.cycles[j].repaint();	
		
            	 
            	if(Cycle.cycles[j-1].getColor() != darkGreen && j-1 != min_idx) { //Make previous index j back to white
    				Cycle.cycles[j-1].setColor(Color.white);
    				Cycle.cycles[j-1].repaint();
            		
            	}
            	if(j == Cycle.numberOfCycles - 1 && j != min_idx) {
    				try {
    					Sort.displayLoadingCaption(1, "selection sort");
    					Thread.sleep(speed);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
            		Cycle.cycles[j].setColor(Color.white);
            		Cycle.cycles[j].repaint();
            	}
            	

            	

            	if (arr[j].cycleWaveLength < arr[min_idx].cycleWaveLength){

            		
            		if(Cycle.cycles[min_idx].getColor() != darkGreen) { //Make previous minimum index back to white

                    	Cycle.cycles[min_idx].setColor(Color.white);
        				Cycle.cycles[min_idx].repaint();
            			
            		}

                	

                	
                		
                		min_idx = j; 
                	
                    						
                     
	
            	}	
            	if(min_idx > i) {
                	Cycle.cycles[min_idx].setColor(Color.red); //Highlight new minimum index
    				Cycle.cycles[min_idx].repaint();
            		
            	}
            	
            	Sort.clearColors(i); // make all the cycles behind cycle index i white
            // Swap the found minimum element with the first 
            // element
            	
      
            }

            
            
            if(Window.segmentPanels[min_idx] != null) {
                Cycle temp = arr[min_idx]; 
                double temp2 = Window.segmentPanels[min_idx].getBounds().getX();
                JPanel temp3 = Window.segmentPanels[min_idx];
                
                
                
                
                
    			try {
    				Sort.displayLoadingCaption(2, "selection sort");
    				Thread.sleep(speed);
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
                
    			Cycle.cycles[i].setColor(Color.white); //Make previous index i back to white
    			Cycle.cycles[i].repaint();
                
                
    			
                
                
                
                
                arr[min_idx] = arr[i]; 
                Window.segmentPanels[min_idx].setBounds((int)Window.segmentPanels[i].getBounds().getX(), Window.cycleYPos, (int)Window.segmentPanels[min_idx].getBounds().getWidth(), 100);
                Window.segmentPanels[min_idx] = Window.segmentPanels[i];
                
                
                double shift = Window.segmentPanels[i].getBounds().getWidth() - temp3.getBounds().getWidth();
                
                //Shift cycles in between the two cycles being switched
                for(int k = 0; k < Window.segmentPanels.length; k++) {
                	
                	if(Window.segmentPanels[k] == null) break;
                	
                	else if(Window.segmentPanels[k].getBounds().getX() > (int)Window.segmentPanels[i].getBounds().getX()
                		&& Window.segmentPanels[k].getBounds().getX() < (int)temp2){
                		
                		Window.segmentPanels[k].setBounds((int)(Window.segmentPanels[k].getBounds().getX() - shift), Window.cycleYPos, (int)Window.segmentPanels[k].getBounds().getWidth() ,100);
                		
                		
                		
                	}
                	 
                	
                }
                
                
                
                arr[i] = temp; 
                Window.segmentPanels[i].setBounds((int)(temp2 - shift), Window.cycleYPos, (int)Window.segmentPanels[i].getBounds().getWidth(), 100);
                Window.segmentPanels[i] = temp3;
         	
            }

           
            
        }
        

  
      
    }  
	

    
    
	
	
}
