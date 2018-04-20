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

import java.io.File;
import java.io.IOException;

/**
 *
 Class to check the file existance
 and creating a new one in other case.

 * @version
1.00 20 Apr 2018
 * * @author
Astakhov Alexey  */
public class FileChecker {

    protected static void checkExistance(String filename){

        File f = new File(filename);

        if(!f.exists()){

            try {

                f.createNewFile();

            } catch (IOException e) {

                e.printStackTrace();
            }

            System.out.println(f+" created");
        }

    }

}
