package br.com.library.services

import br.com.library.data.vo.BookVO
import br.com.library.model.Book
import br.com.library.model.User
import br.com.library.repository.BookRepository
import br.com.library.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PagedResourcesAssembler
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.PagedModel
import org.springframework.stereotype.Service
import java.util.logging.Logger


@Service
class UserService {

    @Autowired
    private lateinit var repository: UserRepository

    @Autowired
    private lateinit var assembler: PagedResourcesAssembler<User>

    private val logger = Logger.getLogger(UserService::class.java.name);

    fun findAll(pageable: Pageable): PagedModel<EntityModel<User>>{
        logger.info("Finding all users!");
        val users = repository.findAll(pageable);
        return assembler.toModel(users);
    }

    fun findById(id: Long): User? {
        logger.info("Finding user with ID: $id")
        return repository.findUserById(id)
    }

    fun findByName(name: String, pageable: Pageable): PagedModel<EntityModel<User>> {
        logger.info("Finding users with name: $name")
        val users = repository.findUserByName(name, pageable);
        return  assembler.toModel(users);
    }
}