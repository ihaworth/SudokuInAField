package sudoku;

import java.util.Arrays;
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
                    if (puzzle[row][otherCol(col)] != 0) {
                        puzzle[row][col] = first(otherNumbers(asSet(puzzle[row][otherCol(col)])));
                        return solve(puzzle);
                    }

                    if (puzzle[otherRow(row)][col] != 0) {
                        puzzle[row][col] = first(otherNumbers(asSet(puzzle[otherRow(row)][col])));
                        return solve(puzzle);
                    }
                }
            }
        }

        return puzzle;
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

    private Set<Integer> otherNumbers(Set<Integer> knownNumbers) {
        Set<Integer> otherNumbers = allPossibleNumbers();
        otherNumbers.removeAll(knownNumbers);
        return otherNumbers;
    }

    private Set<Integer> asSet(Integer... i) {
        return new HashSet<>(Arrays.asList(i));
    }

    private Set<Integer> allPossibleNumbers() {
        return IntStream.rangeClosed(1, puzzleSize).boxed().collect(toSet());
    }

}
