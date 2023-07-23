package bg.softuni.bookshopsystem.entities;

import bg.softuni.bookshopsystem.entities.enums.AgeRestriction;
import bg.softuni.bookshopsystem.entities.enums.EditionType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    @Column(nullable = false, length = 50)
    private String title;

    @Column(columnDefinition = "TEXT", length = 1000)
    private String description;

    @Column(name = "edition_type",nullable = false)
    @Enumerated(EnumType.STRING)
    private EditionType editionType;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer copies;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "age_restriction", nullable = false)
    @Enumerated(EnumType.STRING)
    private AgeRestriction ageRestriction;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @ManyToMany
    @JoinTable(name = "books_categories",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Set<Category> categories;


    public String getTitleReleaseDateAndCopies() {
        return String.format("Title: %s, Release date: %s, Copies sold: %s", title, releaseDate, copies);
    }

    public String getTitleAndPrice() {
        return String.format("%s - $%s", title, price);
    }

    public String getTitleEditionTypeAndPrice() {
        return String.format("%s %s %s", title, editionType, price);
    }

    public String getTitleAndAuthor() {
        return String.format("%s (%s %s)", title, author.getFirstName(), author.getLastName());
    }

}
