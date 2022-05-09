package com.example.demo;

import java.time.Duration;
import java.util.List;

import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Log;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class DemoFlux {
    
    public static void main(String[] args) {
       System.out.println(
            Service.disBonjour()
            .zipWith(Service.disAurevoir())
            .block()
       );
       Service.getSpeech().subscribe(System.out::println);

       Service.getYellByletterspeech().subscribe(System.out::println);


       Service.blocks();
       //System.out.println(Service.getYellDelaySpeech().blockFirst());
       Service.sizeWordSpeech();

       Service.zipExample();

       Service.filteringNumber();
        
    }
}

class Service {
    static Mono<String> disBonjour() {
        return Mono.just("hello ");
    }

    static Mono<String> disAurevoir() {
        return Mono.just("au revoir");
    }
    

    

   /* static void firstEmitting() {
        Mono<String> a = Mono.just("oops I'm late")
                             .delaySubscription(450);
        Flux<String> b = ((Object) Flux.just("let's get", "the party", "started"))
                             .delayMillis(400);
      
        return Flux.firstEmitting(a, b)
            .toIterable()
            .forEach(System.out::println);
      }*/

      public static String[] speech = {
        "Well,","you","were","born;","here","you","came,","something","like","fifteen","years","ago,","and","though",
        "your","father","and","mother","and","grandmother,","looking","about","the","streets","through","which","they",
        "were","carrying","you,","staring","at","the","walls","into","which","they","brought","you,","had","every",
        "reason","to","be","heavy-hearted,","yet","they","were","not,","for","here","you","were,","big","James,",
        "named","for","me.","You","were","a","big","baby.","I","was","not.","Here","you","were","to","be","loved.",
        "To","be","loved,","baby,","hard","at","once","and","forever","to","strengthen","you","against","the",
        "loveless","world.","Remember","that.","I","know","how","black","it","looks","today","for","you.","It","looked",
        "black","that","day","too.","Yes,","we","were","trembling.","We","have","not","stopped","trembling","yet,",
        "but","if","we","had","not","loved","each","other,","none","of","us","would","have","survived,","and","now",
        "you","must","survive","because","we","love","you","and","for","the","sake","of","your","children","and",
        "your","children's","children.",
};
        static Flux<String> getSpeech() {
            return Flux
                    .fromArray(speech);
        } 

        static Flux<String> getYellByletterspeech(){
            return  Flux
            .fromArray(speech)
            .flatMap(word -> Flux.fromArray(word.split("")))
          .distinct()
           .sort()
           .zipWith(Flux.range(1, Integer.MAX_VALUE),
              (string, count) -> String.format("%2d. %s", count, string));
        }


        static Flux<String> getSpeechByWord(){
            return  Flux
            .fromArray(speech)
            //.delayElements(Duration.ofMillis(500))
            .map(String::toUpperCase)
            .doAfterTerminate(() -> System.out.println("Done"));
        }


        static Flux<String> getYellmissingByletterspeech(){
        Mono<String> missing = Mono.just("s");

            return  Flux
            .fromArray(speech)
            .flatMap(word -> Flux.fromArray(word.split("")))
            .concatWith(missing)
          .distinct()
           .sort()
           .zipWith(Flux.range(1, Integer.MAX_VALUE),
              (string, count) -> String.format("%2d. %s", count, string));
        }

        static void blocks() {
            Flux<String> helloPauseWorld = 
              Mono.just("Hello")
                  .concatWith(Mono.just("world")
                                  .delaySubscription(Duration.ofMillis( 500)));
          
            helloPauseWorld.toStream()
                           .forEach(System.out::println);
          }



          static void firstWordSpeech() {
            Flux<String> test=
            Flux
            .fromArray(speech)
            .map(x-> String.valueOf(x.charAt(0)));

            test.subscribe(System.out::println);

          }

          static void sizeWordSpeech() {
            Flux<String> test=
            Flux
            .fromArray(speech)
            .map(x-> String.valueOf(x.length()));

            test.subscribe(System.out::println);

          }

          public void onErrorExample() {
            
                Flux<String> fluxCalc = Flux.just(-1, 0, 1)
            
                    .map(i -> "10 / " + i + " = " + (10 / i))
                    .onErrorReturn(ArithmeticException.class, "Division by 0 not allowed");

                
            
                fluxCalc.subscribe(value -> System.out.println("Next: " + value),
            
                    error -> System.err.println("Error: " + error));
            
            }

            static void stepVerifierTest() {
                
                    Flux<String> fluxCalc = Flux.just(-1, 0, 1)
                
                        .map(i -> "10 / " + i + " = " + (10 / i));
                
                
           /*         StepVerifier.create(fluxCalc)
                
                        .expectNextCount(1)
                
                        .expectError(ArithmeticException.class)
                
                        .verify();*/
                
                }
                public static boolean isSuperiorToOne(Integer x){
                    if(x>1){
                        return true;
                    }else {
                        return false;
                    }
                }
                static void filteringNumber(){
                    Flux<Integer> s= Flux.just(1,2,3,4);
                    Flux<Integer> s2 = s.filter(x->isSuperiorToOne(Integer.parseInt(x.toString()))); 

                    s2.subscribe(System.out::println);
                }
            
    
          
static void zipExample() {
  Flux<String> fluxFruits = Flux.just("apple", "pear", "plum");

    Flux<String> fluxColors = Flux.just("red", "green", "blue");

    Flux<Integer> fluxAmounts = Flux.just(10, 20, 30);

    Flux.zip(fluxFruits, fluxColors, fluxAmounts).subscribe(System.out::println);

}

          

}
