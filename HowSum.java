import java.util.*;

public class HowSum {

    public static ArrayList<Long> howSumRec(long target, ArrayList<Long> num){
        if(target==0){
            ArrayList<Long> arr2=new ArrayList<>();
            return arr2;
        }
        if(target<0){
            return null;
        }
        
        for(int i=0;i<num.size();i++){
            ArrayList<Long> arr2=howSumRec(target-num.get(i),num);
            
            if(arr2!=null){
                arr2=new ArrayList<>(arr2);
                arr2.add(num.get(i));
                return arr2;
            }
        }
        
        return null;
    }
    
    public static ArrayList<Long> howSumMemo(long target, ArrayList<Long> num, HashMap<Long, ArrayList<Long>> memo){
        if(memo.containsKey(target)) return memo.get(target);
        if(target==0){
            ArrayList<Long> arr2=new ArrayList<>();
            return arr2;
        }
        if(target<0){
            return null;
        }
        
        for(int i=0;i<num.size();i++){
            ArrayList<Long> arr2=howSumMemo(target-num.get(i),num,memo);
            
            if(arr2!=null){
                arr2.add(num.get(i));
                memo.put(target-num.get(i),arr2);
                return arr2;
            }
        }
        
        memo.put(target, null);
        return null;
    }
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        long target = s.nextLong();
        
        int n = s.nextInt();
        ArrayList<Long> num=new ArrayList<>();
        for(int i=0;i<n;i++) num.add(s.nextLong());
        
        //System.out.println(howSumRec(target,num));
        HashMap<Long, ArrayList<Long>> memo = new HashMap<>();
        System.out.println(howSumMemo(target,num,memo));
    }
    
}
