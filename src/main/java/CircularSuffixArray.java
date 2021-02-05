import edu.princeton.cs.algs4.Merge;
import jdk.internal.net.http.common.Pair;

import java.util.HashMap;

public class CircularSuffixArray {
    private final int n;
    private Suffix[] suffixes;
    private int[] index;

    // circular suffix array of s
    public CircularSuffixArray(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        this.n = s.length();
        this.suffixes = new Suffix[n];
        for (int i = 0; i < n; i++) {
            suffixes[i] = new Suffix(s, i);
        }

        Merge.sort(suffixes);
        this.index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = suffixes[i].getIndex();
        }
    }


    // length of s
    public int length() {
        return n;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i > this.n - 1) {
            throw new IllegalArgumentException();
        }
        return index[i];
    }

    private class Suffix implements Comparable<Suffix> {
        private String s;
        private final int index;

        private Suffix(String s, int index) {
            if (s == null) {
                throw new IllegalArgumentException();
            }
            if (index < 0) {
                throw new IllegalArgumentException();
            }
            if (index > n) {
                throw new IllegalArgumentException();
            }
            this.s = s;
            this.index = 0;
        }

        public int getIndex() {
            return index;
        }

        public int compareTo(Suffix that) {
            if (that == null) {
                throw new IllegalArgumentException();
            }
            if (this == that) {
                return 0;
            }
            int n = this.s.length();
            for (int i = 0; i < n; i++) {
                char chThis = s.charAt((this.index + i) % n);
                char chThat = s.charAt((that.index + i) % n);
                if (chThis < chThat) {
                    return -1;
                }
                if (chThis > chThat) {
                    return 1;
                }
            }
            return 0;
        }
    }


    // unit testing (required)
    public static void main(String[] args) {
    }
}
