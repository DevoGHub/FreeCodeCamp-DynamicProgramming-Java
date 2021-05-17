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
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.next();
        int n= s.nextInt();
        String[] arr = new String[n];
        for(int i=0;i<n;i++) arr[i]=s.next();
        
        //System.out.println(countConstructRec(str,arr));
        HashMap<String, Long> memo=new HashMap<>();
        System.out.println(countConstructMemo(str,arr,memo));
    }
}
