public class Sudoko {
    public static boolean isSafe(int grid[][],int row, int column,int num,int n ){
        //Row clash- row has unique values
        for (int i = 0; i < n; i++) {
            if (grid[row][i]==num){
                return false;
            }
        }

        //Column clash - column has unique values
        for (int i = 0; i < n; i++) {
            if (grid[i][column]==num){
                return false;
            }
        }

        //Box clash - subgrid has unique values
        int sqrt = (int)Math.sqrt(n);
        int boxRow = row - row % sqrt;
        int boxColumn = column - column % sqrt;

        for (int i = boxRow; i <boxRow+sqrt  ; i++) {
            for (int j = boxColumn; j < boxColumn+sqrt; j++) {
                if (grid[i][j]==num){
                    return false;
                }
            }

        }

        return true;
    }

    public static boolean solve(int[][] grid,int n){
        int row = -1, column = -1;
        boolean isempty = true;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j]==0)
                {
                     row = i;
                     column = j;

                     isempty = false;
                     break;
                }
            }
            if (!isempty){
                break;
            }
        }

        //no empty space
        if (isempty){
            return true;
        }

        for (int num = 1; num < 10 ; num++) {
            if(isSafe(grid,row,column,num,n)){
                grid[row][column]=num;

                if (solve(grid,n)){
                    return true;
                }

                //else backtrack
                grid[row][column]=0;
            }
        }

        return false;
    }
}
