package sv.edu.udb.tarea1_ejercicio1_cg172415_lm170147;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Tarea1_Ejercicio1_Ventana2_CG172415_LM170147 extends AppCompatActivity {

    private TextView txvNombre;
    private TextView txvCodigo;
    private TextView txvComision2;
    private TextView txvVentas;
    private ImageView imgPagina2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea1_ejercicio1_ventana2_cg172415_lm170147);

        txvNombre=(TextView) findViewById(R.id.txvNombre);
        txvCodigo=(TextView) findViewById(R.id.txvCodigo);
        txvComision2=(TextView) findViewById(R.id.txvComision2);
        imgPagina2=(ImageView) findViewById(R.id.imgPagina2);
        txvVentas=(TextView)findViewById(R.id.txvVentas);

        Bundle bundle = getIntent().getExtras();
        String nombre=bundle.getString("txtNombre");
        String codigo=bundle.getString("txtCodigo");
        String ventas=bundle.getString("txtVentas");
        String comision=bundle.getString("textTotalComision");


        txvNombre.setText(nombre);
        txvCodigo.setText(codigo);
        txvVentas.setText(ventas);
        txvComision2.setText(comision);
    }

    public void finalizar(View v){
        finish();
    }
}