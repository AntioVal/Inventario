package org.gp.inventario.controladores;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.gp.inventario.daos.UsuarioDAO;
import org.gp.inventario.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormsControlador {

	@Autowired
	@Qualifier("usuarioDAO")
	private UsuarioDAO usuarioDAO;

//	@InitBinder
//	public void initBinder(WebDataBinder webDataBinder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		dateFormat.setLenient(false);
//		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(
//				dateFormat, true));
//	}

	@RequestMapping(value = "/")
	public String muestraBlog(String cadena, Integer offset,
			@RequestParam(value = "lim", required = false) Integer limite,
			Model modelo) {

		System.out.println("offset:" + offset + ", limite:" + limite);

		modelo.addAttribute("fecha", new Date());
		modelo.addAttribute("cadena", cadena);
		modelo.addAttribute("offset", offset);

		return "login";
	}

	@RequestMapping(value = "/session")
	public String pruebaSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		// session.setAttribute("valSession", "valSessionValor");
		if (session.getAttribute("valSession") != null)
			System.out.println("valSession:"
					+ session.getAttribute("valSession").toString());
		request.setAttribute("valReq", "valReqValor");
		System.out.println("asignar a Session");
		session.setAttribute("valSession", "valSessionValor");

		return "home";
	}

	@RequestMapping(value = "/usuario/{usuarioId:[0-9]+}")
	public String muestraUsuario(@PathVariable Integer usuarioId, Model modelo) {
		System.out.println("usuario id:" + usuarioId);

		// hacemos la consulta usando hibernate
		Usuario usuario = usuarioDAO.buscaPorId(usuarioId);

		modelo.addAttribute("nombre", "usuario prueba");
		// aventamos el resultado de la consulta a la vista
		modelo.addAttribute("usuario", usuario);

		return "usuario";
	}

	@RequestMapping(value = "/Login")
	public String loginCheck(Model modelo, HttpServletRequest request) {
		Usuario usuario = null;
		// hacemos la consulta usando hibernate
		usuario = usuarioDAO.buscaPorUsuarioContrasenaStatusA(
				request.getParameter("usuario"),
				request.getParameter("contrasenna"));
		if (usuario == null) {
			modelo.addAttribute("msg", "¡Usuario o contraseña incorrectos!");
			return "login";
		}
		// modelo.addAttribute("nombre", "usuario prueba");
		// aventamos el resultado de la consulta a la vista
		request.getSession().setAttribute("usuarioSession", usuario);

		return "home";
	}

	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public String modificarUsuario(@ModelAttribute Usuario usuario,
			BindingResult validacion, Model modelo, HttpServletRequest request) {
		Integer idUsuario = usuarioDAO.modificar(usuario);

		return "redirect:/usuario/" + idUsuario + "/";
	}

	@RequestMapping(value = "/nuevoUsuario")
	public String nuevoUsuario(@ModelAttribute @Valid Usuario usuario,
			BindingResult validacion, Model modelo,
			@RequestParam(value = "validar", required = false) Boolean validar) {
		String ruta = "nuevoUsuario";
		if (validar != null && validar) {
			System.out.println("Valindando datos de usuario ...");
			if (validacion.hasErrors()) {
				System.out.println("¡Errores obtenidos al validar usuario!");
				// si hay errores de validacion
				System.out.println(validacion.toString());
				modelo.addAttribute("usuario", usuario);
				ruta = "/nuevoUsuario";
			} else {
				Integer idUsuario = usuarioDAO.crearNuevo(usuario);
				ruta = "redirect:/usuario/" + idUsuario + "/";
			}
		}
		return ruta;
	}

}
