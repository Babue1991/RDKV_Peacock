package com.automatics.rdkv.commonmethods;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.automatics.image.imagick.MagickComparison;
import com.automatics.rdkv.constants.ReferenceImageConstants;

public class CropImage {
	static BufferedImage cropImage;
	static BufferedImage cropedImage = null;

	public static void main(String[] args) throws IOException {

		BufferedImage liveImage = ImageIO.read(new File("/home/user/Desktop/WWE.jpg"));
		
		try {
			cropedImage = cropImage(liveImage, 80,100,1180,180);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		File outputFile = new File("/home/user/Desktop/image1.jpg");
		ImageIO.write(cropedImage, "jpg", outputFile);
	}
	
	   /**  
     * @param args
     * 
     * liveImage
     *        The original image used for cropping.
     *        
     * StartX and StartY 
     * 		- These 2 params values are start point of cropping image.
     * 
     *   endX and endY 
     *   		- End point of the the image to be cropped.
     */
	
	public BufferedImage subImage(BufferedImage liveImage, int startX, int startY, int endX, int endY ) {
	      BufferedImage image=liveImage.getSubimage(10,20,200,70);
	      return image;
	}
	public static BufferedImage cropImage(BufferedImage liveImage, int startX, int startY, int endX, int endY ) {
		//fill in the corners of the desired crop location here
		BufferedImage img = liveImage.getSubimage(startX, startY, endX, endY); 
		BufferedImage copyOfImage = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g = copyOfImage.createGraphics();
		g.drawImage(img, 0, 0, null);
		return copyOfImage;
	}

}
