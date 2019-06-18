import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author qiaozhe
 */
public class NewsTest {

    @Test
    public void read2time_return_2time() {
        Article news = Article.getNews(2);
        Assertions.assertEquals(2, news.getReadTime());
    }
}
