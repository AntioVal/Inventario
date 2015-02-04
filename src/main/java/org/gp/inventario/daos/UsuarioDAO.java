package org.gp.inventario.daos;

import org.gp.inventario.entidades.Usuario;

public interface UsuarioDAO {
	
	Integer modificar(Usuario usuario);
	
	Integer crearNuevo(Usuario usuario);

	Usuario buscaPorId(Integer usuarioId);	
	
	Usuario buscaPorUsuarioContrasenaStatusA(String usuario, String contrasena);

}
