package com.company;

import org.junit.Assert;

import java.util.Arrays;

import static org.junit.Assert.*;


public class AdjacencyRepresentationTest {
    String[] friends = {"alb ken ber","ken alb ber", "ber alb ken eme oak", "eme ber oak", "oak eme ber pie", "pie oak"};

    @org.junit.Test
    public void addNameMapping() throws Exception {
        String[] expectedMapping = {"alb", "ken", "ber", "eme", "oak", "pie"};
        AdjacencyRepresentation matrix = new AdjacencyRepresentation(friends);
        Assert.assertTrue(Arrays.equals(matrix.namesMapping, expectedMapping));
    }

    @org.junit.Test
    public void parcurgeGrafDfs() throws Exception {
        AdjacencyRepresentation matrix = new AdjacencyRepresentation(friends);
        matrix.parcurgeGrafDfs();
        assertEquals("The edges are not visited in the expected order", "0-1,1-2,2-3,3-4,4-5,", matrix.visitedEdges);
    }

    @org.junit.Test
    public void getUnvisitedNode() throws Exception {
    }

    @org.junit.Test
    public void genAdjacencyRep() throws Exception {
        int[][] knownAdjacenyRep = {
            {0, 1, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 0,},
            {1, 1, 0, 1, 1, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 1, 1, 0, 1},
            {0, 0, 0, 0, 1, 0}
            };
        AdjacencyRepresentation matrix = new AdjacencyRepresentation(friends);

        Assert.assertTrue(Arrays.deepEquals(matrix.adjacencyMatrix, knownAdjacenyRep));
//        System.out.println(Arrays.deepEquals(matrix.adjacencyMatrix, knownAdjacenyRep));
//        matrix.printMatrix();

    }

}