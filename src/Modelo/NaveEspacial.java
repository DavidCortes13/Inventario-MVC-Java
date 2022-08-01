package Modelo;

/**
 *
 * @author Tec David Cortes
 * 3223149084
 * cortesd114@gmail.com
 */
public class NaveEspacial {

   //Se declaran los datos que utilizaremos ...deben ser los mismos que la tabla en la base de datos.
   private int id;
   private String nombreNave;
   private String tipoNave;
   private String fechaLanzamiento;
   private double pesoToneladas;
   
   //metodos get y set para tratar con los datos declarados

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreNave() {
        return nombreNave;
    }

    public void setNombreNave(String nombreNave) {
        this.nombreNave = nombreNave;
    }

    public String getTipoNave() {
        return tipoNave;
    }

    public void setTipoNave(String tipoNave) {
        this.tipoNave = tipoNave;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public double getPesoToneladas() {
        return pesoToneladas;
    }

    public void setPesoToneladas(double pesoToneladas) {
        this.pesoToneladas = pesoToneladas;
    }

   


   

   
}
