package com.appsdeveloperblog.estore.usersservice.query;

import com.appsdeveloperblog.estore.core.model.PaymentDetails;
import com.appsdeveloperblog.estore.core.model.User;
import com.appsdeveloperblog.estore.core.query.FetchUserPaymentDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserEventsHandler {

    @QueryHandler
    public User findUserPaymentDetails(FetchUserPaymentDetailsQuery query) {
        PaymentDetails paymentDetails = PaymentDetails.builder()
                .cardNumber("123Card")
                .cvv("123")
                .name("NİYAZİ ÇAPAR")
                .validUntilMonth(12)
                .validUntilYear(2030)
                .build();

        return User.builder().firstName("Niyazi").lastName("Çapar").userId(query.getUserId())
                .paymentDetails(paymentDetails).build();
    }
}
