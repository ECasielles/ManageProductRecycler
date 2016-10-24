package com.mercacortex.manageproductrecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.mercacortex.manageproductrecycler.adapter.ProductAdapterRecycler;

public class ProductsActivity extends AppCompatActivity {

    private ProductAdapterRecycler adapter;
    private RecyclerView rcvProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        adapter = new ProductAdapterRecycler(this);
        rcvProduct = (RecyclerView) findViewById(R.id.rcv_product);

        // Custom layout manager
        rcvProduct.setLayoutManager(new LinearLayoutManager(this));
        rcvProduct.setHasFixedSize(true);
        rcvProduct.setAdapter(adapter);
    }
}
