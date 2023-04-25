package Filtros;

import Logica.ComandoFiltro;
import Logica.Imagen;


public class FlipHorizontal extends ComandoFiltro {

    public FlipHorizontal(Imagen imagenBase) {
        super(imagenBase);
    }


    @Override
    public void ejecutar() {
        int ancho = imagenBase.getAncho();
        int alto = imagenBase.getAlto();
        int[][] pixeles = imagenBase.getPixeles();
        for (int i = 0; i < ancho; i ++) {
            for (int j = 0; j < alto / 2; j++) {
                int temp = pixeles[i][j];
                pixeles[i][j] = pixeles[i][ ancho- 1 - j];
                pixeles[i][ancho - 1 - j] = temp;
            }
        }
        imagenBase.cambiosImagen();
    }

}

