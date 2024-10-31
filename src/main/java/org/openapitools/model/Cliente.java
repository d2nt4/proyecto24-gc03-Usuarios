package org.openapitools.model;

import java.net.URI;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;

import java.time.OffsetDateTime;
import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.*;

import io.swagger.v3.oas.annotations.media.Schema;
import org.openapitools.modelDB.ClienteDB;


import java.util.*;
import javax.annotation.Generated;

/**
 * Cliente
 */


@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-17T11:57:22.023517+02:00[Europe/Madrid]", comments = "Generator version: 7.9.0")
public class Cliente {

    private Integer id;

    private String nombre;

    private String apellidos;

    private String fechaDeNacimiento;

    private String email;

    private String password;

    private String numeroTarjetaDeCredito;

    private String ccv;

    public Cliente(ClienteDB clienteDB) {
        this.id = clienteDB.getId();
        this.nombre = clienteDB.getNombre();
        this.apellidos = clienteDB.getApellidos();
        this.fechaDeNacimiento = clienteDB.getFechaDeNacimiento()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.email = clienteDB.getEmail();
        this.password = clienteDB.getPassword();
        this.numeroTarjetaDeCredito = clienteDB.getNumeroTarjetaDeCredito();
        this.ccv = clienteDB.getCcv();
    }

    public Cliente id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
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

    public Cliente nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    /**
     * Get nombre
     *
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

    public Cliente apellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    /**
     * Get apellidos
     *
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

    public Cliente fechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
        return this;
    }

    /**
     * Get fechaDeNacimiento
     *
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

    public Cliente email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Get email
     *
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

    public Cliente password(String password) {
        this.password = password;
        return this;
    }

    /**
     * Get password
     *
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

    public Cliente numeroTarjetaDeCredito(String numeroTarjetaDeCredito) {
        this.numeroTarjetaDeCredito = numeroTarjetaDeCredito;
        return this;
    }

    /**
     * Get numeroTarjetaDeCredito
     *
     * @return numeroTarjetaDeCredito
     */

    @Schema(name = "numero_tarjeta_de_credito", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("numero_tarjeta_de_credito")
    public String getNumeroTarjetaDeCredito() {
        return numeroTarjetaDeCredito;
    }

    public void setNumeroTarjetaDeCredito(String numeroTarjetaDeCredito) {
        this.numeroTarjetaDeCredito = numeroTarjetaDeCredito;
    }

    public Cliente ccv(String ccv) {
        this.ccv = ccv;
        return this;
    }

    /**
     * Get ccv
     *
     * @return ccv
     */

    @Schema(name = "ccv", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("ccv")
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
        Cliente cliente = (Cliente) o;
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

