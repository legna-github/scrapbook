package codility.iterations.binarygap;

import static org.junit.Assert.*;

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

    private int N;

    public SolutionTest(int expected, int n) {
		super();
		this.expected = expected;
		N = n;
	}

    @Parameters(name = "{index}: Solution({1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {2, 9},
                {4, 529},
                {1, 20},
                {0, 15},
                {0, 0},
                {5, 1041}
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
		assertEquals(this.expected, new Solution().solution(this.N));
	}

}
