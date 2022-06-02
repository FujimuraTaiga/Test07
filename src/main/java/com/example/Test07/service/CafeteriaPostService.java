package com.example.Test07.service;

import com.example.Test07.repository.cafeteria.CafeteriaPost;
import com.example.Test07.repository.cafeteria.CafeteriaRepository;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class CafeteriaPostService {
    private final CafeteriaRepository cafeteriaRepository = new CafeteriaRepository();

    public void post(String postId, String menuId, double evaluation, String comment) throws DataAccessException {
        cafeteriaRepository.post(postId, menuId, evaluation, comment);
    }

    public  List<CafeteriaPost> read() throws DataAccessException{
        cafeteriaRepository.readPost();
        return cafeteriaRepository.getPosts();
    }
}
