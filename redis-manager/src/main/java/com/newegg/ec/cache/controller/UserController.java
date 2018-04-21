package com.newegg.ec.cache.controller;

import com.newegg.ec.cache.logic.UserLogic;
import com.newegg.ec.cache.model.Response;
import com.newegg.ec.cache.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by gl49 on 2018/4/20.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserLogic logic;

    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    @ResponseBody
    public Response list(){
        List<User> userList = logic.getUserList();
        return Response.Obj(0, userList);
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @ResponseBody
    public Response getUser(@RequestParam int id){
        User user = logic.getUser( id );
        return Response.Obj(0, user);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public Response addUser(@RequestBody User user){
        boolean res = logic.addUser( user );
        return Response.Obj(0, res);
    }

    @RequestMapping(value = "/removeUser", method = RequestMethod.GET)
    @ResponseBody
    public Response removeUser(@RequestParam int id){
        boolean res = logic.removeUser( id );
        return Response.Obj(0, res);
    }
}
