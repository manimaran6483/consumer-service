package com.consumer.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class ConsumerNotFoundExceptionTests {

	@Test//test_exception_custom
    void test_exception_custom() {
        Exception exception = assertThrows(
            ConsumerNotFoundException.class, 
            () -> findById((long)1));
            
        assertTrue(exception.getMessage().contains("Consumer not found"));
    }

    String findById(long id) throws ConsumerNotFoundException{
        throw new ConsumerNotFoundException("Consumer not found!");
    }
}