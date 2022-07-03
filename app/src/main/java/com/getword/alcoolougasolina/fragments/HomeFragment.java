package com.getword.alcoolougasolina.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.getword.alcoolougasolina.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Button btnCalcular;

    public EditText editPrecoAlcool;
    public EditText editPrecoGasolina;
    public TextView textResultado;

    View vista;


    public HomeFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_home, container, false);

        btnCalcular = (Button) vista.findViewById(R.id.btnCalcular);
        editPrecoAlcool = (EditText) vista.findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = (EditText) vista.findViewById(R.id.editPrecoGasolina);
        textResultado = (TextView) vista.findViewById(R.id.textResultado);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                //recuperar valores digitados
                String precoAlcool = editPrecoAlcool.getText().toString();
                String precoGasolina = editPrecoGasolina.getText().toString();

                //Validar os campos digitados
                Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
                if( camposValidados ){

                    //Convertendo string para números
                    Double valorAlcool = Double.parseDouble( precoAlcool );
                    Double valorGasolina = Double.parseDouble( precoGasolina );

                    /* Fazer cálculo de menor preço
                     * Se (valorAlcool / valorGasolina) >= 0.7 é melhor utilizar gasolina
                     *   senão é melhor utilizar álcool
                     * */
                    Double resultado = valorAlcool / valorGasolina;
                    if( resultado >= 0.7 ){
                        textResultado.setText("Melhor utilize Gasolina");
                    }else {
                        textResultado.setText("Melhor utilizar Álcool");
                    }


                }else {
                    textResultado.setText("Preencha os preços primeiro!");
                }
            }

            public Boolean validarCampos( String pAlcool, String pGasolina ){

                Boolean camposValidados = true;

                if( pAlcool == null || pAlcool.equals("") ){
                    camposValidados = false;
                }else if( pGasolina == null || pGasolina.equals("") ){
                    camposValidados = false;
                }

                return camposValidados;

            }
        });


        return vista;

    }
}