package co.unicauca.parqueaderopublico.modelo;

import co.unicauca.parqueaderopublico.utilidades.Round;

/**
 * @author Juan Sebastian Osorio, Diego Vidal Lopez
 */
public class CarroVehiculoCosto implements IVehiculoCosto{
    /**
     * calcula el pago de un Carro
     * @param minutos recibe las horas que estuvo el Carro en forma 
     * de minutos para mas facil su manejo a la hora del calculo
     * @return pago de naturaleza double
     */
    @Override
    public double calcularPago(int minutos) {
        double pago=0;
        if (minutos<=60) {
            pago=2000;
        }else if (minutos>60) {
            pago=2000+(((minutos-60)*1000)/60);
        }
        return Round.redondear((int) pago);
    }
    
}
