/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.9.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.Gestor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.openapitools.util.ApiUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-17T11:57:22.023517+02:00[Europe/Madrid]", comments = "Generator version: 7.9.0")
@Validated
@Tag(name = "Gestores", description = "Operaciones relacionadas con los gestores.")
public interface GestoresApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /gestores : Obtener todos los gestores
     * Devuelve una lista de todos los gestores.
     *
     * @return Lista de gestores obtenida exitosamente. (status code 200)
     */
    @Operation(
            operationId = "gestoresGet",
            summary = "Obtener todos los gestores",
            description = "Devuelve una lista de todos los gestores.",
            tags = {"Gestores"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de gestores obtenida exitosamente.", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Gestor.class)))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/gestores",
            produces = {"application/json"}
    )

    default ResponseEntity<List<Gestor>> gestoresGet(

    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"apellidos\" : \"apellidos\", \"password\" : \"password\", \"fecha_de_nacimiento\" : \"DD/MM/AAAA\", \"id\" : 0, \"nombre\" : \"nombre\", \"email\" : \"nombre@email.com\" }, { \"apellidos\" : \"apellidos\", \"password\" : \"password\", \"fecha_de_nacimiento\" : \"DD/MM/AAAA\", \"id\" : 0, \"nombre\" : \"nombre\", \"email\" : \"nombre@email.com\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /gestores/{id_de_usuario} : Borrar un gestor
     * Borra un gestor específico por su ID.
     *
     * @param idDeUsuario ID del gestor. (required)
     * @return Gestor borrado exitosamente. (status code 204)
     * or Gestor no encontrado. (status code 404)
     */
    @Operation(
            operationId = "gestoresIdDeUsuarioDelete",
            summary = "Borrar un gestor",
            description = "Borra un gestor específico por su ID.",
            tags = {"Gestores"},
            responses = {
                    @ApiResponse(responseCode = "204", description = "Gestor borrado exitosamente."),
                    @ApiResponse(responseCode = "404", description = "Gestor no encontrado.")
            }
    )
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/gestor/{id_de_usuario}"
    )

    default ResponseEntity<Void> gestoresIdDeUsuarioDelete(
            @Parameter(name = "id_de_usuario", description = "ID del gestor.", required = true, in = ParameterIn.PATH) @PathVariable("id_de_usuario") Integer idDeUsuario
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /gestores/{id_de_usuario} : Obtener detalles de un gestor
     * Devuelve los detalles de un gestor por su ID.
     *
     * @param idDeUsuario ID del gestor. (required)
     * @return Detalles del gestor obtenidos exitosamente. (status code 200)
     * or Gestor no encontrado. (status code 404)
     */
    @Operation(
            operationId = "gestoresIdDeUsuarioGet",
            summary = "Obtener detalles de un gestor",
            description = "Devuelve los detalles de un gestor por su ID.",
            tags = {"Gestores"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Detalles del gestor obtenidos exitosamente.", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Gestor.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Gestor no encontrado.")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/gestor/{id_de_usuario}",
            produces = {"application/json"}
    )

    default ResponseEntity<Gestor> gestoresIdDeUsuarioGet(
            @Parameter(name = "id_de_usuario", description = "ID del gestor.", required = true, in = ParameterIn.PATH) @PathVariable("id_de_usuario") Integer idDeUsuario
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"apellidos\" : \"apellidos\", \"password\" : \"password\", \"fecha_de_nacimiento\" : \"DD/MM/AAAA\", \"id\" : 0, \"nombre\" : \"nombre\", \"email\" : \"nombre@email.com\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /gestores/{id_de_usuario} : Actualizar datos de un gestor
     * Actualiza los datos de un gestor específico.
     *
     * @param idDeUsuario ID del gestor. (required)
     * @param gestor      (required)
     * @return Datos del gestor actualizados exitosamente. (status code 200)
     * or Datos inválidos proporcionados. (status code 400)
     */
    @Operation(
            operationId = "gestoresIdDeUsuarioPut",
            summary = "Actualizar datos de un gestor",
            description = "Actualiza los datos de un gestor específico.",
            tags = {"Gestores"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Datos del gestor actualizados exitosamente."),
                    @ApiResponse(responseCode = "400", description = "Datos inválidos proporcionados.")
            }
    )
    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/gestor/{id_de_usuario}",
            consumes = {"application/json"}
    )

    default ResponseEntity<Void> gestoresIdDeUsuarioPut(
            @Parameter(name = "id_de_usuario", description = "ID del gestor.", required = true, in = ParameterIn.PATH) @PathVariable("id_de_usuario") Integer idDeUsuario,
            @Parameter(name = "Gestor", description = "", required = true) @Valid @RequestBody Gestor gestor
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /gestores : Crear un nuevo gestor
     * Da de alta un nuevo gestor en la aplicación.
     *
     * @param gestor (required)
     * @return Gestor creado exitosamente. (status code 201)
     * or Datos inválidos proporcionados. (status code 400)
     */
    @Operation(
            operationId = "gestoresPost",
            summary = "Crear un nuevo gestor",
            description = "Da de alta un nuevo gestor en la aplicación.",
            tags = {"Gestores"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "Gestor creado exitosamente."),
                    @ApiResponse(responseCode = "400", description = "Datos inválidos proporcionados.")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/gestor",
            consumes = {"application/json"}
    )

    default ResponseEntity<Void> gestoresPost(
            @Parameter(name = "Gestor", description = "", required = true) @Valid @RequestBody Gestor gestor
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
