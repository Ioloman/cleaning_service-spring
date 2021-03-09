package com.ical.cleaningservice.controllers;

import com.ical.cleaningservice.models.Service;
import com.ical.cleaningservice.models.ServiceType;
import com.ical.cleaningservice.models.UserService;
import com.ical.cleaningservice.repos.ServiceRepository;
import com.ical.cleaningservice.repos.ServiceTypeRepository;
import com.ical.cleaningservice.repos.UserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Autowired
    private UserServiceRepository userServiceRepository;

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Service> servicesList = serviceRepository.findAll();
        model.addAttribute("services", servicesList);
        return "index";
    }

    @GetMapping("/services")
    public String services(Model model) {
        Iterable<Service> servicesList = serviceRepository.findAll();
        ArrayList<Map> servicesData = new ArrayList<>();
        for (Service service : servicesList) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("service", service);
            map.put("user", userServiceRepository.findById(service.getUserServicePk()).get());
            map.put("type", serviceTypeRepository.findById(service.getServiceTypePk()).get());
            servicesData.add(map);
        }
        model.addAttribute("services", servicesData);
        model.addAttribute("types", serviceTypeRepository.findAll());
        return "list";
    }

    @GetMapping("/service/{id}")
    public String service(@PathVariable(value = "id") int id, Model model) {
        Service service = serviceRepository.findByServicePk(id);
        UserService userService = userServiceRepository.findById(service.getUserServicePk()).get();
        ServiceType type = serviceTypeRepository.findById(service.getServiceTypePk()).get();
        model.addAttribute("service", service);
        model.addAttribute("user", userService);
        model.addAttribute("type", type);
        return "service";
    }

    @GetMapping("/service/{id}/edit")
    public String serviceEditGet(@PathVariable(value = "id") int id, Model model) {
        Service service = serviceRepository.findByServicePk(id);
        UserService userService = userServiceRepository.findById(service.getUserServicePk()).get();
        ServiceType type = serviceTypeRepository.findById(service.getServiceTypePk()).get();
        model.addAttribute("service", service);
        model.addAttribute("user", userService);
        model.addAttribute("type", type);
        model.addAttribute("types", serviceTypeRepository.findAll());
        return "service_edit";
    }

    @PostMapping("/service/{id}/edit")
    public String serviceEditPost(@PathVariable(value = "id") int id, @RequestParam String title,
                                  @RequestParam String description, @RequestParam BigDecimal price,
                                  @RequestParam int type){
        Service service = serviceRepository.findByServicePk(id);
        serviceRepository.delete(service);
        service.setTitle(title);
        service.setDescription(description);
        service.setPrice(price);
        service.setServiceTypePk(type);
        serviceRepository.save(service);
        return "redirect:/service/" + id;
    }

    @PostMapping("/service/{id}/delete")
    public String serviceDelete(@PathVariable(value = "id") int id){
        Service service = serviceRepository.findByServicePk(id);
        serviceRepository.delete(service);
        return "redirect:/services";
    }

    @PostMapping("/service/create")
    public String servicePostAdd(@RequestParam String title, @RequestParam String description, @RequestParam BigDecimal price, @RequestParam int type, @RequestParam int user){
        Service service = new Service(title, description, price, user, type, Date.valueOf(LocalDate.now(ZoneId.of("GMT+07:00"))));
        serviceRepository.save(service);
        return "redirect:/services";
    }

    @GetMapping("/service/create")
    public String serviceCreateGet(Model model) {
        Iterable<UserService> userServiceList = userServiceRepository.findAll();
        UserService userService = new UserService();
        for (UserService user : userServiceList){
            userService = user;
            break;
        }
        model.addAttribute("user", userService);
        model.addAttribute("types", serviceTypeRepository.findAll());
        return "service_create";
    }

}