package problem_solving.hackerrank;

public class PlusMinus {
    public static void main(String[] args) {
        double a = (double) 3 /6 ;
        System.out.printf("%.6f%n",a);
        //System.out.println(timeConversion("12:40:00AM"));
        System.out.println(timeConversion("12:05:45PM"));
    }

    public static String timeConversion(String s) {
        // Write your code here
        int hour = Integer.parseInt(s.substring(0,2)) ;
        String h = "";
        if(s.substring(8,10).equals("AM")){
            if(hour == 12){
                h = "00";
            }
            else if(hour < 10){
                h = "0" + hour ;
            }
            else{
                h = "" + hour ;
            }
        }
        else{
            if(hour != 12){
                hour = hour + 12 ;
                h = "" + hour ;
            }
            else{
                h = "" + hour ;
            }
        }

        return "" + h + ":" + s.substring(3,5) + ":" + s.substring(6,8) + s.substring(8,10) ;
    }
}
