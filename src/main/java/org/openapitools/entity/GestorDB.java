package org.openapitools.entity;

import org.openapitools.model.Gestor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Gestor")
public class GestorDB {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	private String apellidos;

	@Override
	public String toString() {
		return "GestorDB{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", apellidos='" + apellidos + '\'' +
				", fechaDeNacimiento='" + fechaDeNacimiento + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				'}';
	}

	@Column(name = "fecha_de_nacimiento")
	private LocalDate fechaDeNacimiento;

	private String email;

	private String password;

	protected GestorDB() {}

	public GestorDB(Gestor gestor) {
			id = gestor.getId();
			nombre = gestor.getNombre();
			apellidos = gestor.getApellidos();
			fechaDeNacimiento = LocalDate.parse(gestor.getFechaDeNacimiento());
			email = gestor.getEmail();
			password = gestor.getPassword();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = LocalDate.parse(fechaDeNacimiento);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
