/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umons.fragmentassmbler.Alignement;

import com.umons.fragmentassmbler.FragmentAssembler.Edge;
import com.umons.fragmentassmbler.Util.Util;

/**
 *
 * @author bouali
 */
public class Alignement {

    private StringBuilder S;
    private StringBuilder T;

    /*  the alignement Cost
        of the two Sequences
     */
    private int weight;

    /*
      the margin between F1 and F2 
      Example
      ACTGACT---
      ---GACTACT
      margin=3;
     */
    private int margin;

    private boolean SOverT = true;
    private int startPositionOfS = 0;
    private int startPositionOfT = 0;

    public Alignement() {

    }

    public Alignement(StringBuilder S, StringBuilder T) {
        this.S = new StringBuilder(S);
        this.T = new StringBuilder(T);
    }

    public Alignement(String S, String T) {
        this.S = new StringBuilder(S);
        this.T = new StringBuilder(T);
    }

    public Alignement(Alignement alignementToClone) {
        this.S = new StringBuilder(alignementToClone.S.toString());
        this.T = new StringBuilder(alignementToClone.T.toString());
        this.SOverT = alignementToClone.SOverT;
        this.margin = alignementToClone.margin;
        this.startPositionOfS = alignementToClone.startPositionOfS;
        this.startPositionOfT = alignementToClone.startPositionOfT;
        this.weight = alignementToClone.weight;
    }

    public static Alignement initializeAlignement(Edge edge) {
        StringBuilder S = new StringBuilder(edge.getSource().getSequence());
        StringBuilder T = new StringBuilder(edge.getDestination().getSequence());
        Alignement al = new Alignement(S, T);
        return al;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setS(StringBuilder S) {
        this.S = S;
    }

    public void setT(StringBuilder T) {
        this.T = T;
    }

    public StringBuilder getS() {
        return S;
    }

    public StringBuilder getT() {
        return T;
    }

    public int getMargin() {
        return margin;
    }

    public void setMargin(int margin) {
        this.margin = margin;
    }

    @Override
    public String toString() {

        Util.printSpace(getStartPositionOfS());
        return "Src: " + this.S + "\nDst: " + this.T;
        /*"\n" + " With Margin " + this.margin;*/
    }

    public void setSOverT(boolean SOverT) {
        this.SOverT = SOverT;
    }

    public boolean isSOverT() {
        return SOverT;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof Alignement)) {
            return false;
        }
        Alignement otherAlignement = (Alignement) other;
        return this.S.toString().equals(otherAlignement.getS().toString())
                && this.T.toString().equals(otherAlignement.getT().toString())
                && this.margin == otherAlignement.getMargin()
                && this.SOverT == otherAlignement.isSOverT();
    }

    public int getStartPositionOfS() {
        return startPositionOfS;
    }

    public int getStartPositionOfT() {
        return startPositionOfT;
    }

    public void setStartPositionOfS(int startPositionOfS) {
        this.startPositionOfS = startPositionOfS;
    }

    public void setStartPositionOfT(int startPositionOfT) {
        this.startPositionOfT = startPositionOfT;
    }

    public void recalculateMargin() {
        this.margin = this.startPositionOfT - this.startPositionOfS;
    }

}
