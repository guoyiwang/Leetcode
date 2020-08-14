import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _210_CourseScheduleII {
    //All vertices are WHITE at first. The vertices are GRAY when they are processed. The vertices are BLACK when they are added to stack.
    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;

    boolean isPossible;
    Map<Integer, Integer> color;
    Map<Integer, List<Integer>> adjList;
    List<Integer> topologicalOrder;

    private void init(int numCourses){
        this.isPossible = true;
        this.color = new HashMap<Integer, Integer>();
        this.adjList = new HashMap<Integer, List<Integer>>();
        this.topologicalOrder = new ArrayList<>();

        //By default all vertices are WHITE;
        for(int i = 0; i < numCourses; i++){
            this.color.put(i, WHITE);
        }
    }
    //Put the deepest vertex in stack which could be found without adjacent nodes to process. The deepest vertex will the last course should be completed
    private void dfs(int node){
        //Don't recurse further if we found a cycle already
        if(!this.isPossible){
            return;
        }

        //Start the recursion
        this.color.put(node, GRAY);

        //Traverse on neighboring vertices
        for(Integer neighbor : this.adjList.getOrDefault(node, new ArrayList<Integer>())){
            if(this.color.get(neighbor) == WHITE){
                this.dfs(neighbor);
            }else if(this.color.get(neighbor) == GRAY){
                // An edge to a GRAY vertex represents a cycle
                this.isPossible = false;
            }
        }

        //Recursion ends. We mark it as black
        this.color.put(node, BLACK);
        this.topologicalOrder.add(node);
    }
    public int[] findOrder(int numCourses, int[][] prerequisites){
        this.init(numCourses);

        //Create the adjacency list representation of the graph
        for(int i = 0; i < prerequisites.length; i++){
            int after = prerequisites[i][0];
            int pre = prerequisites[i][1];
            List<Integer> list = adjList.getOrDefault(pre, new ArrayList<Integer>());
            list.add(after);
            adjList.put(pre, list);//Some courses will have the same prerequisite. One prerequisite will have an adjacency list.
            //If pre is existing key in this HashMap, the previous value will be replaced by the new value.
        }

        //if the node is unprocessed, then call dfs on it.
        for(int i = 0; i < numCourses; i ++){
            if(this.color.get(i) ==WHITE){
                this.dfs(i);
            }
        }

        int[] order;
        if(this.isPossible){
            order = new int[numCourses];
            for(int i = 0; i < numCourses; i++){
                order[i] = this.topologicalOrder.get(numCourses - i - 1); //topologicalOrder[0] is the last course you should take
            }
        }else {
            order = new int[0];
        }
        return order;
    }
}
