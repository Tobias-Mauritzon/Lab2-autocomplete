package Autocomplete;

import java.util.LinkedList;

public class Autocomplete {
	Term[] terms;
    // Initializes the data structure from the given array of terms.
    // Complexity: O(N log N), where N is the number of terms
    public Autocomplete(Term[] terms) {
    	this.terms = terms;
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    // Complexity: O(log N + M log M), where M is the number of matching terms
    public Term[] allMatches(String prefix) {
    	Term term = new Term(prefix, 0);
    	int firstIndex = RangeBinarySearch.firstIndexOf(terms, term, term.byLexicographicOrder());
    	int lastIndex = RangeBinarySearch.lastIndexOf(terms, term, term.byLexicographicOrder());
    	
    	int length = firstIndex - lastIndex;
    	
    	Term[] retTerms; 
    	
    	return null;
    }

    // Returns the number of terms that start with the given prefix.
    // Complexity: O(log N)
    public int numberOfMatches(String prefix)
}
