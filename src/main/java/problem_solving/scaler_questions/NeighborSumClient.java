package problem_solving.scaler_questions;

public class NeighborSumClient {
    public static void main(String[] args) {


        //[[[[3,6,0],[8,5,1],[2,4,7]]],[1],[3],[7],[2],[5],[8],[0],[1],[4],[8],[6],[3],[2],[6],[5],[7],[4],[0]]


        int[][] grid = {
                {1,2,0,3},
                {4,7,15,6},
                {8,9,10,11},
                {12,13,14,5}
        };


//        int sum = 0 ;
//
//        for(int i = 0 ; i < 3 ; i++){
//            for(int j = 0 ; j < 3 ; j++){
//                grid[i][j] = sum ;
//                sum++ ;
//            }
//        }

        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        DesignNeighborService obj = new DesignNeighborService(grid);

        System.out.println(obj.adjacentSum(15));

        System.out.println(obj.diagonalSum(9));

        //System.out.println(obj.adjacentSum(4));
        //System.out.println(obj.diagonalSum(4));
    }
}
