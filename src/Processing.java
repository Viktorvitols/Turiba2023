import java.util.ArrayList;
import java.util.Scanner;

public class Processing {
    Words words = new Words();
    Crossword crosswordObj = new Crossword();
    Crossword emptyCrossword = new Crossword();
    String[][] crosswordArray = crosswordObj.getCrossword();
    ArrayList<String> usedWords = new ArrayList<>();

    public void runCrossword() {
        showQuestion(this.words);
        showCrossword(this.crosswordObj);
        System.out.println("\nType your answer.\n" +
                "First symbol must be the number of the question\n" +
                "To see empty crossword (to see the numbers), type '?'\n" +
                "To see your crossword, type '!'");

        while (!this.crosswordObj.isSolved) {
            input();
        }
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        if (input.equals("?")) {
            emptyCrossword.showCrossword();
        } else if (input.equals("!")) {
            crosswordObj.showCrossword();
        } else if (!Character.isDigit(input.charAt(0))) {
            System.out.println("First symbol must be the number of the question, e.g. '0java'\n");
        } else {
            processAnswer(input);
        }
    }

    public Boolean isDuplicate(String answer) {
        for (String i : usedWords) {
            if (i.equals(answer)) {
                return true;
            }
        }
        return false;
    }

    public void processAnswer(String input) {

        Integer answerIndex = null;
        answerIndex = Integer.valueOf(input.substring(0, 1));
        String[] correctAnswers = words.getAllWords();
        String answer = (input.substring(1).toUpperCase());

        if (isDuplicate(answer)) {
            System.out.println("Already there.");

        } else if (answerIndex < 5 & correctAnswers[answerIndex].equals(answer)) {
            updateHorizontal(answerIndex);
            usedWords.add(answer);
            showQuestion(this.words);
            crosswordObj.showCrossword();
            if (usedWords.size() == words.getAllWords().length) {
                System.out.println("\nCongratulations! \nYou have done it!");
                crosswordObj.isSolved = true;
            } else System.out.println("\nCorrect! Type in the next answer!");

        } else if (answerIndex >= 5 & correctAnswers[answerIndex].equals(answer)) {
            updateVertical(answerIndex);
            usedWords.add(answer);
            showQuestion(this.words);
            crosswordObj.showCrossword();
            if (usedWords.size() == words.getAllWords().length) {
                System.out.println("\nCongratulations! \nYou have done it!");
                crosswordObj.isSolved = true;
            } else System.out.println("\nCorrect! Type in the next answer!");


        } else if (input.equals("?")) {
            emptyCrossword.showCrossword();
        } else {
            System.out.println("\nWrong!");
        }
    }


    public void updateHorizontal(int wordIndex) {
        String word = words.getAllWords()[wordIndex];
        int[] wordCoords = emptyCrossword.getWordCoords(wordIndex);
        int row = wordCoords[0];
        int col = wordCoords[1];
        for (int i = 0; i < word.length(); i++) {
            this.crosswordArray[row][col] = "[" + word.substring(i, i + 1) + "]";
            col++;
        }
    }

    public void updateVertical(int wordIndex) {
        String word = words.getAllWords()[wordIndex];
        int[] wordCoords = emptyCrossword.getWordCoords(wordIndex);
        int row = wordCoords[0];
        int col = wordCoords[1];
        for (int i = 0; i < word.length(); i++) {
            this.crosswordArray[row][col] = "[" + word.substring(i, i + 1) + "]";
            row++;
        }
    }

    public void showQuestion(Words words) {
        String question = words.getQuestions();
        System.out.println(question);
    }

    public void showCrossword(Crossword crossword) {
        crossword.showCrossword();
    }
}