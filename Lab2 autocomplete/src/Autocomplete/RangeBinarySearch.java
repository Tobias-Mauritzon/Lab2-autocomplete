package Autocomplete;

import java.util.Comparator;

public class RangeBinarySearch {
	// Returns the index of the first key in a[] that equals the search key, or -1
	// if no such key exists.
	// Complexity: O(log N), N = a.length.
	// @pre a is sorted.
	public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
		if (a == null || key == null || comparator == null) {
			throw new IllegalArgumentException();
		}

		int low = 0;
		int high = a.length - 1;
		int index = -1;

		while (low <= high) {
			int mid = (low + high) / 2;
			Key midVal = a[mid];
			int cmp = comparator.compare(key, midVal);
			if (cmp < 0) {
				low = mid + 1;
			} else if (cmp > 0) {
				high = mid - 1;
			} else if (cmp == 0) {
				if (index > mid) {
					index = mid;
				}
				high = mid - 1;
			}
		}
		return index; // key not found.
	}

	// Returns the index of the last key in a[] that equals the search key, or -1 if
	// no such key exists.
	// Complexity: O(log N), N = a.length
	// @pre a is sorted.
	public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
		if (a == null || key == null || comparator == null) {
			throw new IllegalArgumentException();
		}

		int low = 0;
		int high = a.length - 1;
		int index = -1;

		while (low <= high) {
			int mid = (low + high) / 2;
			Key midVal = a[mid];
			int cmp = comparator.compare(key, midVal);
			if (cmp < 0) {
				low = mid + 1;
			} else if (cmp > 0) {
				high = mid - 1;
			} else if (cmp == 0) {
				if (index < mid) {
					index = mid;
				}
				low = mid + 1;
			}		
		}
		return index; // key not found.
	}
}
