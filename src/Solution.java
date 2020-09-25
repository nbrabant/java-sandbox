
import java.util.*;

public class Solution {

    public static void main() {
        String str = "Hello world";

        String[] arr = str.split(" ");

        Map<Integer, List<String>> convert = new HashMap<>();

        int iteration = 1;
        for (String word: arr) {
            if (iteration % 2 == 0)
            {
                StringBuilder sb = new StringBuilder(str);
                word = sb.reverse().toString();
            }


            iteration++;
        }
        ArrayList<String> e = new ArrayList<>();
    }

}
