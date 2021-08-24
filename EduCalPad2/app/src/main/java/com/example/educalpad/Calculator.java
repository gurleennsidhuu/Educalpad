package com.example.educalpad;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {



        //declaring variables denoting every button
        Button square,fact,ln,log,tan,num1,num2,num3,num4,num5,num6,num7,num8,num9,num0,point,butPi,multi,
                equal,plus,div,inv,sqrt,cos,sin,openB,closeB,clear,ac,minus;
//declaring variables for text views displaying calculations
        TextView tvMain,tvSec;
//declaring constant value for pi
        String pi="3.14159265";
        @SuppressLint("SetTextI18n")

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_calculator2);

            //equating every button variable with its respective button views
            num1=findViewById(R.id.one);
            num2=findViewById(R.id.two);
            num3=findViewById(R.id.three);
            num4=findViewById(R.id.four);
            num5=findViewById(R.id.five);
            num6=findViewById(R.id.six);
            num7=findViewById(R.id.seven);
            num8=findViewById(R.id.eight);
            num9=findViewById(R.id.nine);
            num0=findViewById(R.id.zero);
            butPi=findViewById(R.id.pi);
            square=findViewById(R.id.square);
            fact=findViewById(R.id.factorial);
            ln=findViewById(R.id.ln);
            log=findViewById(R.id.log);
            tan=findViewById(R.id.tan);
            point=findViewById(R.id.point);
            equal=findViewById(R.id.equal);
            plus=findViewById(R.id.sum);
            div=findViewById(R.id.divide);
            inv=findViewById(R.id.reciprocal);
            sqrt=findViewById(R.id.root);
            cos=findViewById(R.id.cos);
            sin=findViewById(R.id.sine);
            ac=findViewById(R.id.AC);
            clear=findViewById(R.id.C);
            multi=findViewById(R.id.multiply);
            minus=findViewById(R.id.subtract);
            openB=findViewById(R.id.open);
            closeB=findViewById(R.id.close);
            //equating each text view variable with its respective text view.
            tvMain=findViewById(R.id.tvMain);
            tvSec=findViewById(R.id.tvSec);
            //declaring actions to be performed when any of the buttons are clicked
            //the text on the screen will be concatenated with digit 1
            num1.setOnClickListener(v -> tvMain.setText(tvMain.getText()+"1"));
            //the text on the screen will be concatenated with digit 2
            num2.setOnClickListener(v -> tvMain.setText(tvMain.getText()+"2"));
            //the text on the screen will be concatenated with digit 3
            num3.setOnClickListener((View v) -> tvMain.setText(tvMain.getText() + "3"));
            //the text on the screen will be concatenated with digit 4
            num4.setOnClickListener(v -> tvMain.setText(tvMain.getText()+"4"));
            //the text on the screen will be concatenated with digit 5
            num5.setOnClickListener(v -> tvMain.setText(tvMain.getText()+"5"));
            //the text on the screen will be concatenated with digit 6
            num6.setOnClickListener(v -> tvMain.setText(tvMain.getText()+"6"));
            //the text on the screen will be concatenated with digit 7
            num7.setOnClickListener(v -> tvMain.setText(tvMain.getText()+"7"));
            //the text on the screen will be concatenated with digit 8
            num8.setOnClickListener(v -> tvMain.setText(tvMain.getText()+"8"));
            //the text on the screen will be concatenated with digit 9
            num9.setOnClickListener(v -> tvMain.setText(tvMain.getText()+"9"));
            //the text on the screen will be concatenated with digit 0
            num0.setOnClickListener(v -> tvMain.setText(tvMain.getText()+"0"));
            //the text on the screen will be concatenated with character .
            point.setOnClickListener(v -> tvMain.setText(tvMain.getText()+"."));
            //clears the screen when the button AC is clicked
            ac.setOnClickListener(v -> {
                tvMain.setText("");
                tvSec.setText("");
            });
            //Deletes the last digit/character on the screen
            clear.setOnClickListener(v -> {
                String val=tvMain.getText().toString();
                val=val.substring(0,val.length()-1);
                tvMain.setText(val);
            });
            plus.setOnClickListener(v -> {
                //the text on the screen will be concatenated with operator +
                tvMain.setText(tvMain.getText()+"+");
            });
            //the text on the screen will be concatenated with operator -
            minus.setOnClickListener(v -> tvMain.setText(tvMain.getText()+"-"));
            //the text on the screen will be concatenated with operator ÷
            div.setOnClickListener(v -> tvMain.setText(tvMain.getText()+"÷"));
            //the text on the screen will be concatenated with operator ×
            multi.setOnClickListener(v -> tvMain.setText(tvMain.getText()+"×"));
            //performs the square root of the input number using sqrt function
            sqrt.setOnClickListener(v -> {
                String val=tvMain.getText().toString();
                double r=Math.sqrt(Double.parseDouble(val));
                tvMain.setText(String.valueOf(r));
            });
            //the text on the screen will be concatenated with character (
            openB.setOnClickListener(v -> tvMain.setText(tvMain.getText()+"("));
            //the text on the screen will be concatenated with character )
            closeB.setOnClickListener(v -> tvMain.setText(tvMain.getText()+")"));
            //the text on the screen will be concatenated with declared value of pi
            butPi.setOnClickListener(v -> {
                tvSec.setText(butPi.getText());
                tvMain.setText(tvMain.getText()+pi);
            });
            //the text on the screen will be concatenated with text sin
            sin.setOnClickListener(v -> tvMain.setText(tvMain.getText()+"sin"));
            //the text on the screen will be concatenated with text cos
            cos.setOnClickListener(v -> tvMain.setText(tvMain.getText()+"cos"));
            //the text on the screen will be concatenated with text tan
            tan.setOnClickListener(v -> tvMain.setText(tvMain.getText()+"tan"));
            //the text on the screen will be concatenated with text ln
            ln.setOnClickListener(v -> tvMain.setText(tvMain.getText()+"ln"));
            //the text on the screen will be concatenated with text log
            log.setOnClickListener(v -> tvMain.setText(tvMain.getText()+"log"));
            //the text on the screen will be concatenated with text ^(-1) which means the inv of the number
            inv.setOnClickListener(v -> tvMain.setText(tvMain.getText()+"^"+"(-1)"));
            //performs factorial of the input number by calling the function factorial
            fact.setOnClickListener(v -> {
                int val= Integer.parseInt(tvMain.getText().toString());
                int fact=factorial(val);
                tvMain.setText(String.valueOf(fact));
                tvSec.setText(val+"!");
            });
            //performs square of the input number by multiplying the number by itself
            square.setOnClickListener(v -> {
                double d= Double.parseDouble(tvMain.getText().toString());
                double square= d*d;
                tvMain.setText(String.valueOf(square));
                tvSec.setText(d+"²");
            });
            /* performs the final calculation by calling eval function */
            equal.setOnClickListener(v -> {
                String val=tvMain.getText().toString();
                String replacedStr= val.replace('÷','/').replace('×','*');
                double result= eval(replacedStr);
                tvMain.setText(String.valueOf(result));
                tvSec.setText(val);
            });
        }
        //factorial function
        //recursively calling the factorial function
        int factorial(int n){
            return (n==1||n==0)?1: n*factorial(n-1);
        }
        //eval function
        public static double eval(final String str){
            return new Object(){
                int pos=-1,ch;
                void nextChar(){
                    ch=(++pos < str.length()) ? str.charAt(pos) : -1;
                }
                boolean eat(int charToEat){
                    while(ch==' ') nextChar();
                    if(ch== charToEat){
                        nextChar();
                        return true;
                    }
                    return false;
                }
                double parse() {
                    nextChar();
                    double x = parseExpression();
                    if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                    return x;
                }
                double parseExpression(){
                    double x=parseTerm();
                    for(;;){
                        if(eat('+')) x+=parseTerm(); //addition
                        else if (eat('-')) x-=parseTerm(); //subtraction
                        else return x;
                    }
                }
                double parseTerm(){
                    double x= parseFactor();
                    for(;;){
                        if(eat('*')) x*=parseFactor(); //multiplication
                        else if(eat('/')) x/=parseFactor(); //division
                        else return x;
                    }
                }
                double parseFactor(){
                    if(eat('+')) return parseFactor(); //unary plus
                    if(eat('-')) return -parseFactor(); //unary minus
                    double x;
                    int startPos=this.pos;
                    if(eat('(')){
                        //parentheses
                        x=parseExpression();
                        eat(')');
                    }
                    else if((ch>='0' && ch<='9') || ch=='.'){
                        //numbers
                        while((ch>='0' && ch<='9')|| ch=='.') nextChar();
                        x=Double.parseDouble(str.substring(startPos,this.pos));
                    }
                    else if(ch>='a' && ch<='z') {
                        //functions
                        while (ch >= 'a' && ch <= 'z') nextChar();
                        String func = str.substring(startPos, this.pos);
                        x = parseFactor();
                        //calling in built sqrt function
                        switch (func) {
                            case "sqrt":
                                x = Math.sqrt(x);
                                break;
                            //calling in built sin function
                            case "sin":
                                x = Math.sin(Math.toRadians(x));
                                break;
                            //calling in built cos function
                            case "cos":
                                x = Math.cos(Math.toRadians(x));
                                break;
                            //calling in built tan function
                            case "tan":
                                x = Math.tan(Math.toRadians(x));
                                break;
                            //calling in built log function
                            case "log":
                                x = Math.log10(x);
                                break;
                            //calling in built ln function
                            case "ln":
                                x = Math.log(x);
                                break;
                            //throwing an error when the input is invalid
                            default:
                                throw new RuntimeException("Unknown function: " + func);
                        }
                    }
                    else{
                        throw new RuntimeException("Unexpected function: "+(char)ch);
                    }
                    //calling in built pow function for calculating raised to power
                    if(eat('^')) x=Math.pow(x,parseFactor()); //exponentiation
                    return x;
                }
            }.parse();
        }
        public void openMain(View view){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    public void openNotepad(View view){
        Intent intent = new Intent(this,Notepad.class);
        startActivity(intent);
    }
    public void openNews(View view){
        Intent intent = new Intent(this,EduNews.class);
        startActivity(intent);
    }
    public void openSearch(View view){
        Intent intent = new Intent(this,search.class);
        startActivity(intent);
    }
}
