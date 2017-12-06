/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umons.fragmentassmbler.Util;

import com.umons.fragmentassmbler.Alignement.Alignement;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author bouali
 */
public class GapAdderImpl {

    private GapAdderImpl() {
    }
    private static GapAdderImpl instance = null;

    public final static GapAdderImpl getInstance() {
        if (GapAdderImpl.instance == null) {
            synchronized (GapAdderImpl.class) {
                if (GapAdderImpl.instance == null) {
                    GapAdderImpl.instance = new GapAdderImpl();
                }
            }
        }
        return GapAdderImpl.instance;
    }

    /**
     * *
     * propagate to all the fragment where it is needed
     * @param listOfAlignements
     * @return
     */
    public static ArrayList<Alignement> propagateGaps(ArrayList<Alignement> listOfAlignements) {
        ListIterator<Alignement> listIterator = listOfAlignements.listIterator();
        downIteration(listIterator);
        return listOfAlignements;

    }

    /**
     * @param listIterator that permit going forward and backword on the list
     * and permit to change the values of the alignement()
     */
    private static ListIterator<Alignement> downIteration(ListIterator<Alignement> listIterator) {
        Alignement previous, current;
        current = listIterator.next();
        int pos;
        while (listIterator.hasNext()) {
            previous = current;
            current = listIterator.next();
            pos = listIterator.nextIndex();/*for saving the listiterator's current index*/
            int indexInSequ1 = 0, indexInSequ2 = 0;
            while ((indexInSequ1 < previous.getT().length())
                    && (indexInSequ2 < current.getS().length())) {
                if (isThereAGap(previous.getT(), indexInSequ1, current.getS(), indexInSequ2)) {
                    if (previous.getT().charAt(indexInSequ1) == Util.GAP) {
                        addGap(current, indexInSequ1 + previous.getStartPositionOfT());
                        downGapPropagation(listIterator,indexInSequ1 + previous.getStartPositionOfT());
                        backToTheStartPosition(listIterator, pos, Util.Orientation.DOWN);
                    } else {
                        UpGapPropagation(listIterator,indexInSequ2 + current.getStartPositionOfS());
                        backToTheStartPosition(listIterator, pos, Util.Orientation.UP);
                    }
                 }
                indexInSequ2++;
                indexInSequ1++;
            }
        }
        return listIterator;
    }

    /**
     *
     * @param listIterator
     * @param gapPosition
     * @return
     */
    public static ListIterator<Alignement> downGapPropagation(ListIterator<Alignement> listIterator,
             int gapPosition) {
        Alignement cr;
        while (listIterator.hasNext()) {
            cr = listIterator.next();
            addGap(cr, gapPosition);
        }
        return listIterator;
    }
 /**
     *
     * @param listIterator
     * @param current
     * @param gapPosition
     * @return
     */
    private static ListIterator<Alignement> UpGapPropagation(ListIterator<Alignement> listIterator, int gapPosition) {
        Alignement cr;
        listIterator.previous();
        while (listIterator.hasPrevious()) {
             cr = listIterator.previous();
             addGap(cr, gapPosition);
        }
        return listIterator;
    }
    private static void backToTheStartPosition(ListIterator<Alignement> listIterator, int pos, int orient) {
        if (orient == Util.Orientation.DOWN) {
            while (listIterator.nextIndex() > pos) {
                listIterator.previous();
            }
        } else {
            while (listIterator.nextIndex()< pos) {
                listIterator.next();
            }
        }
    }

   

    /**
     *
     * @param alignement
     * @param gapPosition
     * @return
     */
    public static Alignement addGap(Alignement alignement, int gapPosition) {

        if (gapPosition <= alignement.getStartPositionOfS()) {
            alignement.setStartPositionOfS(alignement.getStartPositionOfS() + 1);
        } else if (gapPosition < alignement.getStartPositionOfS() + alignement.getS().length()) {
            alignement.getS().insert(gapPosition - alignement.getStartPositionOfS(), Util.GAP);
        }
        if (gapPosition <= alignement.getStartPositionOfT()) {
            alignement.setStartPositionOfT(alignement.getStartPositionOfT() + 1);
        } else if (gapPosition < alignement.getStartPositionOfT() + alignement.getT().length()) {
            alignement.getT().insert(gapPosition - alignement.getStartPositionOfT(), Util.GAP);
        }
        alignement.recalculateMargin();
        return alignement;
    }

    /**
     * Only one gap , either in sequ1 or seque2
     *
     * @param seq1
     * @param indexInSequ1
     * @param seq2
     * @param indexInSequ2
     * @param orientation
     * @return
     */
    private static boolean isThereAGap(StringBuilder seq1, int indexInSequ1, StringBuilder seq2, int indexInSequ2) {
        return ((seq1.charAt(indexInSequ1)) == Util.GAP && seq2.charAt(indexInSequ2) != Util.GAP)
                || ((seq1.charAt(indexInSequ1)) != Util.GAP && seq2.charAt(indexInSequ2) == Util.GAP);

    }
}
