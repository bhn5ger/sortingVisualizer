package com.sorting.visualizer;

import java.awt.Color;

import javax.swing.JPanel;

public class InsertionSort {
	public static Color darkGreen = new Color(0 , 153, 0);
	public static int speed = 500;
	
	
	
    /*Function to sort array using insertion sort*/
    public static void sort(JPanel arr[]) 
    { 
    
        int n = arr.length; //original
        for (int i = 1; i < n; ++i) { //original
        	if(arr[i] == null) break;

			try {
				Sort.displayLoadingCaption(0, "insertion sort");
				Thread.sleep(speed); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	
			SinusoidSegment.segments[i].setColor(Color.red); 
			SinusoidSegment.segments[i].repaint();
			
            JPanel key = arr[i]; //original
            SinusoidSegment key2 = SinusoidSegment.segments[i];
            
            int j = i - 1; //original
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j].getBounds().getWidth() > key.getBounds().getWidth()) { //original
                arr[j + 1] = arr[j]; //original
                SinusoidSegment.segments[j+1] = SinusoidSegment.segments[j];
                
    			try {
    				Sort.displayLoadingCaption(1, "insertion sort");
    				Thread.sleep(speed); 
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
            	
    			SinusoidSegment.segments[j].setColor(darkGreen); 
    			SinusoidSegment.segments[j].repaint();
    			            	
                double shift = arr[j].getBounds().getWidth() - key.getBounds().getWidth();
                double keyXPosTemp = key.getBounds().getX();
                key.setBounds((int)arr[j].getBounds().getX(), Window.cycleYPos, (int)key.getBounds().getWidth() ,100);
                arr[j].setBounds((int)(keyXPosTemp - shift), Window.cycleYPos, (int)arr[j].getBounds().getWidth() ,100);
                

                
                j = j - 1; //original
                
                Sort.clearColors(i-1);
            } 
            arr[j + 1] = key; //original
            SinusoidSegment.segments[j+1] = key2;
           
        }
        
        
        
     
        
    } 
}






