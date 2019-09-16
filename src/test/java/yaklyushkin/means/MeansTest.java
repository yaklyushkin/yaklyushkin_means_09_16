package yaklyushkin.means;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import yaklyushkin.means.Means;
import yaklyushkin.means.MeansWasNotAddedException;

import org.junit.jupiter.api.Test;

public class MeansTest {

    private static int INT_MAX_VALUE = 2147483647;

    @Test()
    public void errorOnNotAddedNumberRequestTest() {
        Means means = new Means();
        MeansWasNotAddedException exception =
                assertThrows(
                        MeansWasNotAddedException.class,
                        () -> means.getMean(),
                        "nothing");
        assertEquals("No one number was added!", exception.getMessage());
    }

    @Test()
    public void oneNumberAddedTest() throws MeansWasNotAddedException {
        Means means = new Means();
        means.addInt(2);
        assertEquals(2, means.getMinimum());
        assertEquals(2, means.getMaximum());
        assertEquals(2, means.getMean());
    }

    @Test()
    public void simpleTest() throws MeansWasNotAddedException {
        Means means = new Means();

        means.addInt(2);
        means.addInt(-2);
        assertEquals(-2, means.getMinimum());
        assertEquals(2, means.getMaximum());
        assertEquals(0, means.getMean());

        means.addInt(3);
        assertEquals(-2, means.getMinimum());
        assertEquals(3, means.getMaximum());
        assertEquals(1, means.getMean());
    }

    @Test()
    public void addSeveralIntMaxValuesTest() throws MeansWasNotAddedException {
        Means means = new Means();

        for (int i = 0; i < 100; ++i) {
            means.addInt(this.INT_MAX_VALUE);
        }

        assertEquals(this.INT_MAX_VALUE, means.getMinimum());
        assertEquals(this.INT_MAX_VALUE, means.getMaximum());
        assertEquals(this.INT_MAX_VALUE, means.getMean());
    }
}
