package Filtros;

import Logica.ComandoFiltro;
import Logica.Imagen;

public class FlipVertical  extends ComandoFiltro {

    public FlipVertical(Imagen imagenBase) {
        super(imagenBase);
    }

    @Override
    public void ejecutar() {
        int ancho = imagenBase.getAncho();

        int[][] pixeles = imagenBase.getPixeles();

        for (int fila = 0; fila < ancho / 2; fila++) {
            int[] temp = pixeles[fila];
            pixeles[fila] = pixeles[ancho - 1 - fila];
            pixeles[ancho - 1 - fila] = temp;
        }
        imagenBase.cambiosImagen();
    }

}

