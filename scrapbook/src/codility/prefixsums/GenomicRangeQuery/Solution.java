// GenomicRangeQuery
// Find the minimal nucleotide from a range of sequence DNA.
package codility.prefixsums.GenomicRangeQuery;


/*
 A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?

 The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).

 For example, consider string S = CAGCCTA and arrays P, Q such that:

 P[0] = 2    Q[0] = 4
 P[1] = 5    Q[1] = 5
 P[2] = 0    Q[2] = 6
 The answers to these M = 3 queries are as follows:

 The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
 The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
 The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.
 Write a function:

 class Solution { public int[] solution(String S, int[] P, int[] Q); }
 that, given a non-empty zero-indexed string S consisting of N characters and two non-empty zero-indexed arrays P and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all queries.

 The sequence should be returned as:

 a Results structure (in C), or
 a vector of integers (in C++), or
 a Results record (in Pascal), or
 an array of integers (in any other programming language).
 For example, given the string S = CAGCCTA and arrays P, Q such that:

 P[0] = 2    Q[0] = 4
 P[1] = 5    Q[1] = 5
 P[2] = 0    Q[2] = 6
 the function should return the values [2, 4, 1], as explained above.

 Assume that:

 N is an integer within the range [1..100,000];
 M is an integer within the range [1..50,000];
 each element of arrays P, Q is an integer within the range [0..N − 1];
 P[K] ≤ Q[K], where 0 ≤ K < M;
 string S consists only of upper-case English letters A, C, G, T.
 Complexity:

 expected worst-case time complexity is O(N+M);
 expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 Elements of input arrays can be modified.
 */
// SOLVED 100%
public class Solution {

	private final int number_of_nucleotides = "ACGT".length();

	private final int impact_array_index_adjustment = 1;
	
	private final int lower_bound_adjustment = 1;

	public Solution() {
		super();
	}

	public int[] solution(final String sequence_dna, final int[] query_lower_bounds, final int[] query_upper_bounds) {

		int[][] counters = buildCountersMatrix(sequence_dna);

		// find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] 
		int[] result = new int[query_upper_bounds.length];
		for (int i = 0; i < query_upper_bounds.length; i++) {
			int p = query_lower_bounds[i];
			int q = query_upper_bounds[i];
			for (int counter = 0; counter < number_of_nucleotides; counter++) {
				if (counters[counter][p] != counters[counter][q + lower_bound_adjustment]) {
					result[i] = counter + impact_array_index_adjustment;
					break;
				}
			}
		}

		return result;
	}

	private int[][] buildCountersMatrix(final String sequence_dna) {

		// for each nucleotide build and array counters marking the positions where the given nucleotide is found on the S string - 
		// a counter of how many times a given nucleotide has been encounter up to a certain position 
		// to include the lower bound and extra element has been added to each array thus  
/*
		p,q		0  1  2  3  4  5  6  7  8  9  0  1  2  3  4  5  6  7  8  9  0  1  2  3  4
		[		A  C  C  G  G  G  T  T  T  T  G  G  G  C  C  A  C  C  G  G  G  T  T  T  T
		1:A	[0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2], 
		2:C	[0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 4, 4, 5, 6, 6, 6, 6, 6, 6, 6, 6], 
		3:G	[0, 0, 0, 0, 1, 2, 3, 3, 3, 3, 3, 4, 5, 6, 6, 6, 6, 6, 6, 7, 8, 9, 9, 9, 9, 9], 
		4:T	[0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 6, 7, 8]
		ix:	 0  1  2  3  4  5  6  7  8  9  0  1  2  3  4  5  6  7  8  9  0  1  2  3  4  5
		]
 */		

		int length = sequence_dna.length() + lower_bound_adjustment;
		
		int[][] counters = new int[number_of_nucleotides][length];
		
		for (int i = 0 + lower_bound_adjustment; i < length; i++) {
			for (int counter = 0; counter < number_of_nucleotides; counter++) {
				counters[counter][i] = counters[counter][i - 1];
			}
			int counter = impact(sequence_dna.charAt(i - lower_bound_adjustment)) - impact_array_index_adjustment;
			counters[counter][i]++;
		}
		return counters;
	}

	// returns the impact factor of a given nucleotide represented by char 'ch'
	private static int impact(char ch) {
		switch (ch) {
		case 'A':
			return 1;
		case 'C':
			return 2;
		case 'G':
			return 3;
		case 'T':
			return 4;
		}
		throw new IllegalArgumentException(String.format("impact(%s)", ch));
	}
}
