package maishai.testing.BackendsTesting.mapping.mapper;

import maishai.testing.BackendsTesting.adapters.in.rest.model.UserNameTO;
import maishai.testing.BackendsTesting.mapping.IMapper;
import maishai.testing.BackendsTesting.util.UserName;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserNameMapper extends IMapper<UserName, UserNameTO> {
    UserNameMapper INSTANCE = Mappers.getMapper(UserNameMapper.class);
    @Override
    @Mapping(target = "first", source = "firstname")
    @Mapping(target = "last", source = "lastname")
    @Mapping(target = "middle", source = "Middlename")
    UserNameTO fromInToOut(UserName entity) ;

    @Override
    @InheritInverseConfiguration
    @Mapping(target = "firstname", source = "first")
    @Mapping(target = "lastname", source = "last")
    @Mapping(target = "Middlename", source = "middle")
    UserName fromOutToIn(UserNameTO to);
}
