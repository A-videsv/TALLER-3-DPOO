package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	public Ruta getRuta() {
		return ruta;
	}

	public String getFecha() {
		return fecha;
	}

	public Avion getAvion() {
		return avion;
	}

	public Collection<Tiquete> getTiquetes() {
		return tiquetes.values();
	}

	private Ruta ruta;
	private String fecha;
	private Avion avion;
	private Map<String, Tiquete> tiquetes;
	
	public Vuelo(Ruta ruta, String fecha, Avion avion) {
		this.ruta = ruta;
		this.fecha = fecha;
		this.avion = avion;
		this.tiquetes = new HashMap<>();
	}
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) 
			throws VueloSobrevendidoException {
		
	    if (avion.getCapacidad() - tiquetes.size() < cantidad) {
	        throw new VueloSobrevendidoException(this);
	    }
	    
	    int valorTotal = 0;
	    for (int i = 0; i < cantidad; i++) {
	        int tarifa = calculadora.calcularTarifa(this, cliente);
	        valorTotal += tarifa;
	    }
	    
	    for (int i = 0; i < cantidad; i++) {
	        Tiquete tiquete = new Tiquete(fecha, this, cliente, i);
	        tiquetes.put(tiquete.getCodigo(), tiquete);
	        cliente.agregarTiquete(tiquete);
	    }

	    return valorTotal;
	}
}
