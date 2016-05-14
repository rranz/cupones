package com.rest.users;

public interface UserRepository extends Repository<User> {
    User create(User user);

    User update(User user);

    void remove(int id);

    int getNumberOfUsers();
}
