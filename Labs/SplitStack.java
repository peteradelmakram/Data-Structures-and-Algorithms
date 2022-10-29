public class SplitStack {

    public static void splitStack(ArrayStack x , int y){

        ArrayStack divisible = new ArrayStack(x.size());
        ArrayStack undivisible = new ArrayStack(x.size());

        while(!x.isEmpty()){
            if(x.top() % y == 0){
                divisible.push(x.pop());
            }else{
                undivisible.push(x.pop());
            }
        }

        divisible.printStack();

        undivisible.printStack();
    }
 
    public static void main(String[] args) {
        ArrayStack x = new ArrayStack(4);

        x.push(8);
        x.push(6);
        x.push(9);
        x.push(5);

        splitStack(x, 3);
    }
}
