package com.maximoprog.appbottomnavigationfragment.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maximoprog.appbottomnavigationfragment.MenuDetailActivity;
import com.maximoprog.appbottomnavigationfragment.R;
import com.maximoprog.appbottomnavigationfragment.models.Menu;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
//propiades necesarias

    private Context context;
    private ArrayList<Menu> listMenu;

    public MenuAdapter(Context context) {
        this.context = context;
        listMenu = new ArrayList<>();
    }

    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        se le indica que vista usara el adapter
        View vista = LayoutInflater.from(context)
                .inflate(R.layout.list_menu_element, parent, false);
        return new MenuAdapter.ViewHolder(vista);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, int position) {
        final Menu item = listMenu.get(position);
        holder.txtMenuTitle.setText(item.getTitle());
        holder.txtMenuPrice.setText("Precio: S./: " + item.getPrice());
        holder.ivMenuImage.setImageResource(item.getImage());
        holder.btnMenuDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.success(context, item.getTitle(), Toast.LENGTH_SHORT, true).show();
//                crea un intent
                Intent intentMenuDetalle = new Intent(
                        context, MenuDetailActivity.class
                );
//                le pasa el item osea el objecto como parametro
                intentMenuDetalle.putExtra("menu", item);
//                inicia la actividad
                context.startActivity(intentMenuDetalle);
            }
        });
    }

    public void addElementsMenu(ArrayList<Menu> data) {
        listMenu.clear();
        listMenu.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listMenu.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivMenuImage;
        TextView txtMenuTitle, txtMenuPrice;
        Button btnMenuDetails;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMenuImage = itemView.findViewById(R.id.imageViewMenu);
            txtMenuTitle = itemView.findViewById(R.id.titleMenuView);
            txtMenuPrice = itemView.findViewById(R.id.priceMenuView);
            btnMenuDetails = itemView.findViewById(R.id.btnMenuItem);
//            ivMenuImage.setImageResource();
        }
    }
}
