package com.automatics.rdkv.STBhomescreen;

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

		BufferedImage liveImage = ImageIO.read(new File("/home/user/Desktop/trickplayChannels.jpg"));
		
		try {
<<<<<<< HEAD
			cropedImage = cropImage(liveImage, 450,600,550,100);
=======
			cropedImage = cropImage(liveImage, 750,400,60,120);
>>>>>>> c19e801d3bf3e3e581b0a4c7774d4f3a81d9e063
			//730,350,340,150
			//Popular entertainment section  70,380,380,70
			
			//Application text section : 70,25,160,60
			//Peacock text in application screen grab 50,300,160,45
			// Splash screen resolution 120,230,1000,250
			// Menu resolution 35,150,250,420
			//Movie option from menu 95,280,120,32
			//Featured Movies 70,380,300,60
			//Movie play pause 50,630,40,44
			//Search button highlight menu 95,185,120,32
			//Search bar keyboard 80,100,1180,180
			//Search bar text verify 100,280,380,50
			//Search bar content Antz 90,340,290,180
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		File outputFile = new File("/home/user/Desktop/image4.jpg");
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
	
	public static BufferedImage subImage(BufferedImage liveImage, int startX, int startY, int endX, int endY ) {
	      BufferedImage image=liveImage.getSubimage(70,380,380,70);
	      return image;
	}
	public static BufferedImage cropImage(BufferedImage liveImage, int startX, int startY, int endX, int endY ) {
		//fill in the corners of the desired crop location here
		BufferedImage img = liveImage.getSubimage(startX, startY, endX, endY); 
		BufferedImage copyOfImage = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
		System.out.println("Width of image"+img.getWidth());
		System.out.println("Height of image"+img.getHeight());
		Graphics g = copyOfImage.createGraphics();
		g.drawImage(img, 0, 0, null);
		return copyOfImage;
	}

}
