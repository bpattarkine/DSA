import java.util.Stack;

class MinStack {
     Stack<Integer> st,minSt;
    public MinStack() {
      st=new Stack<Integer>();
        minSt=new Stack<Integer>();
    }
    public void push(int val) {
        st.push(val);
        if(minSt.isEmpty() || minSt.peek()>=val){
            minSt.push(val);
        }

    }
    public void pop() {
        int s=st.pop();
        if(!minSt.isEmpty() && minSt.peek()==s){
            minSt.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSt.peek();
    }
}