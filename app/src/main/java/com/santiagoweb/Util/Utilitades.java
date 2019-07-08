package com.santiagoweb.Util;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Utilitades {
    /**Metodo para ocultar el teclado*/
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static int getIdentifymultiplo(String valor){
            /** Case (igual a 0):  /v1/public/characters - 0
             * Case (múltiplos de 3): /v1/public/comics - 1
             * Case (múltiplos de 5): /v1/public/comics - 2
             * Case (múltiplos de 7): /v1/public/creators - 3
             * Case (múltiplos de 11): /v1/public/events - 4
             * Case (múltiplos de 13): /v1/public/series - 5
             * Case default/invalid: /v1/public/stories  -6 */
        int result = -1;
        if (valor.equals("Invalid") ){
            result =6;
        }else{
            double  mvalor = Double.parseDouble(valor);
            if (mvalor == 0){
                result =0;
            }else if((mvalor%3) ==0){
                result = 1;
            }else if((mvalor%5) ==0){
                result = 2;
            }else if((mvalor%7) ==0){
                result = 3;
            }else if((mvalor%11) ==0){
                result = 4;
            }else if((mvalor%13) ==0){
                result = 5;
            }
        }
        return result;
    }
}
