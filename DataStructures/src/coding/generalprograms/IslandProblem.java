package coding.generalprograms;

// Order of complexity O(ROW x COL)
public class IslandProblem {
    public static void main(String[] args) {
        int grid[][] = new int[][]{
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        System.out.println("Number of islands: " + numberOfIslands(grid));
    }

    private static int numberOfIslands(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    count++; // we increment the count whenever the 1 is found and then makes surrounding as 0;
                    callDFS(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void callDFS(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return; // end conditions
        }
        //making the current as 0;
        grid[i][j] = 0;
        // if only considering the up and down.
        callDFS(grid,i+1,j); // down
        callDFS(grid,i-1,j); // up
        callDFS(grid,i,j-1); //left
        callDFS(grid,i,j+1); //right

        // if only considering the up and down and diagonal.
        callDFS(grid,i+1,j+1);  // down right
        callDFS(grid,i-1,j-1);  // up left
        callDFS(grid,i+1,j-1); // down left
        callDFS(grid,i-1,j+1); // up right
    }
}
