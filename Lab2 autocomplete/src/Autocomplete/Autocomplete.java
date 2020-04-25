package Autocomplete;

import java.util.Arrays;

public class Autocomplete {
	private Term[] terms;

	// Initializes the data structure from the given array of terms.
	// Complexity: O(N log N), where N is the number of terms
	public Autocomplete(Term[] terms) {

		try {
			Arrays.sort(terms, Term.byLexicographicOrder());

			this.terms = terms;

		} catch (NullPointerException e) {
			throw e;
		}
	}

	// Returns all terms that start with the given prefix, in descending order of
	// weight.
	// Complexity: O(log N + M log M), where M is the number of matching terms
	public Term[] allMatches(String prefix) {
		if (prefix == null) {
			throw new NullPointerException();
		}
		Term term = new Term(prefix, 0);
		int firstIndex = RangeBinarySearch.firstIndexOf(terms, term, Term.byPrefixOrder(prefix.length()));

		if (firstIndex >= 0) {

			int lastIndex = RangeBinarySearch.lastIndexOf(terms, term, Term.byPrefixOrder(prefix.length()));
			int length = lastIndex - firstIndex + 1;
			Term[] retTerms = new Term[length];

			int i = 0;
			while (firstIndex <= lastIndex) {
				retTerms[i] = terms[firstIndex];
				i++;
				firstIndex++;
			}
			Arrays.sort(retTerms, Term.byReverseWeightOrder());
			return retTerms;

		} else {
			return new Term[0];
		}

	}

	// Returns the number of terms that start with the given prefix.
	// Complexity: O(log N)
	public int numberOfMatches(String prefix) {
		if (prefix == null) {
			throw new NullPointerException();
		}

		Term term = new Term(prefix, 0);
		int firstIndex = RangeBinarySearch.firstIndexOf(terms, term, Term.byPrefixOrder(prefix.length()));
		if (firstIndex < 0) {
			return 0;
		} else {
			int lastIndex = RangeBinarySearch.lastIndexOf(terms, term, Term.byPrefixOrder(prefix.length()));
			return lastIndex - firstIndex + 1;
		}
	}
}
