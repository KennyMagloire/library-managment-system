package com.library;

public class Book implements Cloneable {
    private String bookID;
    private String ISBN;
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private int totalCopies;
    private int availableCopies;
    private BookStatus status;

    public Book(String bookId, String ISBN, String title, String author,
                String genre, int publicationYear, int totalCopies) {
        this.bookID = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
        this.status = BookStatus.AVAILABLE;
    }

    // Getters
    public String getBookID() {return bookID; }
    public String getISBN() { return ISBN; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public int getPublicationYear() { return publicationYear; }
    public int getTotalCopies() { return totalCopies; }
    public int getAvailableCopies() { return availableCopies; }
    public BookStatus getStatus() { return status; }

    // Setters
    public void setStatus(BookStatus status) { this.status = status; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setTotalCopies(int totalCopies) { this.totalCopies = totalCopies; }


    public boolean isAvailable() {
        return availableCopies > 0;
    }

    public void updateDetails(String title, String author, String genre, int totalCopies) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.totalCopies = totalCopies;
    }

    public void decreaseCopies() {
        if (availableCopies > 0) {
            availableCopies--;
        }
        if (availableCopies == 0) {
            this.status = BookStatus.BORROWED;
        }
    }

    public void increaseCopies() {
        availableCopies++;
        if (availableCopies > 0) {
            this.status = BookStatus.AVAILABLE;
        }
    }

    @Override
    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning failed", e);
        }
    }

}
