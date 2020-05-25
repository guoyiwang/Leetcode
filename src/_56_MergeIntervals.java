import java.util.*;

public class _56_MergeIntervals {
    private class IntervalsComparator implements Comparator<int []> {
        @Override
        public int compare(int[] a, int[] b){//compare in Abstract class is set that lee than, negative integer; equal, zero; more than, positive integer.
            return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
        }
    }
    public int[][] merge(int[][] intervals){
        Collections.sort(Arrays.asList(intervals), new IntervalsComparator());
        //Choose LinkedList which could getLast, and add elements
        LinkedList<int []> mergered = new LinkedList<int []>();
        for(int[] interval: intervals){
            //mergered is empty, it should add element first. Then if last element is overlap with interval, the element in mergered should be changed.
            if (mergered.isEmpty() || mergered.getLast()[1] < interval[0]) {
                mergered.add(interval);
            }else{
                mergered.getLast()[1] = Math.max(mergered.getLast()[1], interval[1]);
            }

        }
        printMatirx(mergered.toArray(new int[mergered.size()][]));
        return mergered.toArray(new int[mergered.size()][]);
    }
    public static void printMatirx(int[][] as){
        System.out.print("[");
        for(int i = 0; i < as.length; i++){
            System.out.print("[");
            for(int j =0; j < as[i].length; j++) {
                System.out.print(as[i][j] + (j==as[i].length-1? "":","));
            }
            System.out.print("]" + (i==as.length-1? "":","));
        }
        System.out.print("]");
    }
}
