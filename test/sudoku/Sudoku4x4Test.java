package sudoku;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class Sudoku4x4Test extends SudokuTest {


    @TestFactory
    List<DynamicTest> sudokuTests() {
        return asList(
                dynamicTest("Identity", () -> sudokuTest(
                        "3 2 4 1", "3 2 4 1",
                        "1 4 2 3", "1 4 2 3",
                        "2 1 3 4", "2 1 3 4",
                        "4 3 1 2", "4 3 1 2"
                ))
        );
    }
}
