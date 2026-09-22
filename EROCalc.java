import java.util.Arrays;

public class ArrayCalc {
    //NOTE - setting up matrix value
    private int[][] myMatrix;

    public ArrayCalc(int[][] matrix){
        myMatrix = matrix;
    }

    public int getLength(int row){
        return myMatrix[(row-1)].length;
    }
    public void add(int num, int row1, int row2){
        for(int i = 0; i < this.getLength(row1); i++){
            myMatrix[(row2-1)][i] += num * myMatrix[(row1-1)][i];
        }
    }

    public void multiply(int num, int row){
        for(int i = 0; i < this.getLength(row); i++){
            myMatrix[(row-1)][i] *= num;
        }
    }

    public void swap(int row1, int row2){
        int length = this.getLength(row1); // didn't feel like typing it twice
        int[] temp;
        temp = new int[length];

        for (int i = 0; i < length; i++){
            temp[i] = myMatrix[(row1-1)][i]; // fills temp array with the values from row1
        }
        for (int i = 0; i < length; i++){
            myMatrix[(row1-1)][i] = myMatrix[(row2-1)][i]; // fills row1 with entries from row2
        }
        for (int i = 0; i < length; i++){
            myMatrix[row2-1][i] = temp[i]; // fills row2 with entreis from temp array
        }
    }

    public String toString(){
        return (Arrays.deepToString(myMatrix));
    }


}