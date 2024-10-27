package StacksAndQueues;

import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public void push(int x) {
        first.push(x);
    }
    
    public int pop() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        return second.pop();
    }
    
    public int peek() {
        while (!first.isEmpty()) {
            second.push(first.peek());
        }
        return second.peek();
    }
    
    public boolean empty() {
        if (first.isEmpty()) {
            return true;
        }
        return false;
    }
}

