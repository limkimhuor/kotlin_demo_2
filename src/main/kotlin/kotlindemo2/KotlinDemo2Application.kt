package kotlindemo2

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinDemo2Application

fun main(args: Array<String>) {
    SpringApplication.run(KotlinDemo2Application::class.java, *args)
}
