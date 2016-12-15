package codility.prefixsums.CountDiv;

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
		assertEquals(3, new Solution().solution(6, 11, 2));
		assertEquals(3, new Solution().solution(5, 11, 2));
		assertEquals(4, new Solution().solution(6, 12, 2));
		assertEquals(4, new Solution().solution(5, 12, 2));
	}

}
