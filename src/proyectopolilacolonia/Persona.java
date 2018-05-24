package proyectopolilacolonia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Moron
 */
public abstract class Persona extends Entidad {
    //atributos
    protected LocalDate fechaNacimiento;
    protected String codTarjeta;
    protected String dni;
    protected String nombreCompleto;
    protected String sexo;
    protected boolean deleted;
    //relaciones
    protected List<Contacto> contactosList = new ArrayList();
    protected List<Observacion> observacionList = new ArrayList();
    protected Observacion obs;
    protected Contacto contact;

    public Observacion getObs() {
        return obs;
    }

    public void setObs(Observacion obs) {
        this.obs = obs;
    }

    public Contacto getContact() {
        return contact;
    }

    public void setContact(Contacto contact) {
        this.contact = contact;
    }
    
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCodTarjeta() {
        return codTarjeta;
    }

    public void setCodTarjeta(String codTarjeta) {
        this.codTarjeta = codTarjeta;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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
