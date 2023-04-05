package ibf2022.paf.assessment.server.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.Utils;
import ibf2022.paf.assessment.server.models.User;
import ibf2022.paf.assessment.server.models.User2;

// TODO: Task 3

@Repository
public class UserRepository extends BasicCrud {

    // "select * where username=?"
    public Optional<User> findUserByUSername(String username){
        List<User2> user2 = findItemBy("*", "users", "username", username, User2.class);
        if(user2.isEmpty()){
            return Optional.empty();            
        }else{
            User user = Utils.user2ToUser(user2.get(0));
            return Optional.of(user);
        }
    }

    // insert into users(user_id,username,fullname) values(?,?,?)
    public String insertUser(User user){
        User2 user2 = Utils.userToUser2(user);

        //! generate random userid and set 
        String userId = UUID.randomUUID().toString().substring(0, 8);
        user2.setUserId(userId);

        //! insert into data base;
        int isInserted = insert("users", "user_id,username,fullname", "'"+user2.getUserId()+"','"+user2.getUsername()+"','"+user2.getFullname()+"'");
        
        if(isInserted>0){
            return user2.getUserId();
        }else{
            return null;
        }
    }
}
