package proyectofinal.game;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Inicio extends ActionBarActivity implements View.OnClickListener {

    private TextView nombre, txtnum1, txtnum2, operacion,ejercicio;
    private EditText txtResul;
    private int vidas = 3, num1 = 0, num2 = 0, random = 0, contador = 0;
    private String nom = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        Bundle datos= getIntent().getExtras();  // Se crea una variable que reciba los datos enviados de clase MainActivity
        nom=datos.getString("Nombre");

        nombre=(TextView)findViewById(R.id.lblTitulo);
        nombre.setText("Bienvenido "+nom+", tienes < "+vidas+" > vidas.");

        txtnum1= (TextView)findViewById(R.id.lblNum1); //Se llama a la etiqueta Num1
        txtnum2= (TextView)findViewById(R.id.lblNum2); //Se llama a la etiqueta Num2
        operacion= (TextView)findViewById(R.id.lblOpera); //Se llama a la etiqueta Operacion
        txtResul= (EditText)findViewById(R.id.txtResul);
        ejercicio= (TextView)findViewById(R.id.lblContador); // Es la Etiqueta para el contador de los ejercicios

        View btnSig=findViewById(R.id.btnSig);  //Se llama al boton Siguiente
        btnSig.setOnClickListener(this);        //Se le establece que tiene una accion

            StartGame();
    }

    public void StartGame(){
        int aux;
        num1=(int)(Math.random()*(100-2+1)+2);
        num2=(int)(Math.random()*(100-2+1)+2);
        random=(int)(Math.random()*3 + 0);
        if(random==3)      // Esto es para evitar divisiones que tenga resuldado 0.0012 etc etc
            if(num1<num2){
                aux=num1;
                num1=num2;
                num2=aux;
            }

        txtnum1.setText(""+num1);
        txtnum2.setText(""+num2);
        if(random==0){
            operacion.setText("+");
        }else if(random==1){
            operacion.setText("-");
        }else if(random==2){
            operacion.setText("*");
        }else{
            operacion.setText("/");
        }


    }

    public void GameOver(){
        vidas--;
        Toast.makeText(getBaseContext(), "Juego Terminado", Toast.LENGTH_SHORT).show();
        Intent WindowsGame = new Intent(this, Final.class);
        WindowsGame.putExtra("Nombre", nom);

        startActivity(WindowsGame);
        
    }

    public void onClick(View vista) {

        if (vista.getId() == findViewById(R.id.btnSig).getId()) {
            if(!nom.equals("")) {
                int res=Integer.parseInt(txtResul.getText().toString());

                switch (random){
                    case 0:
                        Sum(num1, num2, res);
                        break;
                    case 1:
                        Res(num1, num2, res);
                        break;
                    case 2:
                        Mul(num1,num2,res);
                        break;
                    case 3:
                        Div(num1, num2, res);
                        break;
                }
                StartGame();
            }else{
                Toast.makeText(getBaseContext(), "Pon Tu Respuesta", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void Sum(int num1,int num2,int res){

        if(num1+num2==res) {
            nombre.setText("Bienvenido "+nom+", tienes < "+vidas+" > vidas.");
        }else{
            if(vidas>1) {
                vidas--;
                nombre.setText("Bienvenido " + nom + ", tienes < " + vidas + " > vidas.");
            }else {
                
                GameOver();
                
            }
        }
    }

    public void Res(int num1,int num2,int res){

        if(num1-num2==res) {
            nombre.setText("Bienvenido "+nom+", tienes < "+vidas+" > vidas.");
        }else{
            if(vidas>1) {
                vidas--;
                nombre.setText("Bienvenido " + nom + ", tienes < " + vidas + " > vidas.");
            }else{
                
                GameOver();
                
            }
        }
    }

    public void Mul(int num1,int num2,int res){

        if(num1*num2==res) {
            nombre.setText("Bienvenido "+nom+", tienes < "+vidas+" > vidas.");
        }else{
            if(vidas>1) {
                vidas--;
                nombre.setText("Bienvenido " + nom + ", tienes < " + vidas + " > vidas.");
            }else{
                GameOver();
                
            }
        }
    }

    public void Div(int num1,int num2,int res){

        if(num1/num2==res) {
            nombre.setText("Bienvenido "+nom+", tienes < "+vidas+" > vidas.");
        }else{
            if(vidas>1) {
                vidas--;
                nombre.setText("Bienvenido " + nom + ", tienes < " + vidas + " > vidas.");
            }else{
                GameOver();
                
            }
        }
    }

}