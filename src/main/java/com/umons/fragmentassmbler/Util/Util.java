/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umons.fragmentassmbler.Util;

import com.umons.fragmentassmbler.Alignement.Alignement;
import com.umons.fragmentassmbler.Alignement.Aligner;
import com.umons.fragmentassmbler.Alignement.MyAligner;
import com.umons.fragmentassmbler.FragmentAssembler.Edge;
import com.umons.fragmentassmbler.FragmentAssembler.Fragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Utility Class
 *
 * @author zakariae
 */
public class Util {

    public static final char GAP = '_';
    public static class Orientation {

       public static final int UP = 1;
       public static final int DOWN = -1;
        
    }
    public static class Nucleotides {

        public static final char A = 'a';
        public static final char C = 'c';
        public static final char T = 't';
        public static final char G = 'g';
       }
    public static class AlignementScore {
        public static final int MATCH = 1;
        public static final int MISMATCH = -1;
        public static final int GAP = -2;
    }
    /**
     * Semi-global Alignement i should using multithreading to accelerate calcul
     * without constructing the resulted Sequences the goal for this method is
     * oonly knowing the cost of every possible alignement
     *
     * @param listOfFragments
     * @return
     */
    public static ArrayList<Edge> createEdges(ArrayList<Fragment> listOfFragments) {
        List<Edge> edges = listOfFragments.parallelStream().flatMap(v1 -> listOfFragments.stream().map(v2 -> CREATEEDGE(v1, v2))).collect(Collectors.toList());
        ArrayList<Edge> listOfEdges = new ArrayList<>(edges);
        return listOfEdges;
    }
    
    
    
    private static Edge CREATEEDGE(Fragment f1 , Fragment f2) {
        Aligner alig = new MyAligner();//added
        int weight = alig.CostOfSemiGlobalAlignement(f1.getSequence().toString(),f2.getSequence().toString());
        Edge edge = new Edge(f1, f2, weight);
        return edge;
    }
    
    
    
    
    private static Edge createEdge(ArrayList<Fragment> listOfFragments, int i, int j) {
        Fragment S;
        Fragment T;
        S = listOfFragments.get(i);
        T = listOfFragments.get(j);
        Aligner alig = new MyAligner();//added
        int weight = alig.CostOfSemiGlobalAlignement(S.getSequence().toString(),T.getSequence().toString());
        Edge edge = new Edge(S, T, weight);
        return edge;
    }
    /**
     *
     * @param listOfAlignements
     * @return
     */
    public static ArrayList<Alignement> recalculateStartOfFragments(ArrayList<Alignement> listOfAlignements) {
        System.out.println("recalculateStartOfFragments ");
        System.out.println("La list D'alignement contient "+listOfAlignements.size()+ "alignements");
        ListIterator<Alignement> listIterator = listOfAlignements.listIterator();
        Alignement currentAlignement;
        Alignement previousAlignement = listIterator.next();
        while (listIterator.hasNext()) {
            currentAlignement = listIterator.next();
            currentAlignement.setStartPositionOfS(previousAlignement.getStartPositionOfT());
            currentAlignement.setStartPositionOfT(currentAlignement.getStartPositionOfS() + currentAlignement.getMargin());
            listIterator.set(currentAlignement);
            previousAlignement = currentAlignement;
        }
        return listOfAlignements;
    }
    public static void printStartPosition(ArrayList<Alignement> listOfAlignements) {
        Alignement al;
        for (int i = 0; i < listOfAlignements.size(); i++) {
            al = listOfAlignements.get(i);
            System.out.println("Start Of S " + al.getStartPositionOfS());
            System.out.println("Start Of T " + al.getStartPositionOfT());
        }
    }
    private Util() {
    }
    public static void printMap(Map<Integer, List<Integer>> map) {
        Set s = map.entrySet();
        Iterator it = s.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Integer key = (Integer) entry.getKey();
            List<Integer> value = (List<Integer>) entry.getValue();
            System.out.print(key + " => ");
            print(value);
        }//while
        System.out.println("========================");
    }
    public static void showMatrice(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] < 0) {
                    System.out.print(" " + array[i][j]);
                } else {
                    System.out.print("  " + array[i][j]);
                }
            }
            System.out.println("");
        }

    }
    public static void showMatrice(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                 System.out.print(" " + array[i][j]);
               }
            System.out.println("");
        }

    }
    public static void print(List list) {
        for (int j = 0; j < list.size(); j++) {
           System.out.println("Alignement \n"+j+" "+list.get(j));
        }
    }
    public static void printAlignement(ArrayList<Alignement> list) {
        Alignement al;
        for (int j = 0; j < list.size(); j++) {
            al = list.get(j);
            System.out.print("n° "+j+" ");
            printSpace(al.getStartPositionOfS());
            System.out.println(al.getS());
            System.out.print("n° "+j+" ");
            printSpace(al.getStartPositionOfT());
            System.out.println(al.getT());
        }
    }
    public static void printSpace(int startPositionOfS) {
        for (int i = 0; i < startPositionOfS; i++) {
            System.out.print("_");
        }
        
    }
    public static void showListOfEdges(ArrayList<Edge> listOfEdges) {
        System.out.println("The List Of Edges");
        listOfEdges.forEach((edge) -> {
            System.out.println(edge);
        });
    }
    public static void printStartOfFragment(ArrayList<Alignement> list){
        Alignement al;
        for (int j = 0; j < list.size(); j++) {
            al = list.get(j);
            System.out.print(j+" Start Of S  ");
            System.out.println((al.getStartPositionOfS()));
            System.out.print(j+" Start Of T  ");
            System.out.println((al.getStartPositionOfT()));
            }
        
    }

    
}
