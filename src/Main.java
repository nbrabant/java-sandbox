import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    private static DateFormat dateParser = new SimpleDateFormat("dd-MM-yyyy");
    private static DateFormat dateFormatter = new SimpleDateFormat("EEEE");

    public static void main(String[] args) {
        Main.printDate();
        Main.printDeque();

//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        String l = in.nextLine();

//        Solution.main();

        // calculette
        Main.calculate("2 3 +", 5);
        Main.calculate("20 6 *", 120);
        Main.calculate("3 10 5 + *", 45);

    }

    /**
     * Unit test from scratch powa!
     *
     * @param expression
     * @param expected
     */
    private static void calculate(String expression, int expected) {
        int result = Calculette.compute(expression);
        if (result != expected) {
            System.out.printf("\u001B[31mError on compute : [%s] is not [%s]\u001B[0m\n", result, expected);
        } else {
            System.out.printf("\u001B[32mComputation is correct for [%s] expression\u001B[0m\n", expression);
        }
    }

    private static void printDate() {
        int day = 23;
        int month = 9;
        int year = 2020;

        Date date = null;
        try {
            date = Main.dateParser.parse(
                    Integer.toString(day) + "-" +
                            Integer.toString(month) + "-" +
                            Integer.toString(year)
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }


        System.out.println(Main.dateFormatter.format(date));
    }

    private static void printDeque() {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = 6;
        int m = 3;
        int s[] = {5, 3, 5, 2, 3, 2};

        int i;
        for (i = 0; i < m; i++) {
            while (!deque.isEmpty() && s[i] >= s[deque.peekLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);
        }

        for (i = 0; i < n; i++) {
            while ((!deque.isEmpty()) && deque.peek() <= i - m)
                deque.removeFirst();

            while ((!deque.isEmpty()) && s[i] >= s[deque.peekLast()])
                deque.removeLast();

            deque.addLast(i);
        }

        System.out.print(s[deque.peek()] + "\n");
    }


}
