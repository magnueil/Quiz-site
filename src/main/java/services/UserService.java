package services;

import resources.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Magnus on 20/09/2017.
 */
@Path("/users/")
public class UserService {
    private static Map<String, User> users = new HashMap<String, User>();
    private static int idCount = 0;

    @GET
    @Path("/{userId}/")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("userId") String userId) {
        if(users.containsKey(userId)) {
            return users.get(userId);
        } else {
            throw new NotFoundException();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, User> getUsers() {
        return users;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUser(User u) {
        users.put(u.getUserId(),u);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateuser(User u)  {
        if(users.containsKey(u.getUserId())) {
            users.put(u.getUserId(),u);
        } else {
            throw new NotFoundException();
        }
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(User u) {
        if(users.containsKey(u.getUserId())) {
            users.remove(u.getUserId());
        } else {
            throw new NotFoundException();
        }
    }
}
