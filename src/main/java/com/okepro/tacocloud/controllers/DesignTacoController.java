package com.okepro.tacocloud.controllers;

import com.okepro.tacocloud.models.Ingredient;
import com.okepro.tacocloud.models.Ingredient.Type;
import com.okepro.tacocloud.models.Taco;
import com.okepro.tacocloud.models.TacoOrder;
import com.okepro.tacocloud.repositories.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepository.findAll();
        Type[] types = Ingredient.Type.values();

        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    @GetMapping
    public String showDesignForm(Taco design) {
        return "design";
    }

    @PostMapping
    public String processTaco(@Valid Taco taco, Errors errors,
                              @ModelAttribute TacoOrder tacoOrder) {
        if (errors.hasErrors()) {
            return "design";
        }

        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);
        return "redirect:/orders/current";
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "tacos")
    public Taco taco() {
        return new Taco();
    }

    private static Iterable<Ingredient> filterByType(Iterable<Ingredient> ingredients, Type type) {
        List<Ingredient> filteredIngredients = new ArrayList<>();

        Iterator<Ingredient> iterator = ingredients.iterator();
        if (iterator.hasNext()) {
            Ingredient ingredient = iterator.next();
            if (type.equals(ingredient.getType())) {
                filteredIngredients.add(ingredient);
            }
        }
        return filteredIngredients;

    }
}
