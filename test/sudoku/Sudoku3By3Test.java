package sudoku;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class Sudoku3By3Test extends SudokuTest {

    @TestFactory
    List<DynamicTest> sudokuTests() {
        return asList(
                dynamicTest("Identity",() -> sudokuTest(
                        "1 2 3",  "1 2 3",
                        "2 3 1",  "2 3 1",
                        "3 1 2",  "3 1 2")),

                dynamicTest("Missing a 2 from an inner 2x2",() -> sudokuTest(
                        "1 0 3",  "1 2 3",
                        "2 3 1",  "2 3 1",
                        "3 1 2",  "3 1 2")),

                dynamicTest("Missing a 3",() -> sudokuTest(
                        "1 2 0",  "1 2 3",
                        "2 3 1",  "2 3 1",
                        "3 1 2",  "3 1 2")),

                dynamicTest("A minimal puzzle",() -> sudokuTest(
                        "1 0 0",  "1 2 3",
                        "0 3 0",  "2 3 1",
                        "0 0 0",  "3 1 2")),

                dynamicTest("A puzzle where other cells need to be solved before other cells can be completed",() -> sudokuTest(
                        "1 0 0",  "1 3 2",
                        "0 0 3",  "2 1 3",
                        "0 0 0",  "3 2 1"))
        );
    }

}
