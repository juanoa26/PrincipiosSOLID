package co.unicauca.parqueaderopublico.modelo;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author Juan Sebastian Osorio, Diego Vidal Lopez
 */
public class VehiculoFactory {
    /**
     * variable donde se mapeara los vehiculos por su tipo
     */
    private Map<VehiculoEnum,IVehiculoCosto> vehiculoDiccionario;
    /**
     * una intancia de la misma clase
     * se le conoce como Singleton
     */
    private static VehiculoFactory instance;
    
    /**
     * Constructor por defecto 
     * este inicializa el mapeo de los vehiculos
     */
    private VehiculoFactory() {
        vehiculoDiccionario = new EnumMap<>(VehiculoEnum.class);
        vehiculoDiccionario.put(VehiculoEnum.Camion, new CamionVehiculoCosto());
        vehiculoDiccionario.put(VehiculoEnum.Carro, new CarroVehiculoCosto());
        vehiculoDiccionario.put(VehiculoEnum.Moto, new MotoVehiculoCosto());
        // Si se requiere otro tipo de vehiculo, se abre un registro en este diccionario
        // No se viola el principio porque este este modulo no está pensado
        // para que sea estable.
    }
    

    /**
     * Devuelve la instancia de la clase
     *
     * @return instancia unica del service
     */

    public static VehiculoFactory getInstance() {
        if (instance == null) {
            instance = new VehiculoFactory();
        }
        return instance;
    }

    /**
     * Retorna una instancia del vehiculo al calcular el costo, pasado por parametros
     *
     * @param vehiculo recibe el tipo de vehiculo a elegir
     * @return el tipo de vehiculo encontrado
     */
    public IVehiculoCosto getVehiculo(VehiculoEnum vehiculo) {

        IVehiculoCosto result = null;

        if (vehiculoDiccionario.containsKey(vehiculo)) {
            result = vehiculoDiccionario.get(vehiculo);
        }

        return result;

    }
    
}
