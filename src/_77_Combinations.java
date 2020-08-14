import java.util.ArrayList;
import java.util.List;

public class _77_Combinations {
    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> kind = new ArrayList<Integer>();
        int i = 1;
        while(i<=n || kind.size()!=0){
            if(kind.size()==k){
                list.add(new ArrayList<>(kind));
            }
            if(i>n || kind.size() ==k){
                i = kind.get(kind.size()-1) + 1;
                kind.remove(kind.size()-1);
            }else {
                kind.add(i);
                i++;
            }
        }
        return list;
    }
}
