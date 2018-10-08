package id.uripyogantara.rentcar.user.profil;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import id.uripyogantara.rentcar.R;
import id.uripyogantara.rentcar.login.LoginActivity;
import id.uripyogantara.rentcar.login.LoginPresenter;
import id.uripyogantara.rentcar.utils.PreferencesHelper;

public class ProfilFragment extends Fragment {
    private PreferencesHelper preferencesHelper;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        preferencesHelper=new PreferencesHelper(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profil,container,false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_profil,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_logout:
                preferencesHelper.logout();
                Intent intent=new Intent(getContext(),LoginActivity.class);
                getActivity().startActivity(intent);
                getActivity().finish();
                break;
        }
        return true;
    }
}
