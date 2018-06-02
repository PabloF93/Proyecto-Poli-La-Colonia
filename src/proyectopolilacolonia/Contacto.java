package proyectopolilacolonia;

public class Contacto extends Entidad{
    private String nombreContacto;
    private String telefono;
    private String vinculo; // Este atributo indica la relacion con la persona. (Padre, madre, amigo, tutor, etc.)

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String Telefono) {
        this.telefono = Telefono;
    }

    public String getVinculo() {
        return vinculo;
    }

    public void setVinculo(String vinculo) {
        this.vinculo = vinculo;
    }

    
}
