package problem_solving.scaler_questions;

import java.util.Arrays;
import java.util.Comparator;

public class EdgeInMST {
    public static void main(String[] args) {
        int[][] B = new int[][]
                {{44,50,42},{23,26,468},{20,45,335},{4,26,501},{12,33,170},{9,41,725},
                        {30,51,479},{2,26,359},{2,23,963},{16,18,465},{32,51,706},{30,49,146},
                        {46,52,282},{13,31,828},{2,37,962},{11,44,492},{22,23,996},{31,40,943},{1,5,828},
                        {13,44,437},
                        {6,13,392},{23,37,605},{29,37,903},{8,43,154},{13,37,293},{30,36,383},
                        {11,39,422},{11,42,717},{29,32,719},{28,32,896},{26,37,448},{28,45,727},
                        {7,31,772},{15,46,539},{31,51,870},{15,19,913},{22,36,668},{6,47,300},
                        {10,48,36},{19,27,895},{2,19,704},{11,40,812},{33,35,323},{8,38,334},
                        {38,43,674},{3,36,665},{1,16,142},{22,32,712},{18,20,254},{31,43,869},
                        {18,44,548},{5,33,645},{21,42,663},{17,29,758},{2,51,38},{12,19,860},
                        {13,47,724},{18,38,742},{22,27,530},{15,21,779},{10,31,317},{16,20,36},
                        {44,45,191},{2,11,843},{7,36,289},{8,47,107},{25,38,41},{10,36,943},
                        {1,41,265},{5,49,649},{11,38,447},{32,40,806},{32,37,891},{17,45,730},
                        {6,37,371},{2,10,351},{13,48,7},{3,26,102},{5,9,394},{43,50,549},
                        {17,52,630},{2,42,624},{10,27,85},{24,37,955},{37,51,757},{10,29,841},
                        {24,46,967},{38,46,377},{46,51,932},{14,44,309},{6,39,945},{31,35,440},
                        {39,41,627},{2,15,324},{3,13,538},{16,27,539},{20,23,119},{16,28,83},
                        {12,20,930},{3,4,542},{26,35,834},{12,50,116},{35,41,640},{21,30,659},
                        {27,52,705},{2,45,931},{23,45,978},{14,51,307}}
                ;
        int[] ans = solve(52, B ) ;

        for(int i = 0 ; i < ans.length ; i++){
            System.out.print(ans[i] + " ");
        }
    }
    public static  int[] solve(int A, int[][] B) {
        //System.out.println("length : " + B.length);

        int[][] arr = new int[B.length][4] ;

        for(int i = 0 ; i < B.length ; i++){
            int j = 0 ;
            for( ; j < 3 ; j++){
                arr[i][j] = B[i][j] ;
            }
            arr[i][j] = i ;
        }




        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            // Compare values according to columns
            public int compare(final int[] entry1,
                               final int[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[2] <= entry2[2])
                    return -1;
                return 1 ;

            }
        });


        for(int i = 0 ; i < arr.length ;i++){
            System.out.println(i + " ");
            for(int j = 0 ; j < arr[0].length ; j++){
                System.out.print( arr[i][j] + " ");
            }
            System.out.println();
        }

        int[] ans = new int[B.length] ;

        int[] comp = new int[A+1] ;
        for(int i = 1 ; i <= A ; i++){
            comp[i] = i ;
        }

        for(int i = 0 ; i < arr.length ; i++){
            int w = arr[i][2] ;
            int k = i ;

            while(k < arr.length && w == arr[k][2]){
                k++ ;
            }

            if( (k > i+1) && ( (k == arr.length) || (w != arr[k][2]))){
                // from i to k-1 has same weight
                // go and process these weights first

                int j = i ;
                while(j <= k-1){
                    if(j == 50){
                        System.out.println("-------------");
                        for(int z = 0 ; z <= A ; z++){
                            System.out.print(z + ":" + comp[z] + ", ");
                        }
                        System.out.println();
                        System.out.println("-----------------");
                    }
                    int u1 = arr[j][0] ;
                    int v1 = arr[j][1] ;
                    int index1 = arr[j][3] ;
                    int pu1 = component_method(u1,comp);
                    int pv1 = component_method(v1,comp);

                    if(pu1 != pv1){
                        ans[index1] = 1 ;
                    }
                    j++ ;
                }

                // and then do the component update
                j = i ;
                while(j <= k-1){
                    int u1 = arr[j][0] ;
                    int v1 = arr[j][1] ;
                    int pu1 = component(u1,comp);
                    int pv1 = component(v1,comp);
                    if(pu1 != pv1){
                        comp[Math.max(pu1,pv1)] = comp[Math.min(pu1,pv1)] ;
                    }
                    j++ ;
                }
                // update i = k-1 ;
                i = k-1;
                continue;
                //continue
            }

            int u = arr[i][0] ;
            int v = arr[i][1] ;

            int index = arr[i][3] ;

            int pu = component(u,comp) ;
            int pv = component(v,comp) ;

            if( pu != pv ){
                ans[index] = 1 ;
                comp[Math.max(pu,pv)] = comp[Math.min(pu,pv)] ;
            }
        }
        return ans ;
    }

    public static int component_method(int u , int[] comp){
        if(comp[u] == u){
            return u ;
        }
        return component(comp[u],comp) ;
        //return comp[u] ;
    }
    public static int component(int u , int[] comp){
        if(comp[u] == u){
            return u ;
        }
        comp[u] = component(comp[u],comp) ;
        return comp[u] ;
    }
}
