package com.renatodias.desafio;

import com.renatodias.desafio.Model.Users;

import org.junit.Assert;
import org.junit.Test;

public class UsersTest {

    @Test
    public void users() {

        Users  users = new Users("teste", "2", "1234", "dasdas","dsada", "asdada", 1);
        Users  users2 = new Users("", "2", "1234", "dasdas","dsada", "asdada", 2);

        Assert.assertFalse(users.getId() > users2.getId());

        Assert.assertFalse(users2.getLogin().length() > 0);

        Assert.assertTrue(users.getLogin().contains("teste"));

    }
}
