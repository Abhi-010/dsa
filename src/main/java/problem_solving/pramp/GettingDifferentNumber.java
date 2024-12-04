package problem_solving.pramp;

public class GettingDifferentNumber {
    static GettingDifferentNumber obj = new GettingDifferentNumber() ;
    public static void main(String[] args) {
        System.out.println(obj.solution1(new int[]{10,2,6,9,0,1}));
    }

    /*
    **Brute Force Solution**
    this is simple and easy solution with
    TC : nlogn + n
     */
    public int solution1(int[] A){
        int n = A.length ;
        for(int j = 0;true; j++){
            boolean isPresent = false;
            for (int k : A) {
                if (k == j) {
                    isPresent = true;
                    break;
                }
            }
            if(!isPresent){
                return j ;
            }
        }
    }

}
