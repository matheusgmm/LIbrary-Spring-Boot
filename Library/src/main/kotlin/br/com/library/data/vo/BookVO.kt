package br.com.library.data.vo
import br.com.library.model.Author
import br.com.library.model.User
import jakarta.persistence.*
import java.util.Date


class BookVO (

    var id: Long = 0,
    var author: Author? = null,
    var title: String = "",
    var price: Double = 0.0,
    var launchDate: Date? = null,
    var user: User? = null
)



