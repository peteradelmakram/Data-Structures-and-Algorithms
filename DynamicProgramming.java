import java.util.*;
public class DynamicProgramming {
    //Another attempt with Dynamic Programming:
    public static long fibArr(int n){
        long[] f = new long[n+2];
        f[0] = 0;
        f[1] = 1;
        
        //Create an array with base cases, iterate over n times, add previous two using O(n) duhh!
        for(int i = 2; i <= n; i++){
            f[i] = f[i-1] + f[i-2]; 
        }

        return f[n];
    }

    //THIS IS THE COOLEST FUCKING SHIT EVER
    public static long fib(int n){
        Map<Integer, Long> DP = new HashMap<>(); // Map (fib(3) --> 2 / fib(4) --> 3 / fib(5) --> 5 / fib(6) --> 8)
        return fibDynamic(n, DP);
    }

    public static long fibDynamic(int n, Map<Integer, Long> DP){
        if(DP.containsKey(n)) return DP.get(n);
        if(n <= 2) return 1;
        DP.put(n, (fibDynamic(n-1, DP) + fibDynamic(n-2, DP)));

        return DP.get(n);
        
    }
    public static double badFib(int n){
      
        if(n <= 2) return 1;
        return badFib(n-1) + badFib(n-2);

    }
    public static void main(String[] args) {
        System.out.print(fib(6));
    }

// fib(3) --> 2
// fib(4) --> 3


    /*                
            
        
        
        
        
                            
     */ 
}
