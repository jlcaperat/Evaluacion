package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Usuario;

public interface IUsuarioService  extends  IService<Usuario>{

	Usuario login(Usuario us);

	List<Usuario> listarPorNombre(Usuario usuario);
	Integer verificarContra(Usuario usuario);

	
	
	
}
