/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

/**
 *
 * @author Parth
 * @modified prane
 */
public class LinearRegressionModel extends RegressionModel {

    private double a; // y intercept
    //eg y = mx+c
    private double b; //slope of line

    public LinearRegressionModel(double[] x, double[] y) {
        super(x, y);
        a = b = 0;
    }

    @Override
    public double[] getCoefficients() {
        if (!computed) {
            throw new IllegalStateException("Model has not yet computed");
        }

        return new double[]{a, b};
    }

    @Override
    public void compute() { //best fitting line

        if (xValues.length < 2 | yValues.length < 2) {
            throw new IllegalArgumentException("Must have more than two values");
        }

        //b = cov[x,y] / var[x]
        b = MathFormula.covariance(xValues, yValues) / MathFormula.variance(xValues);

//formula a = ybar + b * xbar
        a = MathFormula.mean(yValues) - b * MathFormula.mean(xValues);

        computed = true;
    }

    @Override
    public double evaluateAt(double x) { //at a particular position
        if (!computed) {
            throw new IllegalStateException("Model has not yet computed");
        }

        return a + b * x;
    }
}
