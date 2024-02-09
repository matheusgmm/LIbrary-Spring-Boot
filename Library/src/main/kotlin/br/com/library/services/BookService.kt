package br.com.library.services

import br.com.library.model.Book
import br.com.library.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PagedResourcesAssembler
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.PagedModel
import org.springframework.stereotype.Service
import java.util.logging.Logger


@Service
class BookService {

    @Autowired
    private lateinit var repository: BookRepository

    @Autowired
    private lateinit var assembler: PagedResourcesAssembler<Book>

    private val logger = Logger.getLogger(BookService::class.java.name);

    fun findAll(pageable: Pageable): PagedModel<EntityModel<Book>>{
        logger.info("Finding all books!");
        val books = repository.findAll(pageable);
        return assembler.toModel(books);
    }

    fun findById(id: Long): Book {
        logger.info("Finding book with ID: $id")
        return repository.findBookById(id)
    }

    fun findByTitle(title: String, pageable: Pageable): PagedModel<EntityModel<Book>>? {
        logger.info("Finding books with title: $title")
        val books = repository.findBookByTitle(title, pageable);
        return  assembler.toModel(books);
    }
}