package codility.prefixsums.PassingCars;

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
		assertEquals(5, new Solution().solution(new int[]{0, 1, 0, 1, 1}));
		assertEquals(1, new Solution().solution(new int[]{0, 1}));
		assertEquals(0, new Solution().solution(new int[]{1, 1}));
		assertEquals(5, new Solution().solution(new int[]{1, 1, 1, 1, 0, 1, 0, 1, 1}));
	}

}
