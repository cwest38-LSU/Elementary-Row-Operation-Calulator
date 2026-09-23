public class EROCalc {
    //NOTE - setting up matrix value
    private int[][] myMatrix;

    public EROCalc(int[][] matrix){
        myMatrix = matrix;
    }

    public int getLength(int row){
        return myMatrix[(row)].length;
    }
    public void add(int num, int row1, int row2){
        for(int i = 0; i < this.getLength(row1); i++){
            myMatrix[(row2)][i] += num * myMatrix[(row1)][i];
        }
    }

    public void multiply(int num, int row){
        for(int i = 0; i < this.getLength(row); i++){
            myMatrix[(row)][i] *= num;
        }
    }

    public void swap(int row1, int row2){
        int length = this.getLength(row1); // didn't feel like typing it twice
        int[] temp;
        temp = new int[length];

        for (int i = 0; i < length; i++){
            temp[i] = myMatrix[(row1)][i]; // fills temp array with the values from row1
        }
        for (int i = 0; i < length; i++){
            myMatrix[(row1)][i] = myMatrix[(row2)][i]; // fills row1 with entries from row2
        }
        for (int i = 0; i < length; i++){
            myMatrix[row2][i] = temp[i]; // fills row2 with entreis from temp array
        }
    }

    public void printOut(){
        for(int row = 0; row < myMatrix.length; row++){
            if (row == 0){System.out.print("/");} else if (row == (myMatrix.length-1)){System.out.print("\\");} else {System.out.print("|");}
            for(int col = 0; col < myMatrix[row].length; col++){
                if(col != myMatrix[row].length - 1){
                    System.out.printf("%d\t", myMatrix[row][col]);
                } else {
                    System.out.printf("%d", myMatrix[row][col]);
                }
            }
            if (row == 0){System.out.print("\\");} else if (row == (myMatrix.length-1)){System.out.print("/");} else {System.out.print("|");}
            System.out.println("");
        }
        System.out.println("");
    }


}