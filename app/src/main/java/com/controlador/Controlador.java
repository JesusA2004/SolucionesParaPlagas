package com.controlador;

import java.util.List;

public abstract class Controlador <Tipo>{

    public List<Tipo> obtenerLista(){
        return getList();
    }

    public boolean insertar(Tipo objeto){
        return insertObject(objeto);
    }

    public boolean eliminar(String id){
        return deleteObject(id);
    }

    public boolean modificar(Tipo newObject){
        return modifyObject(newObject);
    }

    public Tipo obtenerObjeto(String id){
        Tipo objeto = getObject(id);
        return objeto!=null ? objeto : null;
    }

    // Metodos para una lista de objetos
    protected abstract List<Tipo> getList();
    // Metodos especificos para un solo objeto
    protected abstract Tipo getObject(String id);
    protected abstract boolean deleteObject(String id);
    protected abstract boolean modifyObject(Tipo newObject);
    protected abstract boolean insertObject(Tipo object);

}
