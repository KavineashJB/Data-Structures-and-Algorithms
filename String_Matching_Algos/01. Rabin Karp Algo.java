import java.util.*;

class RabinKarp {
    private static final int d = 256;
    private static final int q = 101;

    // TC: O(n*m)
    // SC: O(1)
    public static List<Integer> naive(String txt, String pat) {
        List<Integer> res = new ArrayList<>();

        int n = txt.length();
        int m = pat.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            for (; j < m; j++) {
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
            }
            if (j == m) {
                res.add(i);
            }
        }
        return res;
    }

    // TC: O(n*m) m-> due to following StringBuilder overhead
    // deleteCharAt(0) is O(M)
    // sb.toString() is O(M)
    // .equals() is O(M)
    // SC: O(M)
    public static List<Integer> slidingWindow(String txt, String pat) {
        List<Integer> res = new ArrayList<>();

        int n = txt.length();
        int m = pat.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(pat.charAt(i));
        }

        if (pat.equals(sb.toString()))
            res.add(0);

        int j = 1;
        for (int i = m; i < n; i++) {

            sb.deleteCharAt(0);
            sb.append(txt.charAt(i));

            if (pat.equals(sb.toString())) {
                res.add(j);
            }

            j++;
        }

        return res;
    }

    // Math.pow() overhead
    public static void MyRabinKarp(String txt, String pat) {

        List<Integer> res = new ArrayList<>();

        int n = txt.length();
        int m = pat.length();

        // since all are lowercase, base is 26
        // if all upper, lower, spe chars then base will be 127

        int p = 0, t = 0;
        for (int i = 0; i < m; i++) {
            p += (pat.charAt(i) * Math.pow(10, m - i - 1));
            t += (txt.charAt(i) * Math.pow(10, m - i - 1));
        }

        System.out.println("p-code:  " + p);
        System.out.println("t-code:  " + t);
        for (int i = m; i < n; i++) {
            // if executes continuously then it's called spurious Hit.
            // Then worst case become TC:O(n*m) -> to avoid this we've to use strong
            // hash-function
            if (p == t) {
                int txtInd = i - m;
                int patInd = 0;
                while (patInd < m && txt.charAt(txtInd) == pat.charAt(patInd)) {
                    txtInd++;
                    patInd++;
                }
                if (patInd == m) {
                    res.add(i - m);
                }
            }

            t = (t - (txt.charAt(i - m) * (int) Math.pow(10, m - 1))) * 10 + txt.charAt(i);
            System.out.println("new t: " + t);
        }
        System.out.println(res);
    }

    // TC: avg-O(n+m)
    // TC: very worst-O(nm)
    public static List<Integer> rabinKarp(String txt, String pat) {
        List<Integer> res = new ArrayList<>();

        int n = txt.length();
        int m = pat.length();

        int p = 0, t = 0, h = 1;

        // max pow value
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        for (int i = 0; i < m; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        System.out.println("pat-code: " + p);
        System.out.println("txt-code: " + t);

        for (int i = 0; i <= n - m; i++) {
            if (p == t) {
                boolean isMatch = true;
                for (int j = 0; j < m; j++) {
                    if (pat.charAt(j) != txt.charAt(i + j)) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    res.add(i);
                }
            }
            // next hash code - rolling hash
            // we don't need to calcualte rooling hash for the last substr
            if (i < n - m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;

                if (t < 0) {
                    t = t + q;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String txt = "aabaaaabaaabaabaa";
        String pat = "aabaa";

        // op: [0,5,9,12]
        // System.out.println(naive(txt, pat));
        // System.out.println(slidingWindow(txt, pat));

        // Approach- Worst-Case TC- Average-Case TC- Auxiliary Space
        // naive()- O(N×M)- O(N) (Fails fast)- O(1)
        // slidingWindow()- O(N×M)- O(N×M) (Heavy object overhead)- O(M)

        System.out.println(rabinKarp(txt, pat));
    }
}