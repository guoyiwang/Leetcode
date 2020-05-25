import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class _HashMap_ {
//    ForEach
    public void HashMap_1(){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 10);
        map.put(2,20);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println("Key =" + entry.getKey() + ", Value = " + entry.getValue());
        }
    }
//    ForEach, when you only want to use key or value
    public void HashMap_2() throws IOException{
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 10);
        map.put(2,20);

        //iterate key
        for(Integer key : map.keySet()){
            System.out.println("Key = " + key);
        }
        //iterate value
        for(Integer value : map.values()){
            System.out.println("Value = " + value);
        }
    }
}
