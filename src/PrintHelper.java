import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

public class PrintHelper {
    public static void print(Object o){
        if(o instanceof Iterable){
            printIterable((Iterable) o);
        }else if(o instanceof int[]){
            printIterable(Arrays.stream((int[]) o).asLongStream().boxed().collect(Collectors.toList()));
        }else if(o.getClass().isArray()){
            printIterable(Arrays.stream((Object[]) o).collect(Collectors.toList()));
        }else{
            System.out.print(o.toString());
        }
    }
    private static <T extends Iterable> void printIterable(T iterable){
        System.out.print("[");
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()){
            Object item = iterator.next();
            if(item instanceof Iterable){
                printIterable((Iterable) item);
            }else if(item instanceof int[]){
                printIterable(Arrays.stream((int[]) item).asLongStream().boxed().collect(Collectors.toList()));
            }else if(item.getClass().isArray()){
                printIterable(Arrays.stream((Object[]) item).collect(Collectors.toList()));
            }else{
                System.out.print(item.toString() + (iterator.hasNext() ? "," : ""));
            }
        }
        System.out.print("]");
    }
}
