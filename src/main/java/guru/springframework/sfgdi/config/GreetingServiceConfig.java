package guru.springframework.sfgdi.config;


import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import guru.springframework.sfgdi.repositorires.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositorires.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

  @Bean
  PetServiceFactory petServiceFactory() {
    return new PetServiceFactory();
  }

  @Profile({"dog", "default"})
  @Bean
  PetService dogPetService(PetServiceFactory petServiceFactory) {
    return petServiceFactory.getPerService("dog");
  }

  @Profile("cat")
  @Bean
  PetService catPetService(PetServiceFactory petServiceFactory) {
    return petServiceFactory.getPerService("cat");
  }

  @Profile({"ES", "default"})
  @Bean("i18nService")
  I18NSpanishService i18NSpanishService() {
    return new I18NSpanishService();
  }

  @Profile("EN")
  @Bean
  I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
    return new I18nEnglishGreetingService(englishGreetingRepository);
  }

  @Bean
  EnglishGreetingRepository englishGreetingRepository() {
    return new EnglishGreetingRepositoryImpl();
  }

  @Primary
  @Bean
  PrimaryGreetingService primaryGreetingService() {
    return new PrimaryGreetingService();
  }

  @Bean
  ConstructorGreetingService constructorGreetingService() {
    return new ConstructorGreetingService();
  }

  @Bean
  PropertyInjectedGreetingService propertyInjectedGreetingService() {
    return new PropertyInjectedGreetingService();
  }

  @Bean
  SetterInjectedGreetingService setterInjectedGreetingService() {
    return new SetterInjectedGreetingService();
  }
}
