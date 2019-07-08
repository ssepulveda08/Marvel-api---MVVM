package com.santiagoweb.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.santiagoweb.R;
import com.santiagoweb.Util.Operation;
import com.santiagoweb.Util.Utilitades;
import com.santiagoweb.Viewmodels.OperationViewModel;

public class OperationActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText operacion;
    private TextInputLayout layout;
    private OperationViewModel viewmodel;

    //view
    private LinearLayout linear_resul;
    private TextView info_resul, info_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);
        //Inicializar el viewmover de la vista
        viewmodel = ViewModelProviders.of(this).get(OperationViewModel.class);
        //Inicializar la vista
        renderView();
        //Agregar eventos de la vista
        addListenerview();
    }

    private void renderView(){
        linear_resul = findViewById(R.id.Linear_contect_result);
        linear_resul.setVisibility(View.GONE);
        info_resul = findViewById(R.id.textView_info_resul);
        info_type = findViewById(R.id.textView_type);
        operacion = findViewById(R.id.Operation);
        layout = findViewById(R.id.layoutNumber);
    }

    /*metodo para Agregar los eventos onclick  alos botones*/
    private void addListenerview(){
        findViewById(R.id.buttom_resul).setOnClickListener(this);
        findViewById(R.id.button_continuar).setOnClickListener(this);
        findViewById(R.id.button_cancelar).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttom_resul:

                if (operacion.getText().toString().length() > 0){
                    Utilitades.hideKeyboard(this);
                    viewmodel.setEquation(operacion.getText().toString());
                    viewmodel.setResultado(Operation.ResultEnd(viewmodel.getEquation()));
                    onResultEquation();
                }else{
                    layout.setError("Agrega una ecuacion");
                    Toast.makeText(this, "Agrega una ecuacion",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_cancelar:
                operacion.setText("");
                viewmodel.setEquation("");
                viewmodel.setResultado("");
                linear_resul.setVisibility(View.GONE);
                break;
            case R.id.button_continuar:

                Intent startIntent = new Intent(this, MainActivity.class);
                startIntent.putExtra("TypeResult", Utilitades.getIdentifymultiplo(viewmodel.getResultado()));
                startActivity(startIntent,
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

                operacion.setText("");
                viewmodel.setEquation("");
                viewmodel.setResultado("");
                linear_resul.setVisibility(View.GONE);
                //finish();
                break;
        }
    }

    //Metodo para activar el resultado de la ecuacion
    private void onResultEquation(){
        linear_resul.setVisibility(View.VISIBLE);
        info_resul.setText("El resultado de la Ecuación ("+viewmodel.getEquation()+") es: "+viewmodel.getResultado());
        info_type.setText("EL resultado es de tipo :"+ Utilitades.getIdentifymultiplo(viewmodel.getResultado()));
    }

}
