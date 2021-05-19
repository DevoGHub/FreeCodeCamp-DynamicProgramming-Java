import java.util.*;

public class CanConstruct {
    public static boolean canConstructRec(String str, String[] arr){
        if(str.equals("")) return true;
        
        for(String s:arr){
            if(str.startsWith(s)){
                if(canConstructRec(str.substring(s.length()),arr)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static boolean canConstructMemo(String str, String[] arr, HashMap<String, Boolean> memo){
        if(memo.containsKey(str)) return memo.get(str);
        if(str.equals("")) return true;
        
        for(String s:arr){
            if(str.startsWith(s)){
                if(canConstructMemo(str.substring(s.length()),arr,memo)){
                    memo.put(str,true);
                    return true;
                }                
            }
        }
        
        memo.put(str,false);
        return false;
    }
    
    public static boolean canConstructTab(String str, String[] arr){
        boolean[] tab = new boolean[str.length()+1];
        Arrays.fill(tab, false);
        tab[0] = true;
        
        for(int i=0;i<=str.length();i++){
            if(tab[i]){
                for(String sub:arr){
                    if(i+sub.length()<=str.length()){
                        if(str.substring(i,i+sub.length()).equals(sub)){
                            tab[i+sub.length()]=true;
                        }
                    }
                }
            }
        }
        
        return tab[str.length()];
    }
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str=s.next();
        int n=s.nextInt();
        String[] arr=new String[n];
        for(int i=0;i<n;i++) arr[i]=s.next();
        
        //---Recursion---
        //System.out.println(canConstructRec(str,arr));
        
        //---Memoisation---
        //System.out.println(canConstructMemo(str,arr,new HashMap<>()));
        
        //---Tabulation---
        System.out.println(canConstructTab(str,arr));
    }
}
