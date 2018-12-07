package com.adam.micrometer;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/metrics")
public class MetricsController {

    private final Counter counter;

    private final Timer timer;

    @Autowired
    public MetricsController(Counter counter, Timer timer) {
        this.counter = counter;
        this.timer = timer;
    }

    @GetMapping("/count")
    public ResponseEntity count() {
        counter.increment();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/timer")
    @Timed
    public ResponseEntity timer() throws Exception {
        return timer.recordCallable(this::waitForResponse);
    }

    private ResponseEntity waitForResponse() throws InterruptedException {
        Thread.sleep(getRandomNumber(1, 5));
        return ResponseEntity.ok().build();
    }

    private int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.ints(min, (max + 1)).findFirst().getAsInt() * 1000;
    }
}
