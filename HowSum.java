import java.util.*;

public class HowSum {

    public static ArrayList<Long> howSumRec(long target, long[] num){
        if(target==0){
            ArrayList<Long> arr2=new ArrayList<>();
            return arr2;
        }
        if(target<0){
            return null;
        }
        
        for(int i=0;i<num.length;i++){
            ArrayList<Long> arr2=howSumRec(target-num[i],num);
            
            if(arr2!=null){
                arr2=new ArrayList<>(arr2);
                arr2.add(num[i]);
                return arr2;
            }
        }
        
        return null;
    }
    
    public static ArrayList<Long> howSumMemo(long target, long[] num, HashMap<Long, ArrayList<Long>> memo){
        if(memo.containsKey(target)) return memo.get(target);
        if(target==0){
            ArrayList<Long> arr2=new ArrayList<>();
            return arr2;
        }
        if(target<0){
            return null;
        }
        
        for(int i=0;i<num.length;i++){
            ArrayList<Long> arr2=howSumMemo(target-num[i],num,memo);
            
            if(arr2!=null){
                arr2.add(num[i]);
                memo.put(target-num[i],arr2);
                return arr2;
            }
        }
        
        memo.put(target, null);
        return null;
    }
    
    public static ArrayList<Long> howSumTab(long target, long[] num){
        ArrayList<Long>[] tab = new ArrayList[(int)target+1];
        Arrays.fill(tab, null);
        
        tab[0]=new ArrayList<>();
        
        for(int i=0;i<=target;i++){
            if(tab[i]!=null){
                for(int j=0;j<num.length;j++){
                    if(i+num[j]<=target){
                        tab[i+(int)num[j]] = new ArrayList<>(tab[i]);
                        tab[i+(int)num[j]].add(num[j]);
                    }
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
        for(int i=0;i<n;i++) num[i]=s.nextLong();
        
        //---Recursion---
        //System.out.println(howSumRec(target,num));
        
        //---Memoisation---
        //System.out.println(howSumMemo(target,num,new HashMap<>()));
        
        //---Tabulation---
        System.out.println(howSumTab(target,num));
    }
    
}
