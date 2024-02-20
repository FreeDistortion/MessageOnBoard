package kr.co.koreasign.messageonboard.utility;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class TransformationUtility {
    private ModelMapper modelMapper = new ModelMapper();

    public <D, E> E convertAtoB(D sourceObject, Class<E> targetClass) {
        return modelMapper.map(sourceObject, targetClass);
    }

    public <S, T> List<T> convertListAtoB(List<S> source, Class<T> targetClass) {
        return source.stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}
