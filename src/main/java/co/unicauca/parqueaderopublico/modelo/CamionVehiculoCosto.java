package co.unicauca.parqueaderopublico.modelo;

import co.unicauca.parqueaderopublico.utilidades.Round;

/**
 * @author Juan Sebastian Osorio, Diego Vidal Lopez
 */
public class CamionVehiculoCosto implements IVehiculoCosto{
    /**
     * calcula el pago de un camion
     * @param minutos recibe las horas que estuvo el camion en forma 
     * de minutos para mas facil su manejo a la hora del calculo
     * @return pago de naturaleza double
     */
    @Override
    public double calcularPago(int minutos) {
        double pago=0;
        if (minutos<=1440 && minutos>720) {
            pago=15000;
        }else if (minutos<=720) {
            pago=10000;
        }else if (minutos>1440) {
            pago=15000+(((minutos-1440)*15000)/1440);
        }
        return Round.redondear((int) pago);
    }
    
}
