/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umons.fragmentassmbler.FastaFileParser;

import com.umons.fragmentassmbler.FragmentAssembler.Fragment;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * this class allow to read a fasta File to create a list aof Fragment
 *
 * @author zakariae
 */
public class FileParser {

    private ArrayList<Fragment> listOfFragment = new ArrayList<>();
    private int collectionNumber;

    /**
     *
     */
    public FileParser() {
    }

    /**
     *
     * @param file
     */
    public FileParser(File file) {
        this.listOfFragment = new ArrayList<>();
        // parseFile(file);
    }

    /**
     *
     * @return the List of Fragments
     */
    public ArrayList<Fragment> getListOfFragment() {
        return listOfFragment;
    }

    /**
     *
     * @param file read the Fasta file and
     * @return the List of Fragments
     */
    public ArrayList<Fragment> parseFile(File file) {
        //String fileName = file.getName();
        BufferedReader br = null;
        try {
            StringBuilder str = new StringBuilder("");
            String line;
            br = new BufferedReader(new FileReader(file));
            br.readLine();//reading the first line 
            int Id = 0;
            /*we begin by reading the second Line in The File ,the first Fragment  */
            Fragment fragment;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(">")) {/*it means that we Will read a new Fragment , So we
                                             save the last readed Fragment    */
                    fragment = new Fragment(str, Id);
                    Id++;
                    listOfFragment.add(fragment);
                    str = new StringBuilder("");
                    continue;
                }
                str.append(line);
            }
            fragment = new Fragment(str, Id);//Creating the last fragment In the File
            listOfFragment.add(fragment);
        } catch (IOException e) {
        } finally {
            try {
                if (br != null) {
                    br.close();
                }

            } catch (IOException ex) {
            }

        }

        return listOfFragment;
    }

    /**
     *i should Rewrite correctly this method
     * @param str the target to save in Fasta File
     * @param path the path where to save the file
     * @param longueur_sequence_cible
     */
    public void saveTargetToFile(String str, String path, int longueur_sequence_cible) {
        try {
            File file = new File(path);
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            String title = "> Groupe-06 Collection " + this.collectionNumber + " Longueur " + longueur_sequence_cible;
            out.write(title);
            out.write(str);
            out.close();
        } catch (IOException e) {
            System.out.println("Exception ");
        }
    }

}
