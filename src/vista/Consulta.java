/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dao.FiltroDao;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Filtro;

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
        container.add(clasificacion);
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
        //eventos();
    }
    
    public final void agregarLabels(){
        lblNombre = new JLabel("Nombre");
        lblDirector = new JLabel("Director");
        lblPais = new JLabel ("Pais");
        lblClasificacion = new JLabel ("Clasificacion");
        lblAnio = new JLabel ("Año");
        lblEnProyeccion = new JLabel("En proyección");
        lblNombre.setBounds(10, 10, ANCHOC, ALTOC);
        lblDirector.setBounds(10, 60, ANCHOC, ALTOC);
        lblPais.setBounds(10, 100, ANCHOC, ALTOC);
        lblClasificacion.setBounds(10, 140, ANCHOC, ALTOC);
        lblAnio.setBounds(10, 180, ANCHOC, ALTOC);
        lblEnProyeccion.setBounds(10, 220, ANCHOC, ALTOC);
    }
    
    public final void formulario(){
        nombre = new JTextField();
        director = new JTextField();
        pais = new JTextField();
        anio = new JTextField();
        si = new JRadioButton();
        clasificacion = new JComboBox();
        resultados = new JTable();
        buscar = new JButton("Buscar");
        insertar = new JButton("Insertar");
        eliminar = new JButton("Eliminar");
        actualizar = new JButton("Actualizar");
        
        table = new JPanel();
        
        clasificacion.addItem("G");
        clasificacion.addItem("PG");
        clasificacion.addItem("14A");
        clasificacion.addItem("18A");
        clasificacion.addItem("R");
        clasificacion.addItem("A");
        
        
        
        existencia = new ButtonGroup();
        existencia.add(si);
        
        nombre.setBounds(140, 10, ANCHOC, ALTOC);
        director.setBounds(140, 60, ANCHOC, ALTOC);
        pais.setBounds(140, 140, ANCHOC, ALTOC);
        anio.setBounds(140, 180, ANCHOC, ALTOC);
        si.setBounds(140, 10, 50, ALTOC);
        
       
        
        buscar.setBounds(450, 210, ANCHOC,ALTOC);
        insertar.setBounds(10, 210, ANCHOC,ALTOC);
        actualizar.setBounds(150, 210, ANCHOC,ALTOC);
        eliminar.setBounds(300, 210, ANCHOC,ALTOC);
        resultados=new JTable();
        table.setBounds(10, 250, 500,200);
        table.add(new JScrollPane(resultados));
         
    }
    
    public void llenarTabla(){
        tm = new DefaultTableModel(){
            public Class<?> getColumnClass(int column){
                switch(column){
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return Integer.class;
                    default:
                        return Boolean.class;
                }
            }
        };
        
        tm.addColumn("Nombre");
        tm.addColumn("Director");
        tm.addColumn("Pais");
        tm.addColumn("Clasificacion");
        tm.addColumn("Año");
        tm.addColumn("En proyeccion");
        
        FiltroDao fd = new FiltroDao();
        ArrayList<Filtro> filtros = fd.readall();
        
        for (Filtro fi : filtros){
            tm.addRow(new Object[]{fi.getNombre(),fi.getDirector(), fi.getPais(), fi.getClasificacion(), fi.getAnio(), fi.isEn_proyeccion()});
        }
        
        resultados.setModel(tm);
        
    }
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                new Consulta().setVisible(true);
 
            }
            
        });
    }

}
