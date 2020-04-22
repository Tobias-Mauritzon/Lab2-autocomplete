package Autocomplete;

import java.util.Arrays;

public class Autocomplete {
	Term[] terms;
    // Initializes the data structure from the given array of terms.
    // Complexity: O(N log N), where N is the number of terms
    public Autocomplete(Term[] terms) {
    	this.terms = terms;
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    // Complexity: O(log N + M log M), where M is the number of matching terms
    public Term[] allMatches(String prefix){
    	Term term = new Term(prefix, 0);
    	int firstIndex = RangeBinarySearch.firstIndexOf(terms, term, Term.byPrefixOrder(prefix.length()));
    	int lastIndex = RangeBinarySearch.lastIndexOf(terms, term, Term.byPrefixOrder(prefix.length()));
    	
    	//Checka om last first samma
    	//Om man inte får tillbaka något
    	int length = lastIndex - firstIndex;
    	
    	Term[] retTerms = new Term[length];
    	
    	int i = 0;
    	while(firstIndex <= lastIndex) {
    		retTerms[i] = terms[firstIndex];
    		i++;
    		firstIndex++;
    	}
    	Arrays.sort(retTerms, Term.byReverseWeightOrder());
    	return retTerms;
    }

    // Returns the number of terms that start with the given prefix.
    // Complexity: O(log N)
    public int numberOfMatches(String prefix) {
    	return 0;
    }
}
