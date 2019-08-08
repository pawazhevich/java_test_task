package by.touchsoft.task.validator;

import by.touchsoft.task.constant.ValidatorConst;
import by.touchsoft.task.entity.BracketList;
import by.touchsoft.task.util.ArrayCombiner;
import by.touchsoft.task.util.StringWorker;

import java.util.*;

//TODO comments

public class CodeValidator {

    public static Set<String> validate(String input){
        HashSet<String> rightRows = new HashSet<>(); // множество правильных возможных строк кода

        String trimmed = StringWorker.trimBrackets(input); // убираем бессмысленные скобки по краям
        if(isValid(trimmed)){ // если сразу пришел правильный
            rightRows.add(trimmed);
            return rightRows;
        }

        BracketList list = new BracketList(trimmed);// список скобок
        ArrayList<Integer> indexes = list.indexesOfOdd(); // получаем индексы скобок лишнего типа
        ArrayList<ArrayList<Integer>> toCombine = new ArrayList<>(); // список для списка индексов для создания комбинаций

        int oddNum = Math.abs(list.getBracketDiff());// определяем количество лишних скобок - оно же min скобок для удаления
        for(int i=0; i<oddNum; i++){
            toCombine.add(indexes);
        }

        HashSet<ArrayList<Integer>> indexSet =  ArrayCombiner.product(toCombine); // получаем возможные комбинации удаления

        indexSet.forEach(l->{
            //удаляем скобки на позициях и проверяем на правильность
            String edited = StringWorker.removeSymbolsAt(l, trimmed);
            if(isValid(edited)){
                rightRows.add(edited);
            }
        });

        return rightRows;
    }

    public static boolean isValid(String input){
        if(input.equals("")){
            return false;
        }
        //стэк для контроля открытых - закрытых скобок
        Stack<Character> stack = new Stack<>();
        char[] symbols = input.toCharArray();
        char symbol;

        for(int i=0;i<symbols.length;i++){
            symbol = symbols[i];
            if(symbol == ValidatorConst.OPEN_BRACKET){
                stack.push(symbol);
            } else if(symbol == ValidatorConst.CLOSE_BRACKET){
                if(!stack.isEmpty()){
                    stack.pop();
                } else return false;
            }
        }
        return stack.isEmpty();
    }

}
