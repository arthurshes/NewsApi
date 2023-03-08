package door.one.newsjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.List;

import door.one.newsjava.Models.NewsLabel;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<NewsLabel> news;
private SelectListener listener;

    public CustomAdapter(Context context, List<NewsLabel> news,SelectListener listener) {
        this.context = context;
        this.news = news;
        this.listener=listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.item_news,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.text_title.setText(news.get(position).getTitle());
        holder.text_source.setText(news.get(position).getSource().getName());
if (news.get(position).getUrlToImage()!=null) {
Picasso.get().load(news.get(position).getUrlToImage()).into(holder.img_headline);
}
holder.cardView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        listener.onNewsClick(news.get(position));
    }
});

    }

    @Override
    public int getItemCount() {
        return news.size();
    }
}
