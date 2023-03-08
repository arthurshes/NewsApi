package door.one.newsjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import door.one.newsjava.Models.NewsLabel;

public class NewsActivity extends AppCompatActivity {
NewsLabel newsLabel;
TextView text_detail_title,text_detail_author,text_detalis_time,text_detail_detail,text_detail_content;
ImageView img_detail_news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        img_detail_news=(ImageView)findViewById(R.id.img_detail_news);
        text_detail_author=(TextView)findViewById(R.id.text_detail_author);
        text_detail_content=(TextView)findViewById(R.id.text_detail_content);
        text_detail_detail=(TextView)findViewById(R.id.text_detail_detail);
        text_detalis_time=(TextView)findViewById(R.id.text_detalis_time);
        text_detail_title=(TextView)findViewById(R.id.text_detail_title);
        newsLabel=(NewsLabel) getIntent().getSerializableExtra("data");
        text_detail_title.setText(newsLabel.getTitle());
        text_detail_author.setText(newsLabel.getAuthor());
        text_detalis_time.setText(newsLabel.getPublishedAt());
        text_detail_detail.setText(newsLabel.getDescription());
        text_detail_content.setText(newsLabel.getContent());
        Picasso.get().load(newsLabel.getUrlToImage()).into(img_detail_news);
    }
}