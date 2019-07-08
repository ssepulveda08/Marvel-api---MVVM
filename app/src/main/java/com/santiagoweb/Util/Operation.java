package com.santiagoweb.Util;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Operation {

    /**Metodo para calcular la solucion de una ecuacion utilizando la libreria rhino-android:1.1.1
     * @param param ecuacion
     * @return  solucion de la ecuacion si no se puede resolver encia Invalid*/
    public static  String ResultEnd(String ecuacion){
        String result ="";

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try{
            result = String.valueOf(engine.eval(ecuacion));
        }catch(Exception e){
            System.out.println("ERROR"+e.getMessage());
            result = "Invalid";
        }
        return  result;
    }



    /**Método para separar las operaciones según su orden indicado por los paréntesis
     @param param param inicial
     @retun debuelbe la ecuacion con la solucion de los parentesisi
     */
    static String splitOperatin(String param){
        String resul="";
        String[] operations = param.split("\\(");
        for (String row  :operations){
            if (row.indexOf(")")>0){
                String[] ope = row.split("\\)");
                for (int i = 0; i <  ope.length; i++) {
                    if (i==0){
                        resul += computeAnother(ope[i]);
                    }else{
                        resul += ope[i];
                    }
                }
            }else{
                resul += row;
            }
        }
        return resul;
    }

    /**Metodo para resolver una ecuacion
     * @param equation ecuacion
     * @return string del resultado */
    static String computeAnother(String equation) {
        try{
            double result = 0.0;

            String noMinus = equation.replace("-", "+-");
            String[] byPluses = noMinus.split("\\+");

            System.out.println("remplace result "+noMinus);
            for (String multipl : byPluses)
            {
                String[] byMultipl = multipl.split("\\*");
                double multiplResult = 1.0;
                for (String operand : byMultipl) {
                    if (operand.contains("/")) {
                        String[] division = operand.split("\\/");
                        double divident = Double.parseDouble(division[0]);
                        for (int i = 1; i < division.length; i++) {
                            divident /= Double.parseDouble(division[i]);
                        }
                        multiplResult *= divident;
                    } else {
                        multiplResult *= Double.parseDouble(operand);
                    }
                }
                result += multiplResult;
            }

            return String.valueOf(result);
        }catch (Exception e){
            return "Invalid";
        }

    }
}
