package pe.com.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.model.Empleado;
import pe.com.cibertec.repository.EmpleadoRepository;
import pe.com.cibertec.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public List<Empleado> listarEmpleados() {
		return empleadoRepository.findAll();
	}

	@Override
	public Empleado buscarPorId(String id) {
		return empleadoRepository.findById(id).get();
	}

	@Override
	public void guardarEmpleado(Empleado empleado) {
		empleadoRepository.save(empleado);
	}

	@Override
	public void actualizarEmpleado(String id, Empleado empleado) {
		Empleado _empleado = buscarPorId(id);
		try {
			_empleado.setDni(id);
			_empleado.setNombre(empleado.getNombre());
			_empleado.setApellido(empleado.getApellido());
			_empleado.setFechaNacimiento(empleado.getFechaNacimiento());
			_empleado.setCorreo(empleado.getCorreo());
			_empleado.setDireccion(empleado.getDireccion());
			_empleado.setArea(empleado.getArea());
			empleadoRepository.save(_empleado);
		} catch (Exception e) {
			throw new RuntimeException("Error al actualizar" + e.getMessage());
		}
	}

	@Override
	public void eliminarEmpleado(String id) {
		Empleado _empleado = buscarPorId(id);
		if (_empleado != null) {
			empleadoRepository.delete(_empleado);
		}
	}

}
