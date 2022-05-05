package co.unicauca.parqueaderopublico.modelo;

import co.unicauca.parqueaderopublico.utilidades.Round;

/**
 * @author Juan Sebastian Osorio, Diego Vidal Lopez
 */
public class MotoVehiculoCosto implements IVehiculoCosto{
    /**
     * calcula el pago de una motocicleta
     * @param minutos recibe las horas que la motocicleta en forma 
     * de minutos para mas facil su manejo a la hora del calculo
     * @return pago de naturaleza double
     */
    @Override
    public double calcularPago(int minutos) {
        double pago=0;
        if (minutos<=60) {
            pago=1000;
        }else if (minutos>60) {
            pago=1000+(((minutos-60)*500)/60);
        }
        return Round.redondear((int) pago);
    }
    
}
