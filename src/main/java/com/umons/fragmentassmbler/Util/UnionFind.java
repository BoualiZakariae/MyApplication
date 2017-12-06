/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umons.fragmentassmbler.Util;

/**
 *
 * @author bouali
 */
public class UnionFind {
    
    private MyUniqueSet myUniqueSet;
    private int[] in;
    private int[] out;

    public UnionFind() {
    }

    public UnionFind(MyUniqueSet myUniqueSet) {
        this.myUniqueSet = myUniqueSet;
    }

    public UnionFind(int mySetSize,int fragmentSize) {
        this.myUniqueSet = new MyUniqueSet(mySetSize);
        initialisation(fragmentSize);
    }
    
    
    
        /* * size of the listOfFragments   -*-**-*/

    void initialisation(int size) {
        in = new int[size];
        out = new int[size];
        for (int i = 0; i < in.length; i++) {
            in[i] = -1;
            out[i] = -1;
        }

    }
       
    /**
     *
     */
    private void showTheTwoArrays() {
        for (int i = 0; i < in.length; i++) {
            System.out.print(in[i] + " ");
        }
        System.out.println("");
        for (int i = 0; i < out.length; i++) {
            System.out.print(out[i] + " ");
        }

    }

    public int[] getInArray() {
        return in;
    }

    public int[] getOutArray() {
        return out;
    }

    public MyUniqueSet getMyUniqueSet() {
        return myUniqueSet;
    }
    
    
    
}
