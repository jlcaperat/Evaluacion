package com.mitocode.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;

import com.mitocode.dao.IUsuarioDAO;
import com.mitocode.model.Usuario;
import com.mitocode.service.IUsuarioService;

@Named
public class UsuarioServiceImpl implements IUsuarioService, Serializable {

	@EJB
	private IUsuarioDAO dao;

	@Override
	public Usuario login(Usuario us) {
		String clave = us.getContrasena();
		String claveHash = dao.traerPassHashed(us.getUsuario());

		try {
			if (BCrypt.checkpw(clave, claveHash)) {
				return dao.leerPorNombreUsuario(us.getUsuario());
			}
		} catch (Exception e) {
			throw e;
		}

		return new Usuario();
	}

	@Override
	public List<Usuario> listarPorNombre(Usuario usuario) {
		// TODO Auto-generated method stub
		return dao.listarPorNombre(usuario);
	}

	@Override
	public Integer registrar(Usuario t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer modificar(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		return dao.modificar(usuario);
	}

	@Override
	public Integer eliminar(Usuario t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public Usuario listarPorId(Usuario t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer verificarContra(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
