package xyz.tonimartinez.workshop.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import xyz.tonimartinez.workshop.R;
import xyz.tonimartinez.workshop.app.adapter.AndroidsAdapter;
import xyz.tonimartinez.workshop.app.presenter.AndroidListPresenter;
import xyz.tonimartinez.workshop.domain.model.Android;

public class MainActivity extends BaseActivity {

    @Bind(R.id.item_list_RV) protected RecyclerView mProductsListRV;

    protected AndroidListPresenter mAndroidListPresenter;
    private AndroidsAdapter mAndroidsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAndroidListPresenter = new AndroidListPresenter(this);
        setupLayout();
        mAndroidListPresenter.getAndroidList();
    }

    private void setupLayout() {
        if ( getSupportActionBar() != null ) {
            getSupportActionBar().setTitle(R.string.app_name);
        }

        mAndroidsAdapter = new AndroidsAdapter(new ArrayList<Android>());
        mAndroidsAdapter.setOnItemClickListener(new AndroidsAdapter.OnItemClickListener() {
            @Override
            public void onClick(Android item) {
                //Intent intent = AndroidDetailActivity.navigate(MainActivity.this, item.getId());
                //startActivity(intent);
            }
        });

        mProductsListRV.setLayoutManager(new LinearLayoutManager(this));
        mProductsListRV.setHasFixedSize(true);
        mProductsListRV.setAdapter(mAndroidsAdapter);
    }


    public void renderAndroidList(List<Android> list) {
        mAndroidsAdapter.clear();
        mAndroidsAdapter.addAll(list);
        hideLoading();
    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_main;
    }
}
