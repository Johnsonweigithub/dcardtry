package com.example.dcardtry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DcardDetailActivity extends AppCompatActivity {
    private String title, content, date, sascore, saclass, lv1, lv2, lv3, id;
    private TextView tvTitle, tvContent, tvDate, tvsascore, tvsaclass, tvlv1, tvlv2, tvlv3;
    Button btnURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dcard_detail);

        //設定隱藏標題
        getSupportActionBar().hide();
        //設定隱藏狀態
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        title = getIntent().getStringExtra("title");
        content = getIntent().getStringExtra("content");
        date = getIntent().getStringExtra("date");
        sascore = getIntent().getStringExtra("sascore");
        saclass = getIntent().getStringExtra("saclass");
        lv1 = getIntent().getStringExtra("lv1");
        lv2 = getIntent().getStringExtra("lv2");
        lv3 = getIntent().getStringExtra("lv3");
        id = getIntent().getStringExtra("id");

        tvTitle = findViewById(R.id.title_tv);
        tvTitle.setText(title);
        tvContent = findViewById(R.id.content_tv);
        tvContent.setText(content);
        tvDate = findViewById(R.id.date_tv);
        tvDate.setText(date);
        tvsascore = findViewById(R.id.score_tv);
        tvsascore.setText(sascore);
        tvsaclass = findViewById(R.id.class_tv);
        tvsaclass.setText(saclass);
        tvlv1 = findViewById(R.id.lv1_tv);
        tvlv1.setText(lv1);
        tvlv1.setTextColor(Color.parseColor("#FFDD55"));
        tvlv2 = findViewById(R.id.lv2_tv);
        tvlv2.setText(lv2);
        tvlv2.setTextColor(Color.parseColor("#FFBB66"));
        tvlv3 = findViewById(R.id.lv3_tv);
        tvlv3.setText(lv3);
        tvlv3.setTextColor(Color.parseColor("#FFA488"));

        btnURL = findViewById(R.id.urlButton);
        btnURL.setOnClickListener(btnURLListener);

        switch (saclass){
            case "Positive":
                tvsaclass.setTextColor(getResources().getColor(R.color.posColor));
                tvsascore.setTextColor(getResources().getColor(R.color.posColor));
                break;
            case "Neutral":
                tvsaclass.setTextColor(getResources().getColor(R.color.neuColor));
                tvsascore.setTextColor(getResources().getColor(R.color.neuColor));
                break;
            case "Negative":
                tvsaclass.setTextColor(getResources().getColor(R.color.negColor));
                tvsascore.setTextColor(getResources().getColor(R.color.negColor));
                break;
            case "null":
                tvsaclass.setTextColor(getResources().getColor(R.color.gray));
                tvsascore.setTextColor(getResources().getColor(R.color.gray));
        }

    }
    private Button.OnClickListener btnURLListener = v -> {
        Uri uri = Uri.parse("https://www.dcard.tw/f/cgu/p/" + id);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    };
}