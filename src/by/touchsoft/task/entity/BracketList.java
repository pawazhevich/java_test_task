package by.touchsoft.task.entity;

import by.touchsoft.task.constant.BracketType;
import by.touchsoft.task.constant.ValidatorConst;

import java.util.ArrayList;
import java.util.Objects;


public class BracketList {
    private ArrayList<Bracket> list;

    public BracketList(){
        list = new ArrayList<>();
    }

    public ArrayList<Bracket> toArrayList(){
        return list;
    }

    public BracketList(String input){
        list = new ArrayList<>();
        char[] symbols = input.toCharArray();
        BracketType type;
        for(int i=0; i<symbols.length; i++){
            if(symbols[i]== ValidatorConst.OPEN_BRACKET){
                list.add(new Bracket(i, BracketType.OPEN));
            } else if(symbols[i] == ValidatorConst.CLOSE_BRACKET){
                list.add(new Bracket(i, BracketType.CLOSE));
            }

        }
    }

    public void add(Bracket bracket){
        list.add(bracket);
    }

    public Bracket get(int index){
        return list.get(index);
    }

    //Метод для получения списка индевсок избыточного типа
    public ArrayList<Integer> indexesOfOdd(){
        int diff = getBracketDiff();
        if(diff >= 0){
            return indexesOf(BracketType.OPEN);
        } else return indexesOf(BracketType.CLOSE);
    }


    //Метод для получения списка индексов скобок заданного типа
    public ArrayList<Integer> indexesOf(BracketType type){
        ArrayList<Integer> indexes = new ArrayList<>();
        list.forEach(b->{
            if(b.getType() == type){
                indexes.add(b.getBracketId());
            }
        });
        return indexes;
    }

    //Метод, определяющий разность между количеством открывающих и закрывающих скобок
    public int getBracketDiff(){
        int diff = 0;
        Bracket br;
        for(int i=0; i< list.size();i++){
            br = list.get(i);
            if(br.getType() == BracketType.OPEN){
                diff++;
            } else diff--;
        }
        return diff;
    }

    public String toString(){
        return "BracketList: "+list.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BracketList that = (BracketList) o;
        return Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
}
