package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    class Data{
        int photo;
        String name;
    }

    public class MyAdapter extends BaseAdapter{
        private MainActivity.Data[] data;
        private int view;


    public MyAdapter(MainActivity.Data[] data,int view){
        this.data=data;
        this.view=view;
    }

    @Override
    public int getCount(){
        return data.length;
    }

    @Override
    public Object getItem(int position){
        return data[position];
    }
    @Override
    public long getItemId(int position){
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        convertView=getLayoutInflater().inflate(view,parent,false);
        TextView name=convertView.findViewById(R.id.name);
        name.setText(data[position].name);
        ImageView imageView=convertView.findViewById(R.id.imageView);
        imageView.setImageResource(data[position].photo);
        return convertView;
    }
}

    @Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    String[] transNameArray =new String[]{"BIKE","機車","CAR","BUS"};
    int [] transPhotoIdArray =new int[]{R.drawable.trans1,R.drawable.trans2,R.drawable.trans3,R.drawable.trans4};

    Data[] transData =new Data[transNameArray.length];
    for(int i=0;i<transData.length;i++){
        transData[i]=new Data();
        transData[i].name=transNameArray[i];
        transData[i].photo=transPhotoIdArray[i];
    }

    MyAdapter transAdapter =new MyAdapter(transData,R.layout.trans_list);

        Spinner spinner=findViewById(R.id.spinner);
        spinner.setAdapter(transAdapter);

        String[] messageArray = new String[]{"massage1","massage2","massage3","massage4","massage5","massage6"};

        ArrayAdapter<String> messageAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1
                ,messageArray);

        ListView listView =findViewById(R.id.listView);
        listView.setAdapter(messageAdapter);

        String[] cubeeNameArray=new String[]{"CRY","SHAKING","BYE","ANGRY","昏倒","竊笑","GOOD","HI","驚嚇","大笑"};
        int [] cubeePhotoIdArray =new int[]{R.drawable.cubee1,R.drawable.cubee2,R.drawable.cubee3,R.drawable.cubee4,
                R.drawable.cubee5,R.drawable.cubee6,R.drawable.cubee7,R.drawable.cubee8,R.drawable.cubee9,R.drawable.cubee10};
        Data[]cubeeData=new Data[cubeeNameArray.length];
        for (int i=0;i<cubeeData.length;i++){
            cubeeData[i] =new Data();
            cubeeData[i].name =cubeeNameArray[i];
            cubeeData[i].photo=cubeePhotoIdArray[i];
        }

        MyAdapter cubeeAdapter =new MyAdapter(cubeeData,R.layout.cubee_list);

        GridView gridView=findViewById(R.id.gridView);
        gridView.setAdapter(cubeeAdapter);
        gridView.setNumColumns(3);
    }
}