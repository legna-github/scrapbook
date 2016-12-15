package codility.arrays.oddoccurrencesinarray;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class SolutionTest {
	
    private int expected ;

    private int[] A;


	public SolutionTest(int expected, int[] a) {
		super();
		this.expected = expected;
		A = a;
	}

    @Parameters(name = "{index}: Solution({1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {7, new int[]{9, 3, 9, 3, 9, 7, 9}},
                {9, new int[]{2, 4, 5, 4, 6, 6, 5, 9, 2}},
        });
    }

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
	public void testSolution() {
		assertEquals(this.expected, new Solution().solution(this.A));
	}

}
