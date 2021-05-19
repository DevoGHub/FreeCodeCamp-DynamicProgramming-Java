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
    
    public static long countWaysTab(long m, long n){
        long[][] tab = new long[(int)m+1][(int)n+1];
        
        tab[1][1]=1;
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i+1<=m) tab[i+1][j]+=tab[i][j];
                if(j+1<=n) tab[i][j+1]+=tab[i][j];
            }
        }
        
        return tab[(int)m][(int)n];
    }
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        long m = s.nextLong();
        long n = s.nextLong();
        
        //---Recursion---
        //System.out.println(countWaysRec(m,n));
        
        //---Memoisation---
        //System.out.println(countWaysMemo(m,n,new HashMap<>()));
        
        //---Tabulation---
        System.out.println(countWaysTab(m,n));
    }
}
