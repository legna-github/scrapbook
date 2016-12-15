package codility.sorting.MaxProductOfThree;

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
	public void test() {
		assertEquals(60, new Solution().solution(new int[]{-3, 1, 2, -2, 5, 6}));
		assertEquals(-6, new Solution().solution(new int[]{-3, 1, 2}));
	}

}
