
import com.umons.fragmentassmbler.Alignement.Alignement;
import com.umons.fragmentassmbler.Util.Util;
import java.util.ArrayList;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bouali
 */
public class GapsPropagationJUnitTest {

    public GapsPropagationJUnitTest() {
    }

    //@Test
    public void TestOfDownGapsPropagation() {
        /***
         ***          ACTGACTG
         ***          AC_GACTG
         ***          AC_G_CT_G
         ***          AC_G_CT_G
         */
        Alignement alignement1 = new Alignement("ACTGACTG", "AC_GACTG");
        Alignement alignement2 = new Alignement("ACGACTG", "ACG_CT_G");
        Alignement alignement3 = new Alignement("ACGCTG", "ACGCTG");
        alignement1.setSOverT(true);alignement2.setSOverT(true);alignement3.setSOverT(true);
        ArrayList listOfAlignements = new ArrayList();
        listOfAlignements.add(alignement1);
        listOfAlignements.add(alignement2);
        listOfAlignements.add(alignement3);
    //    ArrayList<StringBuilder> listOfFragments =GapAdder.propagateGaps(listOfAlignements);
        System.out.println("Affichage list Of Fragments After Gap Propagation");
        //Util.print(listOfFragments);
    }
    //@Test
    public void SecondTestOfDownGapsPropagation() {
        /***
         ***          
         * 
         */
        Alignement alignement1 = new Alignement("ACTGACTG", "G_CTGACT");
        Alignement alignement2 = new Alignement("GCTGACT", "T_A_TACTG");
        Alignement alignement3 = new Alignement("TATACTG", "TGACTATA");
        alignement3.setSOverT(false);
        alignement1.setMargin(3);
        alignement2.setMargin(2);
        alignement3.setMargin(-4);
        ArrayList listOfAlignements = new ArrayList();
        listOfAlignements.add(alignement1);
        listOfAlignements.add(alignement2);
        listOfAlignements.add(alignement3);
     //   ArrayList<StringBuilder> listOfFragments =GapAdder.propagateGaps(listOfAlignements);
        System.out.println("Affichage list Of Fragments After Gap Propagation");
      //  Util.print(listOfFragments);
    }
     @Test
    public void ThirdTestOfDownAndUpGapsPropagation() {
        /***
         * ACTGA__CTG 
         *   T_A__C_G_AC
         *     A_A__G_A_AC
         *   ACTATA__GGA
         
         
         */
        Alignement alignement1 = new Alignement("ACTGACTG", "T_AC_GAC");
        Alignement alignement2 = new Alignement("TA_CGAC", "AA_GA_AC");
        Alignement alignement3 = new Alignement("A_AG_AAC", "ACTATAGGA");
        alignement3.setSOverT(false);
        alignement1.setMargin(2);
        alignement2.setMargin(1);
        alignement3.setMargin(-3);
        ArrayList listOfAlignements = new ArrayList();
        listOfAlignements.add(alignement1);
        listOfAlignements.add(alignement2);
        listOfAlignements.add(alignement3);
     //   ArrayList<StringBuilder> listOfFragments =GapAdder.propagateGaps(listOfAlignements);
        System.out.println("Affichage list Of Fragments After Gap Propagation");
       // Util.print(listOfFragments);
    }
}
