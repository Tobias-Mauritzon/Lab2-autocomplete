package Autocomplete;

import java.util.Arrays;
import java.util.Comparator;

public class RangeBinarySearch {
	 // Returns the index of the first key in a[] that equals the search key, or -1 if no such key exists.
    // Complexity: O(log N), N = a.length.
    // @pre a is sorted.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator comparator) {
    	return Arrays.binarySearch(a, key, comparator);
    }

    // Returns the index of the last key in a[] that equals the search key, or -1 if no such key exists.
    // Complexity: O(log N), N = a.length
    // @pre a is sorted.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator comparator) {
    	return Arrays.binarySearch(a, a.length-1, 0, key, comparator);
    }
}
