/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

public abstract class RegressionModel {

    protected double[] xValues;
    protected double[] yValues;
    protected boolean computed; //unknown

    public RegressionModel(double[] x, double[] y) {
        this.xValues = x;
        this.yValues = y;
        computed = false;
    }

    public double[] getXValues() {
        return this.xValues;
    }

    public double[] getYValues() {
        return this.yValues;
    }

    public abstract double[] getCoefficients(); //for best fit values

    public abstract void compute(); 

    public abstract double evaluateAt(double x); //evaluate model at x
}
