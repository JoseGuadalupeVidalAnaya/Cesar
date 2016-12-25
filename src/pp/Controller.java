package pp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author jose
 */
public class Controller implements Initializable
{

    Cesar c;
    @FXML
    TextField alfa, men, clave, out;
    @FXML
    Button cifrar, decifrar;

    @FXML
    void metodoCifrar(ActionEvent event)
    {
        if (alfa.getText().isEmpty())
        {
            out.setText("Ingrese el alfabeto");
        }
        else if (men.getText().isEmpty())
        {
            out.setText("Ingrese el mensaje a cifrar");
        }
        else if (clave.getText().isEmpty())
        {
            out.setText("Ingrese la clave para cifrar");
        }
        else
        {
            c.setAlfa(alfa.getText());
            try
            {
                c.setClave(Integer.parseInt(clave.getText()));
                c.setMensaje(men.getText());
                out.setText(c.cifrar());
            }
            catch (NumberFormatException e)
            {
                out.setText("\"" + clave.getText() + "\"" + " No valido: Ingrese una clave valida");
            }
        }
    }

    @FXML
    void metodoDecifrar(ActionEvent event)
    {
        if (alfa.getText().isEmpty())
        {
            out.setText("Ingrese el alfabeto");
        }
        else if (men.getText().isEmpty())
        {
            out.setText("Ingrese el mensaje a cifrar");
        }
        else if (clave.getText().isEmpty())
        {
            out.setText("Ingrese la clave para cifrar");
        }
        else
        {
            c.setAlfa(alfa.getText());
            try
            {
                c.setClave(Integer.parseInt(clave.getText()));
                c.setMensaje(men.getText());
                out.setText(c.decifrar());
            }
            catch (NumberFormatException e)
            {
                out.setText("\"" + clave.getText() + "\"" + " No valido: Ingrese una clave valida");
            }
        }
    }

    @Override
    public
    void initialize(URL url, ResourceBundle rb)
    {
        c = new Cesar();
        men.setOnKeyTyped(e ->
        {
            String alfaAux=alfa.getText()+" ";
            if (!alfaAux.contains(e.getCharacter()))
            {
                e.consume();
            }
        });
        alfa.setOnKeyTyped(e ->
        {
            if (e.getCharacter().equals(" "))
            {
                e.consume();
            }
        });
        clave.setOnKeyTyped(e ->
        {
            if (!"1234567890".contains(e.getCharacter()))
            {
                e.consume();
            }
            if (clave.getText().length() > 8)
            {
                e.consume();
            }
        });
    }

}
