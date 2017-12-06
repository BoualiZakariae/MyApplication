/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umons.fragmentassmbler.Alignement;

import com.umons.fragmentassmbler.Util.Util;

/*
 *
 * @author bouali
 *
 * From two Sequence S and T we create an alignement matrix values containes the
 * score of the alignements, the boolean SOverT Array indicate if the alignement
 * is of type SOverT
 */
public class AlignementMatrix {

    private String S;
    private String T;
    private int[][] values;
    private boolean[][] SOverT;
    private boolean maxInLastRow;
    private int maximumScore;
    private int indexOfTheMaximumScore;

    public AlignementMatrix() {
    }

    public AlignementMatrix(String S, String T) {
        this.S = S;
        this.T = T;
        this.values = new int[S.length() + 1][T.length() + 1];
        this.SOverT = new boolean[S.length() + 1][T.length() + 1];
    }

    public int[][] getValues() {
        return values;
    }

    public void setValues(int[][] values) {
        this.values = values;
    }

    public void setValue(int i, int j, int value) {
        values[i][j] = value;
    }

    public void setMaxInLastRow(boolean maxInLastRow) {
        this.maxInLastRow = maxInLastRow;
    }

    public void fill() {
        initialisation();
        for (int i = 1; i < getS().length() + 1; i++) {
            for (int j = 1; j < getT().length() + 1; j++) {
                fillTheCell(i, j);
            }
        }
    }

    private void fillTheCell(int i, int j) {
        int scoreFromDiag, scoreFromLeft, scoreFromUp;
        if (getS().charAt(i - 1) == getT().charAt(j - 1)) {
            scoreFromDiag = getValues()[i - 1][j - 1] + Util.AlignementScore.MATCH;
        } else {
            scoreFromDiag = getValues()[i - 1][j - 1] + Util.AlignementScore.MISMATCH;
        }
        scoreFromLeft = getValues()[i][j - 1] + Util.AlignementScore.GAP;
        scoreFromUp = getValues()[i - 1][j] + Util.AlignementScore.GAP;
        int max = Math.max(Math.max(scoreFromDiag, scoreFromLeft), scoreFromUp);
        setValue(i, j, max);
        setValidity(j, i, scoreFromDiag, max, scoreFromLeft);
    }

    private void setValidity(int j, int i, int scoreFromDiag, int max, int scoreFromLeft) {
        boolean sovert;
        if (j > 1 & i > 1) {
            if (scoreFromDiag == max) {
                sovert = SOverT[i - 1][j - 1];
            } else if (scoreFromLeft == max) {
                sovert = SOverT[i][j - 1];
            } else {
                sovert = SOverT[i - 1][j];
            }
            setSoverT(i, j, sovert);
        }
    }

    private void initialisation() {
        for (int j = 1; j < getValues().length; j++) {
            setSoverT(j, 1, true);
            setSoverT(j, 0, true);
        }
        for (int j = 2; j < getValues()[0].length; j++) {
            setSoverT(1, j, false);
        }

    }

    private void setSoverT(int i, int j, boolean b) {
        this.SOverT[i][j] = b;
    }

    /**
     *
     * @return the index of the maximum cost in the last Column
     */
    public int getIndexOfTheLastColumn() {
        int row = getValues().length, col = getValues()[0].length;
        int index = 0, max = getValues()[0][col - 1];
        for (int i = 1; i < row; i++) {
            if ((max < getValues()[i][col - 1]) && (SOverT[i][col - 1] == true)) {
                max = getValues()[i][col - 1];
                index = i;
            }
        }
        return index;
    }

    /**
     *
     * @return the index of the maximum cost in the last Row
     */
    public int getIndexOfTheLastRow() {
        int row = getValues().length, col = getValues()[0].length;
        int index = 0, max = getValues()[row - 1][0];/*to be reviewed*/
        for (int j = 1; j < col; j++) {
            if ((max < getValues()[row - 1][j]) && (SOverT[row - 1][j] == true)) {
                index = j;
                max = getValues()[row - 1][j];
            }
        }
        return index;
    }

    /**
     *
     * @return the max value in the last Row
     */
    public boolean theMaxIsIntheLastRow() {
        int row = getValues().length, col = getValues()[0].length;
        int max = getValues()[row - 1][0];
        for (int j = 1; j < col; j++) {
            if ((max < getValues()[row - 1][j]) && (SOverT[row - 1][j] == true)) {
                max = getValues()[row - 1][j];
            }
        }
        for (int i = 1; i < row; i++) {
            if ((max < getValues()[i][col - 1]) && (SOverT[i][col - 1] == true)) {
                return false;
            }
        }
        return true;
    }

    public void calculateMaximumScore() {
        setMaxInLastRow(false);
        int row = getValues().length, col = getValues()[0].length;
        int max = getValues()[0][0];
        //last column
        for (int i = 1; i < row; i++) {
            if ((max < getValues()[i][col - 1]) && (SOverT[i][col - 1] == true)) {
                max = getValues()[i][col - 1];
                maximumScore = max;
                indexOfTheMaximumScore = i;
            }
        }
        //last row
        for (int j = 1; j < col; j++) {
            if ((max < getValues()[row - 1][j]) && (SOverT[row - 1][j] == true)) {
                max = getValues()[row - 1][j];
                setMaxInLastRow(true);
                maximumScore = max;
                indexOfTheMaximumScore = j;
            }
        }

    }

    public boolean isMaxInLastRow() {
        return maxInLastRow;
    }

    public String getS() {
        return S;
    }

    public String getT() {
        return T;
    }

    public boolean[][] getSOverT() {
        return SOverT;
    }

    public void setSOverT(boolean[][] SOverT) {
        this.SOverT = SOverT;
    }

    public int getIndexOfTheMaximumScore() {
        return indexOfTheMaximumScore;
    }

    public int getMaximumScore() {
        return maximumScore;
    }

}
