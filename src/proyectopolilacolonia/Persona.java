package proyectopolilacolonia;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Moron
 */
public abstract class Persona extends Entidad {
    private String nombreCompleto;
    private String dni;
    private List<Contacto> contactosList = new ArrayList();
    private List<Observacion> observacionList = new ArrayList();
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Contacto> getContactosList() {
        return contactosList;
    }

    public void setContactosList(List<Contacto> contactosList) {
        this.contactosList = contactosList;
    }

    public List<Observacion> getObservacionList() {
        return observacionList;
    }

    public void setObservacionList(List<Observacion> observacionList) {
        this.observacionList = observacionList;
    }
    
}
