package managamentHR.employee.controller;

import managamentHR.employee.entity.User;
import managamentHR.employee.exception.UserNotFoundException;
import managamentHR.employee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setDepartment(newUser.getDepartment());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    user.setPost(newUser.getPost());
                    user.setPhone(newUser.getPhone());
                    user.setLeaveDays(newUser.getLeaveDays());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }
    @PostMapping("/requestLeave/{id}")
    User requestLeave(@PathVariable Long id, @RequestParam int leaveDays) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        int availableLeaveDays = user.getLeaveDays();
        if (leaveDays > availableLeaveDays) {
            throw new IllegalArgumentException("Insufficient leave days available");
        }

        user.setLeaveDays(availableLeaveDays - leaveDays);
        return userRepository.save(user);
    }
    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return  "Employee with id "+id+" has been deleted success.";
    }
}

