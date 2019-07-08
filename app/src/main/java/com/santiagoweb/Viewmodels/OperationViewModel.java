package com.santiagoweb.Viewmodels;

import androidx.lifecycle.ViewModel;

public class OperationViewModel extends ViewModel {

    private String resultado;
    private String equation;

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }
}
