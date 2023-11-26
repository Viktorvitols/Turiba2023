public class Words {

    final String[] WORDS = {"INSTRUCTION", "LOOP", "OPERATOR", "ATTRIBUTE", "BREAK",
            "CONTINUE", "METHOD", "PACKAGE", "ARRAY", "OBJECT"};
    final String questions =
            "\n0. A line of code that tells the computer to perform a specific action.\n" +
            "1. A control structure that repeats a set of instructions until a certain condition is met.\n" +
            "2. A symbol that performs an operation on one or more operands.\n" +
            "3. A characteristic or property of an object that holds data.\n" +
            "4. A keyword used to exit from a loop or switch statement prematurely." +

            "5. A keyword that skips the rest of the loop's code and continues with the next iteration.\n" +
            "6. A function or procedure associated with an object in Java.\n" +
            "7. A way to organize related classes and interfaces in Java.\n" +
            "8. A data structure that stores elements of the same type in contiguous memory locations.\n" +
            "9. An instance of a class in Java, representing an entity.\n";

    public String[] getAllWords() {
        return WORDS;
    }

    public String getQuestions() {
        return questions;
    }
}
