package com.umons.fragmentassmbler.FragmentAssembler;

import com.umons.fragmentassmbler.Alignement.MyAligner;
import com.umons.fragmentassmbler.Alignement.Alignement;
import com.umons.fragmentassmbler.Util.UnionFind;
import com.umons.fragmentassmbler.Alignement.Aligner;
import com.umons.fragmentassmbler.FastaFileParser.FileParser;
import com.umons.fragmentassmbler.Util.GapAdderImpl;
import com.umons.fragmentassmbler.Util.Util;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The Main Class where the program Starts * @author zakariae
 */
public class FragmentAssembler {

    private final FileParser fileParser = new FileParser();
    private ArrayList<Fragment> listOfFragments = new ArrayList<>();
    private ArrayList<Edge> listOfEdges = new ArrayList<>();
    private StringBuilder TARGET;
    private UnionFind unionFind;
    //private final Aligner alig =    MyAligner.getInstance();
    //private  Aligner alig = new MyAligner();
    private HamiltonienGraph hamiltonienGraph;
    private ArrayList<Alignement> listOfAlignements = new ArrayList<>();
    private ArrayList<Alignement> listOfAlignementsAfterGapPropafgation = new ArrayList<>();

    /**
     * @param file
     * @param pathToSaveTarget
     */
    public void run(File file, String pathToSaveTarget) {
        readFastaFile(file);
        edgesConstruction();
        greedyAlgorithm();
        alignementStage();
        gapsPropagationStage();
        ConsensusStage();
        savingTarget(pathToSaveTarget);
    }

    private void edgesConstruction() {
        listOfEdges = Util.createEdges(listOfFragments);
        Collections.sort(listOfEdges);
    }

    private void greedyAlgorithm() {
        unionFind = new UnionFind(listOfEdges.size(), listOfFragments.size());
        hamiltonienGraph = new HamiltonienGraph(listOfEdges);
        hamiltonienGraph.greedyAlgorithm(unionFind);
        hamiltonienGraph.generateTheOrderedEges();
     
    }

    /*
    *
     */
    private void alignementStage() {
        System.out.println("Begining Alignement Stage");
        Aligner alig = new MyAligner();//added
        listOfAlignements = alig.paireWiseAlignements(hamiltonienGraph.getHamiltonienpath());
        Util.recalculateStartOfFragments(listOfAlignements);
        System.out.println(listOfAlignements.size());

    }

    private void gapsPropagationStage() {
        System.out.println("Propagation Stage");
        listOfAlignementsAfterGapPropafgation = GapAdderImpl.propagateGaps(listOfAlignements);
    }

    private void ConsensusStage() {
        System.out.println("Consensus Stage");
        TARGET = Consensus.getTarget(listOfAlignementsAfterGapPropafgation);
    }

    /**
     * @param file
     */
    private void parseFile(File file) {
        this.listOfFragments = fileParser.parseFile(file);
        System.out.println("LA Taille de la liste Des Fragments " + listOfFragments.size());
    }

    private void savingTarget(String pathToSaveFastaFile) {
        System.out.println("SAving Target");
        fileParser.saveTargetToFile(TARGET.toString(), pathToSaveFastaFile, TARGET.length());
    }

    private void readFastaFile(File file) {
        System.out.println("redaing File FAsta");
        this.parseFile(file);
    }

    /**
     * @param args
     */
    /*
     java -jar FragmentAssembler.jar <fichier.fasta> –out  <sortie.fasta>
     */
    public static void main(String args[]) {
       // System.out.println(args.length);
        String fastaFilePath = args[0];
        String targetFilePath = args[1];
        File fastaFile = new File(fastaFilePath);
        FragmentAssembler assembler = new FragmentAssembler();
        assembler.run(fastaFile, targetFilePath);
    }

}
