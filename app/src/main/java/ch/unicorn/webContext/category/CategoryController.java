package ch.unicorn.webContext.category;

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
import ch.unicorn.webContext.category.dto.CategoryDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

/**
 * This class holds all REST endpoints targeted towards the entity category.
 *
 */
@RestController
@RequestMapping("/categories")
@Api(value = "Category Controller", description = "This class holds all REST endpoints targeted towards the entity category", authorizations = {
		@Authorization(value = "predefined authorization scheme", scopes = {
				@AuthorizationScope(description = "description", scope = "predeclared scope") }) })
public class CategoryController {

	private CategoryService categoryService;

	/**
	 *
	 */
	public CategoryController() {
		super();
	}

	/**
	 * @param categoryservice
	 */
	@Autowired
	public CategoryController(CategoryService categoryservice) {
		categoryService = categoryservice;
	}

	/**
	 * This method returns the requested category
	 *
	 * @param id Id of the requested category
	 * @return ResponseEntity with the category that was requested
	 */
	@ApiOperation(value = "This endpoint returns the requested category", response = CategoryDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "Id of requested category", required = true) })
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDTO> getById(@PathVariable Long id) {
		Category category = categoryService.findById(id);
		CategoryDTO categoryDTO = Mapper.instance().map(category, CategoryDTO.class, CategoryMapperPresets.CATEGORY_TO_CATEGORY_DTO);
		return new ResponseEntity<CategoryDTO>(categoryDTO, HttpStatus.OK);
	}

	/**
	 * This method returns all categorys
	 *
	 * @return ResponseEntity with all existing categorys
	 */
	@ApiOperation(value = "This endpoint returns all categorys", response = CategoryDTO.class)
	@GetMapping({ "", "/" })
	public @ResponseBody ResponseEntity<List<CategoryDTO>> getAll() {
		List<Category> categorys = categoryService.findAll();
		ArrayList<CategoryDTO> categoryDTOs = Mapper.instance().mapAll(categorys, CategoryDTO.class, CategoryMapperPresets.CATEGORY_TO_CATEGORY_DTO,
				ArrayList::new);
		return new ResponseEntity<>(categoryDTOs, HttpStatus.OK);
	}

	/**
	 * This method creates an category
	 *
	 * @return ResponseEntity with the category that was created
	 */
	@ApiOperation(value = "This endpoint creates an category", response = CategoryDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "The category to be created", required = true) })
	@PostMapping({ "", "/" })
	public ResponseEntity<CategoryDTO> create(@Valid @RequestBody CategoryDTO categoryDTO) {
		Category category = Mapper.instance().map(categoryDTO, Category.class, CategoryMapperPresets.CATEGORY_DTO_TO_CATEGORY);
		categoryService.save(category);
		return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
	}

	/**
	 * This method updates the requested category
	 *
	 * @param id   Id of the category that should get updated
	 * @param category category entity to which the requested category should get updated to
	 * @return ResponseEntity with the updated category
	 */
	@ApiOperation(value = "This endpoint updates the requested category", response = CategoryDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "The logged in category", required = true) })
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDTO> updateById(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
		// TODO validate ids
		Category category = Mapper.instance().map(categoryDTO, Category.class, CategoryMapperPresets.CATEGORY_DTO_TO_CATEGORY);
		categoryService.update(category);
		return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
	}

	/**
	 * This method deletes the requested category
	 *
	 * @param id Id of the category that should be deleted
	 * @return ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(value = "This endpoint deletes the requested category", response = CategoryDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "Id of requested category", required = true) })
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		categoryService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
