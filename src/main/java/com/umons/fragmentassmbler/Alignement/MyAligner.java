/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umons.fragmentassmbler.Alignement;

import com.umons.fragmentassmbler.FragmentAssembler.Edge;
import com.umons.fragmentassmbler.FragmentAssembler.Fragment;
import com.umons.fragmentassmbler.Util.Util;
import java.util.ArrayList;

/**
 *
 * @author bouali From Eclipse
 */
public class MyAligner implements Aligner {

    private int row, column;
    private Alignement alignement;
    private AlignementMatrix alignementMatrix;

    public  MyAligner() {
        alignement = null;
        alignementMatrix = null;
        row = 0;
        column = 0;
    }

   
    /**
     * this method align the two fragment contained in the edge We begin by
     * constructin the alignement matrix,the we bactrack in the matrix to build
     * the Alignement
     *
     * @param edge
     * @return
     */
    @Override
    public Alignement makeAlignement(Edge edge) {
        alignement = Alignement.initializeAlignement(edge);
        alignementMatrix = getAlignementMatrix(alignement.getS().toString(),
                alignement.getT().toString());
        alignementMatrix.calculateMaximumScore();
        alignement.setWeight(alignementMatrix.getMaximumScore());
        if (alignementMatrix.isMaxInLastRow() == true) {//has been modified
            alignement = backTrackFromTheLastRow();
        } else {
            alignement = backTrackFromTheLastColumn();
        }
        return alignement;
    }

    public Alignement backTrackFromTheLastRow() {
        // System.out.println("FromTheLastRow");
        row = alignementMatrix.getValues().length - 1;
        column = alignementMatrix.getIndexOfTheMaximumScore();
        return backTrack();
    }

    public Alignement backTrackFromTheLastColumn() {
        row = alignementMatrix.getIndexOfTheMaximumScore();
        column = alignementMatrix.getValues()[0].length - 1;
        return backTrack();
    }

    Alignement backTrack() {
        StringBuilder S = alignement.getS();
        StringBuilder T = alignement.getT();
        int scoreFromDiag, scoreFromLeft, scoreFromUp;
        while (row > 0 && column > 0) {
            if (S.charAt(row - 1) == T.charAt(column - 1)) {
                scoreFromDiag = alignementMatrix.getValues()[row - 1][column - 1] + 1;
            } else {
                scoreFromDiag = alignementMatrix.getValues()[row - 1][column - 1] - 1;
            }
            scoreFromLeft = alignementMatrix.getValues()[row][column - 1] - 2;
            scoreFromUp = alignementMatrix.getValues()[row - 1][column] - 2;
            if ((scoreFromDiag >= scoreFromLeft && scoreFromDiag >= scoreFromUp)
                    && (alignementMatrix.getSOverT()[row - 1][column - 1] == true)) {
                column--;
                row--;
            } else if ((scoreFromLeft >= scoreFromDiag && scoreFromLeft >= scoreFromUp)
                    && (alignementMatrix.getSOverT()[row][column - 1] == true)) {
                alignement.getS().insert(row - 1, Util.GAP);
                column--;
            } else {
                alignement.getT().insert(column - 1, Util.GAP);
                row--;
            }
        }
        updateAlignement();
        return alignement;
    }

    /**
     * update some values of the alignement specifically the margin and the type
     * of alignement
     *
     * @param alignement
     */
    private void updateAlignement() {
        if (column == 0) {
            alignement.setMargin(row);
            alignement.setSOverT(true);
            alignement.setStartPositionOfS(0);
            alignement.setStartPositionOfT(row);
        } else if (row == 0) {
            alignement.setMargin(-column);
            alignement.setSOverT(false);
            alignement.setStartPositionOfS(0);
            alignement.setStartPositionOfT(-column);
        }
    }

    @Override
    public AlignementMatrix getAlignementMatrix(String S, String T) {
        alignementMatrix = new AlignementMatrix(S, T);
        alignementMatrix.fill();
        return alignementMatrix;
    }

    /**
     *
     * @param S
     * @param T
     * @return the cost of a semiglobal alignement
     */
    @Override
    public int CostOfSemiGlobalAlignement(String S, String T) {
        alignementMatrix = getAlignementMatrix(S, T);
        alignementMatrix.calculateMaximumScore();
        return alignementMatrix.getMaximumScore();
    }

    
    
    @Override
    public int SECONDCostOfSemiGlobalAlignement(Fragment F1,Fragment F2) {
        
       
        String S =  F1.getSequence().toString();
        String T =  F1.getSequence().toString();
        alignementMatrix = getAlignementMatrix(S,T);
        alignementMatrix.calculateMaximumScore();
        return alignementMatrix.getMaximumScore();
    }
    
    
    @Override
    public ArrayList<Alignement> paireWiseAlignements(ArrayList<Edge> realPath) {
        ArrayList<Alignement> listOfAlignements = new ArrayList<>();
        Alignement alig;
        for (Edge edge : realPath) {
            alig = this.makeAlignement(edge);
            listOfAlignements.add(alig);
        }
        return listOfAlignements;
    }

    public void setAlignementMatrix(AlignementMatrix alignementMatrix) {
        this.alignementMatrix = alignementMatrix;
    }

    public AlignementMatrix getAlignementMatrix() {
        return alignementMatrix;
    }

    public void setAlignement(Alignement alignement) {
        this.alignement = alignement;
    }

}
