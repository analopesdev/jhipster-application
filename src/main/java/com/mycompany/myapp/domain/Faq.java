package com.mycompany.myapp.domain;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "faqs")
public class Faq {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    private String title;
    private String description;
    private Long sequence;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faq faq = (Faq) o;
        return (
            Objects.equals(id, faq.id) &&
            Objects.equals(title, faq.title) &&
            Objects.equals(description, faq.description) &&
            Objects.equals(sequence, faq.sequence)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, sequence);
    }

    @Override
    public String toString() {
        return "Faq{" + "id=" + id + ", title='" + title + '\'' + ", description='" + description + '\'' + ", sequence=" + sequence + '}';
    }
}
