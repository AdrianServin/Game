package proyectofinal.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Final extends ActionBarActivity implements View.OnClickListener{

    private TextView Nombre, Puntuaje;
    private Activity act=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finall);

        Bundle datos= getIntent().getExtras();

        View btnReiniciar = findViewById(R.id.btnReiniciar);
        View btnSalir = findViewById(R.id.btnSalir);

        Nombre = (TextView) findViewById(R.id.lblName);
        Puntuaje = (TextView) findViewById(R.id.lblPuntos);

        Nombre.setText(datos.getString("Nombre"));
        Puntuaje.setText(datos.getString("Puntos"));

        btnReiniciar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);



    }

    public void onClick(View vista) {

        if (vista.getId() == findViewById(R.id.btnReiniciar).getId()) {
            Intent WindowsGame = new Intent(this, MainActivity.class);
            startActivity(WindowsGame);
            act.finish();
        }
        if (vista.getId() == findViewById(R.id.btnSalir).getId()) {
            act.finish();
        }

    }
}