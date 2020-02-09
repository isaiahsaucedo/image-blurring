/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author mahmoud
 */
public class HistogramOps {
    private int maxCount;
    
    public int[] createHistogram(byte[][] gray_Image) {
        int[] histogram = new int[256];
        for (int i = 0; i < gray_Image.length; i++) {
            for (int j = 0; j < gray_Image[0].length; j++) {
                histogram[(gray_Image[i][j] & 0xff)]++;
            }
        }
        return histogram;
    }
    
    public int maxCount (int[] histogram) 
    {
            maxCount=histogram[0];
            for (int j = 0; j < histogram.length; j++) 
            {
                if (histogram[j] >= maxCount)
                    maxCount =histogram[j];
            }
            return maxCount;
    }
    

    public void printHistogram(int[] histogram, byte[][] gray_Image) {
        int total = 0;
        for (int i = 0; i < histogram.length; i++) {
            System.out.println("Count at i " + i + "is : " + histogram[i]);
            total += histogram[i];
        }
        System.out.println("Total Count (regular or normalized) is : " + total);
        System.out.println("Image size is " + gray_Image.length * gray_Image[0].length);
    }

    public int[]  scaledImageHistogram(int[] originalhist, int maxcount) {
        int[] scaledHistogram = new int[256];
        float alpha = (float) 255 / maxcount;
        for (int i = 0; i < scaledHistogram.length; i++) {
            scaledHistogram[i] = 0;
        }
        for (int i = 0; i < scaledHistogram.length; i++) {
            scaledHistogram[i] = (int) (originalhist[i] * alpha);
            if (scaledHistogram[i] > 255) {
                scaledHistogram[i] = 255;
            }
            if (scaledHistogram[i] < 0) {
                scaledHistogram[i] = 0;
            }
        }
        return scaledHistogram;
    }

    public byte[][] createHistoImage(int[] scaledHistogram) {
        byte[][] histogramImage = new byte[256][256];
        for (int j = 0; j < scaledHistogram.length; j++) {
            for (int i = 255 - scaledHistogram[j]; i < histogramImage.length; i++) {
                histogramImage[i][j] = (byte) 255;
            }
        }
        return histogramImage;
    }

    /**
     * @return the maxCount
     */
    public int getMaxCount() {
        return maxCount;
    }

    /**
     * @param maxCount the maxCount to set
     */
    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

}
