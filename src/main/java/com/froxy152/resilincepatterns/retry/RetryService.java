package com.froxy152.resilincepatterns.retry;

import com.froxy152.resilincepatterns.retry.exception.RandomRetryException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetrySynchronizationManager;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class RetryService {

    Random rnd = new Random();

    @Retryable(recover = ,retryFor = RandomRetryException.class, maxAttempts = 10, backoff = @Backoff(delay = 100, maxDelay = 500))
    public void someAction() {
        log.info("Retry Number: "+ RetrySynchronizationManager.getContext().getRetryCount());

        log.info("Start method someAction()");
        if(1 == 1) {
            throw new RandomRetryException("retry");
        }

        System.out.println("povezlo povezlo");

    }

    @Recover
    public void recoverMethod() {
        System.out.println("i try to recover use some recover logic");
    }
}
