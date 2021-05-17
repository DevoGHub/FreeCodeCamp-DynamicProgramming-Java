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
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        long target = s.nextLong();
        int n = s.nextInt();
        long[] num = new long[n];
        for(int i=0;i<n;i++) num[i]=s.nextInt();
        
        //System.out.println(canSumRec(target,num));
        HashMap<Long,Boolean> memo = new HashMap<>();
        System.out.println(canSumMemo(target,num,memo));
    }
}
