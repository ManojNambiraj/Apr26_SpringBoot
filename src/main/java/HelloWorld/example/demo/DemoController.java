package HelloWorld.example.demo;

import HelloWorld.example.demo.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class DemoController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    ResponseEntity<List<UserModel>> getData() {
        try{
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<>((List<UserModel>) null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<UserModel> getDataById(@PathVariable Long id){
        try{
            UserModel userById = userService.getUserById(id);
            return new ResponseEntity<>(userById, HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    ResponseEntity<UserModel> createUser(@RequestBody UserModel User){
        return new ResponseEntity<>(userService.createUser(User), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    ResponseEntity<UserModel> updateUser(@PathVariable Long id,  @RequestBody UserModel User){
        try{
            UserModel updatedUser = userService.updateUser(id, User);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
