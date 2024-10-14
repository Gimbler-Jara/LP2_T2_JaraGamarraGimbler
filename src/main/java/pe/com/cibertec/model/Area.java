package pe.com.cibertec.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_area")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Area {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "area_id")
    private Integer id;
	
	@Column(nullable = false, length = 45)
    private String nombreArea; 

}
