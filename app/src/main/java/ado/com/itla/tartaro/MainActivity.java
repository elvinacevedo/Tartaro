package ado.com.itla.tartaro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(LOG_TAG,"Estoy aqui");

        Button btnCategoria = (Button) findViewById(R.id.btnCategoria);

        btnCategoria.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO: Llamar otro activity
                Intent viewCategoria;
                viewCategoria = new Intent(MainActivity.this, CategoriaActivity.class);
                viewCategoria.putExtra("nombre","Juan de los palotes");
                startActivity(viewCategoria);

            }

        });
    }
}
