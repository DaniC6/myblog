package it.cgmconsulting.myblog.controller;

import it.cgmconsulting.myblog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/") // la chiamata sarà localhost:8081/?antipasti   METODO POST
    public ResponseEntity<?> save(@RequestParam String categoryName){
        return categoryService.save(categoryName);
    }

    @PostMapping("/{categoryName}") // la chiamata sarà localhost:8081/?antipasti   METODO POST con @PathVariable
    public ResponseEntity<?> save2(@PathVariable String categoryName){
        return categoryService.save(categoryName);
    }

    @PostMapping("/newcat") // la chiamata sarà localhost:8081/?antipasti   METODO POST con @PathVariable
    public ResponseEntity<?> save3(@RequestBody String categoryName){
        return categoryService.save(categoryName);
    }


    @GetMapping // localhost: 8081/categor
    public ResponseEntity<?> getAllVisibleCategories(){
        return categoryService.getAllVisibleCategories ();
    }

    @GetMapping("/all") // localhost: 8081/categor
    public ResponseEntity<?> findAll(){
        return categoryService.findAll();
    }

    @PutMapping("/modif/{id}")
    public ResponseEntity<?> update(@PathVariable byte id,@RequestBody String newCategory){
        return categoryService.update(id,newCategory);
    }
}
