package com.arquitectura.ashotelproducto.dominio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {

    public String validarContrasena(char[] contrasena) {
        String patron = "^[a-z0-9]+$";
        String password=new String(contrasena);
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(password);

        Boolean charvalido=matcher.matches();
        boolean contrasenaValida = contrasena.length == 6;

        if (!contrasenaValida) {
            return "La contraseña debe tener al menos 6 caracteres.";
        }else if(!charvalido){
            return "La contraseña debe tener letras minusculas y números";
        }

        return null;
    }

    public String usuarioRequerido() {
        return "El campo Usuario es requerido";
    }

    public String contrasenaRequerida() {
        return "El campo Contraseña es requerido";
    }


}