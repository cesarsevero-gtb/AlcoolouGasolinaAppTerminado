package com.getword.alcoolougasolina.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.getword.alcoolougasolina.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;


public class SobreFragment extends Fragment {



    public SobreFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String descricao = "Get World, empresa especializada em " +
                "criação de aplicativo ";

        Element versao = new Element();
        versao.setTitle("versão 1.0.0.0.20");




        View sobre = new AboutPage(getActivity())

                .setImage(R.drawable.logo22 )
                .setDescription(descricao)
                .addGroup("Sujestões e Contato")
                .addEmail("direito1boab@gmail.com","Envie um E-mail")


                .addGroup("Links")
                .addPlayStore("com.getword.alcoolougasolina", "Avalie nosso Aplicativo")
                .addWebsite("https://play.google.com/store/apps/dev?id=8817099273138442707", "Conheça todos Aplicativos")
                .addWebsite("https://www.paypal.com/donate/?hosted_button_id=ZWAAXW93L99F8", "Faça uma Doação")

                .create();

        return sobre;
        //return inflater.inflate(R.layout.fragment_sobre, container, false);
    }
}