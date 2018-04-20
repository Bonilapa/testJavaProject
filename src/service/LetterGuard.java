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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 Class to check letter's presence
 in a given expression.

 * @version
1.00 20 Apr 2018
 * * @author
Astakhov Alexey  */
public class LetterGuard {

    public static boolean containsLetters(String input){

        Pattern checkRegex = Pattern.compile("[A-Z]");
        Matcher regexMatcher = checkRegex.matcher(input);

        if (regexMatcher.find()) {

            return true;

        } else {

            return false;
        }

    }

}