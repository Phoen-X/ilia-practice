package com.vygulyarniy.task1;

public class SymbolStatistics {
    private final char symbol;
    private final int count;

    public SymbolStatistics(char symbol, int count) {
        this.symbol = symbol;
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("%s (%d упоминаний)", symbol, count);
    }

    public boolean equals(Object o){
        if(o instanceof SymbolStatistics){
            SymbolStatistics other = (SymbolStatistics)o;
            return this.symbol == other.symbol && this.count == other.count;
        }
        return false;
    }
}
