package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.base.BaseMapper;
import com.example.demo.entity.Trans;
import com.example.demo.model.TransModel;

@Mapper(componentModel = "spring")
public interface TransMapper extends BaseMapper<Trans, TransModel> {

}
