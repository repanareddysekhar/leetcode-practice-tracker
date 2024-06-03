class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = createGraph(numCourses, prerequisites);

        return !isCyclic(graph, numCourses);
    }

    private boolean isCyclic(ArrayList<ArrayList<Integer>> graph, int numCourses) {
        boolean[] vis = new boolean[numCourses];
        boolean[] dfsvis = new boolean[numCourses];

        for(int i=0; i<numCourses; i++) {
            if(!vis[i])
                if(isCyclicUtil(graph, vis, dfsvis, i))
                    return true;
        }

        return false;
    }

    private boolean isCyclicUtil(ArrayList<ArrayList<Integer>> graph, boolean[] vis, boolean[] dfsvis, int v) {
        vis[v] = true;
        dfsvis[v] = true;

        for(Integer node : graph.get(v)) {
            if(!vis[node]) {
                if(isCyclicUtil(graph, vis, dfsvis, node))
                    return true;
            } else if(dfsvis[node])
                return true;
        }

        dfsvis[v] = false;
        return false;
    }

    private ArrayList<ArrayList<Integer>> createGraph(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++)
            graph.add(new ArrayList<>());
        
        for(int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }

        return graph;
    }
}