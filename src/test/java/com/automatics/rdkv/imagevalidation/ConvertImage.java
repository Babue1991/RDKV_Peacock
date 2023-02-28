package com.automatics.rdkv.imagevalidation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ConvertImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public BufferedImage ConvertGrayScale(BufferedImage image) throws IOException {

		BufferedImage result = new BufferedImage(
				image.getWidth(),
				image.getHeight(),
				BufferedImage.TYPE_INT_RGB);

		Graphics2D graphic = result.createGraphics();
		graphic.drawImage(image, 0, 0, Color.GRAY, null);

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
				
			}
			
		}
		return result;
     
	}

}
