package id.uripyogantara.rentcar.admin.addcar;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import id.uripyogantara.rentcar.R;
import id.uripyogantara.rentcar.api.ApiClient;
import id.uripyogantara.rentcar.model.Response;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

public class AddCarActivity extends AppCompatActivity {
    TextView tvSelectImage;
    ImageView imgCar;
    EditText etCarName,etCarPrice,etCarDescription;

    private static final int IMG_REQUEST=777;
    private Bitmap bitmap;
    MultipartBody.Part body;

    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        imgCar=findViewById(R.id.img_car);
        btnAdd =findViewById(R.id.btn_add);
        tvSelectImage=findViewById(R.id.tv_select_image);
        etCarName=findViewById(R.id.et_car_name);
        etCarPrice=findViewById(R.id.et_car_price);
        etCarDescription=findViewById(R.id.et_car_description);

        tvSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkStoragePermission()) {
                        selectImage();
                    }
                }
                else {
                    selectImage();
                }

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upload();
            }
        });
    }



    public static final int MY_PERMISSIONS_REQUEST_STORAGE= 1;
    private boolean checkStoragePermission() {
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE)) {
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_STORAGE);
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_STORAGE);
            }
            return false;
        } else {
            return true;
        }
    }

    private void selectImage(){
        Intent intent= new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMG_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==IMG_REQUEST && resultCode==RESULT_OK&&data!=null){
            Uri selectedImage=data.getData();
            try {
                bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),selectedImage);
                imgCar.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String wholeID = DocumentsContract.getDocumentId(selectedImage);

            // Split at colon, use second item in the array
            String id = wholeID.split(":")[1];

            String[] column = { MediaStore.Images.Media.DATA };

            // where id is equal to
            String sel = MediaStore.Images.Media._ID + "=?";

            Cursor cursor = getContentResolver().
                    query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                            column, sel, new String[]{ id }, null);

            String filePath = "";

            int columnIndex = cursor.getColumnIndex(column[0]);

            if (cursor.moveToFirst()) {
                filePath = cursor.getString(columnIndex);
            }
            cursor.close();
            File file = new File(filePath);

            RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);

            body = MultipartBody.Part.createFormData("picture", file.getName(), reqFile);
//            uploadImage();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_STORAGE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // Izin diberikan.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_GRANTED) {

                        selectImage();
                    }

                } else {
                    // Izin ditolak.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }


    private void upload() {
        RequestBody name = RequestBody.create(okhttp3.MultipartBody.FORM, etCarName.getText().toString());
        RequestBody description = RequestBody.create(okhttp3.MultipartBody.FORM, etCarDescription.getText().toString());
        RequestBody price = RequestBody.create(okhttp3.MultipartBody.FORM, etCarPrice.getText().toString());
//        RequestBody lng = RequestBody.create(okhttp3.MultipartBody.FORM, mLongitude.getText().toString());
        ApiClient.getService(this)
                .addCar(body,name,price,description)
                .enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(AddCarActivity.this, "Sukses", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(AddCarActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        Toast.makeText(AddCarActivity.this, "Error: "+t, Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
