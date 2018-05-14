/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia;

import java.util.Date;

/**
 *
 * @author Moron
 */
public class ValorCuota extends Entidad{
    private float valorCuota;
    private Date fechaEstablecida; // Fecha donde se creo el precio de la cuota

    public float getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(float valorCuota) {
        this.valorCuota = valorCuota;
    }

    public Date getFechaEstablecida() {
        return fechaEstablecida;
    }

    public void setFechaEstablecida(Date fechaEstablecida) {
        this.fechaEstablecida = fechaEstablecida;
    }
    
    
}
