/*
Isaiah Saucedo 
Digital Image Processing
Project 1

This file contains the function to blur an image. 


*/

/**
 *
 * @author Isaiah Saucedo
 */

package app; 



public class Blur {

    public void blurImage(byte[][] arr, int topLeftI, int topLeftJ, int blockSize, int subBlockSize ){

        
        int size = subBlockSize * subBlockSize; 

        
        

          

         


        for (int i = topLeftI ; i < topLeftI + blockSize; i+=subBlockSize){
            for (int j = topLeftJ; j < topLeftJ + blockSize; j+=subBlockSize) {

                // identify subblock 

                

                 int sum = 0; 

                for (int m = i ; m < i + subBlockSize; m++ ){
                    for (int n = j; n < j + subBlockSize; n++){
                        sum += (arr[m][n] & 0xFF);
                    }

                }


                // calculate mean 

                int mean = ImageIo.clip((float)sum / size); 


            

                 





                // replace each pixel by mean

                for (int m = i ; m < i + subBlockSize; m++ ){
                    for (int n = j; n < j + subBlockSize; n++){
                        arr[m][n] = (byte)(mean);
                    }

                }







        



                

               



            }

            
        }

        





    }

    

}