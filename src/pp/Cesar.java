/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp;

/**
 *
 * @author jose
 */
public class Cesar
{

    String alfa;
    int clave;
    String mensaje;

    public Cesar()
    {
        alfa = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        clave = 0;
        mensaje = "";
    }

    void setAlfa(String c)
    {
        alfa = c;
    }

    public void setClave(int c)
    {
        clave = c;
        while (clave >= alfa.length())
        {
            clave = clave - alfa.length();
        }
        while (clave < 0)
        {
            clave = alfa.length() + clave;
        }
    }

    void setMensaje(String c)
    {
        mensaje = c;
    }

    String cifrar()
    {
        String c = "";
        for (int i = 0; i < mensaje.length(); i++)
        {
            c = c + cambiar(mensaje.charAt(i));
            if(cambiar(mensaje.charAt(i)).equals(""))
                return "No se pudo cifrar el mensaje";
        }
        return c;
    }

    String cambiar(char c)
    {
        boolean encontrado=false;
        if (c == ' ')
        {
            return " ";
        }
        int pos = 0;
        for (int i = 0; i < alfa.length(); i++)
        {
            if (c == alfa.charAt(i))
            {
                pos = i;
                encontrado=true;
            }
        }
        if(!encontrado)
            return "";
        pos = pos + clave;
        if (pos > alfa.length()-1)
        {
            pos = pos - alfa.length();
        }
        return ""+alfa.charAt(pos);
    }

    String decifrar()
    {
        String c = "";
        clave=alfa.length()-clave;
        for (int i = 0; i < mensaje.length(); i++)
        {
            c = c + cambiar(mensaje.charAt(i));
            if(cambiar(mensaje.charAt(i)).equals(""))
                return "No se pudo decifrar el mensaje";
        }
        return c;
    }
}
