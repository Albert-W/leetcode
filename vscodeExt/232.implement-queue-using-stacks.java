/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start
class MyQueue {

    // main backup solution
    // private Deque<Integer> mainStack;
    // private Deque<Integer> backupStack;

    // public MyQueue() {
    //     mainStack = new ArrayDeque();
    //     backupStack = new ArrayDeque();
    // }
    
    // public void push(int x) {
    //     mainStack.push(x);
    // }
    
    // public int pop() {
    //     while(!mainStack.isEmpty()) {
    //         backupStack.push(mainStack.pop());
    //     }
    //     int result = backupStack.pop();
    //     while( !backupStack.isEmpty() ) {
    //         mainStack.push(backupStack.pop());
    //     }
    //     return result;
    // }
    
    // public int peek() {
    //     while(!mainStack.isEmpty()) {
    //         backupStack.push(mainStack.pop());
    //     }
    //     int result = backupStack.peek();
    //     while( !backupStack.isEmpty() ) {
    //         mainStack.push(backupStack.pop());
    //     }
    //     return result;
    // }
    
    // public boolean empty() {
    //     return mainStack.isEmpty();
    // }

    // input & output Solution
    private Deque<Integer> input;
    private Deque<Integer> output;

    public MyQueue() {
        input = new ArrayDeque();
        output = new ArrayDeque();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        if(output.isEmpty()) {
            peek();
        }
        return output.pop();
    }
    
    public int peek() {
        if(output.isEmpty()) {
            while(!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        return output.isEmpty() && input.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

