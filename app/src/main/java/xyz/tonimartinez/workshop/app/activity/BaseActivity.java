package xyz.tonimartinez.workshop.app.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import xyz.tonimartinez.workshop.R;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Bind(R.id.pb_loading) View mLoadinPB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayout());
        injectViews();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        resetViews();
    }

    protected abstract int getActivityLayout();

    private void injectViews() {
        ButterKnife.bind(this);
    }

    protected void resetViews() {
        ButterKnife.unbind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void showError(int message) {
        showError(getString(message));
    }

    public void showError(String message) {
        showMessage(message);
    }

    public void showMessage(int message) {
        showMessage(getString(message));
    }

    public void showMessage(String message) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show();
    }

    public void showLoading() {
        try {
            mLoadinPB.setVisibility(View.VISIBLE);
        } catch (Exception e) {
        }
    }

    public void hideLoading() {
        try {
            mLoadinPB.setVisibility(View.GONE);
        } catch (Exception e) {
        }
    }

}
