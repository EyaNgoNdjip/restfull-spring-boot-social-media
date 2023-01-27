package world.enn.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.net.URI;


@RestController
public class UserResource {

    //To autowired UserDaoService into UserResource
    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return service.findAll();
    }


    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable int id) {
        User user = service.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id:" + id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);
    }
}
