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

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 Class to write handled data
 to the out flie.

 * @version
1.00 20 Apr 2018
 * * @author
Astakhov Alexey  */
public class MyWriter extends FileChecker {

    public static boolean writeCells(ArrayList<ArrayList<String>> stringCells,
                                     String fileName){

        checkExistance(fileName);

        try (FileWriter writer = new FileWriter(fileName,
                                                false)) {

            for (ArrayList<String> array :
                    stringCells) {

                for (String cell :
                        array) {

                    writer.write(cell+";");
                    writer.flush();
                }

                writer.append('\n');
            }

        } catch (IOException ex) {

            ex.printStackTrace();
            return false;
        }

        return true;
    }

}