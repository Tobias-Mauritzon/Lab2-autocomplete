package Autocomplete;

public class RangeBinarySearch {
	 // Returns the index of the first key in a[] that equals the search key, or -1 if no such key exists.
    // Complexity: O(log N), N = a.length.
    // @pre a is sorted.
    public static int firstIndexOf(Key[] a, Key key, Comparator comparator);

    // Returns the index of the last key in a[] that equals the search key, or -1 if no such key exists.
    // Complexity: O(log N), N = a.length
    // @pre a is sorted.
    public static int lastIndexOf(Key[] a, Key key, Comparator comparator);
}
