package Stacks;
import java.util.Stack;

public class StackProblems {

    public static String reverseString(String str){

        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for(char c : chars){
            stack.push(c);
        }

        for(int i = 0; i < str.length(); i++){
            chars[i] = stack.pop();
        }
        
        
        return new String(chars);
    }

    public static boolean validParentheses(String str){
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '[' || c == '{' || c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;
                else{
                    char top = stack.peek();
                    if((c == '}' && top == '{') || (c == ')' && top == '(') || (c == ']' && top == '[')){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    //Converting an infix expression to postfix:
    static int priority(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    static String infixToPostFix(String str){
        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length() ; i++) {
            char c = str.charAt(i);
            if(priority(c)>0){
                while(!stack.isEmpty() && priority(stack.peek())>= priority(c)){
                    result += stack.pop();
                }
                stack.push(c);
            }else{
                result += c;
            }
        }
        
        for (int i = 0; i <=stack.size() ; i++) {
            result += stack.pop();
        }
        return result;
    }

    //Solve a postfix expression
    static int solvePostfix(String exp)
    {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < exp.length(); i++)
        {

            char c = exp.charAt(i);

            if(c >= '0' && c <= '9')
                stack.push(c - '0');
            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();
                 
                switch(c)
                {
                    case '+':
                    stack.push(val2+val1); break;
                     
                    case '-':
                    stack.push(val2- val1); break;
                    
                    case '*':
                    stack.push(val2*val1); break;

                    case '/':
                    stack.push(val2/val1); break;
              }
            }
        }
        return stack.pop();   
    }

    static boolean validateExpression(String str){
        int numOperands = 0, numOperators = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            if(priority(c) > 0){
                numOperators++;
            }else{
                numOperands++;
            }
        }

        if(numOperands - numOperators == 1) return true;
        return false;
    }
    public static void main(String[] args) {
        String str = "A+B*C-D/E";
        System.out.println(infixToPostFix(str));
    }
}
