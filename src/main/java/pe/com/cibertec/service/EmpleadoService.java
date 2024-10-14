package pe.com.cibertec.service;

import java.util.List;

import pe.com.cibertec.model.Empleado;

public interface EmpleadoService {

	List<Empleado> listarEmpleados();

	Empleado buscarPorId(String id);

	void guardarEmpleado(Empleado empleado);

	void actualizarEmpleado(String id, Empleado empleado);

	void eliminarEmpleado(String id);

}
