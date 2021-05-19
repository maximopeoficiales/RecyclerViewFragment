package com.maximoprog.appbottomnavigationfragment.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maximoprog.appbottomnavigationfragment.R;
import com.maximoprog.appbottomnavigationfragment.models.Menu;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class MenuAdapters extends RecyclerView.Adapter<MenuAdapters.ViewHolder> {
//propiades necesarias

    private Context context;
    private ArrayList<Menu> listMenu;

    public MenuAdapters(Context context) {
        this.context = context;
        listMenu = new ArrayList<>();
    }

    @NonNull
    @Override
    public MenuAdapters.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        se le indica que vista usara el adapter
        View vista = LayoutInflater.from(context)
                .inflate(R.layout.list_menu_element, parent, false);
        return new MenuAdapters.ViewHolder(vista);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MenuAdapters.ViewHolder holder, int position) {
        final Menu item = listMenu.get(position);
        holder.txtMenuTitle.setText(item.getTitle());
        holder.txtMenuPrice.setText("Precio: S./: " + item.getPrice());
        holder.ivMenuImage.setImageResource(item.getImage());
        holder.btnMenuDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.success(context, item.getTitle(), Toast.LENGTH_SHORT, true).show();
//                crea un intent
//                Intent intentAndroidDetalle = new Intent(
//                        context, DetalleAndroidActivity.class
//                );
//                le pasa el item osea el objecto como parametro
//                intentAndroidDetalle.putExtra("android", item);
//                inicia la actividad
//                context.startActivity(intentAndroidDetalle);
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
