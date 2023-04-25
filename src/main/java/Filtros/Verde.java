package Filtros;

import Logica.ComandoFiltro;
import Logica.Imagen;

public class Verde extends ComandoFiltro {
    public Verde(Imagen imagenBase) {
        super(imagenBase);
    }

    @Override
    public void ejecutar() {
        int ancho = imagenBase.getAncho();
        int alto = imagenBase.getAlto();
        int[][] pixeles = imagenBase.getPixeles();
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                int r = (pixeles[i][j] )& 0x0000ff;
                int g = (pixeles[i][j] ) & 0x0000ff;
                int b = pixeles[i][j] & 0x0000ff;
                int prom = (r+g+b)/3;


                pixeles[i][j] = 0 + prom * 256 + 0 * 256 * 256;
            }
        }
        imagenBase.cambiosImagen();
//        observado.firePropertyChange("IMAGEN", false, true);
    }
}
