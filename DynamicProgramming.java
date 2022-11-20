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
    public int tribonacci(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0,0);
        dp.put(1,1);
        dp.put(2,1);
        return tribonacci(n, dp);
    }
    public int tribonacci(int n, Map<Integer,Integer> dp){
        if(dp.containsKey(n)) return dp.get(n);
        
        dp.put(n, (tribonacci(n-1, dp) + tribonacci(n-2, dp) + tribonacci(n-3, dp)));
        
        return dp.get(n);
    }

    public static long gridTraveler(int m, int n){
        Map<String, Long> DP = new HashMap<>();
        return gridTraveler(m, n, DP);
    }
    public static long gridTraveler(int m, int n , Map<String,Long> DP){
        String key = m + "," + n;
        if(DP.containsKey(key)) return DP.get(key);
        if(m == 1 && n == 1) return 1;
        if(m == 0 || n == 0) return 0;

        DP.put(key, gridTraveler(m-1, n, DP) + gridTraveler(m, n-1, DP));

        return DP.get(key);
    }
    
    public static void main(String[] args) {
        System.out.print(gridTraveler(18,18));
    }

                
}
