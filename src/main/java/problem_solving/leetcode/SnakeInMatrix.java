package problem_solving.leetcode;

import java.util.List;

public class SnakeInMatrix {
    public static void main(String[] args) {
        List<String> list = List.of("DOWN","RIGHT","UP");
        System.out.println(finalPosition(3,list));
    }
    public static int finalPosition(int n, List<String> commands ){
        int i = 0 ; int j = 0 ;
        for(String str : commands){
            if(str.equals("RIGHT")){
                j++;
            }
            else if(str.equals("LEFT")){
                j--;
            }
            else if(str.equals("DOWN")){
                i++;
            }
            else{
                i--;
            }
        }
        return (i*n)+j ;
    }
}
