/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.umons.fragmentassmbler.Util.Util;
import com.umons.fragmentassmbler.Alignement.Alignement;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author bouali
 */
public class GapAdderTest {

    public GapAdderTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

   

    /**
     * Test of propagateGaps method, of class GapAdder.
     */
    //@Test
    public void testPropagateGaps() {
        System.out.println("propagateGaps");
       // ArrayList<Alignement> listOfAlignements = new ArrayList();
        
        Alignement alignement1 = new Alignement("ACTGACTG", "T_AC_GAC");
        Alignement alignement2 = new Alignement("TA_CGAC", "AA_GA_AC");
        Alignement alignement3 = new Alignement("A_AG_AAC", "ACTATAGGA");
        alignement3.setSOverT(false);
        alignement1.setMargin(2);
        alignement2.setMargin(1);
        alignement3.setMargin(-3);
        
        System.out.println(alignement1);
        System.out.println(alignement2);
        System.out.println(alignement3);
        
       //GapAdder.addGap(GapAdder.getGapsPostion(alignement1.getT(), alignement2, Util.DOWN),
       //         alignement2, Util.DOWN);
        System.out.println("Alignement 2 After Gap Propagation ");
        System.out.println(alignement2);
        
     //   GapAdder.addGap(GapAdder.getGapsPostion(alignement2.getT(), alignement3, Util.DOWN),
      //          alignement3, Util.DOWN);
        System.out.println("Alignement 3 After Gap Propagation ");
        System.out.println(alignement3);
     /*   
        GapAdder.addGap( GapAdder.getGapsPostion(alignement3.getS(), alignement2, Util.UP),
                alignement2, Util.UP);
        System.out.println("Alignement 2 After Up Gap Propagation ");
        System.out.println(alignement2);
        
        GapAdder.addGap( GapAdder.getGapsPostion(alignement2.getS(), alignement1, Util.UP),
                alignement1, Util.UP);
        System.out.println("Alignement 1 After Gap Propagation ");
        System.out.println(alignement1);
        */
        
       // System.out.println(alignement1);
       // System.out.println(alignement2);
      //  System.out.println(alignement3);
        
        /***
         * ACTGA__CTG 
         *   T_A__C_G_AC
         *     A_A__G_A_AC
         *   ACTATA__GGA
         
         expResult
         */
        ArrayList<StringBuilder> expResult;
        expResult = new ArrayList(Arrays.asList("ACTGA__CTG",
                                                  "T_A__C_G_AC",
                                                    "A_A__G_A_AC",
                                                  "ACTATA__GGA"));
        
        
        
        //ArrayList<StringBuilder> result = GapAdder.propagateGaps(listOfAlignements);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
        
        
        //ArrayList<StringBuilder> listOfFragments =GapAdder.propagateGaps(listOfAlignements);
       // System.out.println("Affichage list Of Fragments After Gap Propagation");
        //Util.print(listOfFragments);
    }

