package com.umons.fragmentassmbler.FragmentAssembler;

import com.umons.fragmentassmbler.Alignement.Alignement;

/**
 *
 * @author zakariae This Class represent an Edge
 */
public class Edge implements Comparable<Edge> {

    private Fragment source;
    private Fragment destination;
    private Alignement alignement = new Alignement();

    /**
     *
     */
    public Edge() {
        this.alignement = new Alignement();
    }

    /**
     * @param source that indicate the S Sequence
     * @param destination that indicate the T Sequence
     */
    public Edge(Fragment source, Fragment destination) {
        this();
        this.source = source;
        this.destination = destination;
    }

    /**
     *
     * @param source
     * @param destination
     * @param weight
     */
    public Edge(Fragment source, Fragment destination, int weight) {
        this();
        this.source = new Fragment(source);
        this.destination = new Fragment(destination);
        this.alignement.setWeight(weight);

    }

    /**
     *
     * @return
     */
    public Fragment getSource() {
        return source;
    }

    /**
     *
     * @param destination
     */
    public void setDestination(Fragment destination) {
        this.destination = destination;
    }

    /**
     *
     * @return
     */
    public Fragment getDestination() {
        return destination;
    }

    /**
     *
     * @param source
     */
    public void setSource(Fragment source) {
        this.source = source;
    }

    /**
     *
     * @return
     */
    public Alignement getAlignement() {
        return alignement;
    }

    public void setAlignement(Alignement alignement) {
        this.alignement = alignement;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Src: " + getSource() + "\nDst: " + getDestination() + "\n";
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Edge o) {
        return o.getAlignement().getWeight() - this.getAlignement().getWeight();
    }

}
