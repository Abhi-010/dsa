package problem_solving.accenture_assessement;

import java.text.ParseException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
//        Calendar calendar = new GregorianCalendar(2013,1,28,13,24,56);
//        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
//        System.out.println(calendar.get(Calendar.WEEK_OF_MONTH));

//        NumberFormat numberFormat = NumberFormat.getInstance(new Locale("da","DK")) ;
//        Number number = numberFormat.parse("100.9");
//        System.out.println(number);

        List<Integer> list = Arrays.asList(1,2,5,6,6);
        HashSet<Integer> set = new HashSet<>(list);
        set.forEach(System.out::println);
    }
}

