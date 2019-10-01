package generator;

import javax.print.DocFlavor;
import java.util.*;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Generator {
    private int sideLength;
    private String difficulty = "easy";
    private SudokuCell[][] sudokuPuzzle;
    private Tester tester;

    Generator(int sideLength, String difficulty) {
        this.sideLength = sideLength;
        this.difficulty = difficulty;
        tester = new Tester(difficulty);
        setSudokuPuzzle();
    }

    void generateFirstSquare() {
        List<Integer> numList = new ArrayList<Integer>();
        Collections.addAll(numList,1,2,3,4,5,6,7,8,9);
        Random randInt = new Random();
        for (int i = 0; i < sideLength/3; i++) {
            for (int k = 0; k < sideLength/3; k++) {
                sudokuPuzzle[i][k] = new SudokuCell(i,k);
                int random = randInt.nextInt(numList.size());
                sudokuPuzzle[i][k].setValue(numList.get(random));
                numList.remove(random);
            }
        }
    }

    void fillToRight() {
        for (int i = 0; i < 3; i++) {
            List<Integer> usedRowNums = Arrays.asList(sudokuPuzzle[i][0].getValue(), sudokuPuzzle[i][1].getValue(), sudokuPuzzle[i][2].getValue());
            List<Integer> usedColNums = Arrays.asList();
            List<Integer> numList = new ArrayList<Integer>();

            for (int k = 1; k <= 9 & numList.size() < 6; k++) {
                if (!usedRowNums.contains(Integer.valueOf(k))) {
                    numList.add(k);
                }
            }

            for (int k = 0; k < 6; k++) {
                sudokuPuzzle[i][k] = new SudokuCell(i,k);
                sudokuPuzzle[i][k].setValue(numList.get(k));
            }

            //TODO add to usedColNums by checking i-n for each row (if loop or figure something else out)


            System.out.println("FOO");
        }
    }

    void printFirstSquare() {
        for (int i = 0; i < 3; i++) {
            String foo = "";
            for (int k = 0; k < 6; k++) {
                foo += Integer.toString(sudokuPuzzle[i][k].getValue()) + "   ";
            }
            System.out.println(foo + "\n");
        }
    }

    private void setSudokuPuzzle() {
        sudokuPuzzle = new SudokuCell[sideLength][sideLength];
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public SudokuCell[][] getSudokuPuzzle() {
        return sudokuPuzzle;
    }

    public Tester getTester() {
        return tester;
    }

    public void setTester(Tester tester) {
        this.tester = tester;
    }
}