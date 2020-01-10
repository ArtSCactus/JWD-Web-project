package com.epam.model.builders;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

//TODO: QUESTION: Manufacturers - > one Factory?
public interface Manufacturer<T> {
    Optional<T> assembleSingle(ResultSet resultSet) throws IllegalArgumentException;

    List<T> assembleMultiple(ResultSet resultSet);

}
