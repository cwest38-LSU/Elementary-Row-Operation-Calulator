import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class EROCalcRunner {
    public static void main(String[] args) throws FileNotFoundException{
        //NOTE - Scanner initialization
        Scanner sc = new Scanner(System.in);
        File mFile = new File("matrix.csv");
        try{mFile.createNewFile();} catch(IOException e){}
        finally{
            Scanner scF = new Scanner(mFile);
            int numRows = 1;
            int numCols = 1;
            
            int[][] matrix;
            matrix = new int[numRows][numCols];
            
            for(int row = 0; row <= numRows; row++){
                if(scF.hasNextLine()){
                    String currentLine = scF.nextLine();
                    Scanner scL = new Scanner(currentLine);
                    scL.useDelimiter(",");
                    if(row==0){
                        numRows = scL.nextInt();
                        numCols = scL.nextInt();
                        matrix = new int[numRows][numCols];
                    } else{
                        for(int col = 0; col < numCols; col++){
                            matrix[row-1][col] = scL.nextInt();
                        }
                    }
                    scL.close();
                }
            }
            
            EROCalc myMatrix = new EROCalc(matrix);
            
            myMatrix.printOut();;
            
            int num =  1;
            int row1 = 1;
            int row2 = 1;
            ArrayList<String> garbo = new ArrayList<>(Arrays.asList("The dumb stuff you've tried to say for some reason")); // used to consume the scanner's next input so the next one might potentially be an integer
            int tempJawn;
            boolean firstIsInt;

            System.out.println("What operation would you like to do? add '1', multiply '2', SWAP '3', ask for help '4', or end'-1'?\nIncorrect syntax will result in a repeat of this message. ");
            int operation = sc.nextInt();
            //NOTE - Starts looping to find out what the user wants to do
            while (operation != -1){
                if (operation == 1){
                    System.out.print("Number: ");
                    while(!sc.hasNextInt()){
                        garbo.add(sc.next());
                        System.out.print("Please give a valid integer. ");
                    }
                    num = sc.nextInt();
                    
                    System.out.print("First row number: ");
                    
                    
                    if (sc.hasNextInt()){
                        tempJawn = 1;
                        firstIsInt = true;
                    } else{
                        tempJawn = -1;
                        firstIsInt = false;
                    }
                    
                    while( (tempJawn <= 0 || tempJawn > myMatrix.getRows())  ||  (firstIsInt == true)) { 
                        if(firstIsInt){
                            tempJawn = sc.nextInt();
                            // this checks if we're on the first loop, and if the next input from the scanner will be an integer, then legit exits the program in like 2 lines
                        } else {
                            System.out.print("Please try again with a valid integer that is a real line in the matrix. ");    
                            // Soggy, wrong, try again
                            if(sc.hasNextInt()){
                                tempJawn = sc.nextInt();
                                // this says if it's not the first loop, is the next input from scanner an integer, and then exits the program crazy style
                            } else {
                                garbo.add(sc.next());
                                // NOW based on the setup of the while loop, it must be an int but is out of bounds
                            }
                        }
                        // but what about the print statements? Why is it only within the else?
                        // if firstIsInt, we already know there's a print statement for line one
                        // otherwise there isn't. So by not doing all that garbage, we only print out when it's necessary for the program
                        
                        firstIsInt = false;
                    }
                    row1 = tempJawn;
                    
                    System.out.print("Second row number: ");
                    // all of this is literally copy-pasted from the one above, as are the next 3 of these
                    if (sc.hasNextInt()){
                        tempJawn = 1;
                        firstIsInt = true;
                    } else {
                        tempJawn = -1;
                        firstIsInt = false;
                    }
                    while( (tempJawn <= 0 || tempJawn > myMatrix.getRows())  ||  (firstIsInt == true)) { 
                        if(firstIsInt){
                            tempJawn = sc.nextInt();
                        } else {
                            System.out.print("Please try again with a valid integer that is a real line in the matrix. ");    
                            if(sc.hasNextInt()){
                                tempJawn = sc.nextInt();
                            } else {
                                garbo.add(sc.next());
                            }
                        }
                        
                        firstIsInt = false;
                    }
                    
                    row2 = tempJawn; 
                    
                    
                    myMatrix.add(num, row1-1, row2-1); // subtracts 1 from the asked for row because 0-index
                    myMatrix.printOut();
                }
                
                else if (operation == 2){
                    System.out.print("Number: ");
                    while(!sc.hasNextInt()){
                        garbo.add(sc.next());
                        System.out.print("Please give a valid integer. ");
                    }
                    num = sc.nextInt();
                    
                    System.out.print("Row number: ");
                    
                    if (sc.hasNextInt()){
                        tempJawn = 1;
                        firstIsInt = true;
                    } else {
                        tempJawn = -1;
                        firstIsInt = false;
                    }
                    while( (tempJawn <= 0 || tempJawn > myMatrix.getRows())  ||  (firstIsInt == true)) { 
                        if(firstIsInt){
                            tempJawn = sc.nextInt();
                        } else {
                            System.out.print("Please try again with a valid integer that is a real line in the matrix. ");    
                            if(sc.hasNextInt()){
                                tempJawn = sc.nextInt();
                            } else {
                                garbo.add(sc.next());
                            }
                        }
                        
                        firstIsInt = false;
                    }
                    
                    row1 = tempJawn; 
                    
                    myMatrix.multiply(num, row1-1); 
                    myMatrix.printOut();
                }
                
                else if (operation == 3){
                    System.out.print("First row number: ");
                    
                    if (sc.hasNextInt()){
                        tempJawn = 1;
                        firstIsInt = true;
                    } else {
                        tempJawn = -1;
                        firstIsInt = false;
                    }
                    while( (tempJawn <= 0 || tempJawn > myMatrix.getRows())  ||  (firstIsInt == true)) { 
                        if(firstIsInt){
                            tempJawn = sc.nextInt();
                        } else {
                            System.out.print("Please try again with a valid integer that is a real line in the matrix. ");    
                            if(sc.hasNextInt()){
                                tempJawn = sc.nextInt();
                            } else {
                                garbo.add(sc.next());
                            }
                        }
                        
                        firstIsInt = false;
                    }
                    
                    row1 = tempJawn; 
                    
                    System.out.print("Second row number: ");
                    
                    if (sc.hasNextInt()){
                        tempJawn = 1;
                        firstIsInt = true;
                    } else {
                        tempJawn = -1;
                        firstIsInt = false;
                    }
                    while( (tempJawn <= 0 || tempJawn > myMatrix.getRows())  ||  (firstIsInt == true)) { 
                        if(firstIsInt){
                            tempJawn = sc.nextInt();
                        } else {
                            System.out.print("Please try again with a valid integer that is a real line in the matrix. ");    
                            if(sc.hasNextInt()){
                                tempJawn = sc.nextInt();
                            } else {
                                garbo.add(sc.next());
                            }
                        }
                        
                        firstIsInt = false;
                    }
                    
                    row2 = tempJawn; 
                    
                    myMatrix.swap(row1-1, row2-1);
                    myMatrix.printOut();
                }
                
                else if(operation == 4) {
                    System.out.println("Add will ask for a number, and two rows, and will add whatever the number is times the first row to the second row.\nMultiply will ask for a number and row, and multiply the given row by the number.\nSWAP will ask for two rows and swap them.\nEnd will end the program. Do not use this until you've finished, or your progress will be lost");
                }
                
                System.out.print("What operation would you like to do? add '1', multiply '2', SWAP '3', ask for help '4', or end'-1'?\nIncorrect syntax will result in a repeat of this message.");
                operation = sc.nextInt();
            }
            
            sc.close();
            scF.close();
            String[] garboArray = garbo.toArray(new String[0]);
            System.out.println(Arrays.toString(garboArray));
        }
    }
}