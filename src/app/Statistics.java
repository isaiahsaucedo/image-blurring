/*
Isaiah Saucedo 
Digital Image Processing
Project 1

This file contains all the required statistic operations for project one. 


*/

/**
 *
 * @author Isaiah Saucedo
 */

package app;

public class Statistics {
    public int mean;
    public int variance;
    public int dyn_range;

    // getter for mean
    public int getMean() {
        return this.mean;
    }

    // setter for mean
    public void setMean(int mean) {
        this.mean = mean;
    }

    // getter for variance
    public int getVariance() {
        return this.variance;
    }

    // setter for variance
    public void setVariance(int variance) {
        this.variance = variance;
    }

    // getter for dynamic range
    public int getDyn_range() {
        return this.dyn_range;
    }

    // setter for dynamic range
    public void setDyn_range(int dyn_range) {
        this.dyn_range = dyn_range;
    }

    // function to obtain mean
    public void meanFunction(int[] arr) {

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

        }

        int mean = sum / arr.length;

        this.setMean(mean);
    }

    // function to obtain variance
    public void varianceFunction(int[] arr, int mean) {

        int[] copy = arr;
        int sum = 0;

        for (int i = 0; i < copy.length; i++) {

            copy[i] = copy[i] - mean;

            copy[i] = copy[i] * copy[i];

            sum += copy[i];

        }

        int variance = sum / copy.length;
        this.setVariance(variance);

    }

    // function to obtain the dynamic range

    public void dynamicRangeFunction(int[] arr) {

        int start = 0;
        boolean foundStart = false;
        int end = 255;
        boolean foundEnd = false;
        int range;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                if (!foundStart){
                    start = arr[i];
                    foundStart = true; 
                    continue;

                } 

                if (foundStart && !foundEnd){
                    end = arr[i];
                    foundEnd = true;
                    
                }
            }

        }

        range = end - start;

        this.setDyn_range(range);

    }

}