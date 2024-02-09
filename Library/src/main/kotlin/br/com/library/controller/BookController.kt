package br.com.library.controller

import br.com.library.model.Book
import br.com.library.model.User
import br.com.library.services.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.PagedModel
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/book/v1")
class BookController {

    @Autowired
    private lateinit var service: BookService;

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    private fun findALl(@RequestParam(value = "page", defaultValue = "0") page: Int,
                        @RequestParam(value = "size", defaultValue = "12") size: Int,
                        @RequestParam(value = "direction", defaultValue = "asc") direction: String
    ): ResponseEntity<PagedModel<EntityModel<Book>>> {
        val sortDirection: Sort.Direction =
            if("desc".equals(direction, ignoreCase = true)) Sort.Direction.DESC
            else Sort.Direction.ASC
        val pageable: Pageable = PageRequest.of(page, size, Sort.by(sortDirection,"author"))
        return ResponseEntity.ok(service.findAll(pageable))
    }

    @GetMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    private fun findById(@PathVariable(value = "id") id: Long): Book {
        return service.findById(id)
    }

    @GetMapping(value = ["/title/{title}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    private fun findByTitle(
        @PathVariable(value = "title") title: String,
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "12") size: Int,
        @RequestParam(value = "direction", defaultValue = "asc") direction: String
    ): ResponseEntity<PagedModel<EntityModel<Book>>> {
        val sortDirection: Sort.Direction =
            if("desc".equals(direction, ignoreCase = true)) Sort.Direction.DESC
            else Sort.Direction.ASC
        val pageable: Pageable = PageRequest.of(page, size, Sort.by(sortDirection,"title"))
        return ResponseEntity.ok(service.findByTitle(title, pageable))
    }
}