package gukjin.springlecturebasic.singleton;

public class SingletonService {

    private static final SingletonService singletonService = new SingletonService();

    private SingletonService(){
    }

    public static SingletonService getInstance(){
        return singletonService;
    }

    public void logic(){
        System.out.println("싱글턴 클래스가 호출");
    }
}
