public class NQueen {

    public static boolean isSave(int [][] board,int row,int col,int n){

        int i,j;
        //check for left row
        for ( i = 0; i < col; i++) {
            if (board[row][i]==1){
                return false;
            }
        }

        //check for upper diagonal left
        for ( i = row, j = col; i >= 0 && j >= 0 ; i--,j--) {
            if (board[i][j]==1){
                return false;
            }
        }

        //check for lower diagonal left
        for (i = row, j = col; i < n && j >= 0; i++,j--){
            if (board[i][j]==1){
                return false;
            }
        }

        return true;

    }
    public static boolean solveQueen(int [][] board,int column,int n)
    {

        //base condition
        if (column>=n){
            return true;
        }

        //consider this column and try placing all the queens one by one in all the rows

        for (int i = 0; i <n; i++)
        {
            if (isSave(board,i,column,n))
            {
                //place the queen
                board[i][column]=1;

                //recursive call to place the queen
                if (solveQueen(board,column+1,n)){
                    return true;
                }

                //backtrack
                board[i][column]=0;
            }
        }

        //if it is not possible to place the queen in any row of the given column then return false
        return false;
    }

    public static void print(int[][] array){
        for (int[] ints : array) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int [][] board = new int[8][8];

        if (NQueen.solveQueen(board,0,board.length)) {
            print(board);
        }

        else {
            System.out.print("Solution does not exist");
        }
    }
}
