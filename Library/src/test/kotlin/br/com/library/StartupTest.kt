package br.com.library

import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.utility.DockerImageName

@TestConfiguration(proxyBeanMethods = false)
class TestLibraryApplication {

	@Bean
	@ServiceConnection
	fun mysqlContainer(): MySQLContainer<*> {
		return MySQLContainer(DockerImageName.parse("mysql:latest"))
	}

}

fun main(args: Array<String>) {
	fromApplication<LibraryApplication>().with(TestLibraryApplication::class).run(*args)
}
