package Filtros;

import Logica.ComandoFiltro;
import Logica.Imagen;
import java.awt.*;

public class FloydSteinberg extends ComandoFiltro {
    private float errorR;
    private float errorG;
    private float errorB;
    public FloydSteinberg(Imagen imagenBase) {
        super(imagenBase);
    }


    @Override
    public void ejecutar() {
        for (int j = 0; j < alto; j++) {
            for (int i = 0; i < ancho; i++) {
                float oldR = red(pixeles[i][j]);
                float oldG = green(pixeles[i][j]);
                float oldB = blue(pixeles[i][j]);


                int factor = 4;


                //En caso de factor 1 la division de oldcolor y 255 quedaria en un decimal entre 0 y 1
                int newR = (Math.round(factor * oldR / 255)) * (255 / factor);
                int newG = (Math.round(factor * oldG / 255)) * (255 / factor);
                int newB = (Math.round(factor * oldB / 255)) * (255 / factor);


                pixeles[i][j] = newB + newG * 256 + newR * 256 * 256;

                errorR = oldR - newR;
                errorG = oldG - newG;
                errorB = oldB - newB;

/*
            quantizar(i+1,j, 7/16f);
            quantizar(i-1,j+1, 3/16f);
            quantizar(i,j+1, 5/16f);
            quantizar(i+1,j+1, 1/16f);

 */

                // derecha
                if(i+1<ancho){
                    quantizar(i+1,j, 7/16f);
                }
                //inferior izquierda
                if (i>0 && j+1<alto){
                    quantizar(i-1,j+1, 3/16f);
                }
                //inferior
                if (j+1<alto){
                    quantizar(i,j+1, 5/16f);
                }//inferior derecha
                if (j+1<alto && i+1<ancho){
                    quantizar(i+1,j+1, 1/16f);
                }



                /*
        pixels[x + 1][y    ] := pixels[x + 1][y    ] + quant_error × 7 / 16
        pixels[x - 1][y + 1] := pixels[x - 1][y + 1] + quant_error × 3 / 16
        pixels[x    ][y + 1] := pixels[x    ][y + 1] + quant_error × 5 / 16
        pixels[x + 1][y + 1] := pixels[x + 1][y + 1] + quant_error × 1 / 16
                 */


            }
        }


        imagenBase.cambiosImagen();
    }


    public int red(int pixel) {
        return ((pixel >> 16) & 0x000000FF);
    }

    public int green(int pixel) {
        return (pixel >> 8) & 0x000000FF;
    }

    public int blue(int pixel) {
        return (pixel & 0x000000FF);
    }


    public void quantizar(int x,int y, float quant){
        float r = red(pixeles[x][y]);
        float g = green(pixeles[x][y]);
        float b = blue(pixeles[x][y]);

        r = (r + errorR * quant);
        g = (g + errorG * quant);
        b = (b + errorB * quant);

        r = verificar(r);
        g = verificar(g);
        b = verificar(b);

        Color c = new Color(r /255, g /255, b /255);

        pixeles[x][y] = c.getRGB();

    }
    //
    public float verificar(float i){
        if (i>255){
            i=255;
        }
        if (i<0){
            return 0;
        }
        return i;
    }
}
