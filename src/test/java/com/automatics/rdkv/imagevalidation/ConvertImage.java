package com.automatics.rdkv.imagevalidation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ConvertImage {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ConvertImage ci =new ConvertImage();
		BufferedImage originalImage = ImageIO.read(new File("/home/user/Desktop/image3.jpg"));
		ci.ConvertGrayScale(originalImage);

	}
	public BufferedImage ConvertGrayScale(BufferedImage image) throws IOException {

		BufferedImage result = new BufferedImage(
				image.getWidth(),
				image.getHeight(),
				BufferedImage.TYPE_INT_RGB);

		Graphics2D graphic = result.createGraphics();
		graphic.drawImage(image, 0, 0, Color.DARK_GRAY, null);

		for (int i = 0; i < result.getHeight(); i++) {
			for (int j = 0; j < result.getWidth(); j++) {
				Color c = new Color(result.getRGB(j, i));
				int red = (int) (c.getRed() * 0.299);
				int green = (int) (c.getGreen() * 0.587);
				int blue = (int) (c.getBlue() * 0.114);
				Color newColor = new Color(
						red + green + blue,
						red + green + blue,
						red + green + blue);
				result.setRGB(j, i, newColor.getRGB());
				
				//File outputFile = new File("/home/user/Desktop/image4.jpg");
				//ImageIO.write(result, "jpg", outputFile);
			}
			
		}
		return result;
		
	}

}
