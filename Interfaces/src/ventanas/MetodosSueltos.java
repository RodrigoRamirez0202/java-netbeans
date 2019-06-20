package ventanas;

public class MetodosSueltos {

    public int numeroAleatorio(int min, int max) {

        int num = (int) Math.floor(Math.random() * (max - min + 1) + (min));
        return num;
    }

    public String login(String user, String pass) {

        String cadena = "";
        String usu_login = "admin", pass_login = "admin";

        if (usu_login.equals(user)) {

            if (pass_login.equals(pass)) {

                cadena="Conectado";
            } else {

                cadena="Contraseña incorrecta";
            }
        } else {

            if (!pass_login.equals(pass)) {

                cadena="Usuario y contraseña incorrectos";
            } else {

                cadena="Usuario incorrecto";
            }
        }
        return cadena;
    }

}
