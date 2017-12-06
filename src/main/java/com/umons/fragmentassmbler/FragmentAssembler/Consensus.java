/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umons.fragmentassmbler.FragmentAssembler;

import com.umons.fragmentassmbler.Alignement.Alignement;
import com.umons.fragmentassmbler.Util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author bouali
 */
public class Consensus {
 
    private static HashMap<Integer, ArrayList<Integer>> newHashMap = new HashMap<>();
    private static StringBuilder Target = new StringBuilder();
    
    public Consensus() {
    }

    public  static StringBuilder getTarget(ArrayList<Alignement> listOfAlignements){
        for (Alignement alignement : listOfAlignements) {
            int start = alignement.getStartPositionOfS();
            for (int i = start; i < start+alignement.getS().length(); i++) {
                addToHashMap(i,alignement.getS().charAt(i-start));
            }/*The last Alignement*/
                
        }
        return getTargetFromHashMap(newHashMap);
    }
    private static StringBuilder getTargetFromHashMap(HashMap<Integer, ArrayList<Integer>> newHashMap) {
        TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>(newHashMap);
        return generateTaget(treeMap);
    }
    
    
    private static StringBuilder generateTaget(TreeMap<Integer, ArrayList<Integer>> map) {
        Set s = map.entrySet();
        Iterator it = s.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ArrayList<Integer> values = (ArrayList<Integer>) entry.getValue();
            char mostOcuuredChar = getMostOccuredChar(values);
            if (mostOcuuredChar != Util.GAP)
                Target.append(mostOcuuredChar);
        }
        return Target;
      }
    
    
    private static char getMostOccuredChar(ArrayList<Integer> values) {
        int max   = 0;
        int count = values.get(0)  ;
        for (int i = 1; i < values.size()-1; i++) {
            if (values.get(i) > count){
                count = values.get(i);
                max = i;
            }
        }
        return mostOccuredChar(max);
    }

    private static char mostOccuredChar(int max) {
        switch (max) {
            case 0 :
                return Util.Nucleotides.A;
            case 1 :
                return Util.Nucleotides.C;
            case 2 :
                return Util.Nucleotides.T;
            case 3 :
                return Util.Nucleotides.G;
        }
        return Util.GAP;
    }
    
    
    private static void  addToHashMap(int start, char charAt) {
        ArrayList<Integer> counter = newHashMap.get(start);
        if (counter == null)
        {
          counter = new ArrayList<>(Arrays.asList(0,0,0,0,0)); 
          newHashMap.put(start,counter);
        }
        int newValue ;
        switch (charAt) {
                    case Util.Nucleotides.A:
                        newValue = counter.get(0)+1;
                        counter.set(0, newValue);
                        break;
                    case Util.Nucleotides.C:
                        newValue = counter.get(1)+1;
                        counter.set(1, newValue);
                        break;
                    case Util.Nucleotides.T:
                        newValue = counter.get(2)+1;
                        counter.set(2, newValue);
                        break;
                    case Util.Nucleotides.G:
                        newValue = counter.get(3)+1;
                        counter.set(3, newValue);
                        break;
                    case Util.GAP:
                        newValue = counter.get(4)+1;
                        counter.set(4, newValue);
                                break;
                }
        newHashMap.put(start, counter);
    }
}
