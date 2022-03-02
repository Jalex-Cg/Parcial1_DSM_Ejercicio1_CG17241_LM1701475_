package sv.edu.udb.tarea1_ejercicio1_cg172415_lm170147;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imagen;
    private EditText txtNombre;
    private EditText txtCodigo;
    private EditText txtVentas;
    private TextView textTotalComision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen=(ImageView) findViewById(R.id.imagen);
        txtNombre=findViewById(R.id.txtNombre);
        txtCodigo=findViewById(R.id.txtCodigo);
        txtVentas=findViewById(R.id.txtVentas);
        textTotalComision=findViewById(R.id.textTotalComision);
    }

    @SuppressLint("ResourceType")
    public void calculoComision(View view){
        String comision=txtVentas.getText().toString();
        int comi=Integer.parseInt(comision);
        if(comi < 500){
            int comitot = comi;
            comitot = 0;
            String tot=String.valueOf(comitot);
            textTotalComision.setText(tot);
        }else if(comi == 500 || comi < 1000){
            double comitot = comi * 0.05;
            String tot=String.valueOf(comitot);
            textTotalComision.setText(tot);
        }else if(comi == 1000 || comi < 2000){
            double comitot = comi * 0.10;
            String tot=String.valueOf(comitot);
            textTotalComision.setText(tot);
        }else if(comi == 2000 || comi < 3000){
            double comitot = comi * 0.15;
            String tot=String.valueOf(comitot);
            textTotalComision.setText(tot);
        }else if(comi == 3000 || comi < 4000){
            double comitot = comi * 0.20;
            String tot=String.valueOf(comitot);
            textTotalComision.setText(tot);
        }else if(comi > 4000){
            double comitot = comi * 0.30;
            String tot=String.valueOf(comitot);
            textTotalComision.setText(tot);
        }
        Intent i = new Intent(this,Tarea1_Ejercicio1_Ventana2_CG172415_LM170147.class);
        i.putExtra("txtNombre",txtNombre.getText().toString());
        i.putExtra("txtCodigo",txtCodigo.getText().toString());
        i.putExtra("txtVentas",txtVentas.getText().toString());
        i.putExtra("textTotalComision",textTotalComision.getText().toString());
        startActivity(i);

    }

    public void onClickFoto(View view){
        cargarImagen();
    }

    private void cargarImagen() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"seleccione la aplicacion"),10);
    }

    @SuppressLint("ResourceType")
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Uri path=data.getData();
            imagen.setImageURI(path);
        }
    }

}