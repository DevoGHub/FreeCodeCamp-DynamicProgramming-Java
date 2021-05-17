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
                if(canConstructMemo(str.replace(s, ""),arr,memo)){
                    memo.put(str,true);
                    return true;
                }                
            }
        }
        
        memo.put(str,false);
        return false;
    }
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str=s.next();
        int n=s.nextInt();
        String[] arr=new String[n];
        for(int i=0;i<n;i++) arr[i]=s.next();
        
        //System.out.println(canConstructRec(str,arr));
        HashMap<String, Boolean> memo= new HashMap<>();
        System.out.println(canConstructMemo(str,arr,memo));
    }
}
