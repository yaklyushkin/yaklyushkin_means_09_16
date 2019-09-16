package yaklyushkin.means;

import java.math.BigInteger;

public class Means {

    public void addInt(int number) {
        this.meanSum = this.meanSum.add(BigInteger.valueOf(number));
        this.meanCount = this.meanCount.add(BigInteger.valueOf(1));

        if (this.isIntAdded) {
            if (this.minimum > number) {
                this.minimum = number;
            }
            if (this.maximum < number) {
                this.maximum = number;
            }
            this.mean = this.meanSum.divide(this.meanCount).intValue();

        } else {
            this.isIntAdded = true;
            this.mean = number;
            this.minimum = number;
            this.maximum = number;
        }
    }

    public int getMinimum() throws MeansWasNotAddedException {
        return this.getValue(ValueMode.MINIMUM);
    }

    public int getMaximum() throws MeansWasNotAddedException {
        return this.getValue(ValueMode.MAXIMUM);
    }

    public int getMean() throws MeansWasNotAddedException {
        return this.getValue(ValueMode.MEAN);
    }

    private int getValue(ValueMode mode) throws MeansWasNotAddedException {
        if (!this.isIntAdded) {
            throw this.makeMeansWasNotAddedException();
        }
        switch (mode) {
            case MINIMUM: return this.minimum;
            case MAXIMUM: return this.maximum;
            case MEAN: return this.mean;
        }
        return 0;
    }


    private MeansWasNotAddedException makeMeansWasNotAddedException() {
        return new MeansWasNotAddedException("No one number was added!");
    }

    private enum ValueMode {
        MINIMUM,
        MAXIMUM,
        MEAN
    }

    private boolean isIntAdded = false;

    private BigInteger meanSum = new BigInteger("0");
    private BigInteger meanCount = new BigInteger("0");

    private int minimum = 0;
    private int maximum = 0;
    private int mean = 0;
}
