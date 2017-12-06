/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.umons.fragmentassmbler.Util.Util;
import com.umons.fragmentassmbler.Util.GapAdderImpl;
import com.umons.fragmentassmbler.Alignement.Alignement;
import java.util.ArrayList;
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
public class GapAdderImplTest {
    
    public GapAdderImplTest() {
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
     * Test of propagateGaps method, of class GapAdderImpl.
     */
    @Test@Ignore
    public void testPropagateGaps() {
        System.out.println("propagateGaps");
        ArrayList<Alignement> listOfAlignements = null;
        ArrayList<Alignement> expResult = null;
        ArrayList<Alignement> result = GapAdderImpl.propagateGaps(listOfAlignements);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    
    @Test
    public void thirdTestOfDownGapPropagation() {
        System.out.println("downGapPropagation");
        Alignement alignement1 = new Alignement("ACTGACTG", "TGACTGAC");
        Alignement alignement2 = new Alignement("TG___ACTGA_C", "GAAAACTGAACAC");
        Alignement alignement3 = new Alignement("GAAA_AC_T_G_AA_C_AC", "AACCTTGGAAACCACAC");
        alignement1.setMargin(2);
        alignement2.setMargin(1);
        alignement3.setMargin(4);
        
       
        alignement1.setStartPositionOfS(0);
        alignement1.setStartPositionOfT(2);
        
        alignement2.setStartPositionOfS(0);
        alignement2.setStartPositionOfT(1);
        
        alignement3.setStartPositionOfS(0);
        alignement3.setStartPositionOfT(4);
        
        
        ArrayList listOfAlignements = new ArrayList();
        listOfAlignements.add(alignement1);
        listOfAlignements.add(alignement2);
        listOfAlignements.add(alignement3);
        
        Util.recalculateStartOfFragments(listOfAlignements);
        Util.printStartPosition(listOfAlignements);
        GapAdderImpl.propagateGaps(listOfAlignements);

        
        Alignement expectedalignement1 = new Alignement("ACTG____AC_T_G", "TG____AC_T_G_A__C");
        Alignement expectedalignement2 = new Alignement("TG____AC_T_G_A__C", "GAAA_AC_T_G_AA_C_AC");
        Alignement expectedalignement3 = new Alignement("GAAA_AC_T_G_AA_C_AC", "AACCTTGGAAACCACAC");
        expectedalignement1.setMargin(2);
        expectedalignement2.setMargin(1);
        expectedalignement3.setMargin(4);
        
        ArrayList listOfExpectedAlignement = new ArrayList();
        listOfExpectedAlignement.add(expectedalignement1);
        listOfExpectedAlignement.add(expectedalignement2);
        listOfExpectedAlignement.add(expectedalignement3);
      
        //Util.recalculateStartOfFragments(listOfExpectedAlignement);
         assertEquals(expectedalignement3,alignement3);
         assertEquals(expectedalignement2,alignement2);
         assertEquals(expectedalignement1,alignement1);
        assertEquals(listOfExpectedAlignement,listOfAlignements);
    }

    
    
    
    
    
     @Test@Ignore
    public void secondTestOfDownGapPropagation() {
        System.out.println("downGapPropagation");
        Alignement alignement1 = new Alignement("ACTGACTG", "G_CTGACT");
        Alignement alignement2 = new Alignement("GCTG_ACT", "T__A_TACTG");
        Alignement alignement3 = new Alignement("TATA_CTG", "ACTGCTATACC");
        alignement1.setMargin(3);
        alignement2.setMargin(2);
        alignement3.setMargin(-5);
        alignement3.setSOverT(false);
       
        alignement1.setStartPositionOfS(0);
        alignement1.setStartPositionOfT(3);
        
        alignement2.setStartPositionOfS(0);
        alignement2.setStartPositionOfT(2);
        
        alignement3.setStartPositionOfS(0);
        alignement3.setStartPositionOfT(-5);
        
        
        ArrayList listOfAlignements = new ArrayList();
        listOfAlignements.add(alignement1);
        listOfAlignements.add(alignement2);
        listOfAlignements.add(alignement3);
        
        Util.recalculateStartOfFragments(listOfAlignements);
        Util.printStartPosition(listOfAlignements);
        GapAdderImpl.propagateGaps(listOfAlignements);

        
        Alignement expectedalignement1 = new Alignement("ACTGACTG", "G_CTG_ACT");
        Alignement expectedalignement2 = new Alignement("G_CTG_ACT", "T__A_TA_CTG");
        Alignement expectedalignement3 = new Alignement("T__A_TA_CTG", "ACTG_CT__A_TACC");
        expectedalignement1.setMargin(3);
        expectedalignement2.setMargin(3);
        expectedalignement3.setMargin(-6);
        expectedalignement3.setSOverT(false);
        
        ArrayList listOfExpectedAlignement = new ArrayList();
        listOfExpectedAlignement.add(expectedalignement1);
        listOfExpectedAlignement.add(expectedalignement2);
        listOfExpectedAlignement.add(expectedalignement3);
      
        //Util.recalculateStartOfFragments(listOfExpectedAlignement);
         assertEquals(expectedalignement3,alignement3);
         assertEquals(expectedalignement2,alignement2);
         assertEquals(expectedalignement1,alignement1);
        assertEquals(listOfExpectedAlignement,listOfAlignements);
    }

    
    
    
    
    
    
    /**
     * Test of downGapPropagation method, of class GapAdderImpl.
     */
    @Test@Ignore
    public void testDownGapPropagation() {
        System.out.println("downGapPropagation");
        Alignement alignement1 = new Alignement("ACTGACTG", "G_CTGACT");
        Alignement alignement2 = new Alignement("GCTGACT", "T_A_TACTG");
        Alignement alignement3 = new Alignement("TATACTG", "ACTGCTATA");
        alignement1.setMargin(3);
        alignement2.setMargin(2);
        alignement3.setMargin(-5);
        alignement3.setSOverT(false);
       
        alignement1.setStartPositionOfS(0);
        alignement1.setStartPositionOfT(3);
        
        alignement2.setStartPositionOfS(0);
        alignement2.setStartPositionOfT(2);
        
        alignement3.setStartPositionOfS(0);
        alignement3.setStartPositionOfT(-5);
        
        
        ArrayList listOfAlignements = new ArrayList();
        listOfAlignements.add(alignement1);
        listOfAlignements.add(alignement2);
        listOfAlignements.add(alignement3);
        
        Util.recalculateStartOfFragments(listOfAlignements);
       // Util.printStartPosition(listOfAlignements);
        
        Alignement expectedalignement1 = new Alignement("ACTGACTG", "G_CTGACT");
        Alignement expectedalignement2 = new Alignement("G_CTGACT", "T_A_TACTG");
        Alignement expectedalignement3 = new Alignement("T_A_TACTG", "ACTG_CT_A_TA");
        expectedalignement1.setMargin(3);
        expectedalignement2.setMargin(3);
        expectedalignement3.setMargin(-6);
        expectedalignement3.setSOverT(false);
        
        ArrayList listOfExpectedAlignement = new ArrayList();
        listOfExpectedAlignement.add(expectedalignement1);
        listOfExpectedAlignement.add(expectedalignement2);
        listOfExpectedAlignement.add(expectedalignement3);
      
        //Util.recalculateStartOfFragments(listOfExpectedAlignement);
         GapAdderImpl.propagateGaps(listOfAlignements);
       //  assertEquals(expectedalignement1,alignement1);
       //  assertEquals(expectedalignement2,alignement2);
        // System.out.println("alignement 3 "+expectedalignement3);
        // assertEquals(expectedalignement3,alignement3);
        assertEquals(listOfExpectedAlignement,listOfAlignements);
    }

    /**
     * Test of addGap method, of class GapAdderImpl.
     * S before T
     */
    @Test@Ignore
    public void testAddGap() {
        System.out.println("addGap");
        Alignement alignement = new Alignement("ACTGACTG", "T_ACTGAC");
        alignement.setMargin(2);
        alignement.setSOverT(true);
        alignement.setStartPositionOfS(0);
        alignement.setStartPositionOfT(2);
        
        int gapPosition = 8;//tested with many values -1 0 1 2 .....8 10
       
        Alignement expResult = new Alignement("ACTGACTG", "T_ACTG_AC");
        expResult.setMargin(2);
        expResult.setSOverT(true);
        expResult.setStartPositionOfS(0);
        expResult.setStartPositionOfT(2);
        
        Alignement result = GapAdderImpl.addGap(alignement, gapPosition);
        
        assertEquals(expResult, result);
        
        System.out.println("margin :"+alignement.getMargin());
        System.out.println("StartPositionOfS :"+alignement.getStartPositionOfS());
        System.out.println("StartPositionOfT :"+alignement.getStartPositionOfT());
        
        
    }
    
    /**
     * T Before S
     */
    @Test@Ignore
    public void secondTestAddGap() {
        System.out.println("addGap");
        Alignement alignement = new Alignement("T_ACTGAC","ACTGACTG");
        alignement.setMargin(-2);
        alignement.setSOverT(false);
        alignement.setStartPositionOfS(0);
        alignement.setStartPositionOfT(-2);
        
        int gapPosition = 70;//tested with many values -1 0 1 2 .....8 10
       
        Alignement expResult = new Alignement("T_ACTGAC","ACTGACTG");
        expResult.setMargin(-2);
        expResult.setSOverT(false);
        expResult.setStartPositionOfS(0);
        expResult.setStartPositionOfT(-2);
        
        Alignement result = GapAdderImpl.addGap(alignement, gapPosition);
        
        assertEquals(expResult, result);
        
        System.out.println("margin :"+alignement.getMargin());
        System.out.println("StartPositionOfS :"+alignement.getStartPositionOfS());
        System.out.println("StartPositionOfT :"+alignement.getStartPositionOfT());
        
        
    }
    /**
     * T included In S
     */
    @Test@Ignore
    public void thirdTestAddGap() {
        System.out.println("addGap");
        Alignement alignement = new Alignement("ACTGACTG", "GAC");
        alignement.setMargin(3);
        alignement.setSOverT(true);
        alignement.setStartPositionOfS(0);
        alignement.setStartPositionOfT(3);
        
        int gapPosition = 4;//tested with many values -1 0 1 2 .....8 10
       
        Alignement expResult = new Alignement("ACTG_ACTG", "G_AC");
        expResult.setMargin(3);
        expResult.setSOverT(true);
        expResult.setStartPositionOfS(0);
        expResult.setStartPositionOfT(3);
        
        Alignement result = GapAdderImpl.addGap(alignement, gapPosition);
        
        assertEquals(expResult, result);
        
        System.out.println("margin :"+alignement.getMargin());
        System.out.println("StartPositionOfS :"+alignement.getStartPositionOfS());
        System.out.println("StartPositionOfT :"+alignement.getStartPositionOfT());
        
        
    }
    
}
