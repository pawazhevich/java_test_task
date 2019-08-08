package by.touchsoft.task.util;

import java.util.ArrayList;
import java.util.Collections;

public class StringWorker {
    private final static char OPEN_BRACKET = '{';
    private final static char CLOSE_BRACKET = '}';

    public static String trimBrackets(String input){
        StringBuilder builder = new StringBuilder(input);
        char[] symbols = input.toCharArray();
        //удаление с левого края
        int openIndex = input.indexOf(""+OPEN_BRACKET);
        if(openIndex == -1){
            openIndex = symbols.length-1;
        }
        for(int i=openIndex; i>=0; i--){
            if(symbols[i] == CLOSE_BRACKET){
                builder.deleteCharAt(i);
            }
        }
        //удаление с правого края
        int closeIndex = builder.lastIndexOf(""+CLOSE_BRACKET);
        symbols = builder.toString().toCharArray();
        if(closeIndex == -1){
            closeIndex = 0;
        }
        for(int i=symbols.length-1; i > closeIndex; i--){
            if(symbols[i] == OPEN_BRACKET){
                builder.deleteCharAt(i);
            }
        }

        return builder.toString();
    }

    public static String removeSymbolsAt(ArrayList<Integer> indexes, String string){
        indexes.sort(Collections.reverseOrder()); // сортируем в обратном порядке для корректного удаления
        StringBuilder builder = new StringBuilder(string);
        indexes.forEach(builder::deleteCharAt);
        return builder.toString();
    }
}
