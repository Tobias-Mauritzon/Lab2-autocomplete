package Autocomplete;

import java.util.Arrays;
import java.util.Comparator;

public class RangeBinarySearch {
	// Returns the index of the first key in a[] that equals the search key, or -1
	// if no such key exists.
	// Complexity: O(log N), N = a.length.
	// @pre a is sorted.
	public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
		if(a == null || key == null || comparator == null) {
			throw new IllegalArgumentException();
		}
			
		int ret = Arrays.binarySearch(a, key, comparator);
		if (ret < 0) {
			return -1;
		} else {
			return ret;
		}

	}

	// Returns the index of the last key in a[] that equals the search key, or -1 if
	// no such key exists.
	// Complexity: O(log N), N = a.length
	// @pre a is sorted.
	public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
		if(a == null || key == null || comparator == null) {
			throw new IllegalArgumentException();
		}
		//return Arrays.binarySearch(a, a.length - 1, 0, key, comparator);
		
		//private static <T> int binarySearch0(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c) {
			
			int low = 0;
			int high = a.length - 1;
			
			while (low <= high) {
				int mid = (low + high) >>> 1;
				Key midVal = a[mid];
				int cmp = comparator.compare(midVal, key);
				if (cmp < 0)
					low = mid + 1;
				else if (cmp > 0)
					high = mid - 1;
				else
					return mid; // key found
			}
			return -(low + 1);  // key not found.
		
		
	}
}
