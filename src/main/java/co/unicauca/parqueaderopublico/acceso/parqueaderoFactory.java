package co.unicauca.parqueaderopublico.acceso;

/**
 *
 * @author Juan SebasOsorio, Diego Vidal Lopez
 */
public class parqueaderoFactory {
    private static parqueaderoFactory instance;
    
    /**
     * Clase singleton
     *
     * @return
     */
    public static parqueaderoFactory getInstance() {

        if (instance == null) {
            instance = new parqueaderoFactory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IProductRepository
     *
     * @param type cadena que indica qué tipo de clase hija debe instanciar
     * @return una clase hija de la abstracción IProductRepository
     */
    public IParqueaderoRepository getRepository(String type) {

        IParqueaderoRepository result = null;

        switch (type) {
            case "default":
                result = new ParqueaderoRepository();
                break;
        }

        return result;

    }
}
