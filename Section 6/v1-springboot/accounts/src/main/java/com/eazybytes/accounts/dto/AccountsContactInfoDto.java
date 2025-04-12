package com.eazybytes.accounts.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/*
 Java Record is a new type of Java class which was introduced in Java 17.
 Sometimes we require our DTO or POJO class to act as a data carrier which means the DTO or POJO class object
 is created and can read the data from this DTO object but cannot change.
 Whatever field data is passed during object creation and these fields will be final and anyone can read from
 getter methods and there won't be setter method.
 Instead of writing getter method and constructor which accepts final java field we can make use of Record class
*/
// Behind the scene these field will be made final and will generate a getter method and constructor.
// Due to this annotation Spring framework creates a bean and directly injects this bean using @Autowired annotation into the controller.
@ConfigurationProperties(prefix = "accounts")
public record AccountsContactInfoDto(String message, Map<String, String> contactDetails, List<String> onCallSupport)
{
}
