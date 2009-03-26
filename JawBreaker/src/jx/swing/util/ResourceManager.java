/*
 * ResourceManager.java
 *
 * Created on November 21, 2006, 3:16 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jx.swing.util;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageProducer;
import javax.swing.ImageIcon;
import jx.swing.board.model.CellType;

/**
 *
 * @author Administrator
 */
public class ResourceManager {
    
    public static ResourceManager manager;
    private BufferedImage image;
    /** Creates a new instance of ResourceManager */
    private ImageIcon icons [];
    
    private ResourceManager() {
        this.image  = (BufferedImage) UIHelper.loadImage("jawbreaker_balls.png");
        getImageIcons();
    }
    public ImageIcon [] getImageIcons() {
        if(icons == null) {
            icons = new ImageIcon[16];
            Toolkit kit = Toolkit.getDefaultToolkit();
            ImageProducer imageproducer = image.getSource();
            for(int i=0; i<icons.length; i++) {
                CropImageFilter cropimagefilter = new CropImageFilter(0, i * 20, 20, 20);
                Image tmpImage = kit.createImage(new FilteredImageSource(imageproducer, cropimagefilter));
                icons[i] = new ImageIcon(tmpImage);
            }
        }
        return icons;
    }
    public ImageIcon getIcon(CellType type, boolean selected) {
        switch(type) {
            case EMPTY:{
                return null;
//                return icons[10];
            }
            case BLUE :{
                return selected ? icons[5] :icons[0];
            }
            case GREEN:{
                return selected ? icons[6]:icons[1];
            }
            case MAGENTA:{
                return selected ? icons[7] :icons[2];
            }
            case RED:{
                return selected ? icons[8]:icons[3];
            }
            case ORANGE:{
                return selected ? icons[9]:icons[4];
            }
        }
        return null;
//        return icons[10];
    }
    public ImageIcon getSmallIcon(CellType type) {
        switch(type) {
            case BLUE :{
                return  icons[11];
            }
            case GREEN:{
                return icons[12];
            }
            case MAGENTA:{
                return icons[13];
            }
            case RED:{
                return icons[14];
            }
            case ORANGE:{
                return icons[15];
            }
        }
        return null;
    }
    
    
    public static ResourceManager getDefaultManager() {
        if(manager ==null)
            manager = new ResourceManager();
        return manager;
    }
}
