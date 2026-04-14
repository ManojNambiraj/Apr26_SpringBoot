package HelloWorld.example.demo;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/todo")
public class DemoController {
    @GetMapping("/demo")
    String getData() {
        return "Hello World!";
    }

    @GetMapping("/{id}")
    String getDataById(@PathVariable int id){
        return "Hello World!, It's my ID: " + id;
    }

    @GetMapping
    String getDataByParam(@RequestParam("demoId") int id) {
        return "It's Params ID: " + id;
    }

    @PostMapping("/create")
    String createUser(@RequestBody String user){
        return user;
    }

    @PutMapping("/edit/{id}")
    String updateUser(@PathVariable int id){
        return "Updated User: " + id;
    }

    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable int id){
        return "Deleted User: " + id;
    }
}
