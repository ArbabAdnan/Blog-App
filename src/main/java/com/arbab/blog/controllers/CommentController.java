package com.arbab.blog.controllers;

import com.arbab.blog.entities.Comment;
import com.arbab.blog.payloads.ApiResponse;
import com.arbab.blog.payloads.CommentDto;
import com.arbab.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(
            @RequestBody CommentDto comment,
            @PathVariable Integer postId){

        CommentDto createdComment = this.commentService.createComment(comment, postId);
        return new ResponseEntity<CommentDto>(createdComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
        this.commentService.deleteComment(commentId);

      return  new ResponseEntity<ApiResponse>(new ApiResponse("Comment is deleted successfully",true),HttpStatus.OK);
    }
}
