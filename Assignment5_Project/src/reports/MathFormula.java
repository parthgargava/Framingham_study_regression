/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

/**
 *
 * @author Parth
 */
public class MathFormula {

    public static double covariance(double[] x, double[] y) {

        double xmean = mean(x); //it will be calculating means
        double ymean = mean(y);

        double result = 0;

        for (int i = 0; i < x.length; i++) {

            result += (x[i] - xmean) * (y[i] - ymean); //(x- xbar)
        }

        result /= x.length - 1;

        return result;
    }

    public static double mean(double[] data) {
        double sum = 0;

        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }

        return sum / data.length;

    }

    public static double variance(double[] data) {

        double mean = mean(data);

        double sumOfSquaredDeviations = 0;

        for (int i = 0; i < data.length; i++) {

            sumOfSquaredDeviations += Math.pow(data[i] - mean, 2);
        }

        return sumOfSquaredDeviations / (data.length - 1); //least square
    }

}
