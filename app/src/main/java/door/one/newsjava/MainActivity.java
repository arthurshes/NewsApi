package door.one.newsjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import door.one.newsjava.Models.NewsApiResponce;
import door.one.newsjava.Models.NewsLabel;

public class MainActivity extends AppCompatActivity implements SelectListener {
RecyclerView recyclerView;
CustomAdapter adapter;
Button b1,b2,b3,b4,b5,b6;
ProgressDialog progressDialog;
SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestManager manager=new RequestManager(this);
        manager.getNewsLabel(listen,"general",null);
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Загрузка...");
        progressDialog.show();
searchView=(SearchView)findViewById(R.id.searc_view);

searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
    @Override
    public boolean onQueryTextSubmit(String query) {
        progressDialog.setTitle("Загрзка...");
        progressDialog.show();
        RequestManager manager=new RequestManager(MainActivity.this);
        manager.getNewsLabel(listen,"general",query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
});

        b1=(Button)findViewById(R.id.btn_1);
        b2=(Button)findViewById(R.id.btn_2);
        b3=(Button)findViewById(R.id.btn_3);
        b4=(Button)findViewById(R.id.btn_4);
        b5=(Button)findViewById(R.id.btn_5);
        b6=(Button)findViewById(R.id.btn_6);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s="business";
                progressDialog.setTitle("Загрузка данных"+s);
progressDialog.show();
                RequestManager manager=new RequestManager(MainActivity.this);
                manager.getNewsLabel(listen,s,null);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s2="entertainment";
                progressDialog.setTitle("Загрузка даныых"+s2);
progressDialog.show();
                RequestManager manager=new RequestManager(MainActivity.this);
                manager.getNewsLabel(listen,s2,null);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s3="general";
                progressDialog.setTitle("Загрузка данных"+s3);
progressDialog.show();
                RequestManager manager=new RequestManager(MainActivity.this);
                manager.getNewsLabel(listen,s3,null);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s4="health";
                progressDialog.setTitle("Загрузка данных"+s4);
progressDialog.show();
                RequestManager manager=new RequestManager(MainActivity.this);
                manager.getNewsLabel(listen,s4,null);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s5="technology";
                progressDialog.setTitle("Загрузка данных"+s5);
progressDialog.show();
                RequestManager manager=new RequestManager(MainActivity.this);
                manager.getNewsLabel(listen,s5,null);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s6="sports";
                progressDialog.setTitle("Загрузка данных"+s6);
progressDialog.show();
                RequestManager manager=new RequestManager(MainActivity.this);
                manager.getNewsLabel(listen,s6,null);
            }
        });

    }
    private  final OnFechListen<NewsApiResponce>listen=new OnFechListen<NewsApiResponce>() {
        @Override
        public void onFetchData(List<NewsLabel> list, String message) {
            if (list.isEmpty()){
                Toast.makeText(MainActivity.this, "Данные не найдены", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }else{
                showNews(list);
                progressDialog.dismiss();
            }

        }

        @Override
        public void onError(String message) {
            Toast.makeText(MainActivity.this, "Ошибка подключения", Toast.LENGTH_SHORT).show();
        }
    };

    private void showNews(List<NewsLabel> list) {
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter=new CustomAdapter(this,list,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onNewsClick(NewsLabel label) {
startActivity(new Intent(MainActivity.this,NewsActivity.class).putExtra("data",label));
    }


}