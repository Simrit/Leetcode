package com.practice.google.arraysAndStrings;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CutOffTreesForGolfEvent {
    int [][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int cutOffTrees(List<List<Integer>> forest){
        //Approach here is to first convert the forest into a priority queue to get the cells in the order of their heights
        //Now PQ contains the path - starting from element at 0,0 -> next to reach the elements in the Pq.
        //create a minStep method - that runs BFS for every element in the PQ to get to the next element in the PQ

        int r = forest.size(), c=forest.get(0).size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int i=0;i<r; i++){
            for(int j=0; j<c; j++){
                int element = forest.get(i).get(j);
                if(element>1)
                    pq.offer(new int[]{i,j,element});
            }
        }
        int sum=0;
        int [] start = new int[2];
        while(!pq.isEmpty()){
            int [] next = pq.poll();
            int steps = minSteps(forest, start, next, r, c);

            if(steps<0) return -1;
            sum += steps;
            start[0] = next[0];
            start[1] = next[1];
        }

        return sum;
    }

    public int minSteps(List<List<Integer>> forest, int [] start, int [] next, int r, int c){
        boolean [][] seen = new boolean[r][c];
        Queue<int []> q = new LinkedList<>();
        q.offer(start);
        seen[start[0]][start[1]] = true;
        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                if(curr[0]==next[0] && curr[1]==next[1]) return steps;

                for(int [] d: dir){
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];

                    if(x<0 || x>=r || y<0|| y>=c || forest.get(x).get(y)==0 || seen[x][y]) continue;
                    q.offer(new int[]{x,y,forest.get(x).get(y)});
                    seen[x][y]= true;
                }
            }
            steps++;
        }
        return -1;
    }
}
