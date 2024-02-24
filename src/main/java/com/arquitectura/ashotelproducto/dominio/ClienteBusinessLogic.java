package com.arquitectura.ashotelproducto.dominio;

import com.arquitectura.ashotelproducto.datos.cliente.ClienteDAOImpl;

public class ClienteBusinessLogic {
    private ClienteDAOImpl clienteDAO;

    public ClienteBusinessLogic(ClienteDAOImpl clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public Cliente buscarPorDni(String dni) {
        return clienteDAO.buscarPorDni(dni);
    }

    public void guardarCliente(Cliente cliente) {
        clienteDAO.insert(cliente);
    }
}