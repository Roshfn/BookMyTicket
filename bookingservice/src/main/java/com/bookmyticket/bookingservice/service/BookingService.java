package com.bookmyticket.bookingservice.service;

import com.bookmyticket.bookingservice.client.InventoryServiceClient;
import com.bookmyticket.bookingservice.entity.Customer;
import com.bookmyticket.bookingservice.repo.CustomerRepository;
import com.bookmyticket.bookingservice.request.BookingRequest;
import com.bookmyticket.bookingservice.response.BookingResponse;
import com.bookmyticket.bookingservice.response.InventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final CustomerRepository customerRepository;
    private final InventoryServiceClient inventoryServiceClient;

    @Autowired
    private  BookingService (final CustomerRepository customerRepository,
                             final InventoryServiceClient inventroyServiceClient){
        this.customerRepository= customerRepository;
        this.inventoryServiceClient= inventroyServiceClient;
    }
    public BookingResponse createBooking(BookingRequest request) {
        //if customer exists
        final Customer customer = customerRepository.findById(request.getUserId()).orElse(null);

        //if customer does not exist
        if (customer==null){
            throw new RuntimeException(" customer not found");
        }
        //check if there is enough inventory
        final InventoryResponse inventoryResponse= inventoryServiceClient.getInventory(request.getEventId());
        System.out.println("Inventory Service Response "+ inventoryResponse);
        //get event information to also venue information
        // create booking
        //send booking to order service
        return BookingResponse.builder().build();
    }
}
