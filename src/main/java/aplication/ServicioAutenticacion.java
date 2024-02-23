package aplication;

import domain.entity.Administrador;
import domain.entity.Cuenta;
import domain.entity.Usuario;
import domain.model.Autenticacion;

public class ServicioAutenticacion {
	private Autenticacion modelo;

	public ServicioAutenticacion() {
		this.modelo = new Autenticacion();
	}

	public Cuenta autenticarse(Cuenta cuenta) {
		Cuenta tipoCuenta = modelo.autenticar(cuenta);
		if (tipoCuenta instanceof Administrador) {
			return tipoCuenta;
		}
		if (tipoCuenta instanceof Usuario) {
			return tipoCuenta;
		}
		return tipoCuenta;
	}
}
