package world.enn.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static int usersCount = 0;

    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(++usersCount, "Eya", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Skyla", LocalDate.now().minusYears(3)));
        users.add(new User(++usersCount, "Mamie", LocalDate.now().minusYears(15)));
    }

    // Retrieve all users
    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return  users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public void deleteById(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }


}
