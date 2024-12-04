package problem_solving.accenture_assessement;

public class WaitTest {
    public static void main(String[] args) {
        System.out.print("1 ");
        synchronized (args){
            System.out.println("2");
            try {
                args.wait();
            }
            catch (InterruptedException e){}
            System.out.println("3");
        }
    }
}
