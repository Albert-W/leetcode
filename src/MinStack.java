import java.util.ArrayList;
import java.util.Stack;

/*
155. Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 */
//Stack;Design


class MinStack2 {
    //use stack; 94ms;
    /*
    x>min :{x-min,min}
    x<min :{x-min,x}
    无论何种情型，都可以算出上次位的Min;
     */
    Stack<Long> s;
    long min;

    /**
     * initialize your data structure here.
     */
    public MinStack2() {
        s = new Stack<>();
        min = Long.MIN_VALUE;
    }

    public void push(int x) {
        if (s.empty()) {
            s.push((long) x);
            min = (long) x;
        } else {
            //x-min 可能会溢出；
            s.push(x - min);
            if (x < min) {
                min = (long) x;
            }
        }
    }

    public void pop() {
        //如果为空，直接返回
        if (s.isEmpty()) return;
        long x = s.pop();
        //只有一个元素时，回到初始状态；
        if (s.size() == 0) {
            min = Long.MIN_VALUE;
        } else {
            if (x < 0) {
                min = (min - x);
            }
        }

    }

    public int top() {
        long x = s.peek();
        if (s.size() == 1) return (int) x;
        if (x > 0) return (int) (x + min);
        else return (int) min;
    }

    public int getMin() {
        return (int) min;
    }

}

public class MinStack {
    ArrayList<Integer> s;
    ArrayList<Integer> min;

    //117ms;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        s = new ArrayList<>();
        min = new ArrayList<>();

    }

    public void push(int x) {
        s.add(x);
        if (s.size() == 1) {
            min.add(x);
        } else {
            min.add(Math.min(x, min.get(min.size() - 1)));
        }
    }

    public void pop() {
        int x = s.size();
        if (x == 0) return;
        s.remove(x - 1);
        min.remove(x - 1);

    }

    public int top() {
        int x = s.size();
        if (x == 0) return -1;
        return s.get(x - 1);

    }

    public int getMin() {
        int x = min.size();
        if (x == 0) return -1;
        return min.get(x - 1);

    }
}
