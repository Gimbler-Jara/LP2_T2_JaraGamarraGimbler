package pe.com.cibertec.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_empleado")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Empleado {
	
	@Id
	@Column(name = "dni_empleado", unique = true,columnDefinition = "CHAR(8)", length = 8)
	private String dni;
	
	@Column(name = "nombre_empleado", length = 45)
	private String nombre;
	
	@Column(name = "apellido_empleado", length = 45)
	private String apellido;
	
	@Column(name = "fecha_nacimiento", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	
	@Column(length = 45)
	private String direccion;
	
	@Column(length = 45)
	private String correo;
	
	@ManyToOne
	@JoinColumn(name = "area_id", nullable = false)
	private Area area;
	
	

}
