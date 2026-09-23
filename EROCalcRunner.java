import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

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

            // //NOTE - Asks how many rows and columns in the matrix
            // System.out.print("How many rows? ");
            // int numRows = sc.nextInt();
            // System.out.print("How many columns? ");
            // int numCols = sc.nextInt();


            // //NOTE - Sets up initial matrix and makes a new EROCalc
            // int[][] matrix;
            // matrix = new int[numRows][numCols];
            // for(int row = 0; row < numRows; row++){
            //     for(int col = 0; col < numCols; col++){
            //         System.out.print("Num? ");
            //         matrix[row][col] = sc.nextInt();
            //     }
            //     System.out.println("\nNext row\n");
            // }
            // EROCalc myMatrix = new EROCalc(matrix);

            // Print out full matrix to double check
            myMatrix.printOut();;

            int num;
            int row1;
            int row2;

            System.out.println("What operation would you like to do? add '1', multiply '2', SWAP '3', ask for help '4', or end'-1'? Incorrect syntax will result in a repeat of this message. ");
            int operation = sc.nextInt();
            //NOTE - Starts looping to find out what the user wants to do
            while (operation != -1){
                if (operation == 1){                
                    System.out.print("Number: ");
                    num = sc.nextInt();
                    System.out.print("First row number: ");
                    row1 = sc.nextInt();
                    System.out.print("Second row number: ");
                    row2 = sc.nextInt();
                    
                    myMatrix.add(num, row1-1, row2-1); // subtracts 1 from the asked for row because 0-index
                    myMatrix.printOut();
                } else if (operation == 2){
                    System.out.print("Number: ");
                    num = sc.nextInt();
                    System.out.print("Row number: ");
                    row1 = sc.nextInt();
                    
                    myMatrix.multiply(num, row1-1); 
                    myMatrix.printOut();
                } else if (operation == 3){
                    System.out.print("First row number: ");
                    row1 = sc.nextInt();
                    System.out.print("Second row number: ");
                    row2 = sc.nextInt();

                    myMatrix.swap(row1-1, row2-1);
                    myMatrix.printOut();
                } else if(operation == 4) {
                    System.out.println("Add will ask for a number, and two rows, and will add whatever the number is times the first row to the second row.\nMultiply will ask for a number and row, and multiply the given row by the number.\nSWAP will ask for two rows and swap them.\nEnd will end the program. Do not use this until you've finished, or your progress will be lost");
                }
                System.out.println("What operation would you like to do? add '1', multiply '2', SWAP '3', ask for help '4', or end'-1'? Incorrect syntax will result in a repeat of this message. ");
                operation = sc.nextInt();
            }

            sc.close();
            scF.close();
        }
    }
}