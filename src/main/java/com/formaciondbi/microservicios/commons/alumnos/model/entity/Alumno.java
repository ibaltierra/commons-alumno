package com.formaciondbi.microservicios.commons.alumnos.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="alumnos")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	@Size(min=3, max = 20)
	private String nombre;
	@NotEmpty
	@Size(min=3, max = 20)
	private String apellido;
	@NotEmpty
	@Email
	@Size(min=5)
	private String email;
	@Lob
	@JsonIgnore//ignorar el campo para el json.
	private byte[] foto;
	@Column(name="create_At")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	/**
	 * Setea la fecha antes de persistir.
	 */
	@PrePersist
	public void prepersist() {
		this.createAt = new Date();
	}
	public Integer getFotoHashCode() {
		return (this.foto!= null)?this.foto.hashCode(): null;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return Boolean.TRUE;
		}
		if(! (obj instanceof Alumno)) {
			return Boolean.FALSE;
		}
		final Alumno tmp = (Alumno)obj;
		return this.id!= null && this.id.equals(tmp.getId());
	}
	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", createAt="
				+ createAt + "]";
	}
	
}
