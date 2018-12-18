package com.example.ibrahim.fook;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class FormulDegerDialog extends AppCompatDialogFragment {

    private EditText et_degisken;
    private FormulDegerDialogListener listenerr;
    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder= new AlertDialog.Builder((getActivity()));

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_degisken,null);
        builder.setView(view);
        builder.setTitle("Değişken Değer");
        builder.setNegativeButton("Vazgeç", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("Ekle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            String et_calcc =et_degisken.getText().toString();

            listenerr.applyTexts(et_calcc);
            }
        });
        et_degisken =view.findViewById(R.id.dialog_editT);
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listenerr=(FormulDegerDialogListener) context;
        } catch (ClassCastException e) {
           throw  new ClassCastException(context.toString()+"must implement FormulDialogListener");
        }
    }

    public  interface FormulDegerDialogListener{
        void applyTexts(String calc);
    }
}
