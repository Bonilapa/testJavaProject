/*
        Alexey Astakhov
 *
        Copyright (c) 20 Apr 2018 Astakhov Inc.
        404 1 1 Universitetskaya, Innopolis, Verkhne-Uslonskiy rayon,
        Tatarstan Republic, 420500, RF
 *
        No Rights reserved.
 *
        This software is the confidential information of Astakhov Inc..
 *
 *
        ASTAKHOV MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
        THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
        TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
        PARTICULAR PURPOSE, OR NON-INFRINGEMENT.
 */
package service;

import service.calculator.ParsingTree;
import java.util.ArrayList;

/**
 *
 Class to handle literal links in each cell
 with immediate calculation of obtained expression.

 * @version
1.00 20 Apr 2018
 * * @author
Astakhov Alexey  */
public class LinkReplacer {

    private ArrayList<ArrayList<String>> stringList;

    public LinkReplacer(ArrayList<ArrayList<String>> stringList){

        this.stringList = stringList;
    }

    public void refactorCells(){

        for(int i = 0; i<stringList.size(); i++){

            int size = stringList.get(i).size();

            for(int j = 0; j<size; j++){

                stringList.get(i).set(j, refactorCell(i,j).toString());
            }

        }

    }

    public Double refactorCell(int i,
                               int j){

        String input = stringList.get(i).get(j);
        int[] index;
        String link;

        while (LetterGuard.containsLetters(input)) {

            link = getNextLink(input);
            index = Mapper.mapCell(link);
            input = input.replaceAll(link, refactorCell(index[0], index[1]).toString());
        }

        ParsingTree parsingTree = new ParsingTree(input);
        return parsingTree.buildTree();
    }

    private String getNextLink(String input){

        int substringStartIndex = 0;
        int substringEndIndex = 0;

        for (char symbol:
             input.toCharArray()) {

            if(symbol == '+' || symbol == '-' || symbol == '/' || symbol == '*'){

                String s = input.substring(substringStartIndex, substringEndIndex);

                if(LetterGuard.containsLetters(s)) {

                    return s;

                }else{

                    substringStartIndex = substringEndIndex + 1;
                }

            }

            substringEndIndex++;
        }

        return input.substring(substringStartIndex, substringEndIndex);
    }

}