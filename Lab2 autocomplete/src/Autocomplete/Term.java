package Autocomplete;

import java.util.Comparator;

public class Term {
	
	public long weight;
	public String query;

	// Initializes a term with the given query string and weight.
	public Term(String query, long weight) {
		this.query = query;
		this.weight = weight;
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
	public static Comparator<Term> byPrefixOrder(int k);

	// Returns a string representation of this term in the following format:
	// the weight, followed by whitespace, followed by the query.
	public String toString() {
		return String.format("%12d    %s", this.weight, this.query);
	}

}
