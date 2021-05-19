package com.maximoprog.appbottomnavigationfragment.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.maximoprog.appbottomnavigationfragment.R;

import es.dmoral.toasty.Toasty;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

        Button btnCalcular = root.findViewById(R.id.btnCalcularReceta);
        EditText txtPrecio = root.findViewById(R.id.inputPrecioMenu);
        EditText txtNMenus = root.findViewById(R.id.inputNMenus);
        TextView txtResult = root.findViewById(R.id.txtResultReceta);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String precio = txtPrecio.getText().toString();
                String nMenus = txtNMenus.getText().toString();
                if (!precio.equals("") && !nMenus.equals("")) {
                    if (Double.parseDouble(precio) > 0 && Double.parseDouble(nMenus) > 0) {
                        txtResult.setText("El precio a pagar por " + nMenus + " menus es: S./ " + Double.parseDouble(nMenus) * Double.parseDouble(precio));
                        Toasty.success(getContext(), "Calculo Realizado Correctamente", Toast.LENGTH_SHORT, true).show();
                    } else {
                        Toasty.error(getContext(), "No puede ingresar 0", Toast.LENGTH_SHORT, true).show();
                    }
                } else {
                    Toasty.error(getContext(), "El precio o la cantidad de menus esta vacio", Toast.LENGTH_SHORT, true).show();
                }
            }
        });
        return root;
    }
}