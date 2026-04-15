package HelloWorld.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    @Autowired
    private DemoRepository demoRepository;

    void printData(){
        System.out.println(demoRepository.getDatas());
    }
}
