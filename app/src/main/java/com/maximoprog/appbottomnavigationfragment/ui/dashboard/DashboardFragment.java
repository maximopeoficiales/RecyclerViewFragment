package com.maximoprog.appbottomnavigationfragment.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.maximoprog.appbottomnavigationfragment.R;
import com.maximoprog.appbottomnavigationfragment.adapters.MenuAdapter;
import com.maximoprog.appbottomnavigationfragment.models.Menu;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {
    ArrayList<Menu> listMenu;
    RecyclerView recyclerViewMenus;
    private DashboardViewModel dashboardViewModel;
    
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
//        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
//        cargo mi adapter
        listMenu = new ArrayList<>();
        listMenu.add(new Menu(listMenu.size() + 1, "Arroz con pollo", "33.99", "alguna descripcion", R.drawable.ic_food_scale));
        listMenu.add(new Menu(listMenu.size() + 1, "Tallarin Verde", "22.99", "alguna descripcion lorme", R.drawable.ic__01_bread));
        listMenu.add(new Menu(listMenu.size() + 1, "Papa a la Huancaina", "55.99", "alguna descripcion asd", R.drawable.ic__03_tokayaki));
        listMenu.add(new Menu(listMenu.size() + 1, "Pollo a la brasa", "99.99", "alguna descripcion asdf", R.drawable.ic__08_sashimi));
        listMenu.add(new Menu(listMenu.size() + 1, "Chaufa", "45.99", "alguna descripcion asdf", R.drawable.ic__09_sandwich));
        listMenu.add(new Menu(listMenu.size() + 1, "Arroz con Mariscos", "22.99", "alguna descripcion asdf", R.drawable.ic__29_doughnut));
        MenuAdapter menuAdapter = new MenuAdapter(getContext());
        menuAdapter.addElementsMenu(listMenu);
        recyclerViewMenus = root.findViewById(R.id.rvListaMenus);
        recyclerViewMenus.setHasFixedSize(true);
        recyclerViewMenus.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewMenus.setAdapter(menuAdapter);
        return root;

    }



}