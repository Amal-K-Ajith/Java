/**
 * A program to see whether a sentance contains A-Z characters at least once
 * TC~O(N) SC~O(1);
 */

public class StrongSentance {
    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the lazy dog";
        System.out.println(
                "\"" + str + "\"" + (checkStrong(str) ? " is a strong sentence" : " is not a strong sentance"));
    }

    public static boolean checkStrong(String str) {
        int index = 0;
        boolean[] checked = new boolean[26];

        for (int i = 0; i < str.length(); i++) {
            if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
                index = str.charAt(i) - 'a';
            } else if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
                index = str.charAt(i) - 'A';
            }
            checked[index] = true;
        }
        for (int i = 0; i < 26; i++) {
            if (!checked[i]) {
                return false;
            }
        }
        return true;
    }

}
