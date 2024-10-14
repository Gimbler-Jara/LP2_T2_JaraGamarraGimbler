package pe.com.cibertec.service;

import java.util.List;

import pe.com.cibertec.model.Area;

public interface AreaService {

	public List<Area> listarArea();

	public Area buscarPorId(Integer id);

	public void guardarArea(Area area);

	public void actualizarArea(Integer id, Area area);

	void eliminarArea(Integer id);

}
