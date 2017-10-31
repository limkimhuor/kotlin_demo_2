package kotlindemo2

import kotlindemo2.entities.User
import kotlindemo2.repositories.UserRepository
import kotlindemo2.service.UserDetailsServiceImpl
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class KotlinDemo2Application {
    @Bean
    fun init(userDetailsServiceImpl: UserDetailsServiceImpl) = CommandLineRunner {
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(KotlinDemo2Application::class.java, *args)
}
