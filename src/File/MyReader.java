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
package File;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 Class to read 2-dymenional string array
 from the file.

 * @version
1.00 20 Apr 2018
 * * @author
Astakhov Alexey  */
public class MyReader extends FileChecker{

    public static ArrayList<ArrayList<String>> readCells(String filename){

        checkExistance(filename);
        List<String> list = new ArrayList<String>();
        ArrayList<ArrayList<String>> cellContent = new ArrayList<ArrayList<String>>();
        int i = 0;

        try{
            list = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
        } catch (IOException e){

            e.printStackTrace();
        }

        for (String s:
                list) {

            cellContent.add(new ArrayList<>());

            for ( String st:
                    s.split(";")) {

                cellContent.get(i).add(st);
            }

            i++;
        }

        return cellContent;
    }

}