package br.com.cds.connecta.framework.core.util;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import org.apache.commons.codec.binary.Base64;

/**
 * 
 * Auxilia na manipulação de imagens.
 * 
 * 
 * 
 * 
 *
 */
public class ImageUtil {
	
	public static BufferedImage resize(File file, int width, int height) throws IOException{
		
		BufferedImage image = ImageIO.read(file);
		
		if (width==0 && height==0){
			return image;
		}
		
		int type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();
		
		BufferedImage resizedImage = new BufferedImage(width, height, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(image, 0, 0, width, height, null);
		g.dispose();
		g.setComposite(AlphaComposite.Src);
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	
		
		return resizedImage;
		
	}
	
	public static BufferedImage getScaledImage(File file, int width, int height) throws IOException {
	    
		BufferedImage image = ImageIO.read(file);
		
		if (width==0 && height==0){
			return image;
		}
		
		int imageWidth  = image.getWidth();
	    int imageHeight = image.getHeight();

	    double scaleX = (double)width/imageWidth;
	    double scaleY = (double)height/imageHeight;
	    AffineTransform scaleTransform = AffineTransform.getScaleInstance(scaleX, scaleY);
	    AffineTransformOp bilinearScaleOp = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_BILINEAR);

	    return bilinearScaleOp.filter(
	        image,
	        new BufferedImage(width, height, image.getType()));
	}

	public static BufferedImage getScaledImage(URL url, int width, int height) throws IOException {
	    
		BufferedImage image = ImageIO.read(url);

		if (width==0 && height==0){
			return image;
		}
		
		int imageWidth  = image.getWidth();
	    int imageHeight = image.getHeight();

	    double scaleX = (double)width/imageWidth;
	    double scaleY = (double)height/imageHeight;
	    AffineTransform scaleTransform = AffineTransform.getScaleInstance(scaleX, scaleY);
	    AffineTransformOp bilinearScaleOp = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_BILINEAR);

	    return bilinearScaleOp.filter(
	        image,
	        new BufferedImage(width, height, image.getType()));
	}
	
	/**
	 * 
	 * @param bimage Imagem Bufferizada
	 * @param imageFormat Formato da Imagem
	 * @return o input stream 
	 * @throws IOException caso dê algum erro ao escrever ou ler o arquivo
	 */
	public static InputStream parseToInputStream(BufferedImage bimage, String imageFormat) throws IOException{
		
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		ImageIO.write(bimage, imageFormat, out);

        final byte[] imgData = out.toByteArray();

        final InputStream bigInputStream = 
              new ByteArrayInputStream(imgData);
		
        return bigInputStream;
	}
    
    /**
     * Faz o encode de uma imagem para uma String Base64
     *
     * @param imageByteArray - byte array
     * @return String a {@link java.lang.String}
     */
    public static String encodeImageToBase64(byte[] imageByteArray) {
        return Base64.encodeBase64String(imageByteArray);
    }

    /**
     * Faz o decode de uma imagem a partir de uma String Base64
     *
     * @param imageDataString - a {@link java.lang.String}
     * @return byte array
     */
    public static byte[] decodeImageFromBase64(String imageDataString) {
        return Base64.decodeBase64(imageDataString);
    }
 
}
