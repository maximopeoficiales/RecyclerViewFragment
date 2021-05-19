package com.maximoprog.appbottomnavigationfragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.maximoprog.appbottomnavigationfragment.databinding.ActivityMenuDetailBinding;
import com.maximoprog.appbottomnavigationfragment.models.Menu;

public class MenuDetailActivity extends AppCompatActivity {
    ActivityMenuDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_menu_detail);
        binding = ActivityMenuDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //        setContentView(R.layout.activity_detalle_android);
        if (getIntent().hasExtra("menu")) {
            Menu menu = getIntent().getParcelableExtra("menu");
            binding.txtMenuDescriptionDetail.setText(menu.getDescription());
            binding.txtMenuPriceDetail.setText("Precio: S./ " + menu.getPrice());
            binding.txtMenuTitleDetail.setText(menu.getTitle());
            binding.imgViewMenuDetail.setImageResource(menu.getImage());
        }
    }
}