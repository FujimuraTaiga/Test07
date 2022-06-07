package com.example.Test07.service.C2_CafeteriaPost;

import com.example.Test07.repository.C8_Cafeteria.CafeteriaDAO;
import com.example.Test07.repository.C8_Cafeteria.CafeteriaMenu;
import com.example.Test07.repository.C8_Cafeteria.CafeteriaPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class CafeteriaPostService {
    private final CafeteriaDAO dao;

    @Autowired
    CafeteriaPostService(CafeteriaDAO dao){this.dao = dao;}

    public void post(String postId, String menuId, int evaluation, String comment) throws DataAccessException {
        dao.createPost(new CafeteriaPost(postId, menuId, evaluation, comment));
    }

    public  List<CafeteriaPost> readPost() {
        return dao.readPost();
    }

    public List<CafeteriaMenu> readMenu() {
        return dao.readMenu();
    }
}
