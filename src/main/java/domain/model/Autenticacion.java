package domain.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import domain.entity.Administrador;
import domain.entity.Cuenta;
import domain.entity.Usuario;

public class Autenticacion {
	private AbsCRUD<Administrador> modeloAdmin;
	private AbsCRUD<Usuario> modeloUser;
	private List<Cuenta> cuentas;

	public Autenticacion() {
		this.modeloAdmin = new AdministradorModel();
		this.modeloUser = new UsuarioModel();
		List<Administrador> administradores = modeloAdmin.lista();
		List<Usuario> usuarios = modeloUser.lista();
		cuentas = new ArrayList<>();
		cuentas.addAll(administradores);
		cuentas.addAll(usuarios);
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Cuenta autenticar(Cuenta cuenta) {
		for (Cuenta cuentaA : cuentas) {
			if (cuentaA.getUser().equals(cuenta.getUser()) && cuentaA.getPass().equals(cuenta.getPass())) {
				if (cuentaA instanceof Administrador) {
					return (Administrador) cuentaA;
				} else if (cuentaA instanceof Usuario) {
					return (Usuario) cuentaA;
				}
			}
		}
		return null;
	}

}
