package pe.com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import pe.com.cibertec.model.Area;
import pe.com.cibertec.service.AreaService;

@Controller
@RequestMapping("/area")
public class AreaController {

	@Autowired
	private AreaService areaService;

	@GetMapping("")
	public String listarAreas(Model model) {
		List<Area> listarArea = areaService.listarArea();
		model.addAttribute("listaArea", listarArea);
		return "listaArea";
	}

	@GetMapping("/eliminar_area/{id}")
	public String deleteArea(@PathVariable("id") Integer id) {
		areaService.eliminarArea(id);
		return "redirect:/area";
	}

	@GetMapping("/registrar_area")
	public String mostrarRegistrarArea(Model model) {
		model.addAttribute("area", new Area());
		return "registrar_area";
	}

	@PostMapping("/registrar_area")
	public String registrarArea(@ModelAttribute("area") Area area, Model model) {
		areaService.guardarArea(area);
		return "redirect:/area";
	}
	
	@GetMapping("/editar_area/{id}")
	public String mostrarEditarArea(@PathVariable("id") Integer id, Model model) {
		Area area = areaService.buscarPorId(id);
		model.addAttribute("area", area);
		return "editar_area";
	}
	
	@PostMapping("/editar_area/{id}")
	public String editarUsuario(@PathVariable("id") Integer id,@ModelAttribute("user") Area area, Model model) {
		areaService.actualizarArea(id, area);
		return "redirect:/area";
	}

}
