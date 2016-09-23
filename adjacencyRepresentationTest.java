package com.company;

import java.util.Arrays;

import static org.junit.Assert.*;


public class adjacencyRepresentationTest {
    @org.junit.Test
    public void addNameMapping() throws Exception {

    }

    @org.junit.Test
    public void PARCURGE_GRAF_DFS() throws Exception {

    }

    @org.junit.Test
    public void getUnvisitedNode() throws Exception {

    }

    @org.junit.Test
    public void genAdjacencyRep() throws Exception {
        String[] friends = {"alb ken ber","ken alb ber", "ber alb ken eme oak", "eme ber oak", "oak eme ber pie", "pie oak"};
        int[][] knownAdjacenyRep = {
            {0, 1, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 0,},
            {1, 1, 0, 1, 1, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 1, 1, 0, 1},
            {0, 0, 0, 0, 1, 0}
            };
        adjacencyRepresentation matrix = new adjacencyRepresentation(friends);

        Arrays.equals(friends[1], knownAdjacenyRep[1]);
        matrix.printMatrix();

    }

}