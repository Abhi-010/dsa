package problem_solving.accenture_assessement;

public class qq11 {
    public static void main(String[] args) {
        try {
            badMethod();
            System.out.println("1");
        }
        catch (Exception e){
            System.out.println("2");
        }
        finally {
            System.out.println("3");
        }
        System.out.println("4");
    }
    public static void badMethod(){}
}
