package coding.dp_recursions;

import java.util.ArrayList;
import java.util.List;

// https://www.youtube.com/watch?v=eyCj_u3PoJE
// https://www.youtube.com/watch?v=qBbZ3tS0McI
// space complexity is O(2 * n) -->> O(n)
// time complexity
public class GenerateParenthesis {

    public static void main(String[] args) {
        int n = 2;
        List<String> output = new ArrayList<>();
        generateParenthesis(output, "", n, n);
        output.forEach(System.out::println);
    }

    private static void generateParenthesis(List<String> output, String current, int openCount, int closeCount) {
        if (openCount == 0 && closeCount == 0) {
            output.add(current);
            return;
        }
        // we can keep on opening the bracket until the open count is 0
        if (openCount > 0) {
            current = current + "{";
            generateParenthesis(output, current, openCount - 1, closeCount);
        }
        // we can only close the bracket only when we have opened. so closing can be done only if the close count is greater than open.
        if (closeCount > openCount) {
            current = current + "}";
            generateParenthesis(output, current, openCount, closeCount - 1);
        }
    }
}
