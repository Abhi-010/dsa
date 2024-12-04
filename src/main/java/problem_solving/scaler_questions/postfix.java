package problem_solving.scaler_questions;

import java.util.ArrayList;
import java.util.Stack;

public class postfix {
    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>( );

        A.add("2");
        A.add("2");
        A.add("/");

        System.out.println(evalRPN(A));
    }

    public static  int evalRPN(ArrayList<String> A) {

        int n = A.size() ;
        Stack<String> st = new Stack<>();

        for(int i = 0 ; i < n ; i++){

            int sizeOfString = A.get(i).length() ;
            if(sizeOfString > 1){
                st.push(A.get(i)) ;
            }
            else{
                String s = A.get(i);
                char ch = s.charAt(0);
                if(ch >= 48 && ch <= 57){
                    st.push(ch + "");
                }
                else{
                    int first = Integer.parseInt(st.pop());
                    int second = Integer.parseInt(st.pop());

                    //String s1 = st.pop() ;
                    //String s2 = st.pop() ;

                    int ans = 0 ;
                    if(ch == '*'){
                        ans = first * second ;
                    }
                    else if(ch == '/'){
                        ans = first/second ;
                    }
                    else if(ch == '-'){
                        ans = first - second ;
                    }
                    else{
                        ans = first + second ;
                    }
                    st.push(ans+"");
                }
            }

        }
        return Integer.parseInt(st.peek()) ;
    }
}
