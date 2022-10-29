public class StackObj {
    
    private Object[] stackArray;
    private int top;
    private int maxSize;

    public StackObj(int size) {
        maxSize = size;
        stackArray = new Object[maxSize];
        top = -1;
    }

    public void push(Object x){
        stackArray[++top] = x;
    }

    public Object pop(){
        Object result = stackArray[top--];
        return result;
    }

    public Object top(){
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
    
    public void display(){
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
