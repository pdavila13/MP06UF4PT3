
import Controlador.Controlador;
import Vista.Vista;
import beans.MyBean;
import beans.Receptor;
import beans.ReceptorVetador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pdavila
 */
public class Main {
    
    static MyBean modelo = new MyBean();
    static Vista vista = new Vista();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Receptor r = new Receptor();
            ReceptorVetador rv = new ReceptorVetador();
            
            modelo.addPropertyChangeListener(r);
            modelo.addVetoableChangeListener(rv);
            modelo.initConnection("database.properties");
        } catch (Exception e) {
            System.err.println("No se ha podido establecer la conexión con la BD... T.T");
            System.exit(0);
        }
        
        new Controlador(modelo, vista);
    }
}
