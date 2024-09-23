package com.stylo.backend.model;

public class RolPermiso {

    private int id;  // Mapeo de la columna ID
    private int rolId;  // Mapeo de la columna ROL_ID
    private int permisoId;  // Mapeo de la columna PERMISO_ID

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public int getPermisoId() {
        return permisoId;
    }

    public void setPermisoId(int permisoId) {
        this.permisoId = permisoId;
    }
}
