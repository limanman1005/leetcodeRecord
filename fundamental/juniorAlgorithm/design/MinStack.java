package juniorAlgorithm.design;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MinStack
 * Description: 设计一个最小栈，这个是同步栈的设计方法，以后有时间了在写下非同步栈的写法
 * date: 2020/6/6 12:08
 *
 * @author liyh
 */
public class MinStack {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
    }


    private List<Integer> stack;
    private List<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new ArrayList<>();
        this.minStack = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(x);
        if(minStack.size() != 0){
            int min  = minStack.get(minStack.size() - 1);
            if(min < x){
                minStack.add(min);
            }
            else{
                minStack.add(x);
            }
        }
        else{
            minStack.add(x);
        }
    }

    public void pop() {
        stack.remove(stack.size() - 1);
        minStack.remove(minStack.size() - 1);
    }

    public int top() {
        int val = stack.get(stack.size() - 1);
        return val;
    }

    public int getMin() {
        return minStack.get(minStack.size() - 1);

    }
}
