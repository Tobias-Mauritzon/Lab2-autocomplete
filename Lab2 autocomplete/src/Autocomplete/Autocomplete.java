package Autocomplete;

import java.util.Arrays;

public class Autocomplete {
	private Term[] terms;

	// Initializes the data structure from the given array of terms.
	// Complexity: O(N log N), where N is the number of terms
	public Autocomplete(Term[] terms) {
		if(terms == null) {
			throw new NullPointerException();
		}
		for(Term term : terms) {
			if(term == null) {
				throw new NullPointerException();
			}
		}
		
		Arrays.sort(terms, Term.byLexicographicOrder());
		
		this.terms = terms;
	}

	// Returns all terms that start with the given prefix, in descending order of
	// weight.
	// Complexity: O(log N + M log M), where M is the number of matching terms
	public Term[] allMatches(String prefix) {
		if(prefix == null) {
			throw new NullPointerException();
		}
		Term term = new Term(prefix, 0);
		int firstIndex = RangeBinarySearch.firstIndexOf(terms, term, Term.byPrefixOrder(prefix.length()));
		//System.out.println(firstIndex);
		
		if(firstIndex >= 0) {
			
			int lastIndex = RangeBinarySearch.lastIndexOf(terms, term, Term.byPrefixOrder(prefix.length()));

			if(firstIndex == lastIndex) {
				Term[] retTerms = new Term[1];
				
				retTerms[0] = terms[firstIndex];
				return retTerms;
			}else {
				int length = lastIndex - firstIndex;
				Term[] retTerms = new Term[length];

				int i = 0;
				while (firstIndex < lastIndex) {
					retTerms[i] = terms[firstIndex];
					i++;
					firstIndex++;
				}
				Arrays.sort(retTerms, Term.byReverseWeightOrder());
				return retTerms;
			}
		}else {
			return new Term[0];
		}
		
	}

	// Returns the number of terms that start with the given prefix.
	// Complexity: O(log N)
	public int numberOfMatches(String prefix) {
		if(prefix == null) {
			throw new NullPointerException();
		}
		
		Term term = new Term(prefix, 0);
		int firstIndex = RangeBinarySearch.firstIndexOf(terms, term, Term.byPrefixOrder(prefix.length()));
		if(firstIndex < 0) {
			return 0;
		}
		else {
			int lastIndex = RangeBinarySearch.lastIndexOf(terms, term, Term.byPrefixOrder(prefix.length()));
			if (firstIndex == lastIndex) {
				return 1;
			} else {
			return lastIndex - firstIndex;
			}
		}
	}
}
