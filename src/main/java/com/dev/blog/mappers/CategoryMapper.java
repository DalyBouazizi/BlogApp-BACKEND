package com.dev.blog.mappers;

import com.dev.blog.domain.PostStatus;
import com.dev.blog.domain.dtos.CategoryDto;
import com.dev.blog.domain.dtos.CreateCategoryRequest;
import com.dev.blog.domain.entities.Category;
import com.dev.blog.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "Spring" , unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "postCount",source = "posts" , qualifiedByName = "calculatePostCount")
    CategoryDto toCategoryDto(Category category);

    Category toEntity(CreateCategoryRequest request);


    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts) {
        if (posts == null || posts.size() == 0) {
            return 0;
        }
        return posts.stream().filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }



}
