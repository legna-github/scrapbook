package codility.timecomplexity.frogjump;

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

	int X; 
	
	int Y;
	
	int D;

	public SolutionTest(int expected, int x, int y, int d) {
		super();
		this.expected = expected;
		this.X = x;
		this.Y = y;
		this.D = d;
	}

    @Parameters(name = "{index}: Solution({1}) = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {3, 10, 75, 30},
                {2, 10, 70, 30},
                {2, 10, 65, 30},
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
		assertEquals(this.expected, new Solution().solution(this.X, this.Y, this.D));
	}

}
