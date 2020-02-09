/*
Isaiah Saucedo 
Digital Image Processing
Project 1

This project demonstrates how we can utilize and apply the utility functions provided by Dr. Mahmoud K. Quweider in
ImageIo.java and HistogramOps.java. Statistic operations are done via Statistics.java. The operations are tested with the "UTB.jpg" image provided in lab one.
The project also contains Blur.java that takes in an image and outputs the 
*/

/**
 *
 * @author Isaiah Saucedo
 */
package app;

import java.awt.image.BufferedImage;

public class App {
    public static void main(String[] args) throws Exception {

        // read in image
        BufferedImage inImage = ImageIo.readImage("UTB.jpg");


        //convert to grayscale
        BufferedImage grayImage = ImageIo.toGray(inImage);


        //obtain byte arrays 
        byte[][] byteData = ImageIo.getGrayByteImageArray2DFromBufferedImage(grayImage);


        // create histogram
        HistogramOps hist = new HistogramOps();
        int[] histogram = hist.createHistogram(byteData);


        // uncomment verify histogram by using print funct
       // hist.printHistogram(histogram, byteData);


        // Statistic operations

        // Instantiate Statistics object 
        Statistics stat = new Statistics();

        // Mean 

        stat.meanFunction(histogram);
        
        System.out.println("Mean: "+ stat.getMean());

        // Variance

        stat.varianceFunction(histogram, stat.getMean());
        System.out.println("Variance: " + stat.getVariance()); 


        // Dynamic Range
        
        stat.dynamicRangeFunction(histogram);
        System.out.println("Dynamic Range: " + stat.getDyn_range()); 


        // Blur the image 

        

        Blur blurMyImage = new Blur(); 

        blurMyImage.blurImage(byteData, 20,20, 64, 8) ;

        // input into BufferedImage
        BufferedImage outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(byteData);

    

        // Write out as a file

        ImageIo.writeImage(outImage, "jpg", "blurry_image.jpg"); 









    }
    
    

    



    


}