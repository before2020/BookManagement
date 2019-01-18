package com.books.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Book
{
    private Integer bid;
    private String title;
    private String author;
    private String press;
    private String category;
    private Integer year;
    private Double price;

    @Override
    public String toString()
    {
        return "Book{" +
                "bid=" + bid +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", category='" + category + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
