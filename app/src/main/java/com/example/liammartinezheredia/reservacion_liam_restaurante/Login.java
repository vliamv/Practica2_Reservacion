package com.example.liammartinezheredia.reservacion_liam_restaurante;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;


public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public final String usuario ="liam";
    public final String password ="1010";

    EditText usr;
    EditText pass;

    boolean  Control = false ;

    public void Ingresar(View miview) {

        try {

            usr=(EditText)findViewById(R.id.txtUsr);
            pass=(EditText)findViewById(R.id.txtPsw);



            String userName = usr.getText().toString();
            String passUser = pass.getText().toString();

            if (userName.equals(usuario)) {
                if (passUser.equals(password)) {
                    Control = true;

                } else {
                    Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();

                }
            } else {
                Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_SHORT).show();
            }
            if(Control == true){

                AlertDialog.Builder A_Bienvenido = new AlertDialog.Builder(this);

                A_Bienvenido.setTitle("Bienvenido  "+ usuario);
                A_Bienvenido.setMessage("Gracias por reserva con nosotros");
                A_Bienvenido.setPositiveButton("Siguiente", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                A_Bienvenido.create().show();

                Intent Accesoreserva = new Intent(Login.this, MainActivity.class);
                startActivity(Accesoreserva);

            }else{
                Toast.makeText(this,"Datos incorrectos", Toast.LENGTH_SHORT).show();
            }


        }catch(Exception e){
            Toast.makeText(this,"Llene los datos",Toast.LENGTH_SHORT).show();

        }
    }
}
