package sample;


import java.util.ArrayList;

public class Derivative {
    public ArrayList<String> takeIn(String input) {
        ArrayList<String> expression = new ArrayList<>();
        input.replaceAll(" ","");
        int c = 0;
        for(int i=0; i<input.length();i++){
            if(input.charAt(i)=='+'){
                expression.add(input.substring(c, i));
                expression.add("+");
                c=i+1;
            }
            else if(i==input.length()){
                expression.add(input.substring(c, i));
            }
        }
        return expression;

    }
    public String concat(ArrayList<String> exp){
        String ex ="";
        for(int i=0;i<exp.size();i++){
            ex += exp.get(i);
        }
        return ex;
    }
    public String derive(ArrayList<String> exp){
        ArrayList<String> expression = exp;
        for(int i=0; i<expression.size();i++){
            if(expression.get(i)!="+"){
                for(int k=0;k<expression.get(i).length();k++){
                    if(expression.get(i).charAt(k)=='^'){
                        int coef=Integer.parseInt(expression.get(i).substring(k,expression.get(i).length()));
                        int power = coef -1;
                        expression.set(i, Integer.toString(coef)+"x^"+Integer.toString(power));
                    }
                    else{
                        expression.set(i, "0");
                    }
                }
            }
        }
        String finalEx = concat(expression);
        return finalEx;
    }

}
