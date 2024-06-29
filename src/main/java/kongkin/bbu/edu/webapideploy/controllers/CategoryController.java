package kongkin.bbu.edu.webapideploy.controllers;

import kongkin.bbu.edu.webapideploy.exceptions.AppException;
import kongkin.bbu.edu.webapideploy.models.Category;
import kongkin.bbu.edu.webapideploy.models.response.MessageResponse;
import kongkin.bbu.edu.webapideploy.models.services.CategoryService;
import kongkin.bbu.edu.webapideploy.models.services.CategoryServiceLang;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class CategoryController extends BaseController{
    private final CategoryService categoryService;
    private final CategoryServiceLang categoryServiceLang;

    @GetMapping("/test")
    public String test(){
        return "ok";
    }

    @GetMapping("/categories/lang")
    public ResponseEntity<List<Category>> getCategories(@RequestHeader(name = "Accept-Language", defaultValue = "en") String lang) {
        List<Category> categories = categoryServiceLang.getCategories(lang);
        return ResponseEntity.ok(categories);
    }
    @GetMapping("/categories")
    public ResponseEntity<Object> getAll() {
        response = new MessageResponse();
        try {
            List<Category> list = categoryService.getAll();
            response = new MessageResponse();
            response.getDataSuccess(list);
        } catch (AppException e) {
            log.error("Error while get all ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
            response.setMessageKH(e.getMessageKH());

        } catch (Throwable e) {
            log.error("Internal Server Error", e);
            response.generalDataError(null);
        } finally {
            log.info("Final response get all category {}", response);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/categories/create")
    public ResponseEntity<Object> create(@RequestBody Category req) {
        response = new MessageResponse();
        try {
            log.info("Interception create category req {}", req);
            categoryService.create(req);

            response.createDataSuccess(null);

        } catch (AppException e) {
            log.error("Error while create category ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
            response.setMessageKH(e.getMessageKH());

        } catch (Throwable e) {
            log.error("Internal Server Error", e);
            response.generalDataError(null);
        } finally {
            log.info("Final response create category {}", response);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Integer id) {
        response = new MessageResponse();
        try {
            log.info("Interception get category by id {}", id);
            Category category = categoryService.getById(id);

            response.getDataSuccess(category);

        } catch (AppException e) {
            log.error("Error while get category by id ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
            response.setMessageKH(e.getMessageKH());

        } finally {
            log.info("Final response get category by id {}", response);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/categories/update")
    public ResponseEntity<Object> update(@RequestBody Category req) {
        response = new MessageResponse();
        try {
            log.info("Interception update unit type by id {}", req);
            categoryService.update(req);

            response.updateDataSuccess(null);

        } catch (AppException e) {
            log.error("Error while update unit type by id ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
            response.setMessageKH(e.getMessageKH());

        } catch (Throwable e) {
            log.error("Internal Server Error", e);
            response.generalDataError(null);
        } finally {
            log.info("Final response update unit type by id {}", response);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/categories/delete")
    public ResponseEntity<Object> delete(@RequestBody Category req) {
        response = new MessageResponse();
        try {
            log.info("Interception update unit type by id {}", req);
            categoryService.delete(req);

            response.deleteDataSuccess(null);

        } catch (AppException e) {
            log.error("Error while update unit type by id ", e);
            response.setCode(e.getCode());
            response.setMessage(e.getMessage());
            response.setMessageKH(e.getMessageKH());

        } catch (Throwable e) {
            log.error("Internal Server Error", e);
            response.generalDataError(null);
        } finally {
            log.info("Final response update unit type by id {}", response);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
