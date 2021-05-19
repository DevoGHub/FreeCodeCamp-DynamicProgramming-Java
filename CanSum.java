import java.util.*;

public class CanSum {
    public static boolean canSumRec(long target,long[] num){
        if(target==0) return true;
        if(target<0) return false;
        
        for(int i=0;i<num.length;i++){
            if(canSumRec(target-num[i],num)){
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean canSumMemo(long target,long[] num, HashMap<Long,Boolean> memo){
        if(memo.containsKey(target)) return memo.get(target);
        if(target==0) return true;
        if(target<0) return false;
        
        for(int i=0;i<num.length;i++){
            if(canSumMemo(target-num[i],num,memo)){
                memo.put(target-num[i], true);
                return true;
            }
        }
        
        memo.put(target,false);
        return false;
    }
    
    public static boolean canSumTab(long target,long[] num){
        boolean[] tab = new boolean[(int)target+1];
        Arrays.fill(tab,false);
        tab[0]=true;
        
        for(int i=0;i<=target;i++){
            if(tab[i]){
                for(int j=0;j<num.length;j++){
                    if((i+num[j])<=target) tab[i+(int)num[j]]=true;
                }
            }
        }
        
        return tab[(int)target];
    }
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        long target = s.nextLong();
        int n = s.nextInt();
        long[] num = new long[n];
        for(int i=0;i<n;i++) num[i]=s.nextInt();
        
        //---Recursion---
        //System.out.println(canSumRec(target,num));
        
        //---Memoisation---
        //System.out.println(canSumMemo(target,num,new HashMap<>()));
        
        //---Tabulation---
        System.out.println(canSumTab(target,num));
    }
}
