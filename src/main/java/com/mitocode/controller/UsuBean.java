package com.mitocode.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.ButtonModel;
import javax.swing.DefaultButtonModel;

import org.mindrot.jbcrypt.BCrypt;

import com.mitocode.model.Persona;
import com.mitocode.model.Usuario;
import com.mitocode.service.IUsuarioService;

@Named
@ViewScoped
public class UsuBean implements Serializable {

	@Inject
	private IUsuarioService service;
	private Usuario usuario;
	private List<Usuario> lista;
	private String veriPass;
	private String modiPass;
	private boolean visible;

	@PostConstruct
	public void init() {

		usuario = new Usuario();
		
		this.listarPorNombre();

	}

	public void modificarUsuario() {

		try {

			this.usuario.setContrasena(modiPass);
			this.service.modificar(this.usuario);
			this.limpiarUsuario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void verificarContra() {

		if (BCrypt.checkpw(veriPass, usuario.getContrasena())) {
			visible = true;
		}

	}

	public void leerUsuario(Usuario e) {

		this.usuario = e;

	}

	public void limpiarUsuario() {
		usuario = new Usuario();
	}

	public void listarPorNombre() {
		try {
			this.lista = this.service.listarPorNombre(usuario);
			usuario = new Usuario();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getLista() {
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}

	public String getVeriPass() {
		return veriPass;
	}

	public void setVeriPass(String veriPass) {
		this.veriPass = veriPass;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getModiPass() {
		return modiPass;
	}

	public void setModiPass(String modiPass) {
		this.modiPass = modiPass;
	}

}
