package com.glennbech.usda.model;

import java.util.List;

/**
 * Represents a point in N dimensional Space
 */
 class NPoint {

    private int dimensions;
    double[] position;

    public NPoint(int dimensions) {
        this.dimensions = dimensions;
        position = new double[dimensions];
    }

    void set(int dimension, double value) {
        position[dimension] = value;
    }

    double get(int dimension) {
        return position[dimension];
    }

    public double distanceTo(NPoint q) {

        float sum = 0;
        for (int i = 0; i < dimensions; i++) {
            sum += Math.pow(position[i] - q.get(i), 2);
        }
        return Math.abs(Math.sqrt(sum));
    }

    public void set(double... args) {
        for (int i = 0; i < args.length; i++) {
            position[i] = args[i];
        }
    }

    public void set(List<Float> nutrVals) {
        for (int i = 0; i < nutrVals.size(); i++) {
            position[i] = nutrVals.get(i);
        }
    }
}
