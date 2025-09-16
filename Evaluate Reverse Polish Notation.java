// Problem Link : https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

class Solution {

    public int solve(int num1, int num2, String op) {

        if(op.equals("+")) return num2 + num1;

        else if(op.equals("-")) return num2 - num1;

        else if(op.equals("*")) return num2 * num1;

        else return num2 / num1;
    }

    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();

        for(String token : tokens) {

            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {

                int num1 = st.pop();

                int num2 = st.pop();

                int res = solve(num1, num2, token);

                st.push(res);
            }

            else st.push(Integer.parseInt(token));
        }

        return st.peek();
        
    }
}
