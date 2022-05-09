package co.unicauca.parqueaderopublico.main;

import co.unicauca.parqueaderopublico.acceso.IParqueaderoRepository;
import co.unicauca.parqueaderopublico.acceso.Parqueadero;
import co.unicauca.parqueaderopublico.acceso.Service;
import co.unicauca.parqueaderopublico.acceso.parqueaderoFactory;
import co.unicauca.parqueaderopublico.modelo.VehiculoEnum;
import java.text.ParseException;
import java.time.Instant;

/**
 *
 * @author Juan Sebastian Osorio, Diego Vidal Lopez
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException{
        String string1 = "2020-09-13T00:06:00Z";
        Instant fechaEntrada =  Instant.parse(string1);
        
        Parqueadero parq=new Parqueadero(VehiculoEnum.Camion, fechaEntrada, "ads19c");
        parq.setNumSorteo((int) (Math.random()*1000));
        IParqueaderoRepository parqueos=parqueaderoFactory.getInstance().getRepository("default");
        Service sc=new Service(parqueos);
        sc.guardarVehiculo(parq);
        double pago=sc.calcularPago(parq);
        System.out.println("El pago del parqueadero es: "+pago);
    }
    
}

