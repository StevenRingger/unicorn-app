package ch.unicorn.webContext.comment;

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
import ch.unicorn.webContext.comment.dto.CommentDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

/**
 * This class holds all REST endpoints targeted towards the entity comment.
 *
 */
@RestController
@RequestMapping("/comments")
@Api(value = "Comment Controller", description = "This class holds all REST endpoints targeted towards the entity comment", authorizations = {
		@Authorization(value = "predefined authorization scheme", scopes = {
				@AuthorizationScope(description = "description", scope = "predeclared scope") }) })
public class CommentController {

	private CommentService commentService;

	/**
	 *
	 */
	public CommentController() {
		super();
	}

	/**
	 * @param commentservice
	 */
	@Autowired
	public CommentController(CommentService commentservice) {
		commentService = commentservice;
	}

	/**
	 * This method returns the requested comment
	 *
	 * @param id Id of the requested comment
	 * @return ResponseEntity with the comment that was requested
	 */
	@ApiOperation(value = "This endpoint returns the requested comment", response = CommentDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "Id of requested comment", required = true) })
	@GetMapping("/{id}")
	public ResponseEntity<CommentDTO> getById(@PathVariable Long id) {
		Comment comment = commentService.findById(id);
		CommentDTO commentDTO = Mapper.instance().map(comment, CommentDTO.class, CommentMapperPresets.COMMENT_TO_COMMENT_DTO);
		return new ResponseEntity<CommentDTO>(commentDTO, HttpStatus.OK);
	}

	/**
	 * This method returns all comments
	 *
	 * @return ResponseEntity with all existing comments
	 */
	@ApiOperation(value = "This endpoint returns all comments", response = CommentDTO.class)
	@GetMapping({ "", "/" })
	public @ResponseBody ResponseEntity<List<CommentDTO>> getAll() {
		List<Comment> comments = commentService.findAll();
		ArrayList<CommentDTO> commentDTOs = Mapper.instance().mapAll(comments, CommentDTO.class, CommentMapperPresets.COMMENT_TO_COMMENT_DTO,
				ArrayList::new);
		return new ResponseEntity<>(commentDTOs, HttpStatus.OK);
	}

	/**
	 * This method creates an comment
	 *
	 * @return ResponseEntity with the comment that was created
	 */
	@ApiOperation(value = "This endpoint creates an comment", response = CommentDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "The comment to be created", required = true) })
	@PostMapping({ "", "/" })
	public ResponseEntity<CommentDTO> create(@Valid @RequestBody CommentDTO commentDTO) {
		Comment comment = Mapper.instance().map(commentDTO, Comment.class, CommentMapperPresets.COMMENT_DTO_TO_COMMENT);
		commentService.save(comment);
		return new ResponseEntity<>(commentDTO, HttpStatus.CREATED);
	}

	/**
	 * This method updates the requested comment
	 *
	 * @param id   Id of the comment that should get updated
	 * @param comment comment entity to which the requested comment should get updated to
	 * @return ResponseEntity with the updated comment
	 */
	@ApiOperation(value = "This endpoint updates the requested comment", response = CommentDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "The logged in comment", required = true) })
	@PutMapping("/{id}")
	public ResponseEntity<CommentDTO> updateById(@PathVariable Long id, @RequestBody CommentDTO commentDTO) {
		// TODO validate ids
		Comment comment = Mapper.instance().map(commentDTO, Comment.class, CommentMapperPresets.COMMENT_DTO_TO_COMMENT);
		commentService.update(comment);
		return new ResponseEntity<>(commentDTO, HttpStatus.OK);
	}

	/**
	 * This method deletes the requested comment
	 *
	 * @param id Id of the comment that should be deleted
	 * @return ResponseEntity with the outcome of the deletion process
	 */
	@ApiOperation(value = "This endpoint deletes the requested comment", response = CommentDTO.class)
	@ApiImplicitParams({ @ApiImplicitParam(value = "Id of requested comment", required = true) })
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		commentService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
