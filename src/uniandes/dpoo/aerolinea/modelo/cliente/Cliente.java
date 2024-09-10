package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {

	private List<Tiquete> tiquetesSinUsar;
	private List<Tiquete> tiquetesUsados;
	
	public Cliente() {
		tiquetesSinUsar = new ArrayList<>();
		tiquetesUsados = new ArrayList<>();
		
	}
	
	public abstract String getTipoCliente();
	public abstract String getIdentificador();
	
	public void agregarTiquete(Tiquete tiquete) {
		tiquetesSinUsar.add(tiquete);
	}
	
	public int calcularValorTotalTiquetes() {
		int total = 0;
		for (Tiquete tiquete: tiquetesSinUsar) {
			total += tiquete.getTarifa();
		}
		return total;
	}
	
	public void usarTiquetes(Vuelo vuelo) {
		for (Tiquete tiquete: tiquetesSinUsar) {
			if (tiquete.getVuelo().equals(vuelo)) {
				tiquetesUsados.add(tiquete);
				tiquetesSinUsar.remove(tiquete);
			}
		}
	}
	
}