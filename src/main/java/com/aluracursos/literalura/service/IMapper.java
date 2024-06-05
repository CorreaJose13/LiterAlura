package com.aluracursos.literalura.service;

public interface IMapper {
    <T> T convertData(String json, Class<T> customClass);
}
