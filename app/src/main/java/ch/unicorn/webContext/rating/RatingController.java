package ch.unicorn.webContext.rating;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.unicorn.config.mapping.Mapper;
import ch.unicorn.webContext.rating.dto.RatingDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

/**
 * This class holds all REST endpoints targeted towards the entity rating.
 *
 */
@RestController
@RequestMapping("/ratings")
@Api(value = "Rating Controller", description = "This class holds all REST endpoints targeted towards the entity rating", authorizations = {
		@Authorization(value = "predefined authorization scheme", scopes = {
				@AuthorizationScope(description = "description", scope = "predeclared scope") }) })
public class RatingController {

	private RatingService ratingService;

	/**
	 *
	 */
	public RatingController() {
		super();
	}

	/**
	 * @param ratingservice
	 */
	@Autowired
	public RatingController(RatingService ratingservice) {
		ratingService = ratingservice;
	}

	/**
	 * This method returns the requested rating
	 *
	 * @param id Id of the requested rating
	 * @return ResponseEntity with the rating that was requested
	 */
	@ApiOperation(value = "This endpoint returns the requested rating", response = RatingDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "Id of requested rating", required = true) })
	@GetMapping("/{id}")
	public ResponseEntity<RatingDTO> getById(@PathVariable Long id) {
		Rating rating = ratingService.findById(id);
		RatingDTO ratingDTO = Mapper.instance().map(rating, RatingDTO.class, RatingMapperPresets.RATING_TO_RATING_DTO);
		return new ResponseEntity<RatingDTO>(ratingDTO, HttpStatus.OK);
	}

	/**
	 * This method returns all ratings
	 *
	 * @return ResponseEntity with all existing ratings
	 */
	@ApiOperation(value = "This endpoint returns all ratings", response = RatingDTO.class)
	@GetMapping({ "", "/" })
	public @ResponseBody ResponseEntity<List<RatingDTO>> getAll() {
		List<Rating> ratings = ratingService.findAll();
		ArrayList<RatingDTO> ratingDTOs = Mapper.instance().mapAll(ratings, RatingDTO.class, RatingMapperPresets.RATING_TO_RATING_DTO,
				ArrayList::new);
		return new ResponseEntity<>(ratingDTOs, HttpStatus.OK);
	}

	/**
	 * This method creates an rating
	 *
	 * @return ResponseEntity with the rating that was created
	 */
	@ApiOperation(value = "This endpoint creates an rating", response = RatingDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "The rating to be created", required = true) })
	@PostMapping({ "", "/" })
	public ResponseEntity<RatingDTO> create(@Valid @RequestBody RatingDTO ratingDTO) {
		Rating rating = Mapper.instance().map(ratingDTO, Rating.class, RatingMapperPresets.RATING_DTO_TO_RATING);
		ratingService.save(rating);
		return new ResponseEntity<>(ratingDTO, HttpStatus.CREATED);
	}

	/**
	 * This method updates the requested rating
	 *
	 * @param id   Id of the rating that should get updated
	 * @param rating rating entity to which the requested rating should get updated to
	 * @return ResponseEntity with the updated rating
	 */
	@ApiOperation(value = "This endpoint updates the requested rating", response = RatingDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "The logged in rating", required = true) })
	@PutMapping("/{id}")
	public ResponseEntity<RatingDTO> updateById(@PathVariable Long id, @RequestBody RatingDTO ratingDTO) {
		// TODO validate ids
		Rating rating = Mapper.instance().map(ratingDTO, Rating.class, RatingMapperPresets.RATING_DTO_TO_RATING);
		ratingService.update(rating);
		return new ResponseEntity<>(ratingDTO, HttpStatus.OK);
	}

	/**
	 * This method deletes the requested rating
	 *
	 * @param id Id of the rating that should be deleted
	 * @return ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(value = "This endpoint deletes the requested rating", response = RatingDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "Id of requested rating", required = true) })
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		ratingService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
