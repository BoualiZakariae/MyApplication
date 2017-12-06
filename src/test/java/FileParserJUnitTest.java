/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.umons.fragmentassmbler.FastaFileParser.FileParser;
import com.umons.fragmentassmbler.FragmentAssembler.Fragment;
import java.io.File;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * 
 * @Before Executed before each test. It is used to prepare the test environment
 * (e.g., read input data, initialize the class).
 *
 *
 * @After Executed after each test. It is used to cleanup the test environment
 * (e.g., delete temporary data, restore defaults). It can also save memory by
 * cleaning up expensive memory structures.
 *
 *
 * @BeforeClass Executed once, before the start of all tests. It is used to
 * perform time intensive activities, for example, to connect to a database.
 * Methods marked with this annotation need to be defined as static to work with
 * JUnit.
 *
 *
 * @AfterClass Executed once, after all tests have been finished. It is used to
 * perform clean-up activities, for example, to disconnect from a database.
 * Methods annotated with this annotation need to be defined as static to work
 * with JUnit.
 *
 *
 * @Ignore or @Ignore("Why disabled") Marks that the test should be disabled.
 * This is useful when the underlying code has been changed and the test case
 * has not yet been adapted. Or if the execution time of this test is too long
 * to be included. It is best practice to provide the optional description, why
 * the test is disabled.
 *
 *
 * @Test (expected = Exception.class) Fails if the method does not throw the
 * named exception.
 *
 *
 * @Test(timeout=100) Fails if the method takes longer than 100 milliseconds.
 */
public class FileParserJUnitTest {

    static FileParser fp;
    static File file;
    static ArrayList<Fragment> listOfFragments;

    public FileParserJUnitTest() {
    }

    /*
    the file Containes 5 Fragments 
    Fragment 1 = 7 lines 7*8 56 nuclotitide
    Fragment 2 = 6 lines 6*8 48 nuclotitide
    Fragment 3 = 7 lines 7*8 56 nuclotitide
    Fragment 4 = 7 lines 7*8 56 nuclotitide
    Fragment 5 = 6 lines 6*8 48 nuclotitide
     */
    @BeforeClass
    public static void setUpClass() {
        fp = new FileParser();
        file = new File("C:\\Users\\bouali\\Desktop\\One.FASTA");
        fp.parseFile(file);
        listOfFragments = fp.getListOfFragment();
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

    @Test
    public void parseFile() {

        assertEquals("the size of the FragmentList is  not Equivalent to the number"
                + "Of Fragment in the File ", listOfFragments.size(), 5);
        int i = 0;
        for (Fragment fragment : listOfFragments) {
            assertEquals(fragment.getId(), i++);
        }

    }

    @Test
    public void fragmentLength() {
        assertEquals(listOfFragments.get(0).getSequence().length(), 80);
        assertEquals(listOfFragments.get(1).getSequence().length(), 80);
        assertEquals(listOfFragments.get(2).getSequence().length(), 80);
        assertEquals(listOfFragments.get(3).getSequence().length(), 80);
        assertEquals(listOfFragments.get(4).getSequence().length(), 80);

    }

    @Test
    public void fragmentComparison() {
        assertEquals(listOfFragments.get(4).getSequence().toString(), "gtcctgcccaaggactacgc"
                + "cccgggggctaacc"
                + "gctggctgggacaacggcctgcc"
                + "ggtgcgggtgacgggcgcctacc");

    }

    @Test
    public void ShowFragments() {
        System.out.println("ShowFragment");
        for (Fragment fragment : listOfFragments) {
            System.out.println(fragment.toString());
        }
    }

}
