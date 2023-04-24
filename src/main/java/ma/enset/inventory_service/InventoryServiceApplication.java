package ma.enset.inventory_service;

import ma.enset.inventory_service.entities.Product;
import ma.enset.inventory_service.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository){
        return args -> {
            productRepository.save(new Product(null, "PC", 234, 4));
            productRepository.save(new Product(null, "Monitor", 342, 4));
            productRepository.save(new Product(null, "Chair", 753, 4));
            productRepository.save(new Product(null, "HeadPhone", 233, 4));
            productRepository.findAll().forEach(product -> System.out.println(product.toString()));
        };
    }
}
