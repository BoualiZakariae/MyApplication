package com.umons.fragmentassmbler.FragmentAssembler;

/**
 *
 * @author zakariae
 */
public class Fragment {
    private int Id;/*Frgament Identifier*/
   /// private StringBuilder sequence = new StringBuilder();
       private StringBuilder sequence ;

    /**
     *
     */
    public Fragment() {
    }

    /**
     *
     * @param seq
     * @param Id
     */
    public Fragment(StringBuilder seq, int Id) {
        this.sequence = seq;
        this.Id = Id;
    }

    /**
     *
     * @param seq
     */
    public Fragment(StringBuilder seq) {
        this.sequence = seq;

    }

    public Fragment(String seq) {
        this(new StringBuilder(seq));
        
    }
    
    

    /**
     *
     * @param f
     */
    public Fragment(Fragment f) {
        this(new StringBuilder(f.getSequence()));
        this.Id = f.getId();
    }

    /**
     *
     * @return
     */
    public StringBuilder getSequence() {
        return sequence;
    }

    /**
     *
     * @param sequence
     */
    public void setSequence(StringBuilder sequence) {
        this.sequence = sequence;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return this.sequence.toString();
    }

    /**
     *
     * @return
     */
    public int getId() {
        return Id;
    }

    /**
     *
     * @param Id
     */
    public void setId(int Id) {
        this.Id = Id;
    }
    
    

}
