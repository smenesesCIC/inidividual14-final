package es.cic.bootcamp.individual14_final.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
public class TipoMedida {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Length(max = 15)
	@NotBlank
	private String nombre;
	
	@NotBlank
	private String unidades;
	
	public TipoMedida() {
		super();
	}
	

	public TipoMedida(@Length(max = 15) @NotBlank String nombre, @NotBlank String unidades) {
		this.nombre = nombre;
		this.unidades = unidades;
	}


	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getUnidades() {
		return unidades;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setUnidades(String unidades) {
		this.unidades = unidades;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, unidades);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoMedida other = (TipoMedida) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(unidades, other.unidades);
	}

	@Override
	public String toString() {
		return "TipoMedida [id=" + id + ", nombre=" + nombre + ", unidades=" + unidades + "]";
	}

	

}
