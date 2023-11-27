import java.util.ArrayList;
import java.util.Scanner;

public class RatInMaze_2 {

    public static ArrayList<String>Ans = new ArrayList<>();
    public static int size = 4;
    public static boolean [][] vis = new boolean[size][size];
    public static Scanner sc = new Scanner(System.in);

    public static void solveMaze(int [][] maze, int r,int c,String path){

        //Base case condition
        if (r==size-1 && c==size-1){
            Ans.add(path);
            return;
        }

        //Checking if rat is in under the boundary
        if (r>=0 && r<size && c>=0 && c<size){

            //Checking weather the path is block, or we already visited this path
            if (maze[r][c]==0 || vis[r][c]){
                return;
            }
            vis[r][c]=true;
            solveMaze(maze,r+1,c,path+"D"); //Downward direction
            solveMaze(maze,r,c+1,path+"R"); //Right direction
            solveMaze(maze,r-1,c,path+"U"); //Upward direction
            solveMaze(maze,r,c-1,path+"L"); //Left direction
            vis[r][c]=false;
        }
    }

    public static void main(String[] args) {

        int [][] maze = {  {1,0,0,0},
                           {1,1,0,1},
                           {1,1,0,0},
                           {0,1,1,1} };

        solveMaze(maze,0,0,"");

        System.out.println(Ans);

    }
}
