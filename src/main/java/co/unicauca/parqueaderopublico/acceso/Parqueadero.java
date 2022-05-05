package co.unicauca.parqueaderopublico.acceso;

import co.unicauca.parqueaderopublico.modelo.*;
import java.time.Instant;
/**
 * @author Juan SebasOsorio, Diego Vidal Lopez
 */
public class Parqueadero {
    /**
     * fecha donde se registra la entrada de un vehiculo
     */
    private Instant fechaEntrada;
    /**
     * fecha donde se registra la salida de un vehiculo
     */
    private Instant fechaSalida;
    /**
     * la placa del vehiculo en el parqueadero
     */
    private String placa;
    /**
     * Tipo de vehiculo guardado
     */
    private VehiculoEnum vehiculo;
    /**
     * guarda un numero de sorteo aleatorio(si es camion);
     */
    private int numSorteo;
    
    public Parqueadero(){
        this.vehiculo=null;
        this.fechaEntrada=null;
        this.fechaSalida=null;
        this.placa="";
        this.numSorteo=-1;
    }
    /**
     * Constructor parametrizado
     * @param vehiculo tipo de vehiculo al registrar
     * @param fechaEntrada  fecha y hora que se registra al entrar un vehiculo al parqueadero
     * @param placa Identificacion del vehiculo
     */
    public Parqueadero(VehiculoEnum vehiculo,Instant fechaEntrada,String placa){
        this.vehiculo=vehiculo;
        this.fechaEntrada=fechaEntrada;
        this.placa=placa;
        this.numSorteo=-1;
    }
    //Getters y setters

    public Instant getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Instant fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Instant getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Instant fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public VehiculoEnum getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoEnum vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getNumSorteo() {
        return numSorteo;
    }

    public void setNumSorteo(int numSorteo) {
        this.numSorteo = numSorteo;
    }
    
}
