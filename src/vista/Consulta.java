/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Container;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LN710Q
 */
public class Consulta extends JFrame{
    public JLabel lblNombre, lblDirector, lblPais, lblClasificacion, lblAnio, lblEnProyeccion;
    
    public JTextField nombre, director, pais, anio;
    public JComboBox clasificacion;
    
    ButtonGroup existencia = new ButtonGroup();
    public JRadioButton si;
    public JTable resultados;
    
    public JPanel table;
    
    public JButton insertar, eliminar, actualizar, buscar;
    
    private static final int ANCHOC = 130, ALTOC = 30;
    
    DefaultTableModel tm;

    public Consulta(){
        super("CINEPOLIX");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        agregarLabels();
        formulario();
        llenarTabla();
        Container container = getContentPane();
        container.add(lblNombre);
        container.add(lblDirector);
        container.add(lblPais);
        container.add(lblClasificacion);
        container.add(lblAnio);
        container.add(nombre);
        container.add(director);
        container.add(pais);
        container.add(anio);
        container.add(si);
        container.add(table);
        container.add(insertar);
        container.add(eliminar);
        container.add(actualizar);
        container.add(buscar);
        container.add(lblEnProyeccion);
        setSize(1000,400);
        eventos();
    }
    
    public final void agregarLabels(){
        lblNombre = new JLabel("Nombre");
        lblDirector = new JLabel("Director");
        lblPais = new JLabel ("Pais");
        lblClasificacion = new JLabel ("Clasificacion");
        lblAnio = new JLabel ("Año");
        lblEnProyeccion = new JLabel("En proyección");
        
    }
    

    
    
}
