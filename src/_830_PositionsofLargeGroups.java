import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _830_PositionsofLargeGroups {
    public List<List<Integer>> largeGroupPosition(String s){
        List<List<Integer>> ans = new ArrayList();
        int i = 0, N = s.length();
        for(int j = 0; j < N; j++){
            if (j == N-1 || s.charAt(j) != s.charAt(j+1)) {
                // Here, [i, j] represents a group.
                if (j-i+1 >= 3)
                    ans.add(Arrays.asList(new Integer[]{i, j}));
                i = j + 1;
            }
        }
        return ans;
    }
}
