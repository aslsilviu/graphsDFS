package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int nodesNo;
        String[] friends;
        Scanner sc = new Scanner(System.in);

//        nodesNo = sc.nextInt();
        nodesNo = sc.nextInt();
        sc.nextLine();
        friends = new String[nodesNo];

        for (int i = 0; i < nodesNo; i++) {
            friends[i] = sc.nextLine();
        }

        System.out.println(Arrays.toString(friends));

        AdjacencyRepresentation matrix = new AdjacencyRepresentation(friends);
        matrix.printMatrix();
        matrix.parcurgeGrafDfs();

    }
}
