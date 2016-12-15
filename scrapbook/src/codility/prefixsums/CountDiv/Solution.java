// CountDiv
// Compute number of integers divisible by k in range [a..b].
package codility.prefixsums.CountDiv;

/*
	Write a function:
	
	class Solution { public int solution(int A, int B, int K); }
	that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
	
	{ i : A ≤ i ≤ B, i mod K = 0 }
	For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
	
	Assume that:
	
	A and B are integers within the range [0..2,000,000,000];
	K is an integer within the range [1..2,000,000,000];
	A ≤ B.
	Complexity:
	
	expected worst-case time complexity is O(1);
	expected worst-case space complexity is O(1).
 */
public class Solution {

	public Solution() {
		super();
	}

	public int solution(int A, int B, int K) {
		// Correctness 50% Performance 100% Task score 75%
        // return (B - A) / K + ((A % K == 0)? 1 : 0);
		return (B/K - A/K) + ((A % K == 0)? 1 : 0);
	}
}
/*
	just generalizing the question 'How many (natural) numbers between A and B are divisible by B?' (number of integers within [A..B] that are divisible by C)
	
	Division (a/b=c) by definition - taking a set of size a and forming groups of size b. The number of groups of this size that can be formed, c, is the quotient of a and b. - is nothing more than the number of integers within range/interval ]0..a] (not including zero, but including a) that are divisible by b.
	
	so:
	B/C - number of integers within ]0..B] that are divisible by C
	so the answer to the initial question is the number
	
	A/C - number of integers within ]0..A] that are divisible by C
	so the answer to the initial question is the number
	
	
	result = [B/C] - [A/C] + x (where x = 1 if and only if A is divisible by C - as the given range [A..B] includes A, otherwise 0)
	         = [300/12] - [100/12] + 0 = 25 - 8 + 0 = 17
 */
