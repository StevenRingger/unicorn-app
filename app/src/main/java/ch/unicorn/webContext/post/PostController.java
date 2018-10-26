package ch.unicorn.webContext.post;

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
import ch.unicorn.webContext.post.dto.PostDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

/**
 * This class holds all REST endpoints targeted towards the entity post.
 *
 */
@RestController
@RequestMapping("/posts")
@Api(value = "Post Controller", description = "This class holds all REST endpoints targeted towards the entity post", authorizations = {
		@Authorization(value = "predefined authorization scheme", scopes = {
				@AuthorizationScope(description = "description", scope = "predeclared scope") }) })
public class PostController {

	private PostService postService;

	/**
	 *
	 */
	public PostController() {
		super();
	}

	/**
	 * @param postservice
	 */
	@Autowired
	public PostController(PostService postservice) {
		postService = postservice;
	}

	/**
	 * This method returns the requested post
	 *
	 * @param id Id of the requested post
	 * @return ResponseEntity with the post that was requested
	 */
	@ApiOperation(value = "This endpoint returns the requested post", response = PostDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "Id of requested post", required = true) })
	@GetMapping("/{id}")
	public ResponseEntity<PostDTO> getById(@PathVariable Long id) {
		Post post = postService.findById(id);
		PostDTO postDTO = Mapper.instance().map(post, PostDTO.class, PostMapperPresets.POST_TO_POST_DTO);
		return new ResponseEntity<PostDTO>(postDTO, HttpStatus.OK);
	}

	/**
	 * This method returns all posts
	 *
	 * @return ResponseEntity with all existing posts
	 */
	@ApiOperation(value = "This endpoint returns all posts", response = PostDTO.class)
	@GetMapping({ "", "/" })
	public @ResponseBody ResponseEntity<List<PostDTO>> getAll() {
		List<Post> posts = postService.findAll();
		ArrayList<PostDTO> postDTOs = Mapper.instance().mapAll(posts, PostDTO.class, PostMapperPresets.POST_TO_POST_DTO,
				ArrayList::new);
		return new ResponseEntity<>(postDTOs, HttpStatus.OK);
	}

	/**
	 * This method creates an post
	 *
	 * @return ResponseEntity with the post that was created
	 */
	@ApiOperation(value = "This endpoint creates an post", response = PostDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "The post to be created", required = true) })
	@PostMapping({ "", "/" })
	public ResponseEntity<PostDTO> create(@Valid @RequestBody PostDTO postDTO) {
		Post post = Mapper.instance().map(postDTO, Post.class, PostMapperPresets.POST_DTO_TO_POST);
		postService.save(post);
		return new ResponseEntity<>(postDTO, HttpStatus.CREATED);
	}

	/**
	 * This method updates the requested post
	 *
	 * @param id   Id of the post that should get updated
	 * @param post post entity to which the requested post should get updated to
	 * @return ResponseEntity with the updated post
	 */
	@ApiOperation(value = "This endpoint updates the requested post", response = PostDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "The logged in post", required = true) })
	@PutMapping("/{id}")
	public ResponseEntity<PostDTO> updateById(@PathVariable Long id, @RequestBody PostDTO postDTO) {
		// TODO validate ids
		Post post = Mapper.instance().map(postDTO, Post.class, PostMapperPresets.POST_DTO_TO_POST);
		postService.update(post);
		return new ResponseEntity<>(postDTO, HttpStatus.OK);
	}

	/**
	 * This method deletes the requested post
	 *
	 * @param id Id of the post that should be deleted
	 * @return ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(value = "This endpoint deletes the requested post", response = PostDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "Id of requested post", required = true) })
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		postService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
