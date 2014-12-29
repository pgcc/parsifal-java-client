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
package br.ufjf.parsifal.model;

/**
 *
 * @author vitorfs
 */
public class Keyword {
    private Integer id;
    private String description;
    private String related_to;
    private Integer review;
    private Integer synonym_of;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the related_to
     */
    public String getRelated_to() {
        return related_to;
    }

    /**
     * @param related_to the related_to to set
     */
    public void setRelated_to(String related_to) {
        this.related_to = related_to;
    }

    /**
     * @return the review
     */
    public Integer getReview() {
        return review;
    }

    /**
     * @param review the review to set
     */
    public void setReview(Integer review) {
        this.review = review;
    }

    /**
     * @return the synonym_of
     */
    public Integer getSynonym_of() {
        return synonym_of;
    }

    /**
     * @param synonym_of the synonym_of to set
     */
    public void setSynonym_of(Integer synonym_of) {
        this.synonym_of = synonym_of;
    }
}
