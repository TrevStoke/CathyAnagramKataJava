/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package anagramkata;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Turner Family
 */
class Anagram {
    private String word;
    private ArrayList<String> matches = new ArrayList<String>();

    public ArrayList<String> getMatches() {
        return matches;
    }
    private Scanner file;

    public Anagram() throws FileNotFoundException {
        openFile();
    }

    void setWord(String string) {
        word = string;
    }

    String getWord() {
        return word;
    }

    String getAnags() {
        return word;
    }

    private void openFile() throws FileNotFoundException {
          file = new Scanner(new File("wordlist.txt"));
      }

    String readFile() throws FileNotFoundException {
  //       openFile();
         String first = file.next();
         return first;
    }

    public void findAnags() {
        String s = word;
        byte[] b = word.getBytes();
        Arrays.sort(b);
        findMatch(new String(b));
//        findMatch(word);
//        StringBuffer sb = new StringBuffer(word);
//        sb.c
/*        for (int i=0; i < sb.length() - 1; i++)  {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(i+1));
            sb.setCharAt(i+1, temp);
            findMatch(sb.toString());
            System.out.println(sb);
        }
 * */
 
        System.out.println("Anagrams of " + word + ": ");
        System.out.println(matches);
    }

    void findMatch(String w)  {
        String match = "";
        try {
        openFile();
        }

        catch (FileNotFoundException e) {}
        int length = w.length();
        while (file.hasNext()) {
            match = file.next();
            if (length == match.length()) {
            byte[] b = match.getBytes();
            Arrays.sort(b);
            String sortedB = new String(b);
            if (sortedB.equals(w))
                matches.add(match);
            }
        }
        file.close();
    }
}
