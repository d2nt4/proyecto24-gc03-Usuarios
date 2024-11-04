package org.openapitools.model;

import java.time.format.DateTimeFormatter;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.openapitools.entity.AdministradorDB;

import javax.annotation.Generated;

/**
 * Administrador
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-17T11:57:22.023517+02:00[Europe/Madrid]", comments = "Generator version: 7.9.0")
public class Administrador {

  private Integer id;

  private String nombre;

  private String apellidos;

  private String fechaDeNacimiento;

  private String email;

  private String password;

  public Administrador id(Integer id) {
    this.id = id;
    return this;
  }

  public Administrador(Integer id, String nombre, String apellidos, String fechaDeNacimiento, String email, String password) {
    this.id = id;
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.fechaDeNacimiento = fechaDeNacimiento;
    this.email = email;
    this.password = password;
  }

  public Administrador(AdministradorDB adminDB) {
    id = adminDB.getId();
    nombre = adminDB.getNombre();
    apellidos = adminDB.getApellidos();
    fechaDeNacimiento = adminDB.getFechaDeNacimiento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    email = adminDB.getEmail();
    password = adminDB.getPassword();
  }

  /**
   * Get id
   * @return id
   */

  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Administrador nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * @return nombre
   */

  @Schema(name = "nombre", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nombre")
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Administrador apellidos(String apellidos) {
    this.apellidos = apellidos;
    return this;
  }

  /**
   * Get apellidos
   * @return apellidos
   */

  @Schema(name = "apellidos", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("apellidos")
  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public Administrador fechaDeNacimiento(String fechaDeNacimiento) {
    this.fechaDeNacimiento = fechaDeNacimiento;
    return this;
  }

  /**
   * Get fechaDeNacimiento
   * @return fechaDeNacimiento
   */

  @Schema(name = "fecha_de_nacimiento", example = "DD/MM/AAAA", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fecha_de_nacimiento")
  public String getFechaDeNacimiento() {
    return fechaDeNacimiento;
  }

  public void setFechaDeNacimiento(String fechaDeNacimiento) {
    this.fechaDeNacimiento = fechaDeNacimiento;
  }

  public Administrador email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   */

  @Schema(name = "email", example = "nombre@email.com", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Administrador password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
   */

  @Schema(name = "password", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Administrador administrador = (Administrador) o;
    return Objects.equals(this.id, administrador.id) &&
            Objects.equals(this.nombre, administrador.nombre) &&
            Objects.equals(this.apellidos, administrador.apellidos) &&
            Objects.equals(this.fechaDeNacimiento, administrador.fechaDeNacimiento) &&
            Objects.equals(this.email, administrador.email) &&
            Objects.equals(this.password, administrador.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre, apellidos, fechaDeNacimiento, email, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Administrador {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    apellidos: ").append(toIndentedString(apellidos)).append("\n");
    sb.append("    fechaDeNacimiento: ").append(toIndentedString(fechaDeNacimiento)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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
