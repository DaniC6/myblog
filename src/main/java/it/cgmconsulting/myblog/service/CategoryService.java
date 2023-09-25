package it.cgmconsulting.myblog.service;

import it.cgmconsulting.myblog.entities.Category;
import it.cgmconsulting.myblog.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j // ci crea automaticamente un oggetto di tipo log
public class CategoryService {

    //miglior soluzione rispetto all'@Autowired perchè l annotazione è riconosciuta solamente da SpringBoot
    private final CategoryRepository categoryRepository;



    public ResponseEntity<?> save(String categoryName){
        log.info ( "Category persistence start" );
        if(categoryRepository.existsByCategoryName(categoryName)){
            log.info ( "Category already present" );
            return new ResponseEntity<> ( "Category already present", HttpStatus.BAD_REQUEST );
        }else{
            Category cat = new Category (categoryName);
            categoryRepository.save(cat);
            log.info ( "Category persisted: " + cat.toString () );
            return  new ResponseEntity<> ( cat,HttpStatus.CREATED );
        }
    }

    public ResponseEntity<?> getAllVisibleCategories() {
        log.info("Get all visible categories");
        return new ResponseEntity<>(categoryRepository.getAllVisibleCategories (),HttpStatus.OK);
    }

    public ResponseEntity<?> findAll() {
        log.info ("Get all categories");
        return new ResponseEntity<> (categoryRepository.findAll(),HttpStatus.OK);
    }

    //put categoryName e visible separatamente

    public ResponseEntity<?> update(byte id,String newCategory){
        if(categoryRepository.existsByCategoryName ( newCategory )){
            log.info ( "Category already present" );
            return new ResponseEntity<> ( "Category " + newCategory +  " already present", HttpStatus.BAD_REQUEST );
        }

        Optional<Category> cat = categoryRepository.findById ( id );
        if(!cat.isPresent()){
            log.info("No category found");
            return new ResponseEntity<> ( "No category found with id: " + id, HttpStatus.NOT_FOUND );
        }else{
            cat.get().setCategoryName ( newCategory );
            categoryRepository.save ( cat.get () );
        }

        return new ResponseEntity<> ( "Category has been updated",HttpStatus.OK );

    }


}
