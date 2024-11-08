package org.openapitools.controller;

import org.openapitools.api.ClientesApi;
import org.openapitools.model.Cliente;


import org.openapitools.service.ClienteDBService;
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
@RequestMapping("${openapi.aPIUsuarios.base-path:/StreamHub/clientes}")
public class ClientesApiController implements ClientesApi {
    private final ClienteDBService clienteDBService;
    private final NativeWebRequest request;

    @Autowired
    public ClientesApiController(ClienteDBService clienteDBService, NativeWebRequest request) {
        this.clienteDBService = clienteDBService;
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<Cliente>> clientesGet() {
        List<Cliente> clientes = clienteDBService.findAllClientes();
        return ResponseEntity.ok(clientes);
    }

    @Override
    public ResponseEntity<Cliente> clientesIdDeUsuarioGet(Integer idDeUsuario) {
        Optional<Cliente> clienteOptional = clienteDBService.findClienteById(idDeUsuario);

        if (clienteOptional.isPresent()) {
            return ResponseEntity.ok(clienteOptional.get()); // Return 200 with the Cliente data
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if not found
        }
    }

    @Override
    @PostMapping("/register")
    public ResponseEntity<Void> clientesPost(Cliente cliente) {
        // Call the service to save the new Cliente
        boolean isCreated = clienteDBService.createCliente(cliente);

        if (isCreated) {
            // Return 201 Created response
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            // Handle cases where creation failed (e.g., due to validation)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Override
    public ResponseEntity<Void> clientesIdDeUsuarioDelete(Integer idDeUsuario) {
        // Call the service to delete the cliente by ID
        boolean isDeleted = clienteDBService.deleteClienteById(idDeUsuario);

        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }

    @Override
    public ResponseEntity<Void> clientesIdDeUsuarioPut(Integer idDeUsuario, Cliente cliente) {
        // Call the service to update the cliente
        boolean isUpdated = clienteDBService.updateCliente(idDeUsuario, cliente);

        if (isUpdated) {
            return new ResponseEntity<>(HttpStatus.OK); // 200 OK
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }


}
