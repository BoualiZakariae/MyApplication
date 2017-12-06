/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.umons.fragmentassmbler.Alignement.Aligner;
import com.umons.fragmentassmbler.Alignement.MyAligner;
import com.umons.fragmentassmbler.FragmentAssembler.Edge;
import com.umons.fragmentassmbler.FragmentAssembler.Fragment;
import com.umons.fragmentassmbler.Util.Util;
import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author bouali
 */
public class EdgeJUnitTest {
    // Aligner al = AlignerImpl.getInstance();

    public EdgeJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    /**
     *we align a list of edge
     *Src: ACGTACGTAGT
      *  Dst: ACGTAGTACCCGT
      *  The List Of Alignements
      *  Src: ACGTACGTAGT
      *  Dst:     ACGTAGTACCCGT
      *  With Margin 4
      *  Src: ACGTAGTACCCGT
      *  Dst:         CCCGTACGT
      *  With Margin 8
      *  Src:      CCCGTACGT
      *  Dst: TAGTACCC
      *  With Margin -5
      *  Src: ACGTAGTACCCGT
      *  Dst: CCCGTACGT
         */
    @Test
    public void TestOfAllFragmentsAlignement() {
        Aligner al = MyAligner.getInstance();
        ArrayList listOfEdges = new ArrayList();
        ArrayList listOfAlignements = new ArrayList();
        Fragment f1 = new Fragment("ACGTACGTAGT");
        Fragment f2 = new Fragment("ACGTAGTACCCGT");
        Edge edge = new Edge(f1, f2);
        System.out.println(edge.toString());
        Fragment f3 = new Fragment("ACGTAGTACCCGT");
        Fragment f4 = new Fragment("CCCGTACGT");
        Edge edge2 = new Edge(f3, f4);
        Fragment f5 = new Fragment("CCCGTACGT");
        Fragment f6 = new Fragment("TAGTACCC");
        Edge edge3 = new Edge(f5, f6);
        
        
        listOfEdges.add(edge);
        listOfEdges.add(edge2);
        listOfEdges.add(edge3);
        
       // listOfAlignements = al.getAlignements(listOfEdges);
        Util.print(listOfAlignements);    
        //al.align(edge2);
        System.out.println(edge2.toString());
    }
    /*
    @Test
    public void TestOfAlignementOfTwoFragments() {
        Aligner al = MyAligner.getInstance();

        Fragment f1 = new Fragment("CAGCACTTGGATTCTCGG");
        Fragment f2 = new Fragment("CAGCGTGG");
        Edge edge = new Edge(f1, f2);
        al.align(edge);
        //edge.alignThe2Fragments(al);
        System.out.println(edge.toString());

        Fragment f3 = new Fragment("acgtacgtacgt");
        Fragment f4 = new Fragment("atatataacgta");
        Edge edge2 = new Edge(f3, f4);
        al.align(edge2);
        //edge2.alignThe2Fragments(al);
        System.out.println(edge2.toString());
    }
    
    @Test
    public void TestOfGapsPropagation() {
        Fragment f1 = new Fragment("actgac");
        Fragment f2 = new Fragment("ctgcaca");
        Edge edge = new Edge(f1, f2);
        al.align(edge);
        System.out.println(edge.toString());
        System.err.println();

        Fragment f3 = new Fragment("ctgcaca");
        Fragment f4 = new Fragment("actgac");
        Edge edge2 = new Edge(f3, f4);
        al.align(edge2);
        System.out.println(edge2.toString());
    }

    @Test
    public void TestOfMatrixConstruction() {
        System.out.println("Matric Construction");
        Fragment f1 = new Fragment("actgac");
        Fragment f2 = new Fragment("gacat");
        Edge edge = new Edge(f1, f2);

        System.out.println(edge.toString());
        Util.showMatrice(al.getAlignementMatrix(edge.getSource().toString(),
                edge.getDestination().toString()).getValues());
        al.align(edge);
        System.out.println();

    }

    
    @Test
    public void TestOfAlignementCoinstruction() {
        Aligner nvAligner = MyAligner.getInstance();
        Fragment f1 = new Fragment("actgac");
        Fragment f2 = new Fragment("gacat");
        Edge edge = new Edge(f1, f2);
        System.out.println(edge.toString());
        System.out.println("Affichage Matrice");
        Util.showMatrice(nvAligner.getAlignementMatrix(edge.getSource().toString(),
                edge.getDestination().toString()).getValues());
        System.out.println("Construction Alignement");
        Alignement alignement = nvAligner.makeAlignement(edge);
        System.out.println("Affichage Alignement");
        System.out.println(alignement);

        /////////////////////////////////////   
        f2 = new Fragment("actgac");
        f1 = new Fragment("gacat");
        edge = new Edge(f1, f2);
        System.out.println("Affichage Matrice");
        Util.showMatrice(nvAligner.getAlignementMatrix(edge.getSource().toString(),
                edge.getDestination().toString()).getValues());
        System.out.println("Construction Alignement");
        alignement = nvAligner.makeAlignement(edge);
        System.out.println("Affichage Alignement");
        System.out.println(alignement);
        //////////////////////////////
        f1 = new Fragment("CAGCACTTGGATTCTCGG");
        f2 = new Fragment("CAGCGTGG");
        edge = new Edge(f1, f2);
        System.out.println("Affichage Matrice");
        Util.showMatrice(nvAligner.getAlignementMatrix(edge.getSource().toString(),
                edge.getDestination().toString()).getValues());
        System.out.println("Construction Alignement");
        alignement = nvAligner.makeAlignement(edge);
        System.out.println("Affichage Alignement");
        System.out.println(alignement);
        ////////////////////////////////
        Fragment f3 = new Fragment("acgtacgtacgt");
        Fragment f4 = new Fragment("atatataacgta");
        Edge edge2 = new Edge(f3, f4);
        System.out.println("Affichage Matrice");
        Util.showMatrice(nvAligner.getAlignementMatrix(edge.getSource().toString(),
                edge.getDestination().toString()).getValues());
        System.out.println("Construction Alignement");
        alignement = nvAligner.makeAlignement(edge2);
        System.out.println("Affichage Alignement");
        System.out.println(alignement);*/
}
