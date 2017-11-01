import io.reactivex.Observable;

import static junit.framework.Assert.assertTrue;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class RXJava1 {

    String result = "";

    // Simple subscription to a fix value
    @Test
    public void returnAValue() {
        result = "";
        Observable<String> observer = Observable.just("Hello"); // provides datea
        observer.subscribe(s -> result = s); // Callable as subscriber
        assertTrue(result.equals("Hello"));
    }

    @Test
    public void mapTest() {
        Observable.range(0, 5)
                .doOnNext(System.out::println)
                .map((Integer i) -> i + 10)
                .subscribe(System.out::println);

    }

    @Test
    public void delayTest() throws InterruptedException {
        Observable.just(1, 2, 3)
                .delay(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(5);
    }



}
