package com.apache.poi.validators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;

public class ValidHeader 
{
	public static void main(String args[])
	{
		System.out.println("Dummy");
	}
	
	public static String validate(List<String> headers) {
        List<String> mandatoryHeaders = Arrays.asList("First Name", "Email", "Phone");
        List<String> optionalHeaders = Arrays.asList("Last Name", "Address");
        List<String> allHeaders = new ArrayList<>(Arrays.asList("First Name","Last Name","Email","Phone","Address"));
        Map<String, Integer> headerIndexMap = IntStream.range(0, headers.size())
                                                    .boxed()
                                                    .collect(Collectors.toMap(i -> headers.get(i), i -> i));


        if(!allHeaders.containsAll(headers)) {
            return("Some headers exist which are not allowed");
            //return false;
        }

        if (!headers.containsAll(mandatoryHeaders)) {
            return("Mandatory headers are not present");
           // return false;
        }

		/*
		 * System.out.println(mandatoryHeaders.stream() .map(headerIndexMap::get)
		 * .collect(Collectors.toList()));
		 */

        // Check if the manadatory headers are in order
        Integer result = mandatoryHeaders.stream()
                        .map(headerIndexMap::get)
                        .reduce(-1, (x, hi) -> x < hi ? hi : headers.size());


        if (result == headers.size()) {
            return("Mandatory headers are not in order");
           // return false;
        }
        System.out.println(headers.stream());
        System.out.println(headers.stream().map(headerIndexMap::get).collect(Collectors.toList()));
        return "Headers are in required order!";
    }
}
