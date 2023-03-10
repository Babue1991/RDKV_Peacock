package com.automatics.rdkv.STBhomescreen;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CropImage {
	
	static BufferedImage cropedImage = null;

	public static void main(String[] args) throws IOException {

		BufferedImage liveImage = ImageIO.read(new File("/home/user/Desktop/zero.jpg"));
		
		try {
			

			cropedImage = cropImage(liveImage, 40,580,90,40);

            //600,600,60,100
			//730,350,340,150
			//50,450,180,40 - Channels Frasier inside
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
			//Channel ads timer 60,635,40,40
			//Channel NBC 98,390,60,25
			//Moive Next asset 1052,530,120,100
			//episodes 820,395,425,60
			//next episodes 210,395,425,50
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		File outputFile = new File("/home/user/Desktop/image3.jpg");
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
