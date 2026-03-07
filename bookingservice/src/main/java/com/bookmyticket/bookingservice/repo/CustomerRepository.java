package com.bookmyticket.bookingservice.repo;

import com.bookmyticket.bookingservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
