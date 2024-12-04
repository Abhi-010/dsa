package problem_solving.accenture_assessement;

public class TP {
    public static void main(String[] args) {
        int iReturned = new TP().testMethod();
        System.out.println("Returned value of i " + " " + iReturned);
    }
    public int testMethod(){
        int i = 0 ;
        try{
            i = 100/0;
        }
        catch (Exception e){
             i = 200/0 ;
             return i ;
        }
        finally {
            i = 300 ;
            return  i ;
        }
    }
}
