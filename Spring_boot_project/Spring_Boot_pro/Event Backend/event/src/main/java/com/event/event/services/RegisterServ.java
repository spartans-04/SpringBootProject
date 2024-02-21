package com.event.event.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.event.event.model.Register;
import com.event.event.repository.RegisterRepo;

@Service
public class RegisterServ {
   private RegisterRepo registerRepo;

public RegisterServ(RegisterRepo registerRepo) {
    this.registerRepo = registerRepo;
}  
  public boolean saveRegister(Register register)
  {
      try {
              registerRepo.save(register);
          
          } 
          catch (Exception e) {
            return false;
          }
          return true;
      
  }
  public Register getRegister(String username)
  {
      return registerRepo.findById(username).orElse(null);
  }


  public List<Register>getAllRegister()
  {
      return registerRepo.findAll();
  }

  public boolean updateRegister(String username,Register register)
  {
      if(this.getRegister(username)==null)
      {
          return false;
      }
      try {
                  registerRepo.save(register);
          } 
          catch (Exception e) {
            return false;
          }
          return true;
      
  }

  public boolean deleteRegister(String username)
  {
      if(this.getRegister(username)==null)
      {
          return false;
      }
      try {
                  registerRepo.deleteById(username);
          } 
          catch (Exception e) {
            return false;
          }
          return true;
  }
}






