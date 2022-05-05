package co.unicauca.parqueaderopublico.acceso;

import java.util.List;

/**
 * @author Juan SebasOsorio, Diego Vidal Lopez
 */
public interface IParqueaderoRepository {
    boolean guardarVehiculo(Parqueadero vehiculo);
    List<Parqueadero> lista();
}
