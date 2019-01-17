package com.books.domain;

public class Books
{
    private Integer bid;
    private String title;
    private String author;
    private String press;
    private Integer pages;
    private Double price;
    private String category;

    public Integer getBid() { return bid; }

    public void setBid(Integer bid) { this.bid = bid; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public String getPress() { return press; }

    public void setPress(String press) { this.press = press; }

    public Integer getPages() { return pages; }

    public void setPages(Integer pages) { this.pages = pages; }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    @Override
    public String toString()
    {
        return "Books{" +
                "bid=" + bid +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}
