package Logica;
import GUI.Panel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;


public class Imagen {
    private int ancho;
    private  int alto;
    private int[][]pixeles;
    private PropertyChangeSupport observado;
    private static Logger logger = LogManager.getRootLogger();

    public  Imagen(int w, int h){
        ancho = w;
        alto = h;
        pixeles = new int[w][h];
        observado = new PropertyChangeSupport(this);
        logger.info("se crea una imagen vacia "+ w + "x" + h);
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public int[][] getPixeles() {
        return pixeles;
    }

    public  void  dibujar(Graphics g){
        BufferedImage rsm = new BufferedImage(ancho,alto,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rsm.createGraphics();

        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                g2d.setColor(new Color(pixeles[i][j]));
                g2d.drawLine(i,j,i,j);
            }
        }
        g.drawImage(rsm,0,0,null);
    }

    public void leer(File f){
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(f);
        }catch (IOException e){
            e.printStackTrace();
        }
        ancho = bi.getWidth();
        alto = bi.getHeight();

        pixeles = new int[ancho][alto];
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                pixeles[i][j] = bi.getRGB(i,j);

            }
        }
        observado.firePropertyChange("Imagen",false,true);
    }
    public void addObserver(PropertyChangeListener listener) {
        observado.addPropertyChangeListener(listener);
    }
    public  void  cambiosImagen(){
        observado.firePropertyChange("Imagen",false,true);
    }



}
