
public class ArrayStack {
    private int[] stackArray;
    private int top;
    private int maxSize;

    public ArrayStack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int x){
        stackArray[++top] = x;
    }

    public int pop(){
        int result = stackArray[top--];
        return result;
    }

    public int top(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == (maxSize -1);
    }

    public int size(){
        return (top+1);
    }

    public void printStack(){
        if(top == -1){
            System.out.print("Empty stack.");
        }
        else{
            System.out.print(stackArray[top] + " ");
            for(int i = top -1; i >= 0; i--){
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }
}
