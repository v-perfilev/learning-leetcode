package explore.graph.e26;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

public class Test {
    public int minimumSemesters(int n, int[][] relations) {
        ArrayList<HashSet<Integer>> graph = new ArrayList<>();
        int[] inDegrees = new int[n + 1];
        createGraph(n, relations, graph, inDegrees);
        Queue<Integer> queue = initQueue(inDegrees);

        // Khan's algorithm
        int courseCounter = 0;
        int semesterCounter = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int course = queue.remove();
                for (int next : graph.get(course)) {
                    inDegrees[next]--;
                    if (inDegrees[next] == 0) {
                        queue.add(next);
                    }
                }
                courseCounter++;
            }
            semesterCounter++;
        }
        return courseCounter == n ? semesterCounter : -1;
    }

    private void createGraph(int n, int[][] relations, ArrayList<HashSet<Integer>> graph, int[] inDegrees) {
        Arrays.fill(inDegrees, 0);
        inDegrees[0] = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] relation : relations) {
            int prev = relation[0];
            int next = relation[1];
            graph.get(prev).add(next);
            inDegrees[next]++;
        }
    }

    private Queue<Integer> initQueue(int[] inDegrees) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        return queue;
    }
}
