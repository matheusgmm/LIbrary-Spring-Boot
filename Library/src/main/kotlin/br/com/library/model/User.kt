package br.com.library.model
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import jakarta.persistence.*
import java.util.ArrayList
import java.util.Date

@Entity
@Table(name = "users")
@JsonPropertyOrder("id", "firstName", "lastName", "address", "email")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(name = "first_name",  nullable = false)
    var firstName: String = ""

    @Column(name = "last_name",  nullable = false)
    var lastName: String = ""

    @Column(nullable = false)
    var address: String = ""

    @Column(nullable = false)
    var email: String = ""
}