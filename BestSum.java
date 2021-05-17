import java.util.*;
public class BestSum {
    
    public static ArrayList<Long> bestSumRec(long target,long[] num){
        if(target==0){
            ArrayList<Long> arr2=new ArrayList<>();
            return arr2;
        }
        if(target<0){
            return null;
        }
        
        ArrayList<Long> shortest=new ArrayList<>();
        for(int i=0;i<num.length;i++){
            ArrayList<Long> arr2=bestSumRec(target-num[i],num);
            
            if(arr2!=null){
                arr2.add(num[i]);
                
                if(arr2.size()<shortest.size() || shortest.isEmpty()){
                    shortest=arr2;
                }
            }
        }
        
        if(shortest.isEmpty()) return null;
        return shortest;
    }
    
    public static ArrayList<Long> bestSumMemo(long target,long[] num, HashMap<Long, ArrayList<Long>> memo){ 
        if(memo.containsKey(target)) return memo.get(target);
        
        if(target==0) return new ArrayList<>();
        if(target<0)  return null;
        
        ArrayList<Long> shortest=new ArrayList<>();
        for(int i=0;i<num.length;i++){
            ArrayList<Long> arr2=bestSumMemo(target-num[i],num,memo);
            
            if(arr2!=null){
                arr2 = new ArrayList<>(arr2);
/* a new ArrayList has been initialised as equal to operator would
have refered to the return list of recursive function and hinders 
the output.
If the return was [], this step might push [3] into it for the next
iteration if a new List is not formed */
                arr2.add(num[i]);

                if(arr2.size()<shortest.size() || shortest.isEmpty()){
                    shortest=arr2;
                }
            }
        }
        
        if(shortest.isEmpty()){
            memo.put(target,null);
            return null;
        }
        memo.put(target,shortest);
        return shortest;
    }
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        long target = s.nextLong();
        int n= s.nextInt();
        long[] num = new long[n];
        for(int i =0;i<n;i++) num[i]=s.nextLong();
        
        //System.out.println(bestSumRec(target,num));
        HashMap<Long,ArrayList<Long>> memo = new HashMap<>();
        System.out.println(bestSumMemo(target,num,memo));
    }
}
