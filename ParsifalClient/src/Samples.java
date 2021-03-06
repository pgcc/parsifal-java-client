
import br.ufjf.parsifal.core.ParsifalClient;
import br.ufjf.parsifal.model.Article;
import java.util.List;

/*
 * The MIT License
 *
 * Copyright 2014 Pós-Graduação em Ciência da Computação UFJF.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
/**
 *
 * @author vitorfs
 */
public class Samples {
    public static void main(String[] args) {
        ParsifalClient client = new ParsifalClient();
        //client.setBaseUri("http://127.0.0.1:8000/api");
        client.setBaseUri("http://parsif.al/api");
        client.setAuthorization("plscience", "plscience");
        
        try {
            //Review review = client.getReview("5");
            List<Article> articles = client.getReviewArticles("28");
            
            articles.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
