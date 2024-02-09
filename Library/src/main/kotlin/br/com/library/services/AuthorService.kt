package br.com.library.services

import br.com.library.data.vo.BookVO
import br.com.library.model.Book
import br.com.library.model.Author
import br.com.library.repository.BookRepository
import br.com.library.repository.AuthorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PagedResourcesAssembler
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.PagedModel
import org.springframework.stereotype.Service
import java.util.logging.Logger


@Service
class AuthorService {

    @Autowired
    private lateinit var repository: AuthorRepository

    @Autowired
    private lateinit var assembler: PagedResourcesAssembler<Author>

    private val logger = Logger.getLogger(AuthorService::class.java.name);

    fun findAll(pageable: Pageable): PagedModel<EntityModel<Author>>{
        logger.info("Finding all authors!");
        val users = repository.findAll(pageable);
        return assembler.toModel(users);
    }

    fun findById(id: Long): Author? {
        logger.info("Finding author with ID: $id")
        return repository.findAuthorById(id)
    }

    fun findByName(name: String, pageable: Pageable): PagedModel<EntityModel<Author>> {
        logger.info("Finding authors with name: $name")
        val users = repository.findAuthorByName(name, pageable);
        return  assembler.toModel(users);
    }
}