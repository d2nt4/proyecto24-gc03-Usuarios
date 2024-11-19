package org.openapitools.controller;

import org.openapitools.api.AdminApi;
import org.openapitools.model.Administrador;
import org.openapitools.service.AdministradorDBService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-17T11:57:22.023517+02:00[Europe/Madrid]", comments = "Generator version: 7.9.0")
@Controller
@RequestMapping("${openapi.aPIUsuarios.base-path:/StreamHub}")
public class AdminApiController implements AdminApi {
    private final AdministradorDBService adminDBService;
    private final NativeWebRequest request;

    @Autowired
    public AdminApiController(AdministradorDBService adminDBService, NativeWebRequest request) {
        this.adminDBService = adminDBService;
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<Administrador>> adminGet() {
        List<Administrador> admins = adminDBService.getAllAdministradores();
        return ResponseEntity.ok(admins);
    }

    @Override
    public ResponseEntity<Administrador> adminIdDeUsuarioGet(Integer idDeUsuario) {
        Optional<Administrador> adminOptional = adminDBService.getAdministradorById(idDeUsuario);

        if (adminOptional.isPresent()) {
            return ResponseEntity.ok(adminOptional.get()); // Devuelve 200 OK con los datos del administrador
        } else {
            return ResponseEntity.notFound().build(); // Devuelve 404 Not Found si no se encuentra el administrador
        }
    }

    @Override
    public ResponseEntity<Void> adminPost(Administrador admin) {
        boolean isCreated = adminDBService.postAdministrador(admin);

        if (isCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).build(); // Devuelve 201 Created si se ha creado correctamente
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // Devuelve 400 Bad Request si ha habido un error
        }
    }

    @Override
    public ResponseEntity<Void> adminIdDeUsuarioDelete(Integer idDeUsuario) {
        boolean isDeleted = adminDBService.deleteAdministradorById(idDeUsuario);

        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }

    @Override
    public ResponseEntity<Void> adminIdDeUsuarioPut(Integer idDeUsuario, Administrador admin) {
        boolean isUpdated = adminDBService.updateAdministrador(idDeUsuario, admin);

        if (isUpdated) {
            return new ResponseEntity<>(HttpStatus.OK); // 200 OK
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }
}
