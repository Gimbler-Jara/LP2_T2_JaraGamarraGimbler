package pe.com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pe.com.cibertec.model.Area;
import pe.com.cibertec.model.Empleado;
import pe.com.cibertec.service.AreaService;
import pe.com.cibertec.service.EmpleadoService;

@Controller
public class EmpleadoController {
	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private AreaService areaService; 

	@GetMapping("/")
	public String listarAreas(Model model) {
		List<Empleado> listaEmpleado = empleadoService.listarEmpleados();
		model.addAttribute("listaEmpleado", listaEmpleado);
		return "listaEmpleado";
	}

	@GetMapping("/registrar_empleado")
	public String mostrarRegistrarProducto(Model model) {
		List<Area> listaArea = areaService.listarArea();
		model.addAttribute("areas", listaArea);
		model.addAttribute("empleado", new Empleado());
		return "registrar_empleado";
	}

	@PostMapping("/registrar_empleado")
	public String registrarProducto(@ModelAttribute("empleado") Empleado empleado, Model model) {
		empleadoService.guardarEmpleado(empleado);
		return "redirect:/";
	}
	
	@GetMapping("/eliminar_empleado/{id}")
	public String deleteArea(@PathVariable("id") String id) {
		empleadoService.eliminarEmpleado(id);
		return "redirect:/";
	}
	
	@GetMapping("/editar_empleado/{id}")
	public String mostrarEditarArea(@PathVariable("id") String id, Model model) {
		Empleado empleado = empleadoService.buscarPorId(id);
		model.addAttribute("empleado", empleado);
		List<Area> listaArea = areaService.listarArea();
		model.addAttribute("areas", listaArea);
		return "editar_empleado";
	}
	
	@PostMapping("/editar_empleado/{id}")
	public String editarUsuario(@PathVariable("id") String id,@ModelAttribute("empleado") Empleado empleado, Model model) {
		empleadoService.actualizarEmpleado(id, empleado);
		return "redirect:/";
	}
}
