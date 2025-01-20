package com.example.post.service;

import com.example.post.model.Post;
import com.example.post.repository.PostRepository;
import com.example.post.repository.PostRepositoryImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public void createPost(Post post) {
        if (post.getCreatedAt() == null) post.setCreatedAt(LocalDateTime.now());
        if (post.getUpdatedAt() == null) post.setUpdatedAt(LocalDateTime.now());
        postRepository.create(post);
    }

    @Override
    public Optional<Post> selectPost(Long id) {
        return postRepository.select(id);
    }

    @Override
    public void updatePost(Post post) {
        if (post.getUpdatedAt() == null) post.setUpdatedAt(LocalDateTime.now());
        postRepository.update(post);
    }

    @Override
    public void deletePost(Long id, String password) {
        if (postRepository.select(id).get().getPassword().equals(password)) {
            postRepository.delete(id);
        }
    }

    @Override
    public List<Post> selectAllPost() {
        return postRepository.selectAll();
    }
}
