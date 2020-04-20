package Autocomplete;

public class Term {
	
	private long weight;
	private String query;

	// Initializes a term with the given query string and weight.
	public Term(String query, long weight) {
		this.query = query;
		this.weight = weight;
	}

	// Compares the two terms in lexicographic order by query.
	public static Comparator<Term> byLexicographicOrder(){
		
	}

	// Compares the two terms in descending order by weight.
	public static Comparator<Term> byReverseWeightOrder();

	// Compares the two terms in lexicographic order,
	// but using only the first k characters of each query.
	public static Comparator<Term> byPrefixOrder(int k);

	// Returns a string representation of this term in the following format:
	// the weight, followed by whitespace, followed by the query.
	public String toString() {
		return String.format("%12d    %s", this.weight, this.query);
	}

}
