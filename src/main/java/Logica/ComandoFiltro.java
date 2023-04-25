package Logica;

public abstract  class ComandoFiltro {
    protected Imagen imagenBase;
    protected int ancho;
    protected int alto;
    protected int[][] pixeles;

    public ComandoFiltro(Imagen imagenBase) {
        this.imagenBase = imagenBase;
        ancho = imagenBase.getAncho();
        alto = imagenBase.getAlto();
        pixeles = imagenBase.getPixeles();
    }

    public abstract void ejecutar(

    );
}
