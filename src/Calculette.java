import java.util.ArrayList;

public class Calculette {

    public static int compute(String expression) {
        String[] inputs = expression.split(" ");

        ArrayList<Integer> stack = new ArrayList<>();

        for (String input : inputs) {
            if (isInteger(input)) {
                stack.add(Integer.parseInt(input));
                continue;
            }

            if ("+".equals(input)) {
                Calculette.add(stack);
                continue;
            }

            if ("*".equals(input)) {
                Calculette.multiply(stack);
                continue;
            }
        }

        return stack.get(0);
    }

    /**
     * Add the two last input in the stack and place the result at the end of the stack
     *
     * @param stack
     */
    private static void add(ArrayList<Integer> stack) {
        Integer lastNumber = popStackNumber(stack);
        Integer number = popStackNumber(stack);

        stack.add(number + lastNumber);
    }

    /**
     * Multiply the two last input in the stack and place the result at the end of the queue
     *
     * @param stack
     */
    private static void multiply(ArrayList<Integer> stack) {
        Integer lastNumber = popStackNumber(stack);
        Integer number = popStackNumber(stack);

        stack.add(number * lastNumber);
    }

    /**
     * pop the last stack element
     *
     * @param stack
     * @return
     */
    private static Integer popStackNumber(ArrayList<Integer> stack) {
        Integer number = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);

        return number;
    }

    /**
     * check if an input is Integer
     *
     * @param input
     * @return
     */
    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }

        return true;
    }



}
