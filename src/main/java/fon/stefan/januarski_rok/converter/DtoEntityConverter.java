package fon.stefan.januarski_rok.converter;

import fon.stefan.januarski_rok.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface DtoEntityConverter<T, E> {
    T toDto(E e);
    E toEntity(T t);
}
