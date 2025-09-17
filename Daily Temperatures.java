// Problem Link : https://leetcode.com/problems/daily-temperatures/description/

class Solution {

    public int[] dailyTemperatures(int[] nums) {

        int n = nums.length;

        Stack<Integer> st = new Stack<>();

        int[] result = new int[n];

        for(int i=n-1; i>=0; i--) {

            while(!st.isEmpty() && nums[i] >= nums[st.peek()]) st.pop();

            if(st.isEmpty()) result[i] = 0;

            else result[i] = st.peek() - i;

            st.push(i);
        }

        return result;
        
    }
}
