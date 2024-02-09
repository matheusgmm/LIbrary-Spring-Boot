package br.com.library.repository
import br.com.library.model.Book
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface BookRepository : JpaRepository<Book, Long?> {


    @Query("SELECT b FROM Book b JOIN FETCH b.author JOIN FETCH b.user WHERE b.title LIKE LOWER(CONCAT ('%',:title,'%'))")
    fun findBookByTitle(@Param("title") title: String, pageable: Pageable): Page<Book>
    
    @Query("SELECT b FROM Book b JOIN FETCH b.author JOIN FETCH b.user WHERE b.id =:id")
    fun findBookById(@Param("id") id: Long): Book
}
