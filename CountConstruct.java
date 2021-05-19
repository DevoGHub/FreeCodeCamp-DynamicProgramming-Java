import java.util.*;
public class CountConstruct {
    public static long countConstructRec(String str, String[] arr){
        if(str.equals("")) return 1;
        
        long count=0;
        for(String s:arr){
            if(str.startsWith(s)){
                count+=countConstructRec(str.substring(s.length()),arr);
            }
        }
        
        return count;
    }
    
    public static long countConstructMemo(String str, String[] arr, HashMap<String, Long> memo){
        if(memo.containsKey(str)) return memo.get(str);
        if(str.equals("")) return 1;
        
        long count=0;
        for(String s:arr){
            if(str.startsWith(s)){
                count+=countConstructRec(str.substring(s.length()),arr);
            }
        }
        
        memo.put(str, count);
        return count;
    }
    
    public static long countConstructTab(String str, String[] arr){
        long[] tab = new long[(int)str.length()+1];
        Arrays.fill(tab, 0);
        tab[0]=1;
        
        for(int i=0;i<=str.length();i++){
            if(tab[i]!=0){
                for(String sub:arr){
                    if(i+sub.length()<=str.length()){
                        if(str.substring(i,i+sub.length()).equals(sub)){
                            tab[i+sub.length()]+=tab[i];
                        }
                    }
                }
            }
        }
        
        return tab[str.length()];
    }
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.next();
        int n= s.nextInt();
        String[] arr = new String[n];
        for(int i=0;i<n;i++) arr[i]=s.next();
        
        //---Recursion---
        //System.out.println(countConstructRec(str,arr));
        
        //---Memoisation---
        //System.out.println(countConstructMemo(str,arr,new HashMap<>()));
        
        //---Tabulation---
        System.out.println(countConstructTab(str,arr));
    }
}
