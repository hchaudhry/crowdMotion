package org.crowdMotion.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

    private  BufferedImage spriteSheet;
    

    public BufferedImage loadSprite(String file) {

        BufferedImage sprite = null;

        try {
            sprite = ImageIO.read(new File(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sprite;
    }

    public BufferedImage getSpriteFile(String file, int xGrid, int yGrid) {

        if (spriteSheet == null) {
            spriteSheet = loadSprite(file);
        }

        return spriteSheet.getSubimage(xGrid * Constants.TILE_SIZE, yGrid * Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
    }

}
