package problem_solving.scaler_questions;

import java.util.*;

public class AllGCDPair {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 2, 2, 2, 8, 2, 2, 2, 10) ;
        ArrayList<Integer> ans = allGCDPair(list) ;

        list.forEach(System.out::println);
        System.out.println("ans : ");
        ans.forEach((p)->{
            System.out.print(p + " ") ;
        });
    }

    public static ArrayList<Integer> allGCDPair(List<Integer> input){
        ArrayList<Integer> output = new ArrayList<>();
        Collections.sort(input,Collections.reverseOrder());
        System.out.println("input ");
        input.forEach(System.out::println);
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer i : input){
            if(map.containsKey(i)){
               map.put(i,map.get(i)-1);
               if(map.get(i) == 0){
                   map.remove(i) ;
               }
            }
            else{
                //1. take the gcd of all the elements of output array and put in map ;
                addGCDToMap(i,map,output);
                //2. add in output array
                output.add(i) ;
            }
        }
        return output ;
    }
    public static void addGCDToMap(int i , Map<Integer,Integer> map, List<Integer> output){
        for(Integer integer : output){
            int g = gcd(integer,i) ;
            if(!map.containsKey(g)){
                map.put(g,2);
            }
            else{
                map.put(g,map.get(g)+2);
            }
        }
    }
    public static int gcd(int a, int b){
        int temp ;
        if(a > b){
            temp = a;
            a = b ;
            b = temp ;
        }
        while(a>0){
            temp = a ;
            a = b%a ;
            b = temp ;
        }
        return b ;
    }
}
