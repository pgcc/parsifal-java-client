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
package br.ufjf.parsifal.core;

import br.ufjf.parsifal.exception.ParsifalException;
import br.ufjf.parsifal.model.Article;
import br.ufjf.parsifal.model.Keyword;
import br.ufjf.parsifal.model.Question;
import br.ufjf.parsifal.model.Review;
import br.ufjf.parsifal.model.SelectionCriteria;
import br.ufjf.parsifal.model.Source;
import com.google.gson.Gson;
import java.net.HttpURLConnection;
import java.util.List;

/**
 *
 * @author vitorfs
 */
public class ParsifalClient extends ParsifalClientBase implements ParsifalServices {

    @Override
    public Review getReview(String reviewName) throws ParsifalException {
        String url = "/reviews/" + reviewName;
        HttpURLConnection response = request(url, "GET", 200, "application/json");
        String content = parseResponse(response);
        //SearchResult result = new Gson().fromJson(content, SearchResult.class);
        System.out.println(content);
        return new Review();
    }

    @Override
    public List<Article> getReviewArticles(String reviewName) throws ParsifalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Question> getReviewQuestions(String reviewName) throws ParsifalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Keyword> getReviewKeywords(String reviewName) throws ParsifalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SelectionCriteria> getReviewSelectionCriterias(String reviewName) throws ParsifalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Source> getReviewSources(String reviewName) throws ParsifalException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
