package codility.prefixsums.GenomicRangeQuery;

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
		assertArrayEquals(new int[]{2,4,1,2}, new Solution().solution("CAGCCTA", new int[]{2, 5, 0, 3}, new int[]{4, 5, 6, 4}));
		assertArrayEquals(new int[]{2,2,2}, new Solution().solution("CCCCCCCCCC", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
	}

}
