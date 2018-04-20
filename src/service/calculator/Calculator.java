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
package service.calculator;

/**
 *
 Class to calculate single
 simplified algebraic expression.

 * @version
1.00 20 Apr 2018
 * * @author
Astakhov Alexey  */
public class Calculator {

    public static Double calculateStrings(Double operator1, char operation, Double operator2){

        if(operator1 == null){

            System.out.println("Impossible ot calculate, operator 1 is null.");

            return null;

        }else if(operator2 == null){

            System.out.println("Impossible ot calculate, operator 2 is null.");

            return null;
        }

        switch(operation) {

            case '*': {

                return operator1 * operator2;
            }
            case '/': {

                return operator1 / operator2;
            }
            case '+': {

                return operator1 + operator2;
            }
            case '-': {

                return operator1 - operator2;
            }
            default: {

                System.out.println("Unknown operation detected in expression: " +
                        operator1 +
                        operation +
                        operator2);

                return null;
            }

        }

    }

}
