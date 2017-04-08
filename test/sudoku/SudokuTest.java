package sudoku;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;
import static matchers.GridMatcher.gridMatches;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class SudokuTest {

    private final Sudoku sudoku = new Sudoku();

    @TestFactory
    List<DynamicTest> sudokuTests() {
        return asList(
                dynamicTest("test",() -> sudokuTest(
                        "1 2",  "1 2",
                        "2 1",  "2 1")),

                dynamicTest("test", () -> sudokuTest(
                        "0 2",  "1 2",
                        "2 1",  "2 1")),
                dynamicTest("test", () -> sudokuTest(
                        "0 1",  "2 1",
                        "1 2",  "1 2")),

                dynamicTest("test", () -> sudokuTest(
                        "0 0",  "1 2",
                        "2 1",  "2 1")),
                dynamicTest("test", () -> sudokuTest(
                        "0 0",  "2 1",
                        "1 2",  "1 2")),

                dynamicTest("test", () -> sudokuTest(
                        "0 0",  "1 2",
                        "0 1",  "2 1")),
                dynamicTest("test", () -> sudokuTest(
                        "0 0",  "2 1",
                        "0 2",  "1 2"))
        );
    }

    private void sudokuTest(String... rows) {

        int [][] puzzle   = buildGrid(even(rows));
        int [][] solution = buildGrid(odd(rows));

        assertThat(sudoku.solve(puzzle), gridMatches(solution));
    }

    private String[] even(String[] rows) {
        return oddOrEvenRows(rows, 0);
    }

    private String[] odd(String[] rows) {
        return oddOrEvenRows(rows, 1);
    }

    private String[] oddOrEvenRows(String[] allRows, int oddOrEven) {

        assert(allRows.length % 2 == 0);

        String[] rows = new String[allRows.length / 2];

        for (int i = 0; i < allRows.length; i++)
            if (i % 2 == oddOrEven)
                rows[i / 2] = allRows[i];

        return rows;
    }

    private int[][] buildGrid(String[] rows) {
        int[][] grid = new int[rows.length][rows.length];
        for (int i = 0; i < rows.length; i++) {
            String[] elements = rows[i].split(" ");
            for (int j = 0; j < elements.length; j++)
                grid[i][j] = parseInt(elements[j]);
        }
        return grid;
    }

}
