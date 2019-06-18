import org.junit.Assert;
import org.junit.Test;

/**
 * @author qiaozhe
 */
public class ArticleTest {

    @Test
    public void news_not_blog() {
        Article news = Article.getNews(5);
        Article blog = Article.getBlog(5);
        Assert.assertNotEquals(news, blog);
    }

    @Test
    public void news_transform_article() {
        Article news1 = Article.getNews(0);
        Article blog = news1.transform("blog");
        Assert.assertEquals(new Article("blog"), blog);
    }

    @Test
    public void article_transform_news() {
        Article news1 = Article.getNews(0);
        Article blog = news1.transform("news");
        Assert.assertEquals(new Article("news"), blog);
    }

    @Test
    public void sum_read2Time_return_2() {
        Article news = Article.getNews(1);
        Article blog = Article.getBlog(1);
        Sum times = news.plus(blog);
        Assert.assertEquals(times.reduce(), new Article(2));
    }


    @Test
    public void sum_neverRead_return_0() {
        Article news = Article.getNews(0);
        Article blog = Article.getBlog(0);
        Sum times = news.plus(blog);
        Assert.assertEquals(times.reduce(), new Article(0));
    }

    @Test
    public void sum_newsRead1time_newsRead2time_blogRead2Times_return5Times() {
        Sum times = Article.getNews(1).plus(Article.getNews(2)).plus(Article.getBlog(2));
        Assert.assertEquals(times.reduce(), new Article(5));
    }

}
