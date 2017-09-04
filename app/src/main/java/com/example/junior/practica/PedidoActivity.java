package com.example.junior.practica;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.junior.practica.R.id.parent;

/**
 * Created by Junior on 28/08/17.
 */


public class PedidoActivity extends AppCompatActivity {

    private Double precioP=0.00 , precioC=0.00 , Total=0.00;
    private Spinner spinner1;
    private String textSpinner;
    private RadioGroup Tipo;
    private Double PrecioM = 0.00;
    private Double PrecioT = 0.00;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {


                textSpinner = parent.getItemAtPosition(pos).toString();
                if(pos == 1){
                    precioP = 20.00;
                }else if (pos == 2){
                    precioP = 22.00;
                }else if (pos == 3){
                    precioP = 24.00;
                }else if (pos == 4);

                Toast.makeText(parent.getContext(),
                        "Usted ha seleccionado : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg) {

            }

        });
    }

//Declaramos el RadioGroup


    public void radioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // This check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButton:
                if (checked)
                    //Do something when radio button is clicked
                    PrecioM = 0.00;
                    Toast.makeText(getApplicationContext(), "Masa gruesa", Toast.LENGTH_SHORT).show();
                break;

            case R.id.radioButton2:
                //Do something when radio button is clicked
                    PrecioM = 10.00;
                Toast.makeText(getApplicationContext(), "Masa delgada", Toast.LENGTH_SHORT).show();
                break;

            case R.id.radioButton3:
                //Do something when radio button is clicked
                PrecioM = 15.00;
                Toast.makeText(getApplicationContext(), "Masa artesanal", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void answer(View view){

        int radioButtonId = Tipo.getCheckedRadioButtonId();
        if (radioButtonId == -1){
            Toast.makeText(this, "This field is required!", Toast.LENGTH_LONG).show();
        }
        else{
            // Individual selected
            if (radioButtonId == R.id.Tipo){
                Toast.makeText(this, "You selected RelativeLayout", Toast.LENGTH_SHORT).show();
            }else if (radioButtonId == R.id.radioButton2){
                Toast.makeText(this, "You selected LinearLayout", Toast.LENGTH_SHORT).show();
            }//...

            // Dinamic selected
            RadioButton radioButton = (RadioButton) findViewById(radioButtonId);
            Toast.makeText(this, "This text is " + radioButton.getText(), Toast.LENGTH_SHORT).show();
        }
    }

//_________________________________________________________________________________________________


    public void showvalue(View view){

    }


    public void showDialog(View view) {

        String item = (String)spinner1.getSelectedItem();
        Toast.makeText(this, "You have selected : " + item, Toast.LENGTH_SHORT).show();
        PrecioT = PrecioM + precioP;

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Confirmacion de Pedido");
        alertDialog.setMessage("Su Pedido de " + item +  " a " + PrecioT + "+ IGV esta en proceso de envio");
        // Alert dialog button
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Alert dialog action goes here
                        dialog.dismiss();// use dismiss to cancel alert dialog
                    }
                });
        alertDialog.show();

    }

}

