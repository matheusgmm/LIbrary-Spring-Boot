package br.com.library.model
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "authors")
@JsonPropertyOrder("id", "name")
class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(nullable = false)
    var name: String = ""

}