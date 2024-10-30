package org.openapitools.api;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.openapitools.model.Gestor;


import org.openapitools.services.GestorDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-17T11:57:22.023517+02:00[Europe/Madrid]", comments = "Generator version: 7.9.0")
@Controller
@RequestMapping("${openapi.aPIUsuarios.base-path:/StreamHub}")
public class GestoresApiController implements GestoresApi {
    private final GestorDBService gestorDBService;
    private final NativeWebRequest request;

    @Autowired
    public GestoresApiController(GestorDBService gestorDBService, NativeWebRequest request) {
        this.gestorDBService = gestorDBService;
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<Gestor>> gestoresGet() {
        List<Gestor> gestors = gestorDBService.findAllGestores();
        return ResponseEntity.ok(gestors);
    }

    @Override
    public ResponseEntity<Gestor> gestoresIdDeUsuarioGet(Integer idDeUsuario) {
        Optional<Gestor> gestorOptional = gestorDBService.findGestorById(idDeUsuario);

        if (gestorOptional.isPresent()) {
            return ResponseEntity.ok(gestorOptional.get()); // Return 200 with the Gestor data
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if not found
        }
    }

    @Override
    public ResponseEntity<Void> gestoresPost(Gestor gestor) {
        // Call the service to save the new Gestor
        boolean isCreated = gestorDBService.createGestor(gestor);

        if (isCreated) {
            // Return 201 Created response
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            // Handle cases where creation failed (e.g., due to validation)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Override
    public ResponseEntity<Void> gestoresIdDeUsuarioDelete(Integer idDeUsuario) {
        // Call the service to delete the gestor by ID
        boolean isDeleted = gestorDBService.deleteGestorById(idDeUsuario); // Assuming you have a reference to gestorService

        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }

    @Override
    public ResponseEntity<Void> gestoresIdDeUsuarioPut(Integer idDeUsuario, Gestor gestor) {
        // Call the service to update the gestor
        boolean isUpdated = gestorDBService.updateGestor(idDeUsuario, gestor); // Assuming you have a reference to gestorService

        if (isUpdated) {
            return new ResponseEntity<>(HttpStatus.OK); // 200 OK
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }
}
