package codility.countingelements.MissingInteger;

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
	public void test_missing_5() {
		assertEquals(5, new Solution().solution(new int[]{1,3,6,4,1,2}));
	}

	@Test
	public void test_missing_1() {
		assertEquals(1, new Solution().solution(new int[]{4}));
	}

	@Test
	public void test_missing_3() {
		assertEquals(3, new Solution().solution(new int[]{1,2,1,2,4}));
	}

	@Test
	public void test_nothing_missing() {
		assertEquals(4, new Solution().solution(new int[]{1,2,3}));
	}
}
