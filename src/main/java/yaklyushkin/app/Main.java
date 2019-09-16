package yaklyushkin.app;

import yaklyushkin.means.Means;
import yaklyushkin.means.MeansWasNotAddedException;

public class Main {

    public static void main(String[] args) throws MeansWasNotAddedException {
        Means means = new Means();

        means.addInt(1);
        System.out.println();
        System.out.println(String.valueOf(means.getMinimum()));

        /* Здесь возможно попробовать по желанию что-нибудь посчитать */
    }
}
