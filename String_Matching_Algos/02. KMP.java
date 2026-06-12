import java.util.*;

class KMPStringMatch {
    private static void computeLPS(String pat, int[] lps) {
        int m = pat.length();

        lps[0] = 0;

        int i = 1;
        int len = 0; // max len prefix
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }
    }

    // TC: O(n+m)
    private static List<Integer> kmp(String txt, String pat) {
        List<Integer> res = new ArrayList<>();

        int n = txt.length();
        int m = pat.length();

        int[] lps = new int[m];
        computeLPS(pat, lps);

        int i = 0;
        int j = 0;
        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;

                if (j == m) {
                    res.add(i - j);
                    j = lps[j - 1];
                }
            } else {
                if (j == 0)
                    i++;
                else {
                    j = lps[j - 1];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String txt = "aabaacaadaabaaba";
        String pat = "aaba";

        System.out.println(kmp(txt, pat)); // [0, 9, 12]
    }
}