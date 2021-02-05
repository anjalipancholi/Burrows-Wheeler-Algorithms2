
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {

    // apply move-to-front encoding, reading from standard input and writing to standard output
    public static void encode() {
        char[] alphabets = new char[256];
        // Initializing the sequence by making the ith character in the sequence equal to the ith ASCII character
        for (int i = 0; i < alphabets.length; i++) {
            alphabets[i] = (char) i;
        }
        while (!BinaryStdIn.isEmpty()) {
            char ch = BinaryStdIn.readChar();
            int index = -1;
            for (int i = 0; alphabets[i] != ch; i++) {
                index = i;
            }
            index++;

            BinaryStdOut.write((char) index);

            //Move character to the front
            for (int i = index; i - 1 >= 0; i--) {
                char temp = alphabets[i - 1];
                alphabets[i - 1] = alphabets[i];
                alphabets[i] = temp;
            }
        }
        BinaryStdOut.close();
    }

    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode() {
        char[] alphabets = new char[256];
        for (int i = 0; i < alphabets.length; i++) {
            alphabets[i] = (char) i;
        }
        while (!BinaryStdIn.isEmpty()) {
            int index = BinaryStdIn.readChar();
            BinaryStdOut.write(alphabets[index]);

            //Move character to the front
            for (int i = index; i - 1 >= 0; i--) {
                char temp = alphabets[i - 1];
                alphabets[i - 1] = alphabets[i];
                alphabets[i] = temp;
            }
        }
        BinaryStdOut.close();
    }

    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args) {
        if (args[0].equals("-")) {
            encode();
        } else if (args[0].equals("+")) {
            decode();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
