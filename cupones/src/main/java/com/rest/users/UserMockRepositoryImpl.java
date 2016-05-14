package com.rest.users;

import java.util.ArrayList;
import java.util.List;

public class UserMockRepositoryImpl extends GenericMockRepository<User> implements UserRepository {

    private List<User> users = new ArrayList<User>();

    private int index = 0;
    
    public UserMockRepositoryImpl() {
        this.users = this.createUsers();
    }

    public User getById(int id) {
        for (User u : this.users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return new NullUser();
    }

    public List<User> getAll() {
        return this.users;
    }

    @Override
    public User create(User user) {
        user.setId(++index);
        this.users.add(user);
        return user;
    }

    @Override
    public User update(User user) {
        User byId = this.getById(user.getId());
        byId.setFirstName(user.getFirstName());
        byId.setLastName(user.getLastName());
        return byId;
    }

    @Override
    public void remove(int id) {
        User byId = this.getById(id);
        this.users.remove(byId);
    }

    @Override
    public int getNumberOfUsers() {
        return this.users.size();
    }

    private List<User> createUsers() {
        int numberOfUsers = 10;
        for (int i = 0; i < numberOfUsers; i++) {
            User user = new User();
            user.setId(i + 1);
            user.setFirstName("Foo" + (i + 1));
            user.setLastName("Bar" + (i + 1));
            this.users.add(user);
        }
        return this.users;
    }

}
