package com.mercacortex.manageproductrecycler.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.mercacortex.manageproductrecycler.R;
import com.mercacortex.manageproductrecycler.adapter.ProductAdapterRecycler;

public class ProductActivity extends AppCompatActivity {

    private ProductAdapterRecycler adapter;
    private RecyclerView rcvProduct;
    private static final int ADD_PRODUCT = 0;


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_product, menu);
        return super.onCreateOptionsMenu(menu);
    }


    /**
     * Inflates activity's menu
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_add_product:
                intent = new Intent(this, AddProductActivity.class);
                startActivityForResult(intent, ADD_PRODUCT);
                break;
            case R.id.action_sort_alphabetically:
                adapter.sortAlphabetically();
                break;
            case R.id.action_settings_general:
                break;
            case R.id.action_settings_account:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // First we have to know which mode was selected
        switch (requestCode) {

            case ADD_PRODUCT:
                // Here we use Android's code
                if (resultCode == RESULT_OK) {
                    // Here we add the product
                }

                break;
        }

    }
}
