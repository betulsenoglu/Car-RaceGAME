
package racing_world;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import racing_motor.Motor;
import racing_tile.Tile;

public class world {

    private int[][] tile;
    private int width,height;
    public world(){
        loadWorld("res/world.txt");
    }

    public world(Motor motor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   // public world(Motor motor) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
        public String loadFile(String path){
        StringBuilder sr=new StringBuilder();
        try {
            BufferedReader reader=new BufferedReader(new FileReader(path));
            String line;
            while((line=reader.readLine())!=null){
                sr.append(line +"\n");
            }
            reader.close();
        } catch (IOException e) {
           e.printStackTrace();
    
        }
        return sr.toString();
    }
    private int parseInt(String number){
        return Integer.parseInt(number);
    }
    private void loadWorld (String path){
        String file=loadFile(path);
        String[] space=file.split("\\s+");//space
         width=parseInt(space[0]);
         height=parseInt(space[1]);
        tile=new int[width][height];
        for(int x=0;x<width;x++){
            for(int y=0;y<height;y++){
                tile[x][y]=parseInt(space[2+(x+y*width)]);
            }
        }
    }

    public void render(Graphics g){
        for(int i=0;i<width;i++){
            for(int j=0;j<height; j++){
            Tile t=Tile.tiles[tile[i][j]];
            t.render(g,i*Tile.tileWidth,j*Tile.tileHeight);
        }
        }
    }
}
