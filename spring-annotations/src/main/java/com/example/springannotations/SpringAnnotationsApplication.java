package com.example.springannotations;

import com.example.springannotations.configurationproperties.AppProperties;
import com.example.springannotations.configurationproperties.AppPropertiesDemo;
import com.example.springannotations.controller.MyController;
import com.example.springannotations.controller.PizzaController;
import com.example.springannotations.lazy.LazyLoader;
import com.example.springannotations.repository.MyRepository;
import com.example.springannotations.service.MyService;
import com.example.springannotations.service.VegPizza;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAnnotationsApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(SpringAnnotationsApplication.class, args);

		AppPropertiesDemo appPropertiesDemo = context.getBean(AppPropertiesDemo.class);
		appPropertiesDemo.display();

//		LazyLoader lazyLoader = context.getBean(LazyLoader.class);

//		MyController myController = context.getBean(MyController.class);
//		System.out.println(myController.hello());

//		MyService myService = context.getBean(MyService.class);
//		System.out.println(myService.hello());

//		MyRepository myRepository = context.getBean(MyRepository.class);
//		System.out.println(myRepository.hello());

		// get bean from class
//		PizzaController pizzaController = context.getBean(PizzaController.class);
//		System.out.println(pizzaController.getPizza());

		// get bean from bean name
//		PizzaController pizzaController = (PizzaController) context.getBean("pizzaDemo");
//		System.out.println(pizzaController.getPizza());

//		VegPizza vegPizza = context.getBean(VegPizza.class);
//		System.out.println(vegPizza.getPizza());

//		VegPizza vegPizza = (VegPizza) context.getBean("vegPizzaBean");
//		System.out.println(vegPizza.getPizza());

//		VegPizza vegPizza = (VegPizza) context.getBean("vegPizza");
//		System.out.println(vegPizza.getPizza());


	}

}
