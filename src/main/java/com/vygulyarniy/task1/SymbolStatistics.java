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
}
