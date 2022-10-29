package Stacks;

import java.util.EmptyStackException;

public class Stack {
    public ListNode top;
    public int length;

    public class ListNode{
        public Object data;
        public ListNode next;

        public ListNode(Object data) {
            this.data = data;
        }

        public ListNode() {
        }
    }

    public Stack() {
        top = null;
        length = 0;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void push(Object o){
        ListNode temp = new ListNode(o);
        temp.next = top;
        top = temp;
        length++;
    }

    public Object pop(){
        if(isEmpty()) throw new EmptyStackException();
        Object res = top.data;
        top = top.next;
        length--;
        return res;
    }

    public Object peek(){
        if(isEmpty()) throw new EmptyStackException();
        return top.data;
    }

    //Problems:
    public static String reverseString(String str){

        Stack stack = new Stack();
        char[] chars = str.toCharArray();

        for(char c : chars){
            stack.push(c);
        }

        for(int i = 0; i < str.length(); i++){
            chars[i] = (char) stack.pop();
        }

        return new String(chars);
    } 

    public int searchInStack(int target){
        ListNode curr = top;
        int count = 0;

        while(curr != null){
            if((int) curr.data == target){
                return count;
            }
            count++;
            curr = curr.next;
        }

        return -1;
    }

    //Testing:
    public static void main(String[] args) {
        Stack newStack = new Stack();
        newStack.push(4);
        newStack.push(1);
        newStack.push(7);
        newStack.push(2);

        System.out.print(newStack.searchInStack(4));
    }
}
