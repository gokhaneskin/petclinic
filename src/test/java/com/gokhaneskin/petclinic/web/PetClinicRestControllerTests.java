package com.gokhaneskin.petclinic.web;

import com.gokhaneskin.petclinic.model.Owner;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PetClinicRestControllerTests {

    private RestTemplate restTemplate;

    @Before
    public void setUp(){
        restTemplate=new RestTemplate();
    }

    @Test
    public void testGetOwnerById(){
        ResponseEntity<Owner> reponse=restTemplate.getForEntity("http://localhost:8080/rest/owner/1", Owner.class);
        MatcherAssert.assertThat(reponse.getStatusCodeValue(), CoreMatchers.equalTo(200));
        MatcherAssert.assertThat(reponse.getBody().getFirstName(),CoreMatchers.equalTo("Gokhan"));
    }

//    @Test
//    public  void testGetOwnersByLastName(){
//        ResponseEntity<List> response=restTemplate.getForEntity("http://localhost:8080/rest/owner?ln=Eskin", List.class);
//        MatcherAssert.assertThat(response.getStatusCodeValue(),CoreMatchers.equalTo(200));
//        List<Map<String,String>> body=response.getBody();
//        List<String> firstNames= body.stream().map(e->e.get("firstName")).collect(Collectors.toList());
//        MatcherAssert.assertThat(firstNames,CoreMatchers.containsString(""));
//    }

    @Test
    public void testCreateOwner(){
        Owner owner=new Owner();
        owner.setFirstName("Mustafa Kemal");
        owner.setLastName("ATATÜRK");
        URI location=restTemplate.postForLocation("http://localhost:8080/rest/owner",owner);
        Owner owner1=restTemplate.getForObject(location,Owner.class);
        MatcherAssert.assertThat(owner1.getFirstName(),CoreMatchers.equalTo(owner.getFirstName()));
        MatcherAssert.assertThat(owner1.getLastName(),CoreMatchers.equalTo(owner.getLastName()));

    }

    @Test
    public void testUpdateOwner(){
        Owner owner=restTemplate.getForObject("http://localhost:8080/rest/owner/4",Owner.class);
        MatcherAssert.assertThat(owner.getFirstName(),CoreMatchers.equalTo("Ayşe"));
        owner.setFirstName("Ayşe Fatma");
        restTemplate.put("http://localhost:8080/rest/owner/4",owner);
        owner=restTemplate.getForObject("http://localhost:8080/rest/owner/4",Owner.class);
        MatcherAssert.assertThat(owner.getFirstName(),CoreMatchers.equalTo("Ayşe Fatma"));
    }

    @Test
    public void testDeleteOwner(){
        //restTemplate.delete("http://localhost:8080/rest/owner/1");
        ResponseEntity<Void> responseEntity=restTemplate.exchange("http://localhost:8080/rest/owner/1", HttpMethod.DELETE,null,Void.class);
        try {
            restTemplate.getForEntity("http://localhost:8080/rest/owner/1",Owner.class);
            Assert.fail("Should have not returned owner");
        }catch (HttpClientErrorException ex){
            MatcherAssert.assertThat(ex.getStatusCode().value(),CoreMatchers.equalTo(404));
        }
    }
}
