/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umons.fragmentassmbler.Alignement;

import com.umons.fragmentassmbler.FragmentAssembler.Edge;
import com.umons.fragmentassmbler.FragmentAssembler.Fragment;
import java.util.ArrayList;

/**
 *
 * @author bouali
 */
public interface Aligner {
    public Alignement makeAlignement(Edge edge);
    public ArrayList<Alignement> paireWiseAlignements(ArrayList<Edge> realPath);
    public AlignementMatrix getAlignementMatrix(String S, String T);
    public int CostOfSemiGlobalAlignement(String S, String T);
    public int SECONDCostOfSemiGlobalAlignement(Fragment F1,Fragment F2);
    
}
