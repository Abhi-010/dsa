package problem_solving.scaler_questions;

public class red_blue {
    public static void main(String[] args) {
        int red = 2 ;
        int blue = 4 ;
        System.out.println(maxHeightOfTriangle(2,4));
    }

    public static int maxHeightOfTriangle(int red, int blue) {

        int red1 = red ;
        int blue1 = blue ;

        int h1 = 0;
        int count = 1;

        while (((count % 2 == 1) && red >= count) || ((count % 2 == 0) && blue >= count)) {
            // red
            if (count % 2 == 1) {
                if (red >= count) {
                    h1++;
                    red = red - count;
                }
            } else {
                if (blue >= count) {
                    h1++;
                    blue = blue - count;
                }
            }
            count++;
        }

        System.out.println("h1 " + h1);
        count = 1;
        int h2 = 0;

        while (  ( (count % 2 == 1) && (blue1 >= count)) || ((count % 2 == 0) && (red1 >= count)) ) {
            // blue
//            System.out.println("count : " + count);
            if (count % 2 == 1) {
                blue1 = blue1 - count;
                h2++;
            } else {
                red1 = red1 - count;
                h2++;
            }
            count++;
        }
        //System.out.println("h2 " + h2);
        return Math.max(h1, h2);

    }
}
