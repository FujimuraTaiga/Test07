package com.example.Test07.service.C2_CafeteriaPost;

import com.example.Test07.repository.C8_Cafeteria.CafeteriaPost;
import com.example.Test07.repository.C8_Cafeteria.CafeteriaRepository;
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
