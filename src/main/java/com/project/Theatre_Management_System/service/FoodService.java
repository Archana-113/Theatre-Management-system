package com.project.Theatre_Management_System.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_Management_System.dao.FoodDao;
import com.project.Theatre_Management_System.dto.Food;
import com.project.Theatre_Management_System.exception.FoodIdNotFoundException;
import com.project.Theatre_Management_System.util.ResponseStructure;
import com.project.Theatre_Management_System.util.ResponseStructureList;
@Service
public class FoodService {
	
	@Autowired
	FoodDao foodDao;
	
	@Autowired
	ResponseStructure<Food> responseStructure;
	
	@Autowired
	ResponseStructureList<Food> responseStructureList;
	
	public ResponseEntity<ResponseStructure<Food>>  saveFood(Food food)
	{
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Food inserted into DB");
		responseStructure.setData(foodDao.saveFood(food));
		return new ResponseEntity<ResponseStructure<Food>>(responseStructure,HttpStatus.CREATED)  ;
	}
	public ResponseEntity<ResponseStructure<Food>> fetchFoodById(int foodId)
	{
		Food food=foodDao.fetchFoodById(foodId);
		if(food!=null)
		{
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully Food fetched from the DB");
		responseStructure.setData(foodDao.fetchFoodById(foodId));
		return new ResponseEntity<ResponseStructure<Food>>(responseStructure,HttpStatus.FOUND) ;
		}
		else {
			throw new FoodIdNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructureList<Food>> fetchAllFood()
	{
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Successfully all the Food fetched from DB");
		responseStructureList.setData(foodDao.fetchAllFood());
		return new ResponseEntity<ResponseStructureList<Food>>(responseStructureList,HttpStatus.FOUND) ;	
	}
	public ResponseEntity<ResponseStructure<Food>> updateFoodById(int oldFoodId,Food newFood)
	{
		Food food=foodDao.fetchFoodById(oldFoodId);
		if(food!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Food got updated in the DB");
		responseStructure.setData(foodDao.updateFoodById(oldFoodId, newFood));
		return new ResponseEntity<ResponseStructure<Food>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new FoodIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Food>> deleteFoodById(int foodId)
	{
		Food food=foodDao.fetchFoodById(foodId);
		if(food!=null)
		{
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Food got deleted from the DB");
		responseStructure.setData(foodDao.deleteFoodById(foodId));
		return new ResponseEntity<ResponseStructure<Food>>(responseStructure,HttpStatus.OK) ;
		}
		else {
			throw new FoodIdNotFoundException();
		}
	}
}
