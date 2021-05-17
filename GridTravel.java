import java.util.*;
public class GridTravel {
    
    public static long countWaysRec(long m, long n){
        if(m==1 || n==1) return 1;
        if(m==0 || n==1) return 0;
        return countWaysRec(m-1,n)+countWaysRec(m,n-1);
    }
    
    public static long countWaysMemo(long m, long n, HashMap<String,Long> memo){
        String key = m + "," + n;
        if(memo.containsKey(key)) return memo.get(key);
        
        if(m==1 || n==1) return 1;
        if(m==0 || n==1) return 0;
        memo.put(key,countWaysMemo(m-1,n,memo)+countWaysMemo(m,n-1,memo));
        return memo.get(key);
    }
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        long m = s.nextLong();
        long n = s.nextLong();
        //System.out.println(countWaysRec(m,n));
        HashMap<String, Long> memo = new HashMap<>();
        System.out.println(countWaysMemo(m,n,memo));
    }
}
