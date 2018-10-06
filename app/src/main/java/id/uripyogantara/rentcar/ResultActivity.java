package id.uripyogantara.rentcar;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    SearchView searchView;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        searchView=findViewById(R.id.search_view);
        tvResult=findViewById(R.id.tv_result);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                tvResult.setText(newText);
                return true;
            }
        });
    }
}
