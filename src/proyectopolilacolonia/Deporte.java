/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia;

/**
 *
 * @author Moron
 */
public class Deporte extends Entidad{

    private String nombreDeporte;
    private ValorCuota cuota;
    
    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }

    public ValorCuota getCuota() {
        return cuota;
    }

    public void setCuota(ValorCuota cuota) {
        this.cuota = cuota;
    }
    
    
}
