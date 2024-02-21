package com.event.event.controller;

import org.springframework.web.bind.annotation.RestController;

import com.event.event.model.Register;
import com.event.event.services.RegisterServ;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class RegisterController {
    private RegisterServ registerServ;

    public RegisterController(RegisterServ registerServ) {
        this.registerServ = registerServ;
    }
    
    @PostMapping("/register")
    public ResponseEntity<Register>postProduct(@RequestBody Register register)
    {
        if(registerServ.saveRegister(register)==true)
        {
            return new ResponseEntity<>(register,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(register,HttpStatus.INTERNAL_SERVER_ERROR);
        
    }


    @GetMapping("/register/{username}")
    public ResponseEntity<Register> getProduct(@PathVariable("username") String username)
    {
        Register p=registerServ.getRegister(username);
        if(p==null)
        {
            return new ResponseEntity<>(p,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
       
        
    }

    @GetMapping("/registers")
    public ResponseEntity<List<Register>> getProducts()
    {
        List<Register>b=registerServ.getAllRegister();
        if(b.size()==0)
        {
            return new ResponseEntity<>(b,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(b,HttpStatus.OK);
    }
        

        @PutMapping("register/{username}")
        public ResponseEntity<Register> putMethodName(@PathVariable("username") String username, @RequestBody  Register register)
        {
            if(registerServ.updateRegister(username,register)==true)
            {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        @DeleteMapping("register/{username}")
        public ResponseEntity<Register>delete(@PathVariable String username)
        {
            if(registerServ.deleteRegister(username)==true)
            {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    

