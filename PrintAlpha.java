/**
    *This class is just used to printwords or characters in a pixelated manner where useing a character as the pixel it
    *could be '@','#' extra use it while initialising the constructor. then call the method:
    *   print(str)      ------  Prints vertically
    *   printLine(str)  -----   Prints horizontally
    *   printSentence(str)----  Prints in line with 4 words per line 
    *The current made array only stores the capital alphabet(A-Z) symbols not even printed
**/

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintAlpha {

    final private static int[][][] a = {
            { { 2 }, { 1, 3 }, { 0, 4 }, { 0, 4 }, { 0, 1, 2, 3, 4 }, { 0, 4 }, { 0, 4 } },
            { { 0, 1, 2, 3 }, { 0, 4 }, { 0, 4 }, { 0, 1, 2, 3 }, { 0, 4 }, { 0, 4 }, { 0, 1, 2, 3 } },
            { { 1, 2, 3 }, { 0, 4 }, { 0 }, { 0 }, { 0 }, { 0, 4 }, { 1, 2, 3, } },
            { { 0, 1, 2, 3 }, { 0, 4 }, { 0, 4 }, { 0, 4 }, { 0, 4 }, { 0, 4 }, { 0, 1, 2, 3, } },
            { { 0, 1, 2, 3, 4 }, { 0 }, { 0 }, { 0, 1, 2, 3, 4 }, { 0 }, { 0 }, { 0, 1, 2, 3, 4 } },
            { { 0, 1, 2, 3, 4 }, { 0 }, { 0 }, { 0, 1, 2, 3, 4 }, { 0 }, { 0 }, { 0 } },
            { { 1, 2, 3, 4 }, { 0 }, { 0 }, { 0, 2, 3, 4 }, { 0, 4 }, { 0, 4 }, { 1, 2, 3 } },
            { { 0, 4 }, { 0, 4 }, { 0, 4 }, { 0, 1, 2, 3, 4 }, { 0, 4 }, { 0, 4 }, { 0, 4 } },
            { { 0, 1, 2, 3, 4 }, { 2 }, { 2 }, { 2 }, { 2 }, { 2 }, { 0, 1, 2, 3, 4 } },
            { { 0, 1, 2, 3, 4 }, { 2 }, { 2 }, { 2 }, { 2 }, { 2 }, { 0, 1 } },
            { { 0, 4 }, { 0, 3 }, { 0, 2 }, { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 } },
            { { 0 }, { 0 }, { 0 }, { 0 }, { 0 }, { 0 }, { 0, 1, 2, 3, 4 } },
            { { 0, 4 }, { 0, 1, 3, 4 }, { 0, 2, 4 }, { 0, 4 }, { 0, 4 }, { 0, 4 }, { 0, 4 } },
            { { 0, 4 }, { 0, 1, 4 }, { 0, 2, 4 }, { 0, 2, 4 }, { 0, 2, 4 }, { 0, 3, 4 }, { 0, 4 } },
            { { 1, 2, 3, }, { 0, 4 }, { 0, 4 }, { 0, 4 }, { 0, 4 }, { 0, 4 }, { 1, 2, 3 } },
            { { 0, 1, 2, 3, }, { 0, 4 }, { 0, 4 }, { 0, 1, 2, 3 }, { 0 }, { 0 }, { 0 } },
            { { 1, 2, 3, }, { 0, 4 }, { 0, 4 }, { 0, 4 }, { 0, 2, 4 }, { 0, 3, 4 }, { 1, 2, 3, } },
            { { 0, 1, 2, 3, }, { 0, 4 }, { 0, 4 }, { 0, 1, 2, 3 }, { 0, 2 }, { 0, 3 }, { 0, 4, } },
            { { 1, 2, 3, }, { 0, 4 }, { 0 }, { 1, 2, 3 }, { 4 }, { 0, 4 }, { 1, 2, 3 } },
            { { 0, 1, 2, 3, 4 }, { 2 }, { 2 }, { 2 }, { 2 }, { 2 }, { 2 } },
            { { 0, 4 }, { 0, 4 }, { 0, 4 }, { 0, 4 }, { 0, 4 }, { 0, 4 }, { 1, 2, 3 } },
            { { 0, 4 }, { 0, 4 }, { 0, 4 }, { 0, 4 }, { 0, 4 }, { 1, 3 }, { 2 } },
            { { 0, 4 }, { 0, 4 }, { 0, 4 }, { 0, 2, 4 }, { 0, 1, 3, 4 }, { 0, 1, 3, 4 }, { 0, 4 } },
            { { 0, 4 }, { 0, 4 }, { 1, 3 }, { 2, }, { 1, 3, }, { 0, 4, }, { 0, 4 } },
            { { 0, 4 }, { 0, 4 }, { 0, 4 }, { 1, 3 }, { 2 }, { 2 }, { 2 } },
            { { 0, 1, 2, 3, 4 }, { 4 }, { 3 }, { 2 }, { 1 }, { 0 }, { 0, 1, 2, 3, 4 } }
    };
    private char ch = '@';

    public PrintAlpha(char c) {
        ch = c;
    }

    public PrintAlpha() {

    }

    public static void main(String[] args) {
        PrintAlpha a = new PrintAlpha();
        a.printLine("Hello");
        a.print("Hello");
        a.printSentence("Hello there my whole world frineds");
    }

    // Private method
    synchronized private void print(int c[][]) {
        for (int i = 0; i < 7; i++) {
            int m = 0;
            for (int k : c[i]) {
                for (int j = m; j < 5; j++) {
                    if (k == j) {
                        System.out.print(ch + " ");
                        m = j + 1;
                        break;
                    } else
                        System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // PRinting vertically
    synchronized public void print(String str) {
        str = str.toUpperCase();
        char c[] = str.toCharArray();
        for (char chr : c) {
            if ((chr < 'A' || chr > 'Z') && chr != ' ')
                continue;
            if (chr == ' ') {
                space();
                continue;
            }
            print(a[chr - 65]);
        }
    }

    // Special Case for only Space
    synchronized public void space() {
        for (int i = 0; i < 7; i++)
            System.out.println();
    }

    // Printing in Multiple lines
    synchronized public void printSentence(String str) {

        Pattern p = Pattern.compile(" ");
        Matcher m = p.matcher(str);
        ArrayList<String> sr = new ArrayList<>();
        int i = 0, st = 0;
        while (m.find()) {
            i++;
            if (i >= 4) {
                sr.add(str.substring(st, m.start()));
                st = m.start() + 1;
                i = 0;
            }
        }
        sr.add(str.substring(st, str.length()));
        for (String s : sr)
            printLine(s);
    }

    // Printing in a straight line
    synchronized public void printLine(String str) {

        str = str.toUpperCase();
        char c1[] = str.toCharArray();
        for (int i = 0; i < 7; i++) {
            for (char c : c1) {
                if (c >= 'A' && c <= 'Z') {
                    int alpha[] = a[c - 65][i];
                    int m = 0, j = 0;
                    for (int al : alpha) {
                        for (j = m; j < 5; j++) {
                            if (al == j) {
                                System.out.print(ch + " ");
                                m = j + 1;
                                break;
                            } else
                                System.out.print("  ");
                        }
                    }
                    if (j < 5) {
                        for (; j < 5; j++)
                            System.out.print("  ");
                    }
                }
                if (c == ' ') {
                    for (int k = 0; k < 3; k++) {
                        System.out.print("   ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println("\n");
    }
}
