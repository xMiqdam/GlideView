package com.example.glideview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Adaptermakanan.ItemClickListener{
    RecyclerView rvmakanan;
    private Adaptermakanan adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvmakanan = findViewById(R.id.rvMakananFavorit);
        rvmakanan = findViewById(R.id.rvMakananFavorit);
        rvmakanan.setHasFixedSize(true);
        rvmakanan.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adaptermakanan(getListMakanan());
        adapter.setClickListener(this);
        rvmakanan.setAdapter(adapter);
    }

    private List<makananmodel> getListMakanan() {
        List<makananmodel> listMakanan = new ArrayList<>();
        listMakanan.add(new makananmodel("https://www.blibli.com/friends-backend/wp-content/uploads/2023/08/COVER.jpg", "Burger", "Makanan cepat saji dengan daging di dalam roti, sering disertai dengan keju dan sayuran."));
        listMakanan.add(new makananmodel("https://asset.kompas.com/crops/_aMC-HU7taASfMRcywxK5d5RI-o=/17x22:985x667/750x500/data/photo/2022/07/23/62dbd7ac6e943.jpg", "Pizza", "Makanan asal Italia terdiri dari adonan, saus tomat, keju, dan berbagai toping seperti daging dan sayuran."));
        listMakanan.add(new makananmodel("data:image/jpeg;base64,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", "Mie Goreng", " Mie yang dimasak dengan cara digoreng dalam minyak dengan tambahan bumbu seperti bawang putih, kecap, dan berbagai bahan lainnya seperti telur dan sayuran."));
        listMakanan.add(new makananmodel("https://asset.kompas.com/crops/AXQRTLOnPfT7ZGHpQbuNSa7PltE=/100x67:900x600/750x500/data/photo/2023/09/15/65041d6eb2d02.jpg", "Roti", "Makanan dasar terbuat dari adonan tepung terigu yang dibuat dalam berbagai bentuk dan variasi."));
        listMakanan.add(new makananmodel("https://cdn.idntimes.com/content-images/community/2022/01/screenshot-2022-01-02-05-10-19-72-1c337646f29875672b5a61192b9010f9-6d2cbb4bbec2340f770674be006d2944-0c6c08844a9f986440835cb11b7d41d0_600x400.jpg", "Lentog", "Lentog adalah camilan Jawa Tengah yang terbuat dari kacang hijau direbus dengan gula merah dan daun pandan."));
        return listMakanan;
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position).getTitle() + " on row number " + position, Toast.LENGTH_SHORT).show();    }


}
