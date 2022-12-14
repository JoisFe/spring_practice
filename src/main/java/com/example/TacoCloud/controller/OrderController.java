package com.example.TacoCloud.controller;

import com.example.TacoCloud.config.web.OrderProps;
import com.example.TacoCloud.domain.Order;
import com.example.TacoCloud.domain.Users;
import com.example.TacoCloud.repository.OrderRepository;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @author : 조재철
 * @since 1.0
 */
@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderProps props;

    private OrderRepository orderRepo;

    @Autowired
    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm(@AuthenticationPrincipal Users users,
        @ModelAttribute Order order) {
        if (order.getDeliveryName() == null) {
            order.setDeliveryName(users.getFullname());
        }
        if (order.getDeliveryStreet() == null) {
            order.setDeliveryStreet(users.getStreet());
        }
        if (order.getDeliveryCity() == null) {
            order.setDeliveryCity(users.getCity());
        }
        if (order.getDeliveryState() == null) {
            order.setDeliveryState(users.getState());
        }
        if (order.getDeliveryZip() == null) {
            order.setDeliveryZip(users.getZip());
        }

        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus, @AuthenticationPrincipal
        Users users) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        order.setUsers(users);

        orderRepo.save(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }

    @GetMapping
    public String ordersForUser(@AuthenticationPrincipal Users users, Model model) {
        Pageable pageable = PageRequest.of(0, props.getPageSize());

        model.addAttribute("orders", orderRepo.findByUsersOrderByPlacedAtDesc(users, pageable));

        return "orderList";
    }
}
