package org.prog.testng;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.prog.dto.PersonDto;
import org.prog.dto.ResultsDto;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;

public class RestTests {}

    //https://randomuser.me/api/?inc=gender,name,nat,id&noinfo
    //TODO: Add IdDto class (describing "id" field of a person)
    // add new Dto to existing PersonDto class
    // print "name" and "value" from IdDto

