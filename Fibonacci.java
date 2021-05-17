import java.util.*;

public class Fibonacci {
    public static long fibRec(long n){
        if(n<=2) return 1;
        return fibRec(n-1)+fibRec(n-2);
    }
    
    public static long fibMemo(long n, HashMap<Long,Long> memo){
        if(memo.containsKey(n)) return memo.get(n);
        if(n<=2) return 1;
        memo.put(n,fibMemo(n-1,memo)+fibMemo(n-2,memo));
        return memo.get(n);
    }
    
    
    public static void main(String[] arg){
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        //System.out.println(fibRec(n));
        HashMap<Long, Long> memo= new HashMap<>();
        System.out.println(fibMemo(n,memo));
    }
}
