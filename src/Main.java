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
import service.LinkReplacer;
import java.util.ArrayList;

/**
 *
 Class reads data from argument 1 file,
 calculates all the expressions
 and writes it to argument 2 file.

 * @version
1.00 20 Apr 2018
 * * @author
Astakhov Alexey  */
public class Main {

    private static ArrayList<ArrayList<String>> stringList = new ArrayList<>();

    public static void main(String[] args){

        stringList = File.MyReader.readCells(args[0]);

        LinkReplacer linkReplacer = new LinkReplacer(stringList);

        linkReplacer.refactorCells();

        if(File.MyWriter.writeCells(stringList, args[1])){

            System.out.println(args[1]+" update is successful.");
        }

    }

}