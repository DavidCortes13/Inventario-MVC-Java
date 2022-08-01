package main;

// Nuestras carpetas
import Controlador.CtrlNave;
import Modelo.Consultas;
import Modelo.NaveEspacial;
import Vista.frmNave;

/**
 *
 * @author DavidCortes
 * 3223149084
 * cortesd114@gmail.com
 */
public class MvcBasicoProducto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        NaveEspacial mod = new NaveEspacial(); // Creamos un objeto de la clase Nave Espacial
        Consultas modC = new Consultas(); // Objeto para realizar consultas
        frmNave frm = new frmNave(); // Obejto para el j frame

        CtrlNave ctrl = new CtrlNave(mod,modC,frm); //Enviamos todo a nuestro controlador

        ctrl.iniciar();  //Ejecutamos nuestro metodo iniciar ubicado en controlador, el cuial sera nuestro metodo principal
        frm.setVisible(true); // Permitir la vista del j frame

    }
    
}
