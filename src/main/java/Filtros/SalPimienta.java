package Filtros;

import Logica.ComandoFiltro;
import Logica.Imagen;

import java.util.Random;

public class SalPimienta extends ComandoFiltro {
    public SalPimienta(Imagen imagenBase) {
        super(imagenBase);
    }


    @Override
    public void ejecutar() {
        int porcentajeRuido = 5;
        int width = imagenBase.getAncho();
        int height = imagenBase.getAlto();
        int[][] pixeles = imagenBase.getPixeles();
        int numPixelesRuido = (int) (width * height * porcentajeRuido / 100.0);

        Random random = new Random();
        for (int i = 0; i < numPixelesRuido; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int color = random.nextBoolean() ? 0 : 255; // 0 para sal, 255 para pimienta
            pixeles[x][y] = (color << 16) | (color << 8) | color; // Establecer el valor del pixel
        }
        imagenBase.cambiosImagen();
    }
}



