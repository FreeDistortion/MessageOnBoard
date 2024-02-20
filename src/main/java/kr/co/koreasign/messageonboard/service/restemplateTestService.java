package kr.co.koreasign.messageonboard.service;

import kr.co.koreasign.messageonboard.itface.serviceITFace.TestService;
import kr.co.koreasign.messageonboard.model.dto.TestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@Slf4j
public class restemplateTestService implements TestService {

    @Override
    public ProcessBuilder executeProgram(String cmd) {
        return null;
    }

    @Override
    public ResponseEntity<String> getJSON() {
//        RestClient restClient= RestClient.create();
//        ResponseEntity<String> entity = restClient.get()
//                .uri("https://jsonplaceholder.typicode.com/posts")
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .toEntity(String.class);
//        return entity;


        // builder pattern
        return RestClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com/posts")
                .defaultStatusHandler(HttpStatusCode::is4xxClientError,
                        (request, response) -> {
                            log.error("Client Error Code={}",response.getStatusCode());
                            log.error("Client Error Message={}",new String(response.getBody().readAllBytes()));
                        })
                .defaultStatusHandler(HttpStatusCode::is5xxServerError,
                        (request, response) -> {
                            log.error("Server Error Code={}",response.getStatusCode());
                            log.error("Server Error Message={}",new String(response.getBody().readAllBytes()));
                        })
                .build()
                .get()

                // uri 설정시 baseUrl을 overwrite
                .uri("https://jsonplaceholder.typicode.com/posts/1")

                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(String.class);

    }

}
