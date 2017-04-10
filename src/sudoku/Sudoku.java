package sudoku;

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
                    {
                        Set<Integer> otherNumbers = allPossibleNumbers();
                        if (otherNumbers.removeAll(knownNumbersInRow(puzzle, row))) {
                            puzzle[row][col] = first(otherNumbers);
                            return solve(puzzle);
                        }
                    }

                    {
                        Set<Integer> possibleNumbers = allPossibleNumbers();
                        if (possibleNumbers.removeAll(knownNumbersInCol(puzzle, col))) {
                            puzzle[row][col] = first(possibleNumbers);
                            return solve(puzzle);
                        }
                    }
                }
            }
        }

        return puzzle;
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

    private int otherRow(int row) {
        return (row == 1) ? 0 : 1;
    }

    private int otherCol(int col) {
        return (col == 1) ? 0 : 1;
    }

    private int first(Set<Integer> numbers) {
        return numbers.stream().findFirst().get();
    }

    private Set<Integer> allPossibleNumbers() {
        return IntStream.rangeClosed(1, puzzleSize).boxed().collect(toSet());
    }

}
