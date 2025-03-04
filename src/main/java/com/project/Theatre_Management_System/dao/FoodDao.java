package com.project.Theatre_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_Management_System.dto.Food;
import com.project.Theatre_Management_System.repo.FoodRepo;

@Repository
public class FoodDao {
	@Autowired
	FoodRepo foodRepo;
	
	public Food saveFood(Food food)
	{
		return foodRepo.save(food);
	}
	public Food fetchFoodById(int foodId)
	{
		Optional<Food> dbFood= foodRepo.findById(foodId);
		if(dbFood.isPresent())
		{
			return dbFood.get();
		}
		return null;	
	}
	public List<Food> fetchAllFood()
	{
		return foodRepo.findAll();
		
	}
	public Food updateFoodById(int oldFoodId,Food newFood)
	{
		newFood.setFoodId(oldFoodId);
		return saveFood(newFood);
	}
	
	public Food deleteFoodById(int FoodId)
	{
		Food Food=fetchFoodById(FoodId);
		foodRepo.delete(Food);
		return Food;
	}

}
