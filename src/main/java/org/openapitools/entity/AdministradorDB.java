package org.openapitools.entity;

import org.openapitools.model.Administrador;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Administrador")
public class AdministradorDB {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellidos;
    private String email;
	private String password;

    @Column(name = "fecha_de_nacimiento")
	private LocalDate fechaDeNacimiento;

	@Override
	public String toString() {
		return "AdministradorDB{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", apellidos='" + apellidos + '\'' +
				", fechaDeNacimiento='" + fechaDeNacimiento + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				'}';
	}

	protected AdministradorDB() {
        //Empty constructor
    }

	public AdministradorDB(Administrador admin) {
		id = admin.getId();
		nombre = admin.getNombre();
		apellidos = admin.getApellidos();
		fechaDeNacimiento = LocalDate.parse(admin.getFechaDeNacimiento());
		email = admin.getEmail();
		password = admin.getPassword();
	}

    // Getters and Setters
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
