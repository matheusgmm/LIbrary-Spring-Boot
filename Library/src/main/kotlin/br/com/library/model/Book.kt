package br.com.library.model
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "books")
@JsonPropertyOrder("id", "title", "price", "launchDate", "author", "user")
class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

   @ManyToOne
   @JoinColumn(name = "author_id", nullable = false)
    var author: Author? = null

    @Column(nullable = false)
    var title: String = ""

    @Column(nullable = false)
    var price: Double = 0.0

    @Column(name = "launch_date", nullable = false)
    var launchDate: Date? = null

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User? = null
}



