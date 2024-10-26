package org.openapitools.modelDB;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
//Esto especifica que la tabla se llama "Cliente". Si no estuviera, SpringJPA asumiría que la tabla
//se llama "ClienteDB".
@Table(name = "Cliente")
public class ClienteDB {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nombre;
	private String apellidos;
	@Column(name = "fecha_de_nacimiento")
	private LocalDate fechaDeNacimiento;
	private String email;
	private String password;
	@Column(name = "numero_tarjeta_de_credito")
	private String numeroTarjetaDeCredito;
	private String ccv;

	//Parece ser que JPA necesita este constructor.
	protected ClienteDB() {
	}

	public ClienteDB(Integer id, String nombre, String apellidos, LocalDate fechaDeNacimiento, String email, String password, String numeroTarjetaDeCredito, String ccv) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.email = email;
		this.password = password;
		this.numeroTarjetaDeCredito = numeroTarjetaDeCredito;
		this.ccv = ccv;
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

	public String getNumeroTarjetaDeCredito() {
		return numeroTarjetaDeCredito;
	}

	public void setNumeroTarjetaDeCredito(String numeroTarjetaDeCredito) {
		this.numeroTarjetaDeCredito = numeroTarjetaDeCredito;
	}

	public String getCcv() {
		return ccv;
	}

	public void setCcv(String ccv) {
		this.ccv = ccv;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ClienteDB cliente = (ClienteDB) o;
		return Objects.equals(this.id, cliente.id) && Objects.equals(this.nombre, cliente.nombre) && Objects.equals(this.apellidos, cliente.apellidos) && Objects.equals(this.fechaDeNacimiento, cliente.fechaDeNacimiento) && Objects.equals(this.email, cliente.email) && Objects.equals(this.password, cliente.password) && Objects.equals(this.numeroTarjetaDeCredito, cliente.numeroTarjetaDeCredito) && Objects.equals(this.ccv, cliente.ccv);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, apellidos, fechaDeNacimiento, email, password, numeroTarjetaDeCredito, ccv);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Cliente {\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
		sb.append("    apellidos: ").append(toIndentedString(apellidos)).append("\n");
		sb.append("    fechaDeNacimiento: ").append(toIndentedString(fechaDeNacimiento)).append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
		sb.append("    password: ").append(toIndentedString(password)).append("\n");
		sb.append("    numeroTarjetaDeCredito: ").append(toIndentedString(numeroTarjetaDeCredito)).append("\n");
		sb.append("    ccv: ").append(toIndentedString(ccv)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}

