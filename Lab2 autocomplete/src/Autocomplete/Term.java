package Autocomplete;

import java.util.Comparator;
import java.util.Objects;

public class Term {
	
	public long weight;
	public String query;

	// Initializes a term with the given query string and weight.
	public Term(String query, long weight) {
		if (weight < 0) {
            throw new IllegalArgumentException();
		}
		this.query = Objects.requireNonNull(query);
		this.weight = Objects.requireNonNull(weight);
	}

	// Compares the two terms in lexicographic order by query.
	public static Comparator<Term> byLexicographicOrder(){
		Comparator<Term> com = new Comparator<Term>() {
			public int compare(Term term1, Term term2) {
				if(term1.query.compareToIgnoreCase(term2.query) < 0) {
					return 1;
				}
				else {
					return -1;
				}
			}
			
		}; 
			
		return com;
	}

	// Compares the two terms in descending order by weight.
	public static Comparator<Term> byReverseWeightOrder(){
		//decending order?
		Comparator<Term> com = new Comparator<Term>() {
			public int compare(Term term1, Term term2) {
				if(term1.weight > term2.weight) {
					return 1;
				}
				else {
					return -1;
				}
			}
			
		}; 
			
		return com;
	}

	// Compares the two terms in lexicographic order,
	// but using only the first k characters of each query.
	public static Comparator<Term> byPrefixOrder(int k){
		if (k < 0) {
            throw new IllegalArgumentException();
		}
		Comparator<Term> com = new Comparator<Term>() {
			public int compare(Term term1, Term term2) {
				// Kan nog skippa att declarera Stringsen för bättre prestanda
				String term1K = term1.query.substring(0, k);
				String term2K = term2.query.substring(0, k);
				if(term1K.compareToIgnoreCase(term2K) < 0) {
					return 1;
				}
				else {
					return -1;
				}
			}
			
		}; 
			
		return com;
	}

	// Returns a string representation of this term in the following format:
	// the weight, followed by whitespace, followed by the query.
	public String toString() {
		return String.format("%12d    %s", this.weight, this.query);
	}

}
