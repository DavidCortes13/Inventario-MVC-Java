package Controlador;

//ATRAER LAS PROPIEDADES DE UN PRODUCTO DE UNA CLASE DETERMINADA
import Modelo.Consultas;
import Modelo.NaveEspacial;
import Vista.frmNave;

//Librerias
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class CtrlNave implements ActionListener {

	private NaveEspacial mod;
	private Consultas modC;
	private frmNave frm;

	public CtrlNave(NaveEspacial mod, Consultas modC, frmNave frm){

		this.mod = mod;
		this.modC = modC;
		this.frm = frm;
		this.frm.btnGuardar.addActionListener(this);
		this.frm.btnModificar.addActionListener(this);
		this.frm.btnEliminar.addActionListener(this);
		this.frm.btnLimpiar.addActionListener(this);
		this.frm.btnBuscar.addActionListener(this);
	}

	// iniciar vista
	public void iniciar(){
		frm.setTitle("ingrese una nave al inventario"); // establecer titulo del formulario
		frm.setLocationRelativeTo(null); // posicion del formulario centrado
		frm.txtId.setVisible(false); // caja de texto no visible txtId
	}

        @Override
	public void actionPerformed(ActionEvent e)
        {
		// detectar que boton presiona +++ GUARDAR ++
		if(e.getSource() == frm.btnGuardar){
/*Atraves de presionar btnGuardar
                    */                   
			mod.setNombreNave(frm.txtNombreNave.getText());
			mod.setTipoNave(frm.txtTipoNave.getText());
			mod.setFechaLanzamiento(frm.txtFechaLanzamiento.getText());
			mod.setPesoToneladas(  Double.parseDouble(frm.txtToneladas.getText()));

			if(modC.registrar(mod)){

				JOptionPane.showMessageDialog(null, "Registro Guardado");
				limpiar();

			} else {
				JOptionPane.showMessageDialog(null, "Error al Guardar");	
				limpiar();
			}
		}
// ++ MODIFICAR ++ 
		if(e.getSource() == frm.btnModificar){

			mod.setId( Integer.parseInt(frm.txtId.getText()));
			mod.setNombreNave(frm.txtNombreNave.getText());
			mod.setTipoNave(frm.txtTipoNave.getText());
			mod.setFechaLanzamiento(frm.txtFechaLanzamiento.getText());
			mod.setPesoToneladas(  Double.parseDouble(frm.txtToneladas.getText()));

			if(modC.modificar(mod)){

				JOptionPane.showMessageDialog(null, "Registro Modificado");
				limpiar();

			} else {
				JOptionPane.showMessageDialog(null, "Error al Modificar");	
				limpiar();
			}
		}
// ++ ELIMINAR ++
// si la consulta recibida es true, la elimina por medio del id
		if(e.getSource() == frm.btnEliminar){
                    //id 
			mod.setId( Integer.parseInt(frm.txtId.getText()));
//mensaje  al usuario  segun el caso
			if(modC.eliminar(mod)){

				JOptionPane.showMessageDialog(null, "Registro Eliminado");
				limpiar();

			} else {
				JOptionPane.showMessageDialog(null, "Error al Eliminar");	
				limpiar();
			}
		}
// ++ BUSCAR ++
		if(e.getSource() == frm.btnBuscar){
//Recibe el valor ingresado en el txt de nombre de nave a traves del metodo get de la nave
			mod.setNombreNave(frm.txtNombreNave.getText());
                        // si la consulta retorna true ejecuta la busqueda
			if(modC.buscar(mod)){

				frm.txtId.setText(String.valueOf(mod.getId()));
				frm.txtNombreNave.setText(mod.getNombreNave());
				frm.txtTipoNave.setText(mod.getTipoNave());
				frm.txtFechaLanzamiento.setText(mod.getFechaLanzamiento());
				frm.txtToneladas.setText(String.valueOf(mod.getPesoToneladas()));

			} else {
				JOptionPane.showMessageDialog(null, "No se encontro registro");	
				limpiar();
			}
		}
                    //Si donde se recibe el dato está vacio, se ejecuta el metodo limpiar
		if(e.getSource() == frm.btnLimpiar){
			limpiar();
		}

	}
//Metodo limpiar
        //Enviamos null a los txt creados para que esten visiblemente vacios en el jframe
	public void limpiar(){
		frm.txtId.setText(null);
		frm.txtNombreNave.setText(null);
		frm.txtTipoNave.setText(null);
		frm.txtFechaLanzamiento.setText(null);
		frm.txtToneladas.setText(null);
        }
}