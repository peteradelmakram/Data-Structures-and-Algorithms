package Stacks;
public class ArrayStack {
    private Object[] stackArray;
    private int top;
    private int maxSize;

    public ArrayStack(int size) {
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

    public void resize(int n){
        Object[] oldStack = stackArray;
        Object[] newStack = new Object[n];

        for(int i = 0; i < oldStack.length; i++){
            newStack[i] = oldStack[i];
        }

        stackArray = newStack;
    }

    //Problems : 
    public static String reverseString(String str) {
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
        for(int i = top; i>= 0; i--){
            if((int) stackArray[i] == target){
                return top-i;
            }
        }
       return -1;
    }

    public static ArrayStack sortStack(ArrayStack s){
        ArrayStack temp = new ArrayStack(s.size());
        while(!s.isEmpty()){
            int x = (int) s.pop();
            while(!temp.isEmpty() && x <(int) temp.top())
                s.push(temp.pop());
            temp.push(x);
        }
        return temp;
    }

    public static ArrayStack decomposeStack(ArrayStack s){
        ArrayStack even = new ArrayStack(s.maxSize/2 + 1);
        ArrayStack odd = new ArrayStack(s.maxSize /2 + 1);
        int count = 1;

        while(!s.isEmpty()){
            if(count % 2 == 0){
                even.push(s.pop());
            }else{
                odd.push(s.pop());
            }
            count++;
        }
        ArrayStack temp = new ArrayStack(odd.maxSize);
        while(!odd.isEmpty()){
            temp.push(odd.pop());
        }

        while(!temp.isEmpty()){
            s.push(temp.pop());
        }


        return even;
    }

    public void removeNth(int n){
        ArrayStack temp = new ArrayStack(this.size());
        while(!this.isEmpty() && n <= this.size()){
            if(n == this.size()){
                this.pop();
                break;
            }
            temp.push(this.pop());
        }
        while(!temp.isEmpty()){
            this.push(temp.pop());
        }
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


    public static void main(String[] args) {
        ArrayStack arrStack = new ArrayStack(7);
        arrStack.push(1);
        arrStack.push(2);
        arrStack.push(3);
        arrStack.push(4);
        arrStack.push(5);
        arrStack.push(6);
        arrStack.push(7);

        ArrayStack result = decomposeStack(arrStack);

        result.display();
        arrStack.display();
    }
}
