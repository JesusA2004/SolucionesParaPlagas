package com.controlador;

import com.modelo.entidad.Producto;

import java.util.Collections;
import java.util.List;

public class ControladorProducto extends Controlador<Producto>{


    @Override
    protected List<Producto> getList() {
        return Collections.emptyList();
    }

    @Override
    protected Producto getObject(String id) {
        return null;
    }

    @Override
    protected boolean deleteObject(String id) {
        return false;
    }

    @Override
    protected boolean modifyObject(Producto newObject) {
        return false;
    }

    @Override
    protected boolean insertObject(Producto object) {
        return false;
    }

}
