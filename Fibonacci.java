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
    
    public static long fibTab(long n){
        long[] tab=new long[(int)n+1];
        tab[1]=1;
        
        for(int i=0;i<=n;i++){
            if(i+2<n+1) tab[i+2]+=tab[i];
            if(i+1<n+1) tab[i+1]+=tab[i];
        }
        
        return tab[(int)n];
    }
    
    
    public static void main(String[] arg){
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        
        //---Recursion---
        //System.out.println(fibRec(n));

        //---Memoisation---
        //System.out.println(fibMemo(n,new HashMap<>()));

        //---Tabulation---
        System.out.println(fibTab(n));
    }
}
