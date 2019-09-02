package vn.itplus.cmnthi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThemCongViec extends AppCompatActivity {

    EditText txtTieude , txtnoiDung;
    Button btnSave , btnCancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themcongviec);

        txtTieude = findViewById(R.id.txtTieuDe);
        txtnoiDung = findViewById(R.id.txtNoiDung);
        btnSave = findViewById(R.id.btnsave);
        btnCancel = findViewById(R.id.btncancel);

        btnSave.setOnClickListener(SAVE);
        btnCancel.setOnClickListener(CANCEL);


    }

    private void SendToMain(int resoucecode){

        Intent intent = new Intent();
        CongViec cv = new CongViec();

        cv.setTieuDe(txtTieude.getText().toString());
        cv.setNoiDung(txtnoiDung.getText().toString());

        intent.putExtra("newwork",cv);
        setResult(resoucecode,intent);

        finish();
    }

    public void btnOk(){
        SendToMain(DanhSachCongViec.RESULT_CODE_SAVE);
        finish();
    }
    public void btnCancel(){
        SendToMain(DanhSachCongViec.RESULT_CODE_CANEL);
        finish();
    }

    private  View.OnClickListener SAVE = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnsave:
                    btnOk();
                    break;
            }
        }
    };
    private  View.OnClickListener CANCEL = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btncancel:
                    btnCancel();
                    break;
            }
        }
    };
}
