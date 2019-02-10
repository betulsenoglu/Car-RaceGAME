
package racing_graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.awt.image.BufferStrategy;

public class loadImage {
   
    public static BufferedImage fullImage,road,grass,footPathTile;
    
    public static void init(){
      fullImage=  imageLoader("/grid.png");
      crop();
    }
    public static BufferedImage imageLoader(String path){
        try {
            return ImageIO.read(loadImage.class.getResource(path));
        } catch (IOException ex) {
            Logger.getLogger(loadImage.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
        return null;
    }
    public static void crop(){
      //  subImage1=fullImage.getSubimage(100, 200, 200, 200);
       // subImage2=fullImage.getSubimage(200, 550, 200, 200);
       footPathTile=fullImage.getSubimage(260,0, 130, 119);
       grass=fullImage.getSubimage(0, 0, 130, 119);
       road=fullImage.getSubimage(130,0, 130, 119);
       
    }
    
    
    
    
}
