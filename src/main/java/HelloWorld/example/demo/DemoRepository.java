package HelloWorld.example.demo;

import org.springframework.stereotype.Component;

@Component
public class DemoRepository {
    String getDatas(){
        return "AllUsersData";
    }
}
