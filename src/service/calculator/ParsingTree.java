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
 Class to calculate simplified
 algebraic expressions.

 * @version
1.00 20 Apr 2018
 * * @author
Astakhov Alexey  */
public class ParsingTree {

    String expression;

    public ParsingTree(String expression){

        this.expression = expression;
    }

    public Double buildTree(){

        String internal = new StringBuilder(expression).reverse().toString();

        return calculate(internal);
    }

    private Double calculate(String input) {

        //------------------------------recursion base
        if (isANumber(input)) {

            if (input.isEmpty()) {

                return 0.0;

            } else {

                return Double.parseDouble(new StringBuilder(input).reverse().toString());
            }

        }

        char[] in = input.toCharArray();
        int i = 0;

        if (containsPlusMinus(input)) {

            for (int k = 0; k < in.length; k++) {

                char symbol = in[k];

                if (symbol == '-' || symbol == '+') {

                    // =============================
                    // spike to operate expessions
                    // with negative numbers
                    // without using brackets
                    if (k + 1 >= in.length) {

                        return Calculator.calculateStrings(
                                calculate("")
                                , symbol
                                , calculate(new StringBuilder(input.substring(0, i)).toString()));
                    }

                    if (isOperation(in[k + 1])) {
                        symbol = in[k + 1];
                        i++;
                    }
                    //=================================

                    return Calculator.calculateStrings(
                            calculate(new StringBuilder(input.substring(i + 1, input.length())).toString())
                            , symbol
                            , calculate(new StringBuilder(input.substring(0, i)).toString()));
                }

                i++;
            }

        } else if (containsDivideProduct(input)) {

            for (int k = 0; k < in.length; k++) {

                char symbol = in[k];

                if (symbol == '*' || symbol == '/') {

                    // =============================
                    // spike to operate expessions
                    // with negative numbers
                    // without using brackets
                    if (k + 1 >= in.length) {
                        return Calculator.calculateStrings(
                                calculate("")
                                , symbol
                                , calculate(new StringBuilder(input.substring(0, i)).toString()));
                    }

                    if (isOperation(in[k + 1])) {
                        symbol = in[k + 1];
                        i++;
                    }
                    //=============================

                    return Calculator.calculateStrings(
                            calculate(new StringBuilder(input.substring(i + 1, input.length())).toString())
                            , symbol
                            , calculate(new StringBuilder(input.substring(0, i)).toString()));
                }

                i++;
            }

        }

        return null;
    }

    private boolean isOperation(char c){

        if(c == '+' || c == '-' || c == '*' || c == '/'){

            return true;
        }

        return false;
    }

    private boolean containsPlusMinus(String input){

        for (char symbol:
                input.toCharArray()) {

            if(symbol == '+' || symbol == '-'){

                return true;
            }

        }

        return false;
    }

    private boolean containsDivideProduct(String input){

        for (char symbol:
                input.toCharArray()) {

            if(symbol == '/' || symbol == '*'){

                return true;
            }

        }

        return false;
    }

    private boolean isANumber(String input){

        for (char symbol:
                input.toCharArray()) {

            if(isOperation(symbol)){

                return false;
            }

        }

        return true;
    }

}