package br.com.library.repository
import br.com.library.model.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UserRepository : JpaRepository<User, Long?> {

    @Query("SELECT u FROM User u WHERE u.firstName LIKE LOWER(CONCAT ('%',:firstName,'%'))")
    fun findUserByName(@Param("firstName") firstName: String, pageable: Pageable): Page<User>

    @Query("SELECT u FROM User u WHERE u.id = :id")
    fun findUserById(@Param("id") id: Long): User?
}