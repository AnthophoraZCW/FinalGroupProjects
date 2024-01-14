package com.mycompany.myapp.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class VideoTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static Video getVideoSample1() {
        return new Video()
            .id(1L)
            .title("title1")
            .description("description1")
            .releaseYear(1)
            .classification("classification1")
            .duration(1)
            .episode(1)
            .season(1)
            .videoURL("videoURL1")
            .imageURL("imageURL1");
    }

    public static Video getVideoSample2() {
        return new Video()
            .id(2L)
            .title("title2")
            .description("description2")
            .releaseYear(2)
            .classification("classification2")
            .duration(2)
            .episode(2)
            .season(2)
            .videoURL("videoURL2")
            .imageURL("imageURL2");
    }

    public static Video getVideoRandomSampleGenerator() {
        return new Video()
            .id(longCount.incrementAndGet())
            .title(UUID.randomUUID().toString())
            .description(UUID.randomUUID().toString())
            .releaseYear(intCount.incrementAndGet())
            .classification(UUID.randomUUID().toString())
            .duration(intCount.incrementAndGet())
            .episode(intCount.incrementAndGet())
            .season(intCount.incrementAndGet())
            .videoURL(UUID.randomUUID().toString())
            .imageURL(UUID.randomUUID().toString());
    }
}
