package com.maximoprog.appbottomnavigationfragment.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.maximoprog.appbottomnavigationfragment.databinding.FragmentNotificationsBinding;

import es.dmoral.toasty.Toasty;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        FragmentNotificationsBinding root = FragmentNotificationsBinding.inflate(inflater, container, false);
//        final TextView textView = root.findViewById(R.id.text_notifications);
//        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
////                textView.setText(s);
//            }
//        });


        root.btnGuardarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String precio = root.txtPrecioMenu.getText().toString();
                String menu = root.txtNameMenu.getText().toString();
                if (!precio.equals("") && !menu.equals("")) {
                    if (Double.parseDouble(precio) > 0) {
//                        txtResult.setText("El precio a pagar por " + nMenus + " menus es: S./ " + Double.parseDouble(nMenus) * Double.parseDouble(precio));
                        Toasty.success(getContext(), "Se registro correctamente: " + menu, Toast.LENGTH_SHORT, true).show();
                    } else {
                        Toasty.error(getContext(), "No puede ingresar 0 en el Precio", Toast.LENGTH_SHORT, true).show();
                    }
                } else {
                    Toasty.error(getContext(), "El menu o el precio esta vacio", Toast.LENGTH_SHORT, true).show();
                }
            }
        });
        return root.getRoot();
    }
}