package by.tms.petstore;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@OpenAPIDefinition(info= @Info(
        title = "Swagger PetStore",
        version = "1.0",
        description = "This is a sample server Petstore server.",
        license = @License(name = "Apache 2.0", url = ""),
        contact = @Contact(name = "Herman Dmukhovskiy", url="", email="dmukhovskiy_g@mail.ru")

))
public class PetStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetStoreApplication.class, args);
    }

}
