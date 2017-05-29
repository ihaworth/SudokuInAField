package sudoku;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class Sudoku2By2Test extends SudokuTest {

    @TestFactory
    List<DynamicTest> sudokuTests() {
        return asList(
                dynamicTest("Identity",() -> sudokuTest(
                        "1 2",  "1 2",
                        "2 1",  "2 1")),


                dynamicTest("Three zeros plus top left 1", () -> sudokuTest(
                        "1 0",  "1 2",
                        "0 0",  "2 1")),
                dynamicTest("Three zeros plus top left 2", () -> sudokuTest(
                        "2 0",  "2 1",
                        "0 0",  "1 2")),

                dynamicTest("Three zeros plus bottom left 1", () -> sudokuTest(
                        "0 0",  "2 1",
                        "1 0",  "1 2")),
                dynamicTest("Three zeros plus bottom left 2", () -> sudokuTest(
                        "0 0",  "1 2",
                        "2 0",  "2 1")),

                dynamicTest("Three zeros plus top right 1", () -> sudokuTest(
                        "0 1",  "2 1",
                        "0 0",  "1 2")),
                dynamicTest("Three zeros plus top right 2", () -> sudokuTest(
                        "0 2",  "1 2",
                        "0 0",  "2 1")),

                dynamicTest("Three zeros plus bottom right 1", () -> sudokuTest(
                        "0 0",  "1 2",
                        "0 1",  "2 1")),
                dynamicTest("Three zeros plus bottom right 2", () -> sudokuTest(
                        "0 0",  "2 1",
                        "0 2",  "1 2"))
        );
    }

}
