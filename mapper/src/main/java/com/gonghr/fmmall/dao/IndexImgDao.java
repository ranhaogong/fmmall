package com.gonghr.fmmall.dao;

import com.gonghr.fmmall.entity.IndexImg;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexImgDao {

    public List<IndexImg> selectAllIndexImg();
}
