package com.iredko.testBook;

import java.util.Arrays;
import java.util.List;

public class Matrix {
    private final int arrSize;
    private final int[][] arr;

    public Matrix(int matrixSize) {
        this.arrSize = matrixSize;
        this.arr = new int[matrixSize][matrixSize];
    }

    public void print() {
        for (int[] line : arr) {
            System.out.println(Arrays.toString(line));
        }
    }

    private void fillMatrix() {
        PositionInner lastPosition = new PositionInner(null, Direction.RIGHT);
        for (int number = 1; number <= arrSize * arrSize; number++) {
            PositionInner numberPosition = findPlaceForValue(lastPosition);
            fill(numberPosition.coords, number);
            lastPosition = numberPosition;
        }
    }

    private PositionInner findPlaceForValue(PositionInner lastPosition) {
        if (lastPosition.coords == null) {
            return new PositionInner(Coords.of(0, 0), Direction.RIGHT);
        } else {
            List<Direction> directionPriority = selectDirectionsOrder(lastPosition);
            for (Direction direction : directionPriority) {
                Coords nextCoordsInDirection = lastPosition.coords.next(direction);
                if (canFill(nextCoordsInDirection)) {
                    return new PositionInner(nextCoordsInDirection, direction);
                }
            }
            throw new IllegalStateException("Cannot find free place after coords" + lastPosition + Arrays.deepToString(arr));
        }
    }

    private List<Direction> selectDirectionsOrder(PositionInner position) {
        switch (position.direction) {
            case RIGHT:
                return Arrays.asList(Direction.RIGHT, Direction.DOWN, Direction.LEFT, Direction.UP);
            case DOWN:
                return Arrays.asList(Direction.DOWN, Direction.LEFT, Direction.UP, Direction.RIGHT);
            case LEFT:
                return Arrays.asList(Direction.LEFT, Direction.UP, Direction.RIGHT, Direction.DOWN);
            case UP:
                return Arrays.asList(Direction.UP, Direction.RIGHT, Direction.DOWN, Direction.LEFT);
            default:
                return Arrays.asList(Direction.RIGHT, Direction.DOWN, Direction.LEFT, Direction.UP);
        }
    }

    private void fill(Coords coords, int value) {
        this.arr[coords.y][coords.x] = value;
    }

    private boolean canFill(Coords coords) {
        return isInBounds(coords) && !isFilled(coords);
    }

    private boolean isInBounds(Coords coords) {
        return coords.x >= 0 && coords.y >= 0 &&
                coords.x < arrSize && coords.y < arrSize;
    }

    private boolean isFilled(Coords coords) {
        return isInBounds(coords) && arr[coords.y][coords.x] != 0;
    }

    static class Coords {
        int x;
        int y;

        public Coords(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Coords of(int x, int y) {
            return new Coords(x, y);
        }

        public Coords next(Direction direction) {
            switch (direction) {
                case RIGHT:
                    return right();
                case LEFT:
                    return left();
                case UP:
                    return up();
                case DOWN:
                    return down();
            }
            throw new IllegalArgumentException("Unknown direction " + direction);
        }

        public Coords right() {
            return Coords.of(x + 1, y);
        }

        public Coords left() {
            return Coords.of(x - 1, y);
        }

        public Coords up() {
            return Coords.of(x, y - 1);
        }

        public Coords down() {
            return Coords.of(x, y + 1);
        }

        @Override
        public String toString() {
            return String.format("(%d;%d)", x, y);
        }
    }

    enum Direction {RIGHT, LEFT, DOWN, UP}

    static class PositionInner {
        Coords coords;
        Direction direction;

        public PositionInner(Coords coords, Direction direction) {
            this.coords = coords;
            this.direction = direction;
        }
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix(5);
        matrix.fillMatrix();
        matrix.print();
    }
}
