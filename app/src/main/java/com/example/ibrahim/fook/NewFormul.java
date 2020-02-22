package com.example.ibrahim.fook;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class NewFormul extends AppCompatActivity implements View.OnClickListener,FormulDegerDialog.FormulDegerDialogListener {
    private Button btnDiger,btnUstal,btnDeger,btnBackspace,btnDelete,btnParanez,btnYuzde,btnBol,btnCarp,btnCikar,btnTopla,btnSave,
            btnSifir,btnCiftSifir,btnVirgul,btnBir,btnIki,btnUc,btnDort,btnBes,btnAlti,btnYedi,btnSekiz,btnDokuz;

    private  TextView tv_formul_calc;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_formul);
        mAuth = FirebaseAuth.getInstance();

        tv_formul_calc= findViewById(R.id.tv_fml_calc);

        btnDiger= findViewById(R.id.btn_diger);
        btnUstal= findViewById(R.id.btn_ustal);
        btnDeger=findViewById(R.id.btn_deger);
        btnBackspace =findViewById(R.id.btn_backspace);
        btnDelete=findViewById(R.id.btn_delete);
        btnParanez=findViewById(R.id.btn_parantez);
        btnYuzde=findViewById(R.id.btn_yuzde);
        btnBol=findViewById(R.id.btn_bol);
        btnCarp=findViewById(R.id.btn_carp);
        btnCikar=findViewById(R.id.btn_cikar);
        btnTopla=findViewById(R.id.btn_topla);
        btnSave=findViewById(R.id.btn_save);
        btnSifir=findViewById(R.id.btn_sifir);
        btnCiftSifir=findViewById(R.id.btn_ciftsifir);
        btnVirgul=findViewById(R.id.btn_virgul);
        btnBir=findViewById(R.id.btn_bir);
        btnIki=findViewById(R.id.btn_iki);
        btnUc=findViewById(R.id.btn_uc);
        btnDort=findViewById(R.id.btn_dort);
        btnBes=findViewById(R.id.btn_bes);
        btnAlti=findViewById(R.id.btn_alti);
        btnYedi=findViewById(R.id.btn_yedi);
        btnSekiz=findViewById(R.id.btn_sekiz);
        btnDokuz=findViewById(R.id.btn_dokuz);

        //butonların listenerları
        btnDiger.setOnClickListener(this);
        btnUstal.setOnClickListener(this);
        btnDeger.setOnClickListener(this);
        btnBackspace.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnParanez.setOnClickListener(this);
        btnYuzde.setOnClickListener(this);
        btnBol.setOnClickListener(this);
        btnCarp.setOnClickListener(this);
        btnCikar.setOnClickListener(this);
        btnTopla.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnSifir.setOnClickListener(this);
        btnCiftSifir.setOnClickListener(this);
        btnVirgul.setOnClickListener(this);
        btnBir.setOnClickListener(this);
        btnIki.setOnClickListener(this);
        btnUc.setOnClickListener(this);
        btnDort.setOnClickListener(this);
        btnBes.setOnClickListener(this);
        btnAlti.setOnClickListener(this);
        btnYedi.setOnClickListener(this);
        btnSekiz.setOnClickListener(this);
        btnDokuz.setOnClickListener(this);




    }

    public boolean opMu(String s){//OPERATÖR KONTROLLERİ BURADA YAPILIYOR.
        char c[] =s.substring(s.length()-1,s.length()).toCharArray();

         if (c[0] == '+' || c[0] == '-' || c[0] == '%' || c[0] == '/' || c[0] == 'x' || c[0] == '^'|| c[0] == '(')
             return true;
         else return false;

    }
    public String andDell(TextView tv)
    {
        String s = tv.getText().toString();
        if (s.length()>0) {
            s = s.substring(0, s.length() - 1);
        }

        return s;
    }
    public void opAdd(String op,TextView nTv)
    {
      if (nTv.length()!=0) {
          if (!opMu(nTv.getText().toString()))
              nTv.setText(nTv.getText() + op);
          else if (sonGetir(nTv).equals("(")&&op.equals("-")) {
              nTv.setText(nTv.getText() + op);
          }else if (sonGetir(nTv).equals("(")){}
          else if (nTv.getText().toString().substring(nTv.getText().length()-2,nTv.getText().length()-1).equals("(")){
              //bişey yapma
          }else nTv.setText(andDell(nTv) + op);

      }
    }

    public String sonGetir(TextView tv)
    {
        String s;
        s = tv.getText().toString();
        if (s.length()>0){
        s=s.substring(s.length()-1,s.length());
            return s;
        }
        else return "";
    }
    public void virgulsil(TextView myTvv)
    {
       String son =sonGetir(myTvv);
       if (son.equals(",")){
          myTvv.setText(andDell(myTvv));
       }
    }

    public  void openDegerDialog(){

        FormulDegerDialog formulDegerDialog =new FormulDegerDialog();
        formulDegerDialog.show(getSupportFragmentManager(),"Değişken Değer");
    }
    public  void openDigerDialog(){

        FormulDegerDialog formulDegerDialog =new FormulDegerDialog();
        formulDegerDialog.show(getSupportFragmentManager(),"Diğer");
    }

    int pSayac=0;

    @Override
    public void onClick(View v) {
        TextView tv_clc =findViewById(R.id.tv_fml_calc);
        switch (v.getId())
        {
            //tv_clc.setText(tv_clc.getText()+"");
            case R.id.btn_diger:
                //yapılacaklar-----------------------------------
                break;
            case R.id.btn_ustal:
                //yapılacaklar
                virgulsil(tv_clc);
                opAdd("^",tv_clc);
                break;
            case R.id.btn_deger:
                //yapılacaklar-----------------------------------------------
                openDegerDialog();
                break;
            case R.id.btn_backspace:
                //yapılacaklar
                String s = tv_clc.getText().toString();
                if (tv_clc.length()>0) {
                    tv_clc.setText(s.substring(0, tv_clc.length() - 1));
                }else pSayac=0;
                break;
            case R.id.btn_delete:
                //yapılacaklar
                pSayac=0;
                tv_clc.setText("");
                break;
            case R.id.btn_parantez:
                //yapılacaklar
                virgulsil(tv_clc);
                if (tv_clc.getText().length()>0)
                {
                    if (sonGetir(tv_clc).equals("(")||sonGetir(tv_clc).equals("-"))
                    {
                        tv_clc.setText(tv_clc.getText() + "(");
                        pSayac++;
                    }
                    else if (pSayac>0&&!sonGetir(tv_clc).equals("(")&&!opMu(sonGetir(tv_clc)))
                    {
                        tv_clc.setText(tv_clc.getText() + ")"); //girmemesi gereken yer.
                        pSayac--;
                    }
                    else if (sonGetir(tv_clc).equals(")")||!opMu(tv_clc.getText().toString())){
                        tv_clc.setText(tv_clc.getText() + "x(");
                        pSayac++;
                    }else {
                        tv_clc.setText(tv_clc.getText() + "(");
                        pSayac++;
                    }
                }
                else
                {
                    pSayac++;
                    tv_clc.setText("(");
                }
                break;
            case R.id.btn_yuzde:
                //yapılacaklar
                virgulsil(tv_clc);
                opAdd("%",tv_clc);

                break;
            case R.id.btn_bol:
                //yapılacaklar
                virgulsil(tv_clc);
                opAdd("/",tv_clc);
                break;
            case R.id.btn_carp:
                //yapılacaklar
                virgulsil(tv_clc);
                opAdd("x",tv_clc);
                break;
            case R.id.btn_cikar:
                //yapılacaklar
                virgulsil(tv_clc);
                opAdd("-",tv_clc);
                break;
            case R.id.btn_topla:
                //yapılacaklar
                virgulsil(tv_clc);
                opAdd("+",tv_clc);
                break;
            case R.id.btn_sifir:
                //yapılacaklar
                tv_clc.setText(tv_clc.getText()+"0");
                break;
            case R.id.btn_ciftsifir:
                //yapılacaklar
                tv_clc.setText(tv_clc.getText()+"00");
                break;
            case R.id.btn_virgul:
                //yapılacaklar
                virgulsil(tv_clc);
                tv_clc.setText(tv_clc.getText()+",");
                break;
            case R.id.btn_bir:
                //yapılacaklar
                tv_clc.setText(tv_clc.getText()+"1");
                break;
            case R.id.btn_iki:
                //yapılacaklar
                tv_clc.setText(tv_clc.getText()+"2");
                break;
            case R.id.btn_uc:
                //yapılacaklar
                tv_clc.setText(tv_clc.getText()+"3");
                break;
            case R.id.btn_dort:
                //yapılacaklar
                tv_clc.setText(tv_clc.getText()+"4");
                break;
            case R.id.btn_bes:
                //yapılacaklar
                tv_clc.setText(tv_clc.getText()+"5");
                break;
            case R.id.btn_alti:
                //yapılacaklar
                tv_clc.setText(tv_clc.getText()+"6");
                break;
            case R.id.btn_yedi:
                //yapılacaklar
                tv_clc.setText(tv_clc.getText()+"7");
                break;
            case R.id.btn_sekiz:
                //yapılacaklar
                tv_clc.setText(tv_clc.getText()+"8");
                break;
            case R.id.btn_dokuz:
                //yapılacaklar
                tv_clc.setText(tv_clc.getText()+"9");
                break;
            case R.id.btn_save:
                //yapılacaklar-----------------------------------
                virgulsil(tv_clc);
                break;
            default:break;



        }
    }

    @Override
    public void applyTexts(String calc) {
        tv_formul_calc.setText(tv_formul_calc.getText()+"(\"["+calc+"]\")");
    }
}
