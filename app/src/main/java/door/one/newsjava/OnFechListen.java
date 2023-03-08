package door.one.newsjava;

import java.util.List;

import door.one.newsjava.Models.NewsLabel;

public interface OnFechListen <NewsApiResponce>{
    void onFetchData(List<NewsLabel> list,String message);
    void onError(String message);
}
