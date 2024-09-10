package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {

	public Cliente getCliente() {
		return cliente;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getTarifa() {
		return tarifa;
	}

	public boolean esUsado() {
		return usado;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}
	
	public void marcarComoUsado() {
		usado = true;
	}

	private Cliente cliente;
	private String codigo;
	private int tarifa;
	private boolean usado;
	private Vuelo vuelo;
	
	public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComprador, int tarifa) {
		this.codigo = codigo;
        this.vuelo = vuelo;
        this.cliente = clienteComprador;
        this.tarifa = tarifa;
        this.usado = false;
        clienteComprador.agregarTiquete(this);
	}
}
