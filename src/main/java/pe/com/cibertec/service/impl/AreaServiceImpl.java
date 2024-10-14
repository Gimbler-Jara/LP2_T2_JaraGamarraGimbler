package pe.com.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.model.Area;
import pe.com.cibertec.repository.AreaRepository;
import pe.com.cibertec.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaRepository areaRepository;

	@Override
	public List<Area> listarArea() {
		return areaRepository.findAll();
	}

	@Override
	public Area buscarPorId(Integer id) {
		return areaRepository.findById(id).get();
	}

	@Override
	public void guardarArea(Area area) {
		areaRepository.save(area);
	}

	@Override
	public void actualizarArea(Integer id, Area area) {
		Area _area = buscarPorId(id);
		try {
			_area.setNombreArea(area.getNombreArea());
			areaRepository.save(area);
		} catch (Exception e) {
			throw new RuntimeException("Error al actualizar");
		}
	}

	@Override
	public void eliminarArea(Integer id) {
		Area area = buscarPorId(id);
		if (area != null) {
			areaRepository.delete(area);
		}
	}

}
