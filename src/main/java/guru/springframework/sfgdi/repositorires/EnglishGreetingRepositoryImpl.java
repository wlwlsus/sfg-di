package guru.springframework.sfgdi.repositorires;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository {
  @Override
  public String getGreeting() {
    return "Hello World!! - EN";
  }
}
