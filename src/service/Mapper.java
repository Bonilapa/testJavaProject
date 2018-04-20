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

import java.util.ArrayList;

/**
 *
 Class makes an 2-dimentional index
 of a cell from literal link.

 * @version
1.00 20 Apr 2018
 * * @author
Astakhov Alexey  */
public class Mapper {

    public static int[] mapCell(String input){

        ArrayList<Integer> letterList = new ArrayList<>();
        ArrayList<Integer> numberList = new ArrayList<>();
        int [] out = new int[2];

        for (char symbol:
             input.toCharArray()) {

            for (int i = 65; i<91; i++){

                if (symbol == (char)i){

                    letterList.add(i - 64);
                }

            }

            for (int i = 48; i<58; i++){

                if (symbol == (char)i){

                    numberList.add(i - 48);
                }

            }
        }

        out[1] = letterArrayToNumber(letterList)-1;
        out[0] = numberArrayToNumber(numberList)-1;

        return out;
    }

    private static Integer letterArrayToNumber(ArrayList<Integer> array){

        int degree = 1,
            answer = 0;

        for(int i = 0; i < array.size() - 1; i++){

            degree *= 26;
        }

        for (Integer digit:
                array) {

            answer += degree * digit;
            degree /= 26;
        }

        return answer;
    }

    private static Integer numberArrayToNumber(ArrayList<Integer> array){

        int degree = 1,
            answer = 0;

        for(int i = 0; i < array.size() - 1; i++){

            degree *= 10;
        }

        for (Integer digit:
                array) {

            answer += degree * digit;
            degree /= 10;
        }

        return answer;
    }

}