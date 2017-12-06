/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umons.fragmentassmbler.FragmentAssembler;

import com.umons.fragmentassmbler.Util.UnionFind;
import java.util.ArrayList;

/**
 *
 * @author bouali
 */
public class HamiltonienGraph {

    private final ArrayList<Edge> path;
    private final ArrayList<Edge> hamiltonienpath;
    private ArrayList<Edge> listOfEdges ;
    private UnionFind unionFind;

    public HamiltonienGraph() {
        this.path = new ArrayList<>();
        this.hamiltonienpath = new ArrayList<>();
        this.listOfEdges= new ArrayList<>();
    }

    public HamiltonienGraph(ArrayList<Edge> listOfEdges) {
        this();
        this.listOfEdges = listOfEdges;
        
        
    }

    /**
     * Selecting the Edges By following the rules.No cycles ,in&out to or from a
     * vertex only once
     */
    void greedyAlgorithm(UnionFind unionFind) {
        this.unionFind=unionFind;
        for (Edge edge : listOfEdges) {
            int idOfSource = edge.getSource().getId();
            int idOfDestination = edge.getDestination().getId();
            if ((unionFind.getOutArray()[idOfSource] == -1 && unionFind.getInArray()[idOfDestination] == -1)
                    && (unionFind.getMyUniqueSet().find(idOfSource, idOfDestination) == false)) {
                path.add(edge);
                unionFind.getOutArray()[idOfSource] = idOfDestination;
                unionFind.getInArray()[idOfDestination] = 1;
                unionFind.getMyUniqueSet().unify(idOfSource, idOfDestination);
            }
        }
    }

    /**
     * Reordering the edges To create a valid path
     *
     * @return
     */
    void generateTheOrderedEges() {
        /*From the two arrays we can produce a valid path*/
        int index = lookForTheFirstEdge();
        createHamilthonienPath(index);
    
    }

    private int lookForTheFirstEdge() {
        int index = 0;
        for (int i = 0; i < this.unionFind.getInArray().length; i++) {
            if (this.unionFind.getInArray()[i] == -1) {
                index = i;
                break;
            }
        }
        return index;
    }

    private void createHamilthonienPath(int index) {
        int k = 0;
        while (this.unionFind.getOutArray()[index] != -1) {
          //  System.out.println("i :" + k++);
            Edge newEdge = getTheEdgeFromTheList(index);
            hamiltonienpath.add(newEdge);
            index = this.unionFind.getOutArray()[index];
        }
    }

    /**
     * remove and return an Edge from the path identified by a id
     */
    private Edge getTheEdgeFromTheList(int source) {
        Edge edge = null;
        for (int i = 0; i < path.size(); i++) {
            if (path.get(i).getSource().getId() == source) {
                edge = path.remove(i);
                return edge;
            }
        }
        return edge;
    }
    public ArrayList<Edge> getHamiltonienpath() {
        return hamiltonienpath;
    }

    public ArrayList<Edge> getPath() {
        return path;
    }

}
