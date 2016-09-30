package com.company;


import java.util.LinkedList;
import java.util.Queue;

public class AdjacencyRepresentation {
    int[][] adjacencyMatrix;
    String[] namesMapping;
    int[] visitedNodes;
    String visitedEdges=""; //keep a list of the visited edges in order

    public AdjacencyRepresentation(String[] friends) {
        namesMapping = new String[friends.length];
        visitedNodes = new int[namesMapping.length]; //il folosesc in parcurgeGrafDfs
        adjacencyMatrix = new int[friends.length][friends.length];

        for (int i = 0; i < friends.length; i++) {
            String line = friends[i];
            String[] arr = line.split(" ");

            int commonFriend = addNameMapping(arr[0]);
            for (int j = 1; j < arr.length; j++) {
                adjacencyMatrix[commonFriend][addNameMapping(arr[j])] = 1;
            }
        }

        if (!checkIsUndirected()) try {
            throw new GraphIsNotUndirected("Attention, the graph you provided in not undirected!");
        } catch (GraphIsNotUndirected graphIsNotUndirected) {
            graphIsNotUndirected.printStackTrace();
        }
    }

    private Boolean checkIsUndirected() {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = i; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] != adjacencyMatrix[j][i]){
                    return false;
                }
            }
        }
        return true;
    }

    int addNameMapping(String name){
        //check if name is already in array
        for (int i = 0; i < namesMapping.length; i++) {
            if (namesMapping[i] != null && namesMapping[i].equals(name)) {
                return i;
            }
        }
        //if name not in array then add it
        for (int i = 0; i < namesMapping.length; i++) {
            if (namesMapping[i] == null){
                namesMapping[i] = name;
                return i;
            }
        }
        throw new RuntimeException("This line shouldn't have been reached");
//        return 0;//nu am cum sa ajung aici
    }

    void printMatrix(){
        System.out.println("uite matricea:");
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

// DFS
    void parcurgeGrafDfs(){
        int g = 0;
        while (getUnvisitedNode() !=-1){
            System.out.println("Graf conex " + ++g);
            dfs(getUnvisitedNode());
        }
    }

    int getUnvisitedNode(){
        for (int i=0; i<visitedNodes.length; i++) {
            if (visitedNodes[i] == 0) return i; //am un nod nevizitat deja
        }
        return -1; //nu am noduri nevizitate
    }
    void dfs(int node){
        visitedNodes[node] = 1;
        System.out.println("I've just visited node: " + node);
        for (int j=0; j<visitedNodes.length; j++){
            if (adjacencyMatrix[node][j] == 1){
                System.out.print("Considering edge: " +node+ "->" +j+ "... ");
                if (visitedNodes[j] == 0){
                    System.out.println("Edge is valid, continuing recursion");
                    visitedEdges += node + "-" + j + ",";
                    dfs(j);
                    System.out.println("back from recursion");
                } else{
                    System.out.println("Edge is NOT valid");
                }
                System.out.println("+++++++");
            }
        }
        visitedNodes[node] = 2;

    }

//BFS
    void parcurgeGrafBfs(){
        int g = 0;
        while (getUnvisitedNode() !=-1){
            System.out.println("Graf conex " + ++g);
            bfs(getUnvisitedNode());
        }

    }
    void bfs(int node){
        int nodeFromQueue;
        Queue<Integer> C = new LinkedList<>();
        C.add(node);
        visitedNodes[node] = 1;
        while(!C.isEmpty()){
            nodeFromQueue = C.remove();
            
        }
    }

    public class GraphIsNotUndirected extends Exception {
        public GraphIsNotUndirected() { super(); }
        public GraphIsNotUndirected(String message) { super(message); }
        public GraphIsNotUndirected(String message, Throwable cause) { super(message, cause); }
        public GraphIsNotUndirected(Throwable cause) { super(cause); }
    }

}
