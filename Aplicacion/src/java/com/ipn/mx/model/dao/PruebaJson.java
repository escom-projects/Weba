package com.ipn.mx.model.dao;

import com.ipn.mx.model.entities.Materias;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author Usuario
 */
public class PruebaJson {
    public static void main(String[] args) {
        MateriasDAO dao = new MateriasDAO();
        JsonObjectBuilder materiasBuilder = Json.createObjectBuilder();
        JsonArrayBuilder arrayMateriasBuilder = Json.createArrayBuilder();
        try {
            List<Materias> materias = dao.readAll();
            if (materias.isEmpty()) {
                materiasBuilder.add("status", "empty");
            } else {
                materiasBuilder.add("status", "full");
                for (Materias materia : materias) {
                    materiasBuilder.add("ID", materia.getIdMaterias())
                        .add("nombre", materia.getNombreMateria())
                        .add("creditos", materia.getCreditos());
                    arrayMateriasBuilder.add(materiasBuilder);
                }
            }
        } catch(NullPointerException npe) {
            materiasBuilder.add("status", "error");
        }
        System.out.println(arrayMateriasBuilder.build());
    }
}
