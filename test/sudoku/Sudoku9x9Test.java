package sudoku;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class Sudoku9x9Test extends SudokuTest {

    @TestFactory
    List<DynamicTest> sudokuTests() {
        return asList(
                dynamicTest("Times Mild 8693", () -> sudokuTest(
                        "0 2 0 9 0 6 0 1 0", "5 2 4 9 7 6 8 1 3",
                        "0 0 0 0 0 0 0 0 0", "1 3 9 5 8 4 6 7 2",
                        "8 0 7 0 0 0 4 0 5", "8 6 7 3 1 2 4 9 5",
                        "0 0 0 7 0 8 0 0 0", "2 1 5 7 6 8 3 4 9",
                        "0 8 3 0 5 0 7 2 0", "4 8 3 1 5 9 7 2 6",
                        "0 0 0 4 0 3 0 0 0", "9 7 6 4 2 3 1 5 8",
                        "6 9 0 0 0 0 0 3 1", "6 9 2 8 4 7 5 3 1",
                        "0 5 0 2 0 1 0 6 0", "7 5 8 2 3 1 9 6 4",
                        "0 4 0 0 0 0 0 8 0", "3 4 1 6 9 5 2 8 7"
                ))
        );
    }

}
