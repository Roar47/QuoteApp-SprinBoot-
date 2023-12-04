package org.example.beans;

public class Quote {
    public int id;
    public String quote;
    public String author;
    public String language;
    public String category;

    public int getId() {
        return id;
    }

    public Quote() {

    }
    public Quote(int id, String quote, String author, String language, String category) {
        this.id = id;
        this.quote = quote;
        this.author = author;
        this.language = language;
        this.category = category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
