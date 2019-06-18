/**
 * @author qiaozhe
 */
public class Article {
    private int time;

    String type;

    Article transform(String s) {
        this.type = s;
        return this;
    }

    Article(String type) {
        this.type = type;
    }

    Article(int times) {
        this.time = times;
    }

    void beRead() {
        this.time++;
    }

    Object getReadTime() {
        return this.time;
    }


    public void setTime(int i) {
        this.time = i;
    }

    public static Article getNews(int times) {
        Article news = new Article(times);
        news.type = "news";
        return news;
    }

    public static Article getBlog(int times) {
        Article blog = new Article(times);
        blog.type = "blog";
        return blog;
    }

    @Override
    public boolean equals(Object obj) {
        Article article = (Article)obj;
        return article.time==this.time && article.type == this.type;
    }

    public Sum plus(Article blog) {
        return new Sum(this.time, blog.time);
    }
}
