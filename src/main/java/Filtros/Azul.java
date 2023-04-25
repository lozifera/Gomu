package Filtros;

import Logica.ComandoFiltro;
import Logica.Imagen;

import java.awt.image.BufferedImage;

public  class Azul extends ComandoFiltro {

    public Azul(Imagen imagenBase) {
        super(imagenBase);
    }

    @Override
    public void ejecutar() {
        int width = imagenBase.getAncho();
        int height = imagenBase.getAlto();
        int[][] pixeles = imagenBase.getPixeles();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                int r = (pixeles[i][j]) & 0x000000FF; // Obtener el componente rojo
                int g = (pixeles[i][j]) & 0x000000FF; // Obtener el componente verde
                int b = pixeles[i][j] & 0x000000FF; // Obtener el componente azul
                int prom = (r+g+b)/3;
                pixeles[i][j] = prom + 0 * 256 + 0 * 256 * 256;
         }
        }

        imagenBase.cambiosImagen();
    }

}
