package co.unicauca.parqueaderopublico.acceso;

import co.unicauca.parqueaderopublico.modelo.IVehiculoCosto;
import co.unicauca.parqueaderopublico.modelo.VehiculoEnum;
import co.unicauca.parqueaderopublico.modelo.VehiculoFactory;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * @author Juan SebasOsorio, Diego Vidal Lopez
 */
public class Service{
    /**
     * Instancia un objteo de la interface que va a servir para simular un repositorio
     */
    private IParqueaderoRepository repository;
    
    /**
     * Constructor parametrizado
     * @param repository recibe un objeto de la interface IParqueaderoRepository
     */
    public Service(IParqueaderoRepository repository){
        this.repository=repository;
    }
    /**
     * metodo calculaPago() calcula el pago total del vehiculo dentro del parqueadero
     * @param vehiculo
     * @return retorna el total a pagar
     */
    public double calcularPago(Parqueadero vehiculo) {
        double pago;
        Date fechaSalida=new Date();
        Duration d = Duration.between(vehiculo.getFechaEntrada(), fechaSalida.toInstant());
        int minutos = (int) d.toMinutes();
        if (ganadorNumeroSorteo(vehiculo, fechaSalida.toInstant())) {
            pago=0;
        } else {
            IVehiculoCosto veh = VehiculoFactory.getInstance().getVehiculo(vehiculo.getVehiculo());
            pago= veh.calcularPago(minutos);
        }
        return pago;
    }
    /**
     * Hace el sorteo entre vehiculos tipo camion segun las normas del negocio
     * @param vehiculo
     * @param fechaSalida 
     * @return un numero aleatorio efectuando si hay ganador o no
     */
    public boolean ganadorNumeroSorteo(Parqueadero vehiculo, Instant fechaSalida) {
        int numeroGanador=(int) (Math.random()*1000);
        if (vehiculo.getVehiculo().equals(VehiculoEnum.Camion) && vehiculo.getNumSorteo()==numeroGanador) {
            return true;
        }
        return false;
    }
    /**
     * Guarda un vehiculo dentro de un repositorio parqueadero
     * @param vehiculo recibe el vehiculo
     * @return true o false confirmando el exito de la operacion
     */
    public boolean guardarVehiculo(Parqueadero vehiculo){
        if (vehiculo == null || vehiculo.getPlaca().isBlank() || vehiculo.getVehiculo().name().isBlank()) {
            return false;   
        }
        return repository.guardarVehiculo(vehiculo);
    }
    /**
     * Lista todos los vehiculos del repositorio parqueadero
     * sacados de la base de datos
     * @return lista completa de vehiculos en un parqueadero
     */
    public List<Parqueadero> listaVehiculos() {
        List<Parqueadero> vehiculos = repository.lista();
        return vehiculos;
    }
}
