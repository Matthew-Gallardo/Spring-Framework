package org.acumen.training.codes;


import org.acumen.training.codes.services.BasketSets;
import org.acumen.training.codes.services.RecordData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Configuration
public class MyBeans {

    

    @Bean
    public RecordData recordData1() {
        List<Integer> ageList = Arrays.asList(25, 30, 35);
        Map<String, String> nameRecords = new HashMap<>();
        nameRecords.put("Kendrick", "Developer");
        nameRecords.put("Lil Wayne", "Designer");
        return new RecordData(ageList, nameRecords);
    }

    @Bean
    public RecordData recordData2() {
        List<Integer> ageList = Arrays.asList(22, 28, 40);
        Map<String, String> nameRecords = new HashMap<>();
        nameRecords.put("Kanye", "Manager");
        nameRecords.put("Frank", "Analyst");
        return new RecordData(ageList, nameRecords);
    }

    @Bean
    public RecordData recordData3() {
        List<Integer> ageList = Arrays.asList(20, 25, 50);
        Map<String, String> nameRecords = new HashMap<>();
        nameRecords.put("21Savage", "Engineer");
        nameRecords.put("Drake", "Consultant");
        return new RecordData(ageList, nameRecords);
    }

    @Bean
    public RecordData recordData4() {
        List<Integer> ageList = Arrays.asList(18, 27, 45);
        Map<String, String> nameRecords = new HashMap<>();
        nameRecords.put("Jcole", "Technician");
        nameRecords.put("Future", "Supervisor");
        return new RecordData(ageList, nameRecords);
    }

  

    @Bean(value = {"basketSet1", "basketSet1Alias"})
    @Scope("prototype")
    public BasketSets basketSet1() {
        Set<String> baskets = new HashSet<>(Arrays.asList("Apple", "Banana", "Cherry"));
        return new BasketSets(baskets);
    }

    @Bean(value = {"basketSet2", "basketSet2Alias"})
    @Scope("prototype")
    public BasketSets basketSet2() {
        Set<String> baskets = new HashSet<>(Arrays.asList("Orange", "Mango", "Peach"));
        return new BasketSets(baskets);
    }
}
