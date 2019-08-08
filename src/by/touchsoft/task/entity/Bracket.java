package by.touchsoft.task.entity;

import by.touchsoft.task.constant.BracketType;

import java.util.Objects;

public class Bracket {
    private BracketType type; // тип скобки - открывающая \ закрывающая
    private int bracketId; // индекс скобки в исходной строке

    public Bracket(int id, BracketType type){
        this.type = type;
        bracketId = id;
    }

    public BracketType getType() {
        return type;
    }

    public void setType(BracketType type) {
        this.type = type;
    }

    public int getBracketId() {
        return bracketId;
    }

    public void setBracketId(int bracketId) {
        this.bracketId = bracketId;
    }

    public String toString(){
        return this.type.toString() + bracketId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bracket bracket = (Bracket) o;
        return bracketId == bracket.bracketId &&
                type == bracket.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, bracketId);
    }
}

