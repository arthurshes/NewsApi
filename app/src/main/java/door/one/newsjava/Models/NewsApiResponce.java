package door.one.newsjava.Models;

import java.io.Serializable;
import java.util.List;

public class NewsApiResponce implements Serializable {
    String status;
    int totalResults;
    List<NewsLabel> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<NewsLabel> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsLabel> articles) {
        this.articles = articles;
    }
}
