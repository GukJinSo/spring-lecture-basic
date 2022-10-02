package gukjin.springlecturebasic.lifecycle;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = "+url);
    }

    public void setUrl(String url) {
        this.url = url;
        System.out.println("세터 호출, url = "+url);
    }

    // 서비스 시작 시 호출
    public void connect(){
        System.out.println("connect = "+url);
    }

    public void call(String message){
        System.out.println("call : "+url+" message = "+message);
    }

    // 서비스 종료 시 호출
    public void disconnect(){
        System.out.println("close " + url);
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("의존관계 주입 후 호출");
        connect();
        call("초기화 연결 메세지");
    }
    @PreDestroy
    public void close() throws Exception {
        System.out.println("빈 파괴되기 전 호출");
        disconnect();
    }

}
