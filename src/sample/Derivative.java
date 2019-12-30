package sample;


import java.util.ArrayList;

public class Derivative {
    //to concatenate arrays into strings
    public String concat(ArrayList<String> exp){
        String ex ="";
        for(int i=0;i<exp.size();i++){
            ex += exp.get(i);
        }
        return ex;
    }

    //to break in string input of function, returns arraylist
    //currently only works if in form  of u'(x) + v'(x) (e.g. standard derivative)
    public ArrayList<String> takeIn(String input) {
        ArrayList<String> expression = new ArrayList<>();
        input.replaceAll(" ","");
        int c = 0;
        System.out.println(input);
        for(int i=0; i<input.length();i++){
            if(input.charAt(i)=='+'){
                expression.add(input.substring(c, i));
                expression.add("+");
                c=i;
            }
            else if(i==input.length()-1){
                expression.add(input.substring(c+1));
            }
        }
        System.out.println(expression);
        return expression;

    }

    //takes in arraylist and finds its derivative
    public String derive(ArrayList<String> exp){
        ArrayList<String> expression = exp;
        int coef;
        boolean notVar = false;
        for(int i=0; i<expression.size();i++){
            if(expression.get(i)!="+"){
                for(int k=0;k<expression.get(i).length();k++){
                    if(expression.get(i).charAt(k)=='^'){
                        coef=Integer.parseInt(expression.get(i).substring(k+1));
                        System.out.println(coef + " Hello");
                        int power = coef -1  ;
                        expression.set(i, coef +"x^"+ power);
                        notVar = true;
                        break;
                    }
                    notVar = false;
                }
                if(notVar==false){
                    expression.set(i, "0");
                }

            }
        }
        String finalEx = concat(expression);
        return finalEx;
    }

}
