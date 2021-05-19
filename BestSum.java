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
    
    public static ArrayList<Long> bestSumTab(long target, long[] num){
        ArrayList<Long>[] tab = new ArrayList[(int)target+1];
        Arrays.fill(tab, null);
        tab[0] = new ArrayList<>();
        
        for(int i=0;i<=target;i++){
            if(tab[i]!=null){
                for(long number:num){
                    if(i+number<=target){
                        if(tab[i+(int)number]!=null){
                            if(tab[i+(int)number].size()>=tab[i].size()+1){
                                tab[i+(int)number] = new ArrayList<>(tab[i]);
                                tab[i+(int)number].add(number);
                            }
                        }
                        else{
                            tab[i+(int)number] = new ArrayList<>(tab[i]);
                            tab[i+(int)number].add(number);
                        }
                    }
                }
            }
        }
        
        return tab[(int)target];
    }
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        long target = s.nextLong();
        int n= s.nextInt();
        long[] num = new long[n];
        for(int i =0;i<n;i++) num[i]=s.nextLong();
        
        //---Recusrion---
        //System.out.println(bestSumRec(target,num));
        
        //---Memoisation---
        //System.out.println(bestSumMemo(target,num,new HashMap<>()));
        
        //---Tabulation---
        System.out.println(bestSumTab(target,num));
    }
}
