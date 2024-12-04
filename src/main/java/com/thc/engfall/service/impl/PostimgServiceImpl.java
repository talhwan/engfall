package com.thc.engfall.service.impl;

import com.thc.engfall.dto.PostimgDto;
import com.thc.engfall.entity.Postimg;
import com.thc.engfall.mapper.PostimgMapper;
import com.thc.engfall.repository.PostimgRepository;
import com.thc.engfall.service.PostimgService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostimgServiceImpl implements PostimgService {

    PostimgRepository postimgRepository;
    PostimgMapper postimgMapper;
    public PostimgServiceImpl(
            PostimgRepository postimgRepository
            , PostimgMapper postimgMapper
    ){
        this.postimgRepository = postimgRepository;
        this.postimgMapper = postimgMapper;
    }

    @Override
    public PostimgDto.CreateResDto create(PostimgDto.CreateReqDto params){
        return postimgRepository.save(params.toEntity()).toCreateResDto();
    }

    @Override
    public void update(PostimgDto.UpdateReqDto params){
        Postimg postimg = postimgRepository.findById(params.getId()).orElseThrow(() -> new RuntimeException("no data"));
        if(params.getUrl() != null){
            postimg.setUrl(params.getUrl());
        }
        postimgRepository.save(postimg);
    }

    @Override
    public void delete(PostimgDto.UpdateReqDto params){
        Postimg postimg = postimgRepository.findById(params.getId()).orElseThrow(() -> new RuntimeException("no data"));
        postimg.setDeleted(true);
        postimgRepository.save(postimg);
    }

    public PostimgDto.DetailResDto get(Long id){
        PostimgDto.DetailResDto returnvalue = postimgMapper.detail(id);
        return returnvalue;
    }
    @Override
    public PostimgDto.DetailResDto detail(PostimgDto.DetailReqDto params){
        return get(params.getId());
    }

    @Override
    public List<PostimgDto.DetailResDto> list(PostimgDto.ListReqDto params){
        List<PostimgDto.DetailResDto> list = postimgMapper.list(params);
        List<PostimgDto.DetailResDto> newList = new ArrayList<>();
        for(PostimgDto.DetailResDto each : list){
            newList.add( get(each.getId()) );
        }
        return newList;
    }
}
