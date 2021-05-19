import java.util.*;
public class AllConstruct {
    public static ArrayList<ArrayList<String>> allConstructRec(String str, String[] arr){
        if(str.equals("")){
            ArrayList<ArrayList<String>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }
        
        ArrayList<ArrayList<String>> store=new ArrayList<>();
        for(String s:arr){
            if(str.startsWith(s)){
                ArrayList<ArrayList<String>> temp= allConstructRec(str.substring(s.length()),arr);
                ArrayList<String> temp2;
                for(int i=0;i<temp.size();i++){
                    temp2 =new ArrayList<>(temp.get(i));
                    temp2.add(0, s);
                    store.add(temp2);
                }
            }
        }

        return store;
    }
    
    public static ArrayList<ArrayList<String>> allConstructMemo(String str, String[] arr, HashMap<String,ArrayList<ArrayList<String>>> memo){
        if(memo.containsKey(str)) return memo.get(str);
        
        if(str.equals("")){
            ArrayList<ArrayList<String>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }
        
        ArrayList<ArrayList<String>> store=new ArrayList<>();
        for(String s:arr){
            if(str.startsWith(s)){
                ArrayList<ArrayList<String>> temp= allConstructMemo(str.substring(s.length()),arr,memo);
                ArrayList<String> temp2;
                for(int i=0;i<temp.size();i++){
                    temp2 =new ArrayList<>(temp.get(i));
                    temp2.add(0, s);
                    store.add(temp2);
                }
            }
        }
        
        memo.put(str, store);
        return store;
    }
    
    public static ArrayList<ArrayList<String>> allConstructTab(String str, String[] arr){
        ArrayList<ArrayList<String>>[] tab = new ArrayList[str.length()+1];
        for(int i=0;i<=str.length();i++){
            tab[i]=new ArrayList<>();
        }
        tab[0]=new ArrayList<>();
        tab[0].add(new ArrayList<>());
        
        for(int i=0;i<=str.length();i++){
            if(!tab[i].isEmpty()){
                for(String sub:arr){
                    if(i+sub.length()<=str.length()){
                        if(str.substring(i,i+sub.length()).equals(sub)){
                            for(ArrayList temp:tab[i]){
                                temp= new ArrayList<>(temp);
                                temp.add(sub);
                                tab[i+sub.length()].add(temp);
                            }
                        }
                    }
                }
            }
        }
        
        return tab[str.length()];
    }
    
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String str= s.next();
        int n=s.nextInt();
        String[] arr= new String[n];
        for(int i=0;i<n;i++) arr[i]=s.next();
        
        //---Recursion---
        //System.out.println(allConstructRec(str,arr));
        
        //---Memoisation---
        //System.out.println(allConstructMemo(str,arr,new HashMap<>()));
        
        //---Tabulation---
        System.out.println(allConstructTab(str,arr));
    }
}
