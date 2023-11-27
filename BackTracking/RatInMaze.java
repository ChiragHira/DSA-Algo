public class RatInMaze {
    public static boolean isSave(int[][]maze,int i,int j,int n){
        return i < n && j < n && maze[i][j] == 1;
    }

    public static boolean solveMaze(int[][] maze,int i,int j,int n,int [][] result){

        //Base Condition
        if (i==n-1 && j==n-1 ){
            result[i][j]=1;
             return true;
        }

        //Recursive call
        if (isSave(maze,i,j,n))
        {

            //Checking if we already cover this path or not
           if( result[i][j]==1)
           {
               return false;
           }

           //otherwise the solution
            result[i][j]=1;

           //downward direction
            if (solveMaze(maze, i+1, j, n, result))
            {
                return true;
            }

            //right direction
            if (solveMaze(maze, i, j+1, n, result))
            {
                return true;
            }

            //backtrack
            result[i][j]=0;
            return false;
        }

        return false;

    }

    public static void main(String []args){

        int [][] maze = { {1,1,1,1},
                          {0,1,0,0},
                          {0,1,1,0},
                          {0,1,1,1}  };
        int n = maze.length;

        int [][] solution = new int[n][n];

        RatInMaze.solveMaze(maze,0,0,n,solution);

        for (int i = 0;i<n; i++ ){
            for (int j = 0; j < n; j++) {
                System.out.print(solution[i][j]+" ");
            }
            System.out.println();
        }
    }
}
