/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.umons.fragmentassmbler.Alignement.Alignement;
import com.umons.fragmentassmbler.Alignement.MyAligner;
import com.umons.fragmentassmbler.Alignement.AlignementMatrix;
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
public class AlignementMatrixTest {
    
    public AlignementMatrixTest() {
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
     * Test of getValues method, of class AlignementMatrix.
     */
    @Test
    public void firstTest() {
        System.out.println("getValues");
        
        AlignementMatrix alignementMatrix ;
        alignementMatrix = new AlignementMatrix("TGA", "ACTGAC");
       alignementMatrix.fill();
        com.umons.fragmentassmbler.Util.Util.showMatrice(alignementMatrix.getValues());
        com.umons.fragmentassmbler.Util.Util.showMatrice(alignementMatrix.getSOverT());
        
        MyAligner a = MyAligner.getInstance();
        
        
        Alignement alignement = new Alignement("TGA", "ACTGAC");
        a.setAlignementMatrix(alignementMatrix);
        a.setAlignement(alignement);
        alignementMatrix.calculateMaximumScore();
       alignement.setWeight(alignementMatrix.getMaximumScore());
        if (alignementMatrix.isMaxInLastRow()==true) {//has been modified
            alignement = a.backTrackFromTheLastRow();
        } else {
            alignement = a.backTrackFromTheLastColumn();
        }
        System.out.println(alignement);
        System.out.println("Margin "+alignement.getMargin());
        System.out.println("weight "+alignement.getWeight());
        System.out.println("Maximum Score "+alignementMatrix.getMaximumScore());
        System.out.println("Index Of Maximum Score "+alignementMatrix.getIndexOfTheMaximumScore());
        
    }

    /**
     * Test of setValues method, of class AlignementMatrix.
     */
    @Test@Ignore
    public void testSetValues() {
        System.out.println("setValues");
        int[][] values = null;
        AlignementMatrix instance = new AlignementMatrix();
        instance.setValues(values);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxInLastRow method, of class AlignementMatrix.
     */
    @Test@Ignore
    public void testSetMaxInLastRow() {
        System.out.println("setMaxInLastRow");
        boolean maxInLastRow = false;
        AlignementMatrix instance = new AlignementMatrix();
        instance.setMaxInLastRow(maxInLastRow);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fill method, of class AlignementMatrix.
     */
    @Test@Ignore
    public void testFill() {
        System.out.println("fill");
        AlignementMatrix instance = new AlignementMatrix();
        instance.fill();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIndexOfTheLastColumn method, of class AlignementMatrix.
     */
    @Test@Ignore
    public void testGetIndexOfTheLastColumn() {
        System.out.println("getIndexOfTheLastColumn");
        AlignementMatrix instance = new AlignementMatrix();
        int expResult = 0;
        int result = instance.getIndexOfTheLastColumn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIndexOfTheLastRow method, of class AlignementMatrix.
     */
    @Test@Ignore
    public void testGetIndexOfTheLastRow() {
        System.out.println("getIndexOfTheLastRow");
        AlignementMatrix instance = new AlignementMatrix();
        int expResult = 0;
        int result = instance.getIndexOfTheLastRow();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of theMaxIsIntheLastRow method, of class AlignementMatrix.
     */
    @Test@Ignore
    public void testTheMaxIsIntheLastRow() {
        System.out.println("theMaxIsIntheLastRow");
        AlignementMatrix instance = new AlignementMatrix();
        boolean expResult = false;
        boolean result = instance.theMaxIsIntheLastRow();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateMaximumScore method, of class AlignementMatrix.
     */
    @Test@Ignore
    public void testGetMaxValue() {
        System.out.println("getMaxValue");
        AlignementMatrix instance = new AlignementMatrix();
        int expResult = 0;
      //  int result = instance.calculateMaximumScore();
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isMaxInLastRow method, of class AlignementMatrix.
     */
    @Test@Ignore
    public void testIsMaxInLastRow() {
        System.out.println("isMaxInLastRow");
        AlignementMatrix instance = new AlignementMatrix();
        boolean expResult = false;
        boolean result = instance.isMaxInLastRow();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
