package by.touchsoft.task.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

//класс для комбинирования элементов списков
//Set используется для устранения дубликатов
public class ArrayCombiner{
    // комбинация списка и одной строки
    private static <T> HashSet<ArrayList<T>> multiple(HashSet<ArrayList<T>> list, ArrayList<T> row){
        HashSet<ArrayList<T>> result = new HashSet<>();
        list.forEach(o->{
            row.forEach(r->{
                ArrayList<T> temp = new ArrayList<>(o);
                temp.add(r);
                if(!hasDuplicates(temp)){
                    result.add(temp);
                }
            });
        });
        return result;
    }

    //декартово произведение всех строк списка
    public static <T> HashSet<ArrayList<T>> product(ArrayList<ArrayList<T>> objects){
        HashSet<ArrayList<T>> result = new HashSet<>();
        if(objects.size() == 0){
            return new HashSet<>();
        } else {
            ArrayList<T> first = objects.get(0);
            for(int i=0; i< first.size(); i++){
                ArrayList<T> temp = new ArrayList<>();
                temp.add(first.get(i));
                result.add(temp);
            }
            for(int i=1; i<objects.size(); i++){
                result = multiple(result, objects.get(i));
            }
            return result;
        }
    }
    // проверка на дубликаты с списке
    private static <T> boolean hasDuplicates(ArrayList<T> list){
        ArrayList<T> temp = new ArrayList<>();
        for(int i=0; i<list.size();i++){
            if(temp.contains(list.get(i))){
                return true;
            } else temp.add(list.get(i));
        }
        return false;
    }

}