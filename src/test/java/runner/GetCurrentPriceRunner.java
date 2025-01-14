package runner;

import com.intuit.karate.junit5.Karate;

public class GetCurrentPriceRunner {

    @Karate.Test
    Karate testGetCurrentPrice() {
        return Karate.run("classpath:features/GetCurrentPrice.feature");
    }
}
