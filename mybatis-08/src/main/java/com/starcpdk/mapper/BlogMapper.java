package com.starcpdk.mapper;

import com.starcpdk.pojo.Blog;
import org.apache.ibatis.annotations.Insert;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    // 插入数据
    int addBlog(Blog blog);

    // 查询博客
    List<Blog> queryBlogIF(Map<String , Object> map);

    // 查询
    List<Blog> queryBlogChoose(Map<String , Object> map);

    // 更新博客
    int updateBlog(Map<String , Object> map);

    // 查询1，2，3 号记录的博客
    List<Blog> queryBlogForEach(Map<String , Object> map);

}