    /**
     * Test of addGap method, of class GapAdder.
     */
    /**
     * Test of ReturnTheListOfFragments method, of class GapAdder.
     */
    //@Test@Ignore
    public void testReturnTheListOfFragments() {
        System.out.println("ReturnTheListOfFragments");
        ArrayList<Alignement> listOfAlignements = null;
        ArrayList<StringBuilder> expResult = null;
      //  ArrayList<StringBuilder> result = GapAdder.ReturnTheListOfFragments(listOfAlignements);
     //   assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGapsPostion method, of class GapAdder.
     */
    @Test
    @Ignore
    public void FirsttestGetGapsPostion() {
        System.out.println("getGapsPostion");
        StringBuilder seq1 = new StringBuilder("T_AC_GAC");
        Alignement alignement = new Alignement("TA_CGAC", "AA_GA_AC");
        ArrayList<Integer> expResult = new ArrayList<>(2);
        expResult.add(1);
        expResult.add(4);
       // ArrayList<Integer> result = GapAdder.getGapsPostion(seq1, alignement, Util.DOWN);
        System.out.println("La liste Des Positions de Gaps");
       // Util.print(result);
       // assertEquals(expResult, result);

    }

    @Test
    @Ignore
    public void SecondtestGetGapsPostion() {
        StringBuilder seq1 = new StringBuilder("TA_CGAC");
        Alignement alignement = new Alignement("ACTGACTG", "T_AC_GAC");
        ArrayList<Integer> expResult = new ArrayList<>(1);
        expResult.add(2);
     //   ArrayList<Integer> result = GapAdder.getGapsPostion(seq1, alignement, Util.UP);
        System.out.println("La liste Des Positions de Gaps");
    //    Util.print(result);
    //    assertEquals(expResult, result);

    }
    // @Test to review

    public void ThirdtestGetGapsPostion() {
        StringBuilder seq1 = new StringBuilder("T_A_C_GAC");
        Alignement alignement = new Alignement("ACTGACTG", "T_AC_GAC");
        ArrayList<Integer> expResult = new ArrayList<>(1);
        expResult.add(3);
     //   ArrayList<Integer> result = GapAdder.getGapsPostion(seq1, alignement, Util.UP);
        System.out.println("La liste Des Positions de Gaps");
    //    Util.print(result);
    //    assertEquals(expResult, result);

    }

    @Test
    @Ignore
    public void testAddGap() {
        System.out.println("addGap");
        System.out.println("First Test");
        Integer[] positions = new Integer[]{2};
        ArrayList<Integer> listOfPosition;
        listOfPosition = new ArrayList<>(Arrays.asList(positions));

        Alignement alignement = new Alignement("ACTGACTG", "T_AC_GAC");
        alignement.setMargin(2);
        alignement.setSOverT(true);
        int orient = Util.Orientation.UP;
        Alignement expResult = new Alignement("ACTG_ACTG", "T__AC_GAC");
        expResult.setMargin(2);
        expResult.setSOverT(true);
     //   Alignement result = GapAdder.addGap(listOfPosition, alignement, orient);
      //  System.out.println(result.getS());
        System.out.println(expResult.getS());
     //   System.out.println(result.getT());
        System.out.println(expResult.getT());
      //  assertEquals(expResult, result);

    }

    @Test
    @Ignore
    public void secondTestAddGap() {
        System.out.println("Second Test");
        Integer[] positions = new Integer[]{6};
        ArrayList<Integer> listOfPosition;
        listOfPosition = new ArrayList<>(Arrays.asList(positions));

        Alignement alignement = new Alignement("ACTGACTG", "GACTGACT");
        alignement.setMargin(3);
        alignement.setSOverT(true);
        int orient = Util.Orientation.UP;
        Alignement expResult = new Alignement("ACTGACTG", "GACTGA_CT");
        expResult.setMargin(3);
        expResult.setSOverT(true);
       // Alignement result = GapAdder.addGap(listOfPosition, alignement, orient);
       // System.out.println(result.getS());
        System.out.println(expResult.getS());
      //  System.out.println(result.getT());
        System.out.println(expResult.getT());
      //  assertEquals(expResult, result);

    }

    @Test
    @Ignore
    public void thirdTestAddGap() {
        System.out.println("Second Test");
        Integer[] positions = new Integer[]{1};
        ArrayList<Integer> listOfPosition;
        listOfPosition = new ArrayList<>(Arrays.asList(positions));

        Alignement alignement = new Alignement("GACTGACT", "ACTGACTG");
        alignement.setMargin(-3);
        alignement.setSOverT(false);
        int orient = Util.Orientation.UP;
        Alignement expResult = new Alignement("GACTGACT", "A_CTGACTG");
        expResult.setMargin(-4);
        expResult.setSOverT(false);
     //   Alignement result = GapAdder.addGap(listOfPosition, alignement, orient);
      //  System.out.println(result.getS());
      //  System.out.println(expResult.getS());
       // System.out.println(result.getT());
      //  System.out.println(expResult.getT());
      //  assertEquals(expResult, result);

    }

    @Ignore
    @Test
    public void fourthTestAddGap() {
        System.out.println("Second Test");
        Integer[] positions = new Integer[]{5};
        ArrayList<Integer> listOfPosition;
        listOfPosition = new ArrayList<>(Arrays.asList(positions));

        Alignement alignement = new Alignement("GACTGACT", "ACTGACTG");
        alignement.setMargin(-3);
        alignement.setSOverT(false);
        int orient = Util.Orientation.UP;
        Alignement expResult = new Alignement("GA_CTGACT", "ACTGA_CTG");
        expResult.setMargin(-3);
        expResult.setSOverT(false);
      //  Alignement result = GapAdder.addGap(listOfPosition, alignement, orient);
       // System.out.println(result.getS());
        System.out.println(expResult.getS());
      //  System.out.println(result.getT());
        System.out.println(expResult.getT());
      //  assertEquals(expResult, result);

    }

    @Ignore
    @Test
    public void fifththTestAddGap() {
        Integer[] positions = new Integer[]{6};
        ArrayList<Integer> listOfPosition;
        listOfPosition = new ArrayList<>(Arrays.asList(positions));

        Alignement alignement = new Alignement("GAC", "ACTGACTG");
        alignement.setMargin(-3);
        alignement.setSOverT(false);
        int orient = Util.Orientation.UP;
        Alignement expResult = new Alignement("GAC", "ACTGAC_TG");
        expResult.setMargin(-3);
        expResult.setSOverT(false);
       // Alignement result = GapAdder.addGap(listOfPosition, alignement, orient);
       // System.out.println(result.getS());
        System.out.println(expResult.getS());
       // System.out.println(result.getT());
        System.out.println(expResult.getT());
       // assertEquals(expResult, result);

    }

    @Test@Ignore
    public void sixthtestAddGap() {
        /**
         * Down
         */
        System.out.println("Hello");
        Integer[] positions = new Integer[]{3};
        ArrayList<Integer> listOfPosition;
        listOfPosition = new ArrayList<>(Arrays.asList(positions));

        Alignement alignement = new Alignement("GACTGACT", "TGACTGA");
        alignement.setMargin(3);
        alignement.setSOverT(true);
        int orient = Util.Orientation.UP;
        Alignement expResult = new Alignement("GAC_TGACT", "TGACTGA");
        expResult.setMargin(4);
        expResult.setSOverT(true);
       // Alignement result = GapAdder.addGap(listOfPosition, alignement, orient);
      //  System.out.println(result.getS());
        System.out.println(expResult.getS());
      //  System.out.println(result.getT());
        System.out.println(expResult.getT());
       // assertEquals(expResult, result);

    }

    @Test@Ignore
    public void seventhTestAddGap() {
        /**
         * Down
         */
        System.out.println("Hello");
        Integer[] positions = new Integer[]{5};
        ArrayList<Integer> listOfPosition;
        listOfPosition = new ArrayList<>(Arrays.asList(positions));

        Alignement alignement = new Alignement("GACTGACT", "TGACTGA");
        alignement.setMargin(3);
        alignement.setSOverT(true);
        int orient = Util.Orientation.UP;
        Alignement expResult = new Alignement("GACTG_ACT", "TG_ACTGA");
        expResult.setMargin(3);
        expResult.setSOverT(true);
      //  Alignement result = GapAdder.addGap(listOfPosition, alignement, orient);
      //  System.out.println(result.getS());
        System.out.println(expResult.getS());
      //  System.out.println(result.getT());
        System.out.println(expResult.getT());
      //  assertEquals(expResult, result);

    }
@Test
    public void testRecalculateStartOfFragments() {
        System.out.println("recalculateStartOfFragments");
        ArrayList<Alignement> listOfAlignements = new ArrayList();
       
        Alignement alignement1 = new Alignement("ACTGACTG", "T_AC_GAC");
        Alignement alignement2 = new Alignement("TA_CGAC", "AA_GA_AC");
        Alignement alignement3 = new Alignement("A_AG_AAC", "ACTATAGGA");
        alignement3.setSOverT(false);
        alignement1.setMargin(2);alignement1.setStartPositionOfS(0);alignement1.setStartPositionOfT(2);
        alignement2.setMargin(1);alignement2.setStartPositionOfS(0);alignement2.setStartPositionOfT(1);
        alignement3.setMargin(-3);alignement3.setStartPositionOfS(0);alignement3.setStartPositionOfT(-3);
        
        
        
        listOfAlignements.add(alignement1);
        listOfAlignements.add(alignement2);
        listOfAlignements.add(alignement3);
       
      //  GapAdderImpl.recalculateStartOfFragments(listOfAlignements);
        System.out.println(alignement1.getStartPositionOfS());
        System.out.println(alignement1.getStartPositionOfT());
        
        System.out.println(alignement2.getStartPositionOfS());
        System.out.println(alignement2.getStartPositionOfT());
        
        System.out.println(alignement3.getStartPositionOfS());
        System.out.println(alignement3.getStartPositionOfT());
       
    }
    
}
