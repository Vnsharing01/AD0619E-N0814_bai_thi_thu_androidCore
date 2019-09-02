package vn.itplus.cmnthi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DanhSachCongViec extends AppCompatActivity {

    public static final int REQUEST_CODE_ADD = 100;
    public static final int RESULT_CODE_SAVE = 0;
    public static final int RESULT_CODE_CANEL =112;

    ArrayList<CongViec> mArrayList;
    SQLiteDatabase db;
    CMNThi cmnThi;
    ListView ListcongViec;
    Button btnadd;
    ArrayAdapter<CongViec> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danhsachcongviec);

        ListcongViec = findViewById(R.id.ListCV);

        mArrayList = new ArrayList<CongViec>();

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,mArrayList );
        ListcongViec.setAdapter(arrayAdapter);

        cmnThi = new CMNThi(this);
        db = cmnThi.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(cmnThi.COT_TieuDe, "Tiêu Đề");
        values.put(cmnThi.COT_NoiDung, "Nội Dung");

        long result = db.insert(cmnThi.TABLE_WORK, null, values);
        Cursor danhsach = db.query(cmnThi.TABLE_WORK,null,null,null,null,null,null);
        danhsach.getCount();
        danhsach.moveToFirst();
        db.close();

        if (result != 0){

            Toast.makeText(this, "Thêm Thành Công",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"Thêm Không Thành Công",Toast.LENGTH_LONG).show();
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ADD){
            switch (resultCode){
                case RESULT_CODE_SAVE:
                    CongViec cv = (CongViec) data.getSerializableExtra("newwork");
                    mArrayList.add(cv);
                    arrayAdapter.notifyDataSetChanged();
                    break;
                case RESULT_CODE_CANEL:
                    Toast.makeText(this, "bỏ qua",Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

    @Override
    //  Thêm menu vào ActionBar
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    //  bắt sự kiện khi bấm vào các menu
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.addCongViec:
                Intent intent = new Intent(this,ThemCongViec.class);
                startActivityForResult(intent, REQUEST_CODE_ADD);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
