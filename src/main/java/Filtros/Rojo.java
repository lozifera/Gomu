package Filtros;

import Logica.ComandoFiltro;
import Logica.Imagen;

public class Rojo extends ComandoFiltro {
    public Rojo(Imagen imagenBase) {
        super(imagenBase);
    }
    @Override
    public void ejecutar() {
        int ancho = imagenBase.getAncho();
        int alto = imagenBase.getAlto();
        int[][] pixeles = imagenBase.getPixeles();
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                int r = (pixeles[i][j] )& 0xff0000;
                int g = (pixeles[i][j] ) & 0xff0000;
                int b = pixeles[i][j] & 0xff0000;
                int prom = (r+g+b)/3;

                pixeles[i][j] = prom + prom * 256 + prom * 256 * 256;
            }
        }
        imagenBase.cambiosImagen();
//        observado.firePropertyChange("IMAGEN", false, true);

    }
}

