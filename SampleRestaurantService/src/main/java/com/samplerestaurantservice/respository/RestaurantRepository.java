package com.samplerestaurantservice.respository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.samplerestaurantservice.entity.Restaurant;

public interface RestaurantRepository extends PagingAndSortingRepository<Restaurant, Long> {

	// HAVERSINE formula to calculate nearest lat/lng around a central lat/lng
	// 6371 for KM, 3959 for Miles	
	static final String HAVERSINE_PART = "(6371 * acos(cos(radians(:latitude)) * "
			+ "cos(radians(m.latitude)) * cos(radians(m.longitude) - radians(:longitude)) + "
			+ "sin(radians(:latitude)) * sin(radians(m.latitude))))";
	
	@Query("SELECT m FROM Restaurant m WHERE m.name LIKE CONCAT('%',:search,'%') and " + HAVERSINE_PART + 
			" < :distance ORDER BY "+ HAVERSINE_PART +" ASC")
	public List<Restaurant> findNearestRestaurants(
			@Param("latitude") final double latitude, 
			@Param("longitude") final double longitude, 
			@Param("distance") final double distance, 
			@Param("search") final String search, 
			Pageable pageable);
}
