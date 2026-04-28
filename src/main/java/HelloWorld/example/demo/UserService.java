package HelloWorld.example.demo;

import HelloWorld.example.demo.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserModel createUser(UserModel User){
        return userRepository.save(User);
    }

    public UserModel getUserById(Long id){
        return  userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<UserModel> getAllUsers(){
        return userRepository.findAll();
    }

    public UserModel updateUser(Long id, UserModel User){
        UserModel existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setName(User.getName());
        existingUser.setAge(User.getAge());
        existingUser.setEmail(User.getEmail());
        existingUser.setMobile(User.getMobile());
        existingUser.setPassword(User.getPassword());

        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
