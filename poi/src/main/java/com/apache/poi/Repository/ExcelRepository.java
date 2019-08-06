package com.apache.poi.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apache.poi.Model.Excel;

public interface ExcelRepository extends MongoRepository<Excel, String> 
{

}
