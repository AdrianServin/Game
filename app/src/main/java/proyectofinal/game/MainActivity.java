package proyectofinal.game;

import android.app.Activity;
import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.ActionBarActivity;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private EditText nombre;
    private String nom="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View btnInicio= findViewById(R.id.btnIniciar);
        btnInicio.setOnClickListener(this);

        nombre=(EditText)findViewById(R.id.txtNombre);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onClick(View vista) {

        if (vista.getId() == findViewById(R.id.btnIniciar).getId()) {
            nom=nombre.getText().toString();
            if(nom.equals("")) {
                Toast.makeText(getBaseContext(), "Escriba su nombre", Toast.LENGTH_SHORT).show();
            }else {
                Intent WindowsGame = new Intent(this, Inicio.class);
                WindowsGame.putExtra("Nombre", nom);

                startActivity(WindowsGame);
            }
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
