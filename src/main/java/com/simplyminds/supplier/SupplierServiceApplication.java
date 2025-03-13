package com.simplyminds.supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main entry point for the Supplier Service application.
 * This class is responsible for bootstrapping the application using Spring Boot
 * and configuring the application context by specifying additional package scanning.
 *
 * <p>Features of this class:</p>
 * <ul>
 *     <li>Bootstrapping the application via {@code SpringApplication.run()}</li>
 *     <li>Custom component scanning of specific packages, enabling the inclusion
 *     of beans from shared or external modules.</li>
 *     <li>Leverages Spring Boot's autoconfiguration to simplify the setup and
 *     initialization of the service.</li>
 * </ul>
 *
 * <p><strong>Annotations:</strong></p>
 * <ul>
 *     <li>{@link SpringBootApplication}: Combines {@code @Configuration}, {@code @EnableAutoConfiguration},
 *     and {@code @ComponentScan} to set this class as the application's starting point.</li>
 *     <li>{@link ComponentScan}: Expands the scanning scope to include additional packages
 *     not directly under the main application package.</li>
 * </ul>
 *
 * <p><strong>Package Scanning:</strong></p>
 * <p>By using {@code @ComponentScan}, the application includes beans from the following packages:
 * <ul>
 *     <li>{@code com.simplyminds.product}: Provides product-related components, such as services, repositories, or controllers.</li>
 *     <li>{@code com.simplyminds.common}: Includes shared utilities, models, or configurations used across multiple services.</li>
 * </ul>
 * </p>
 *
 * <p><strong>How It Fits in Microservices:</strong></p>
 * <p>This class enables the Supplier Service to function independently as a microservice, which can:
 * <ul>
 *     <li>Perform supplier-specific operations.</li>
 *     <li>Integrate with shared components in {@code com.simplyminds.common}.</li>
 *     <li>Collaborate with the product-related logic in {@code com.simplyminds.product}.</li>
 * </ul>
 * </p>
 *
 * <p><strong>Key Responsibilities:</strong></p>
 * <p>As the main class, it handles:
 * <ul>
 *     <li>Starting the embedded web server (e.g., Tomcat) to serve the application.</li>
 *     <li>Initializing the Spring Application Context and creating managed beans.</li>
 *     <li>Configuring custom scanning for external modules.</li>
 * </ul>
 * </p>
 *
 * <p><strong>Best Practices:</strong></p>
 * <ul>
 *     <li>Limit {@code @ComponentScan} to include only the necessary packages to avoid bloat in the application context.</li>
 *     <li>Ensure shared modules are correctly included in the project dependencies (e.g., via Maven or Gradle).</li>
 *     <li>Use {@code @SpringBootApplication} only in the primary entry-point class.</li>
 * </ul>
 *
 * @see SpringApplication
 * @see SpringBootApplication
 * @see ComponentScan
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.simplyminds.supplier", "com.simplyminds.common"})
public class SupplierServiceApplication {

	/**
	 * The main method serves as the entry point of the Supplier Service application.
	 * It initializes the Spring Boot framework, loads the application context, and
	 * starts the embedded web server.
	 *
	 * @param args Command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(SupplierServiceApplication.class, args);
	}

}