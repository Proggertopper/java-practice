package tacos.web.api;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;
import tacos.Ingredient;
import tacos.Taco;
import tacos.TacoOrder;
import tacos.data.OrderRepository;
import tacos.data.TacoRepository;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path = "/api" , produces = "application/json")
@CrossOrigin(origins = "http://tacocloud:8080")
public class TacoController {
    TacoRepository tacoRepository;
    OrderRepository orderRepository;
    RestTemplate restTemplate;

    public TacoController(TacoRepository tacoRepository  , OrderRepository orderRepository , RestTemplate restTemplate) {
        this.tacoRepository = tacoRepository;
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }




    @GetMapping
    public Page<Taco> recentTacos() {
        Pageable pageable = PageRequest.of(0, 12, Sort.by("createdAt").descending());
        return tacoRepository.findAll(pageable);
    }

    public Ingredient getIngredientByID(String ingredientId) {
         return restTemplate.getForObject("http://tacocloud:8080/ingredients/{id}", Ingredient.class ,  ingredientId);
    }

   /* public Ingredient getIngredientById(String ingredientId) {
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("id", ingredientId);
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/ingredients/{id}")
                .build(urlVariables);
        return restTemplate.getForObject(url, Ingredient.class);
    }

    public Ingredient getIngredientById2(String ingredientId) {
        ResponseEntity<Ingredient> responseEntity =
                restTemplate.getForEntity("http://localhost:8080/ingredients/{id}",
                        Ingredient.class, ingredientId);
        log.info("Fetched time: {}",
                responseEntity.getHeaders().getDate());
        return responseEntity.getBody();
    }

    public void updateIngredient(Ingredient ingredient) {
        restTemplate.put("http://localhost:8080/ingredients/{id}",
                ingredient, ingredient.getId());
    }

    public void deleteIngredient(Ingredient ingredient) {
        restTemplate.delete("http://localhost:8080/ingredients/{id}" +
                ingredient.getId());
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        return restTemplate.postForObject("http://localhost8080/ingredients" , ingredient , Ingredient.class);
    }

    public java.net.URI createIngredientURI(Ingredient ingredient) {
        return restTemplate.postForLocation("http://localhost:8080/ingredients" , ingredient);
    }

    public Ingredient createIngredient2(Ingredient ingredient) {
        ResponseEntity<Ingredient> entity = restTemplate.postForEntity("http://localhost:8080/ingredients" , ingredient , Ingredient.class);
        log.info("New entity created: {}", entity.getHeaders().getLocation());
        return entity.getBody();
    } */

    // по факту уже не сильно нужен єтот класс, у нас базовый путь и так data-api , чысто для recent можно оставить
}
