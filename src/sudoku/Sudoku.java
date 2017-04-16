package sudoku;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

public class Sudoku {

    private int puzzleSize;

    public int[][] solve(int[][] puzzle) {

        puzzleSize = puzzle.length;

        for (int row = 0; row < puzzleSize; row++) {
            for (int col = 0; col < puzzleSize; col++) {

                if (puzzle[row][col] == 0) {
                    Set<Integer> knownIntersectingNumbers = knownIntersectingNumbers(puzzle, row, col);

                    Set<Integer> possibleNumbers = allPossibleNumbers();
                    if (possibleNumbers.removeAll(knownIntersectingNumbers)) {
                        if (possibleNumbers.size() == 1) {
                            puzzle[row][col] = first(possibleNumbers);
                            return solve(puzzle);
                        }
                    }
                }
            }
        }

        return puzzle;
    }

    private Set<Integer> knownIntersectingNumbers(int[][] puzzle, int row, int col) {

        Set<Integer> knownIntersectingNumbers = new HashSet<>();

        knownIntersectingNumbers.addAll(knownNumbersInRow(puzzle, row));
        knownIntersectingNumbers.addAll(knownNumbersInCol(puzzle, col));
        knownIntersectingNumbers.addAll(knownNumbersInSubSquare(puzzle, row, col));

        return knownIntersectingNumbers;
    }

    private Set<Integer> knownNumbersInRow(int[][] puzzle, int row) {
        return IntStream.range(0, puzzleSize).
                map(col -> puzzle[row][col]).
                filter(n -> n != 0).
                boxed().collect(toSet());
    }

    private Set<Integer> knownNumbersInCol(int[][] puzzle, int col) {
        return IntStream.range(0, puzzleSize).
                map(row -> puzzle[row][col]).
                filter(n -> n != 0).
                boxed().collect(toSet());
    }

    Set<Integer> knownNumbersInSubSquare(int[][] puzzle, int row, int col) {
        if (puzzle.length == 2 || puzzle.length == 3)
            return new HashSet<>();

        int subSquareSize = (int) Math.sqrt(puzzle.length);

        int fromRow = fromSubSquareIndex(row, subSquareSize);
        int toRow = toSubSquareIndex(subSquareSize, fromRow);

        int fromCol = fromSubSquareIndex(col, subSquareSize);
        int toCol = toSubSquareIndex(subSquareSize, fromCol);

        return IntStream.range(fromRow, toRow).
                flatMap(r -> IntStream.range(fromCol, toCol).
                        map(c -> puzzle[r][c])).
                filter(n -> n != 0).
                boxed().
                collect(toSet());
    }

    private int fromSubSquareIndex(int col, int subSquareSize) {
        return (col / subSquareSize) * subSquareSize;
    }

    private int toSubSquareIndex(int subSquareSize, int fromCol) {
        return fromCol + subSquareSize;
    }

    private int first(Set<Integer> numbers) {
        return numbers.stream().findFirst().get();
    }

    private Set<Integer> allPossibleNumbers() {
        return IntStream.rangeClosed(1, puzzleSize).boxed().collect(toSet());
    }

}
