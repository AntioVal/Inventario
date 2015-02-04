package org.gp.inventario.daos;

import org.gp.inventario.entidades.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("usuarioDAO")
@Transactional
public class UsuarioHibernateDAO implements UsuarioDAO {
	
	@Autowired
	private SessionFactory sessionFactory;	

	@Override
	public Integer modificar(Usuario usuario) {
		System.out.println("modificando usuario");

		// Session sesion = sessionFactory.openSession();
		// abrimos una transaccion de la base(esto es por que
		// vamos a modificar datos)
		// sesion.beginTransaction();
		// guardamos los datos
		Session sesion = sessionFactory.getCurrentSession();
		sesion.update(usuario);

		// obtenemos la transaccion sobre la corre este metodo
		// y hacemos commit para reflejar los cambios
		// sesion.getTransaction().commit();
		// terminado todo cerramos la sesion de hibernate
		// sesion.close();

		return usuario.getIdUsuario();
	}
	
	@Override
	public Integer crearNuevo(Usuario usuario) {
		System.out.println("guardando usuario");

		// Session sesion = sessionFactory.openSession();
		// abrimos una transaccion de la base(esto es por que
		// vamos a modificar datos)
		// sesion.beginTransaction();
		// guardamos los datos
		Session sesion = sessionFactory.getCurrentSession();
		sesion.save(usuario);

		// obtenemos la transaccion sobre la corre este metodo
		// y hacemos commit para reflejar los cambios
		// sesion.getTransaction().commit();
		// terminado todo cerramos la sesion de hibernate
		// sesion.close();

		return usuario.getIdUsuario();
	}
	

	@Override
	public Usuario buscaPorId(Integer usuarioId) {
		System.out.println("buscaPorId.........");
		Usuario usuario = null;
		// Session sesion = sessionFactory.openSession();
		Session sesion = sessionFactory.getCurrentSession();
		usuario = (Usuario) sesion.get(Usuario.class, usuarioId);
		
		//Hibernate.initialize(usuario.getArticulos());
		return usuario;
	}
	
	public Usuario buscaPorUsuarioContrasenaStatusA(String usuario, String contrasena){
        Usuario usuarioClass = null;
        
		Criteria criterio = sessionFactory.getCurrentSession().createCriteria(Usuario.class);
		
		//-- SELECT * FROM usuarios where email=? AND password=?
		criterio.add(Restrictions.eq("nombreU", usuario));
		criterio.add(Restrictions.eq("contrasena", contrasena));
		
		//-- SELECT * FROM usuarios where email=? OR password=?
		//desde java 1.5 estan los vargars
		//criterio.add(Restrictions.or(Restrictions.eq("email", email),Restrictions.eq("password", password)));
		
		usuarioClass = (Usuario) criterio.uniqueResult();  
		
		return usuarioClass;
	}

}
