package es.cic.bootcamp.individual14_final.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
public class Medida {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Length(max = 15)
	@NotBlank
	private String nombre;
	
	@OneToOne
	private TipoMedida tipoMedida;
	
	private int equivalencia;
	
	private int medida;

	public TipoMedida getTipoMedida() {
		return tipoMedida;
	}

	public int getEquivalencia() {
		return equivalencia;
	}

	public int getMedida() {
		return medida;
	}

	public void setTipoMedida(TipoMedida tipoMedida) {
		this.tipoMedida = tipoMedida;
	}

	public void setEquivalencia(int equivalencia) {
		this.equivalencia = equivalencia;
	}

	public void setMedida(int medida) {
		this.medida = medida;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Medida(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Medida(){
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, tipoMedida);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medida other = (Medida) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(tipoMedida, other.tipoMedida);
	}

	@Override
	public String toString() {
		return "Medida [id=" + id + ", nombre=" + nombre + ", tipoMedida=" + tipoMedida + ", equivalencia="
				+ equivalencia + ", medida=" + medida + "]";
	}



}
