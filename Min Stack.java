// Problem Link : https://leetcode.com/problems/min-stack/description/

// ************************************** Approach 1 ********************************

// class Pair {

//     int value;

//     int min;

//     public Pair(int value, int min) {

//         this.value = value;

//         this.min = min;
//     }
// }

// class MinStack {

//     Stack<Pair> st;

//     public MinStack() {
        
//         st = new Stack<>();
//     }
    
//     public void push(int val) {

//         if(st.isEmpty()) st.push(new Pair(val, val));

//         else {

//             int prevMin = st.peek().min;

//             st.push(new Pair(val, Math.min(val, prevMin)));
//         }
        
//     }
    
//     public void pop() {

//         if(st.isEmpty()) return;

//         st.pop();
        
//     }
    
//     public int top() {

//         if(st.isEmpty()) return 0;

//         return st.peek().value;
        
//     }
    
//     public int getMin() {
        
//         if(st.isEmpty()) return 0;

//         return st.peek().min;
//     }
// }


// ************************** Approach 2 *************

class MinStack {

    Stack<Long> st;

    long mini;

    public MinStack() {

        st = new Stack<>();

        mini = Long.MAX_VALUE;
        
    }
    
    public void push(int val) {

        if(st.isEmpty()) {

            st.push((long)val);

            mini = (long) val;
        }

        else {

            if(val < mini) {

                long newVal = 2*(long)val - mini;

                st.push(newVal);

                mini = (long)val;
            }

            else st.push((long)val);
        }
        
    }
    
    public void pop() {

        if(st.isEmpty()) return;
 
        long stackElement = st.pop();

        if(stackElement < mini) {

            long newVal = (2*mini) - stackElement;

            mini = newVal;
        }
        
    }
    
    public int top() {

        if(st.isEmpty()) return 0;

        long stackElement = st.peek();

        if(stackElement > mini) return (int)stackElement;

        else return (int)mini;
        
    }
    
    public int getMin() {
        
        if(st.isEmpty()) return -1;

        return (int)mini;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
