package com.xfactor.lably.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.xfactor.lably.entity.Lab;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lab")

public class LabController {

    ArrayList<Lab> labs = new ArrayList<>();

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping("/getlabs")
    public ArrayList<Lab> getlab() {
        return labs;
    }

    @PostMapping("/addlab")
    public Lab addlab(@RequestBody Lab lab) {
        String name = lab.getName();
        lab.setName(name);

        String phone = lab.getPhone();
        lab.setPhone(phone);

        String address = lab.getAddress();
        lab.setAddress(address);

        String pincode = lab.getPincode();
        lab.setPincode(pincode);

        labs.add(lab);
        return lab;
    }

    @GetMapping("/showlabs")
    public Lab showlab(@RequestParam Lab name) {
        for(Lab l:labs){
            if(name.equals(l.getName())==true){
                return l;
            }
            return null;
        }
        
        return name;
    }
}