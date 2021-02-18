//https://leetcode.com/problems/valid-parentheses/

//Runtime: 2 ms, faster than 29.63% of Java online submissions for Valid Parentheses.
//Memory Usage: 37 MB, less than 86.02% of Java online submissions for Valid Parentheses.

class Solution {
    public static boolean check (char m, char n) {
        if ((m == '[' && n == ']')
            || (m == '{' && n == '}')
            || (m == '(' && n == ')')) {
            return true;
        }
        else
            return false;
    }


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i=0; i<s.length(); i++) {
            stack.push(s.charAt(i));

            if (stack.size() > 1) {
                char m = stack.pop();
                char k = stack.pop();

                if (!check(k, m)) {
                    stack.push(k);
                    stack.push(m);
                }
            }
        }

        if (stack.size() == 0)
            return true;

        return false;
    }
}

