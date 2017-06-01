/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.TablaCiudad;
import Modelo.TablaPais;
import Vista.Vista;
import beans.MyBean;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author pdavila
 */
public final class Controlador {
    
    private MyBean odb;
    private Vista vista;
    
    private int filasel = -1;
    private int filasel2 = -1;
    
    public Controlador(MyBean odb, Vista jf) {
        this.odb = odb;
        this.vista = jf;
                
        cargarTabla(odb.listarObjeto(TablaPais.class, "pais"), vista.getjTablePais(), TablaPais.class);
        cargarTabla(odb.listarObjeto(TablaCiudad.class, "ciudad"), vista.getjTableCiudad(), TablaCiudad.class);
        
        //controlPais();
        //controlCiudad();
        exitButton();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
    public void controlPais() {
        vista.getjButtonInsertarPais().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(vista.getjButtonInsertarPais())) {
                    if (!vista.getjTextFieldCodigoPais().getText().trim().equals("") || 
                        !vista.getjTextFieldNombrePais().getText().trim().equals("") ||
                        !vista.getjTextFieldContinentePais().getText().trim().equals("") ||
                        !vista.getjTextFieldRegionPais().getText().trim().equals("") ||
                        !vista.getjTextFieldPoblacionPais().getText().trim().equals("") ||
                        !vista.getjTextFieldCapitalPais().getText().trim().equals("")) {
                        
                        //odb.insertarPais();
                        
                        vista.borrarCamposPais();
                        cargarTabla(odb.listarObjeto(TablaPais.class, "pais"), vista.getjTableCiudad(), TablaCiudad.class);
                    } else {
                        JOptionPane.showMessageDialog(null, "No puedes introducir un registro sin código o nombre!!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }    
            }
        });
        
        /*
        vista.getjButtonModificarPais().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (filasel != -1) {
                    if (!vista.getjTextFieldCodigoPais().getText().trim().equals("") && 
                        !vista.getjTextFieldNombrePais().getText().trim().equals("") &&
                        !vista.getjTextFieldContinentePais().getText().trim().equals("") &&
                        !vista.getjTextFieldRegionPais().getText().trim().equals("") &&
                        !vista.getjTextFieldPoblacionPais().getText().trim().equals("") &&
                        !vista.getjTextFieldCapitalPais().getText().trim().equals("")) {
                        
                        odb.modificarPais(
                            (int) vista.getjTablePais().getValueAt(filasel, 0),
                            vista.getjTextFieldCodigoPais().getText().trim(), 
                            vista.getjTextFieldNombrePais().getText().trim(),
                            vista.getjTextFieldContinentePais().getText().trim(),
                            vista.getjTextFieldRegionPais().getText().trim(),
                            Integer.valueOf(vista.getjTextFieldPoblacionPais().getText().trim()),
                            vista.getjTextFieldPoblacionPais().getText().trim()
                        );
                        vista.borrarCamposPais();
                        cargarTabla(odb.listarObjeto(TablaPais.class, "pais"), vista.getjTablePais(), TablaPais.class);
                    } else {
                        JOptionPane.showMessageDialog(null, "El país tiene que tener todos los campos!!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Has de seleccionar un registro para modificarlo!!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        vista.getjButtonEliminarPais().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (filasel != -1) {
                    if (((int) vista.getjTablePais().getValueAt(filasel, 2)) == 0) {
                        
                        odb.borrarPais(
                                (int) vista.getjTablePais().getValueAt(filasel, 0)
                        );
                        
                        vista.borrarCamposPais();
                        cargarTabla(odb.listarObjeto(TablaPais.class, "pais"), vista.getjTablePais(), TablaPais.class);
                    } else {
                        JOptionPane.showMessageDialog(null, "El país no puede tener registro de ciudades para eliminarlo!!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Has de seleccionar un registro para modificarlo!!", "Error", JOptionPane.ERROR_MESSAGE);
                }  
            }
        });
        */
        
        vista.getjTablePais().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.

                filasel = vista.getjTablePais().getSelectedRow();
                if (filasel != -1) {
                    vista.getjTextFieldCodigoPais().setText((String) vista.getjTablePais().getValueAt(filasel, 1));
                    vista.getjTextFieldNombrePais().setText((String) vista.getjTablePais().getValueAt(filasel, 2));
                    vista.getjTextFieldContinentePais().setText((String) vista.getjTablePais().getValueAt(filasel, 3));
                    vista.getjTextFieldRegionPais().setText((String) vista.getjTablePais().getValueAt(filasel, 4));
                    //vista.getjTextFieldPoblacionPais().setText((String) vista.getjTablePais().getValueAt(filasel, 5));
                    vista.getjTextFieldCapitalPais().setText((String) vista.getjTablePais().getValueAt(filasel, 6));
                    ListSelectionModel model = vista.getjTableCiudad().getSelectionModel();
                    model.clearSelection();
                    
                    for (int i = 0; i < vista.getjTableCiudad().getRowCount(); i++) {
                        if ((vista.getjTableCiudad().getValueAt(i, 1)).equals(
                                vista.getjTablePais().getValueAt(filasel, 0))) {
                            model.addSelectionInterval(i, i);
                        }
                    }
                    
                    vista.borrarCamposCiudad();
                } else {
                    vista.borrarCamposPais();
                }
            }
        }); 
    }
    
    public void controlCiudad() {
        vista.getjButtonInsertarCiudad().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(vista.getjButtonInsertarCiudad())) {
                    if (!vista.getjTextFieldNombreCiudad().getText().trim().equals("") || 
                        !vista.getjTextFieldCodigoPaisCiudad().getText().trim().equals("") ||
                        !vista.getjTextFieldDistritoCiudad().getText().trim().equals("") ||
                        !vista.getjTextFieldDistritoCiudad().getText().trim().equals("")) {
                        
                        //odb.insertarCiudad();
                        
                        vista.borrarCamposCiudad();
                        cargarTabla(odb.listarObjeto(TablaCiudad.class, "ciudad"), vista.getjTableCiudad(), TablaCiudad.class);
                    } else {
                        JOptionPane.showMessageDialog(null, "No puedes introducir un registro sin nombre!!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }    
            }
        });
        
        /*
        vista.getjButtonModificarCiudad().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (filasel != -1) {
                    if (!vista.getjTextFieldNombreCiudad().getText().trim().equals("") || 
                        !vista.getjTextFieldCodigoPaisCiudad().getText().trim().equals("") ||
                        !vista.getjTextFieldDistritoCiudad().getText().trim().equals("") ||
                        !vista.getjTextFieldDistritoCiudad().getText().trim().equals("")) {
                        
                        odb.modificarCiudad(
                            (int) vista.getjTableCiudad().getValueAt(filasel, 0),
                            vista.getjTextFieldNombreCiudad().getText().trim(), 
                            vista.getjTextFieldCodigoPaisCiudad().getText().trim(),
                            vista.getjTextFieldDistritoCiudad().getText().trim(),
                            Integer.valueOf(vista.getjTextFieldDistritoCiudad().getText().trim())
                        );
                        
                        vista.borrarCamposCiudad();
                        cargarTabla(odb.listarObjeto(TablaCiudad.class, "ciudad"), vista.getjTableCiudad(), TablaCiudad.class);
                    } else {
                        JOptionPane.showMessageDialog(null, "La ciudad tiene que tener todos los campos!!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Has de seleccionar un registro para modificarlo!!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        vista.getjButtonEliminarCiudad().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (filasel != -1) {
                    if (((int) vista.getjTableCiudad().getValueAt(filasel, 2)) == 0) {
                        
                        odb.borrarCiudad(
                                (int) vista.getjTableCiudad().getValueAt(filasel, 0)
                        );
                        
                        vista.borrarCamposCiudad();
                        cargarTabla(odb.listarObjeto(TablaCiudad.class, "ciudad"), vista.getjTableCiudad(), TablaCiudad.class);
                    } else {
                        JOptionPane.showMessageDialog(null, "La ciudad no puede tener registro de paises para eliminarlo!!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Has de seleccionar un registro para modificarlo!!", "Error", JOptionPane.ERROR_MESSAGE);
                }  
            }
        });
        */
        vista.getjTableCiudad().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.

                filasel = vista.getjTableCiudad().getSelectedRow();
                if (filasel != -1) {
                    vista.getjTextFieldNombreCiudad().setText((String) vista.getjTableCiudad().getValueAt(filasel, 1));
                    vista.getjTextFieldCodigoPaisCiudad().setText((String) vista.getjTableCiudad().getValueAt(filasel, 2));
                    vista.getjTextFieldDistritoCiudad().setText((String) vista.getjTableCiudad().getValueAt(filasel, 3));
                    vista.getjTextFieldPoblacionCiudad().setText((String) vista.getjTableCiudad().getValueAt(filasel, 4));
                    ListSelectionModel model = vista.getjTableCiudad().getSelectionModel();
                    model.clearSelection();
                    
                    for (int i = 0; i < vista.getjTableCiudad().getRowCount(); i++) {
                        if ((vista.getjTableCiudad().getValueAt(i, 1)).equals(
                                vista.getjTableCiudad().getValueAt(filasel, 0))) {
                            model.addSelectionInterval(i, i);
                        }
                    }
                    
                    vista.borrarCamposCiudad();
                } else {
                    vista.borrarCamposCiudad();
                }
            }
        }); 
    }
    
    public void exitButton() {
        vista.getjButtonSalir().addActionListener((ActionEvent e) -> {
            try {
                odb.finalize();
            } catch (Throwable ex) {
                System.out.println("Error cerrando la BD...!!");
            }
            System.exit(0);
        });
    }
    
    public void cargarTabla(ArrayList resultSet, JTable table, Class<?> classe) {
        // TODO add your handling code here:
        //Quan tornem a carregar la taula perdem la selecció que haviem fet i posem filasel a -1
        filasel = -1;

        Vector columnNames = new Vector();
        Vector data = new Vector();
        DefaultTableModel model;

        //Anotem el nº de camps de la classe
        Field[] camps = classe.getDeclaredFields();
        //Ordenem els camps alfabèticament
        Arrays.sort(camps, new OrdenarCampClasseAlfabeticament());
        int ncamps = camps.length;
        //Recorrem els camps de la classe i posem els seus names com a columnes de la taula
            //Com hem hagut de posar _numero_ davant el name dels camps, mostrem el name a partir de la 4ª lletra 
        for (Field f : camps) {
            columnNames.addElement(f.getName().substring(3));
        }
        //Si hi ha algun element a l'arraylist omplim la taula
        if (resultSet.size() != 0) {

            //Guardem els descriptors de mètode que ens interessen (els getters)
            Vector<Method> methods = new Vector(resultSet.size());
            try {

                PropertyDescriptor[] descriptors = Introspector.getBeanInfo(classe).getPropertyDescriptors();
                Arrays.sort(descriptors, new OrdenarMetodeClasseAlfabeticament());
                for (PropertyDescriptor pD : descriptors) {
                    Method m = pD.getReadMethod();
                    if (m != null & !m.getName().equals("getClass")) {
                        methods.addElement(m);
                    }
                }

            } catch (IntrospectionException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (Object m : resultSet) {
                Vector row = new Vector(ncamps);

                for (Method mD : methods) {
                    try {
                        row.addElement(mD.invoke(m));
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvocationTargetException ex) {
                        Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                data.addElement(row);
            }
        }

        model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (classe.equals(TablaPais.class)) {
                    if (column == 1) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (column == 1 || column == 2 || column == 3 || column == 4) {
                        return true;
                    } else {
                        return false;
                    }
                }
            };
        };
        table.setModel(model);
        TableColumn column;
        for (int i = 0; i < table.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            column.setMaxWidth(250);
        }

    }
    
    private static class OrdenarMetodeClasseAlfabeticament implements Comparator {
        public int compare(Object o1, Object o2) {

            Method mo1 = ((PropertyDescriptor) o1).getReadMethod();
            Method mo2 = ((PropertyDescriptor) o2).getReadMethod();

            if (mo1 != null && mo2 != null) {
                return (int) mo1.getName().compareToIgnoreCase(mo2.getName());
            }

            if (mo1 == null) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    private static class OrdenarCampClasseAlfabeticament implements Comparator {
        public int compare(Object o1, Object o2) {
            return (int) (((Field) o1).getName().compareToIgnoreCase(((Field) o2).getName()));
        }
    }
}
