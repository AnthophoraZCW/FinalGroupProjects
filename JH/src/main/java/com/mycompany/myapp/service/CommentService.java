package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Comment;
import com.mycompany.myapp.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    private CommentRepository repository;

    @Autowired
    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }

    public Comment create(Comment comment) {
        return repository.save(comment);
    }

    public Comment readById(Long id) {
        return repository.findById(id).get();
    }

    public List<Comment> readAll() {
        Iterable<Comment> allComment = repository.findAll();
        List<Comment> CommentList = new ArrayList<>();
        allComment.forEach(CommentList::add);
        return CommentList;
    }

    public Comment update(Long id, Comment newCommentData) {
        Comment commentInDatabase = this.readById(id);
        commentInDatabase.setId(newCommentData.getId());
        commentInDatabase.setPost(newCommentData.getPost());
        commentInDatabase.setThumbsUp(newCommentData.getThumbsUp());
        commentInDatabase.setVideo(newCommentData.getVideo());
        commentInDatabase.setPostedBy(newCommentData.getPostedBy());
        commentInDatabase = repository.save(commentInDatabase);
        return commentInDatabase;
    }

    public Comment deleteById(Long id) {
        Comment commentToBeDeleted = this.readById(id);
        repository.delete(commentToBeDeleted);
        return commentToBeDeleted;
    }
}
