/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ThankYouPackage {
   private  BufferedImage image;
   private  String letter;

   public ThankYouPackage(String path, String letter) throws IOException{
       this.image = ImageIO.read(new File(path));
       this.letter = letter;
   }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
    
    @Override
    public String toString(){
        return "Image: " + image + "\nLetter: " + letter;
    }
}