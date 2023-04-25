package GUI;

import Filtros.*;
import Logica.ComandoFiltro;
import Logica.Imagen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;

public class Ventana extends JFrame {

    private  static Logger logger = LogManager.getRootLogger();
    private Imagen modelo;
    private    JMenuBar bara;

    public Ventana(){
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        this. setTitle("                                                             Filtro");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        modelo = new Imagen(600,400);
        Panel panel = new Panel(modelo);
        modelo.addObserver(panel);

        this.getContentPane().add(panel, BorderLayout.CENTER);
        menu();

        this.pack();
        this.setVisible(true);



    }
    private void menu (){
        bara = new JMenuBar();
        archivo();
        imagen();
        setJMenuBar(bara);
    }
    private  void  archivo(){
        JMenu menu = new JMenu("Archivo");

        JMenuItem item = new JMenuItem("Abrir");
        item.addActionListener( e -> {
            menuArchivoItemAbrrir();
        });
        menu.add(item);
        menu.addSeparator();

        item = new JMenuItem("Salir");
        item.addActionListener(e -> {
            logger.info("El usuario sale del programa");
            System.exit(0);
        });
        menu.add(item);


        bara.add(menu);

    }


    private  void imagen(){
        JMenu menu = new JMenu("Imagen");
        JMenuItem item = new JMenuItem("Gris");
        item.addActionListener(e -> {
            logger.info("El usuario convierte la imagen en Gris");
            ComandoFiltro cmd = new Gris(modelo);
            cmd.ejecutar();
        });
        menu.add(item);
        item = new JMenuItem("Flip Horizontal");
        item.addActionListener(e->{
            logger.info("El usuario convierte la imagen en FlipHorizontal");
            ComandoFiltro cmd = new FlipHorizontal(modelo);
            cmd.ejecutar();
        });
        menu.add(item);
        item = new JMenuItem("Flip Vertical");
        item.addActionListener(e->{
            logger.info("El usuario convierte la imagen en Vertical");
            ComandoFiltro cmd = new FlipVertical(modelo);
            cmd.ejecutar();
        });
        menu.add(item);
        item = new JMenuItem("Azul");
        item.addActionListener(e->{
            logger.info("El usuario convierte la imagen en Azul");
            ComandoFiltro cmd = new Azul(modelo);
            cmd.ejecutar();
        });
        menu.add(item);

        item = new JMenuItem("Rojo");
        item.addActionListener(e->{
            logger.info("El usuario convierte la imagen en Rojo ");
            ComandoFiltro cmd = new Rojo(modelo);
            cmd.ejecutar();
        });
        menu.add(item);
        item = new JMenuItem("Verde");
        item.addActionListener(e->{
            logger.info("El usuario convierte la imagen en Verde ");
            ComandoFiltro cmd = new Verde(modelo);
            cmd.ejecutar();
        });
        menu.add(item);
        item = new JMenuItem("SalPimienta");
        item.addActionListener(e->{
            logger.info("El usuario convierte la imagen en SalPimienta");
            ComandoFiltro cmd = new SalPimienta(modelo);
            cmd.ejecutar();
        });
        menu.add(item);
        item = new JMenuItem("FloydSteinberg");
        item.addActionListener(e->{
            logger.info("El usuario convierte la imagen en FloydSteinberg");
            ComandoFiltro cmd = new FloydSteinberg(modelo);
            cmd.ejecutar();
        });
        menu.add(item);

        bara.add(menu);
        this.setJMenuBar(bara);
    }
    private void menuArchivoItemAbrrir() {
        logger.info("Abrimos menu de escritorio para selecionar una imagen");
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            logger.info(chooser.getSelectedFile().getAbsolutePath());
            modelo.leer(chooser.getSelectedFile());
        }
        this.pack();
    }

    public static void main(String[] args) {
        Ventana obj = new Ventana();
    }
}
