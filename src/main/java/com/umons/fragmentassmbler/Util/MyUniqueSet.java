/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umons.fragmentassmbler.Util;

/**
 *
 * @author zakariae
 */
public class MyUniqueSet {

    private int[] id;

    /**
     *
     */
    public MyUniqueSet() {

    }

    /**
     * Set Creation
     *
     * @param size size of the Set
     */
    public MyUniqueSet(int size) {
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    /**
     *
     * @param a
     * @param b
     * @return true if the two element belong to the same Set
     */
    public boolean find(int a, int b) {
        return id[a] == id[b];
    }

    /**
     * moving the two elements to the Same Set
     *
     * @param a
     * @param b
     */
    public void unify(int a, int b) {
        int c = id[a];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == c) {
                id[i] = id[b];
            }
        }
    }
}
