// NumberOfDiscIntersections
// Compute the number of intersections in a sequence of discs.
package codility.sorting.NumberOfDiscIntersections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
	We draw N discs on a plane. The discs are numbered from 0 to N − 1. A zero-indexed array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].
	
	We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).
	
	The figure below shows discs drawn for N = 6 and A as follows:
	
	  A[0] = 1
	  A[1] = 5
	  A[2] = 2
	  A[3] = 1
	  A[4] = 4
	  A[5] = 0
	
	
	There are eleven (unordered) pairs of discs that intersect, namely:
	
	discs 1 and 4 intersect, and both intersect with all the other discs;
	disc 2 also intersects with discs 0 and 3.
	Write a function:
	
	class Solution { public int solution(int[] A); }
	that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.
	
	Given array A shown above, the function should return 11, as explained above.
	
	Assume that:
	
	N is an integer within the range [0..100,000];
	each element of array A is an integer within the range [0..2,147,483,647].
	Complexity:
	
	expected worst-case time complexity is O(N*log(N));
	expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
	Elements of input arrays can be modified. 
 */
// SOLVED Correctness 87% (times out on medium/large data set) Performance 12% Task Score 50% Detected time complexity:O(N**2)
public class Solution {

	public Solution() {
		super();
	}

	private final Map<Long, Set<Circle>> map = new HashMap<Long, Set<Circle>>();
	
	private final Set<Intersection> intersections = new HashSet<Intersection>();
	
	
	public int solution(int[] A) {
		for (int i = 0; i < A.length; i++) {
			Circle circle = new Circle(i, A[i]);
			for (long j = i - ((long)A[i]); j < i + ((long)A[i]) + 1; j++) {
				if(!map.containsKey(j)) {
					map.put(j, new HashSet<Circle>());
				}
				Set<Circle> circles = map.get(j);
				if(!circles.contains(circle)) {
					for (Circle circle2 : circles) {
						intersections.add(new Intersection(circle2, circle));
						if(intersections.size() > 10000000) {
							return -1;
						}
					}
				}
				circles.add(circle);
			}
			
		}
		return intersections.size();
	}
	private static class Intersection {
		
		private Circle left;
		
		private Circle right;
		
		public Intersection(Circle left, Circle right) {
			super();
			if(left.x < right.x) {
				this.left = left;
				this.right = right;
			}
			else {
				this.left = right;
				this.right = left;
			}
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((left == null) ? 0 : left.hashCode());
			result = prime * result + ((right == null) ? 0 : right.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Intersection other = (Intersection) obj;
			if (left == null) {
				if (other.left != null)
					return false;
			} else if (!left.equals(other.left))
				return false;
			if (right == null) {
				if (other.right != null)
					return false;
			} else if (!right.equals(other.right))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return String.format("Intersection [left=%s, right=%s]", left, right);
		}
		
	}
	private static class Circle {
		
		private final int x; 
		private final int r;
		
		public Circle(int x, int r) {
			super();
			this.x = x;
			this.r = r;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + r;
			result = prime * result + x;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Circle other = (Circle) obj;
			if (r != other.r)
				return false;
			if (x != other.x)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return String.format("Circle [x=%s, r=%s]", x, r);
		}
		
	}
}
