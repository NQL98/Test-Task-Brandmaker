package com.testtask.controller;

import com.testtask.ejb.UserEJB;
import com.testtask.entity.UserEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import java.util.List;

@Path("users")
public class UserController {

    @EJB
    private UserEJB userEJB;

    @PUT
    @Path("/add")
    @Consumes("application/json")
    public void insert(UserEntity user) {
        userEJB.addUser(user);
    }

    @GET
    @Path("/all")
    @Produces("application/json")
    public List<UserEntity> getAll() {
        List<UserEntity> users = userEJB.getAllUsers();
        return users;
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes("application/json")
    public void delete(@PathParam("id") Long id) {
        userEJB.deleteUser(id);
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    public void update(UserEntity user) {
        userEJB.updateUser(user);
    }

}
