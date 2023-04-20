package fr.simplon.sondage.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

/**
 * Entité représentant un sondage.
 */
@Entity
@Table(name="sondage")
public class Sondage {

    /**
     * Identifiant unique du sondage.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * Description du sondage.
     */
    @NotBlank(message = "La description ne peut pas être vide.")
    @Size(min = 3, max = 120, message = "La description doit faire entre 3 et 120 caractères.")
    private String description;

    /**
     * Question posée dans le sondage.
     */
    @NotBlank(message = "La question ne peut pas être vide.")
    @Size(max = 120, message = "La question doit faire maximum 120 caractères.")
    private String question;

    /**
     * Date de création du sondage.
     */
    @NotNull(message = "La date de création ne peut pas être nulle.")
    @Column(updatable = false)
    private LocalDate date_creation = LocalDate.now();


    /**
     * Date de clôture du sondage.
     */
    @NotNull(message = "La date de clôture ne peut pas être nulle.")
    @FutureOrPresent(message = "La date de clôture doit être ultérieure à la date de création.")
    private LocalDate date_cloture;

    /**
     * Nom du créateur du sondage.
     */
    @NotBlank(message = "Le nom du créateur ne peut pas être vide.")
    @Size(max = 64, message = "Le nom du créateur doit faire maximum 64 caractères.")
    private String createur;

    /**
     * Constructeur vide pour la classe Sondage.
     */
    public Sondage(){

    }
    /**
     * Constructeur pour la classe Sondage.
     * @param description La description du sondage.
     * @param question La question posée dans le sondage.
     * @param date_creation La date de création du sondage.
     * @param date_cloture La date de clôture du sondage.
     * @param createur Le nom du créateur du sondage.
     */
    public Sondage(String description, String question, LocalDate date_creation, LocalDate date_cloture, String createur){
        this.description=description;
        this.question=question;
        this.date_creation=date_creation;
        this.date_cloture=date_cloture;
        this.createur=createur;
    }
    /**
     * Retourne l'identifiant unique du sondage.
     * @return l'identifiant unique du sondage.
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifie l'identifiant unique du sondage.
     * @param id Le nouvel identifiant unique du sondage.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retourne la description du sondage.
     * @return La description du sondage.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifie la description du sondage.
     * @param description La nouvelle description du sondage.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retourne la question posée dans le sondage.
     * @return La question posée dans le sondage.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Modifie la question posée dans le sondage.
     * @param question La nouvelle question posée dans le sondage
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Retourne la date de création du sondage.
     * @return La date de création du sondage.
     */
    public LocalDate getDate_creation() {
        return date_creation;
    }

    /**
     * Modifie la date de création du sondage.
     * @param date_creation La date de création du sondage
     */
    public void setDate_creation(LocalDate date_creation) {
        this.date_creation = date_creation;
    }

    /**
     * Retourne la date de cloture du sondage.
     * @return La date de cloture du sondage.
     */
    public LocalDate getDate_cloture() {
        return date_cloture;
    }

    /**
     * Modifie la date de cloture du sondage.
     * @param date_cloture La date de cloture du sondage
     */
    public void setDate_cloture(LocalDate date_cloture) {
        this.date_cloture = date_cloture;
    }

    /**
     * Retourne le créateur du sondage.
     * @return Le créateur du sondage.
     */
    public String getCreateur() {
        return createur;
    }

    /**
     * Modifie le créateur du sondage.
     * @param  createur Le createur du sondage.
     */
    public void setCreateur(String createur) {
        this.createur = createur;
    }
}

