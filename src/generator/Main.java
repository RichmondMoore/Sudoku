package generator;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Generator gen = new Generator(9,"easy");
        gen.generateFirstSquare();
        gen.fillToRight();
        gen.printFirstSquare();
    }
}
