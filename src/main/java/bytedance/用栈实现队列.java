package bytedance;

import java.util.Stack;

public class 用栈实现队列 {

    private Stack<Integer> a;
    private Stack<Integer> b;

    public 用栈实现队列() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int x) {
        a.push(x);
    }

    public int pop() {
        if (b.isEmpty()) {
            while(!a.isEmpty()) {
                b.push(a.pop());
            }
        }
        return b.pop();
    }

    public int peek() {
        if (b.isEmpty()) {
            while(!a.isEmpty()) {
                b.push(a.pop());
            }
        }
        return b.peek();
    }

    public boolean empty() {
        return a.isEmpty() && b.isEmpty();
    }
}
