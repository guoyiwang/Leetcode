import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class _207_CourseSchedule {
    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;

    boolean isPossible;//if topological sort is possible, isPossible is true. If cycle exists, is false.
    Map<Integer, Integer> color;
    Map<Integer, List<Integer>> adjList;

    private void init(int numCourses){
        this.isPossible = true;
        this.color = new HashMap<Integer, Integer>();
        this.adjList = new HashMap<Integer, List<Integer>>();

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
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        return this.isPossible;
    }

}
