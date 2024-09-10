package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {
	
	public static final double IMPUESTO = 0.28;
	public CalculadoraTarifas() {
	}
	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
	protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	protected int calcularValorImpuestos(int costoBase) {
		return (int) Math.round(costoBase*IMPUESTO);
	}
	protected int calcularDistanciaVuelo(Ruta ruta) {
		Aeropuerto origen = ruta.getOrigen();
		Aeropuerto destino = ruta.getDestino();
		
		return Aeropuerto.calcularDistancia(origen, destino);
		
	}
	
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		int costoBase = calcularCostoBase(vuelo, cliente);
		double descuento = calcularPorcentajeDescuento(cliente);
		int valorImpuestos = calcularValorImpuestos(costoBase);
		return (int) Math.round((costoBase-(costoBase*descuento))+
				valorImpuestos);
	}

}