package problem_solving.scaler_questions;

public class DesignNeighborService {

    int[][] grid ;

    public DesignNeighborService(int[][] grid) {
        int n = grid.length ;
        this.grid = new int[n][n] ;
        for(int i = 0 ; i < n  ;i++){
            for(int j = 0 ; j < n ;j++){
                this.grid[i][j] = grid[i][j] ;
            }
        }
    }

    public int adjacentSum(int value) {
        int n = grid.length ;
        int r = -1;
        int c = -1;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == value){
                    r = i ;
                    c = j ;
                    break ;
                }
            }
        }

        int left = 0 ;
        int right = 0 ;
        int top = 0 ;
        int bottom = 0 ;

        if(r != 0){
            top = grid[r-1][c];
        }

        if(r != n-1){
            bottom = grid[r+1][c] ;
        }

        if(c != 0){
            left = grid[r][c-1];
        }
        if(c != n-1){
            right = grid[r][c+1];
        }
        return top + bottom + left + right ;
    }

    public int diagonalSum(int value) {
        int n = grid.length ;
        int r = -1;
        int c = -1;
        for(int i = 0 ; i < n ;i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == value){
                    r = i ;
                    c = j ;
                    break;
                }
            }
        }
        int top_left = 0 ;
        int top_right = 0 ;
        int bottom_left = 0 ;
        int bottom_right = 0 ;

        if(r != 0 && c != 0){
            top_left = grid[r-1][c-1] ;
        }
        if(r != 0 && c != n-1){
            top_right = grid[r-1][c+1] ;
        }

        if(r != 0 && c != n-1){
            bottom_left = grid[r+1][c-1];
        }
        if(r != n-1 && c != n-1 ){
            bottom_right = grid[r+1][c+1] ;
        }
        return top_left + top_right + bottom_left + bottom_right ;
    }
}
