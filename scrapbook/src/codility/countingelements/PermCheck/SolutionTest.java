package codility.countingelements.PermCheck;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SolutionTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_is_a_permutation() {
		assertEquals(1, new Solution().solution(new int[]{4,1,3,2}));
	}

	@Test
	public void test_is_a_permutation_one_element() {
		assertEquals(1, new Solution().solution(new int[]{1}));
	}
	@Test
	public void test_is_not_a_permutation() {
		assertEquals(0, new Solution().solution(new int[]{4,1,3}));
	}
	@Test
	public void test_is_not_a_permutation_one_element() {
		assertEquals(0, new Solution().solution(new int[]{4}));
	}
}
