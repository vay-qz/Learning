import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author qiaozhe
 */
public class BlogTest {

    @Test
    public void read2time_return_2times() {
        Article blog = Article.getBlog(2);
        Article blog2 = Article.getBlog(2);
        assertEquals(blog2, blog);
    }

    @Test
    public void read1time_return_1times() {
        Article article = Article.getBlog(1);
        assertEquals(1, article.getReadTime());
    }

}
