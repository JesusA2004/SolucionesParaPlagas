package com.controlador;

import com.modelo.entidad.Cliente;

import java.util.Collections;
import java.util.List;

public class ControladorCliente extends Controlador<Cliente>{



    @Override
    protected List<Cliente> getList() {
        return Collections.emptyList();
    }

    @Override
    protected Cliente getObject(String id) {
        return null;
    }

    @Override
    protected boolean deleteObject(String id) {
        return false;
    }

    @Override
    protected boolean modifyObject(Cliente newObject) {
        return false;
    }

    @Override
    protected boolean insertObject(Cliente object) {
        return false;
    }

}
