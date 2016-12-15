package codility.arrays.cyclicrotation;

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

    private int[] expected ;

    private int[] A;

    private int K;
    
    
    
	public SolutionTest(int[] expected, int[] a, int k) {
		super();
		this.expected = expected;
		A = a;
		K = k;
	}

    @Parameters(name = "{index}: Solution({1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{9, 7, 6, 3, 8}, new int[]{3, 8, 9, 7, 6}, 3},
                {new int[]{-9, 0}, new int[]{-9, 0}, 2},
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
	public void test() {
		int[] solution = new Solution().solution(A, K);
		assertArrayEquals(expected, solution);
	}

}
