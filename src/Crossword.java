public class Crossword {
    Boolean isSolved = false;
    String[][] crossword = {
            {"[0]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[5]", "[ ]", "[ ]", "[ ]", "[ ]"},
            {"   ", "   ", "   ", "   ", "   ", "[1]", "[ ]", "[ ]", "[ ]", "   ", "   "},
            {"   ", "   ", "   ", "[6]", "   ", "   ", "[ ]", "   ", "   ", "   ", "   "},
            {"   ", "[2]", "[7]", "[ ]", "[ ]", "[8]", "[ ]", "[9]", "[ ]", "   ", "   "},
            {"   ", "   ", "[3]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
            {"   ", "   ", "[ ]", "[ ]", "   ", "[ ]", "[ ]", "[ ]", "   ", "   ", "   "},
            {"   ", "   ", "[ ]", "[ ]", "   ", "[ ]", "[ ]", "[ ]", "   ", "   ", "   "},
            {"   ", "   ", "[ ]", "[ ]", "   ", "[ ]", "[ ]", "[ ]", "   ", "   ", "   "},
            {"   ", "   ", "[ ]", "   ", "   ", "   ", "   ", "[ ]", "   ", "   ", "   "},
            {"[4]", "[ ]", "[ ]", "[ ]", "[ ]", "   ", "   ", "   ", "   ", "   ", "   \n"},
    };

    public String[][] getCrossword() {
        return crossword;
    }

    public int[] getWordCoords(int questionNumber) {
        for (int i = 0; i < crossword.length; ++i) {
            for (int j = 0; j < crossword[i].length; ++j) {
                if (crossword[i][j].equals("[" + questionNumber + "]")) {
                    int[] coords = {i, j};
                    return coords;
                }
            }
        }
        return null;
    }

    public void showCrossword() {
        for (String[] innerArray : crossword) {
            System.out.println();
            for (String data : innerArray) {
                System.out.print(data);
            }
        }
    }
}