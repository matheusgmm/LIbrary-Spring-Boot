package br.com.library.repository
import br.com.library.model.Author
import br.com.library.model.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface AuthorRepository : JpaRepository<Author, Long?> {
    
    @Query("SELECT a FROM Author a WHERE a.name LIKE LOWER(CONCAT ('%',:name,'%'))")
    fun findAuthorByName(@Param("name") name: String, pageable: Pageable): Page<Author>


    @Query("SELECT a FROM Author a WHERE a.id =:id")
    fun findAuthorById(@Param("id") id: Long): Author?

}