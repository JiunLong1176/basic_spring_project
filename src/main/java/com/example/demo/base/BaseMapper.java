package com.example.demo.base;

import java.util.List;

import org.mapstruct.MappingTarget;

public interface BaseMapper<E, M> {
	
	public E mapModelToEntity( M model );
	
	public M mapEntityToModel( E header );
	
	public void updateModelToEntity( M model, @MappingTarget E entity );

	public List<M> mapListToModel(List<E> details);
}
