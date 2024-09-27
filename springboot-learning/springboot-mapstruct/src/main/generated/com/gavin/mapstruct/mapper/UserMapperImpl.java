package com.gavin.mapstruct.mapper;

import com.gavin.mapstruct.entity.pojo.User;
import com.gavin.mapstruct.entity.pojo.UserEnum;
import com.gavin.mapstruct.entity.vo.UserEnumVo;
import com.gavin.mapstruct.entity.vo.UserVo1;
import com.gavin.mapstruct.entity.vo.UserVo2;
import com.gavin.mapstruct.entity.vo.UserVo3;
import com.gavin.mapstruct.entity.vo.UserVo4;
import com.gavin.mapstruct.enums.UserTypeEnum;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-27T11:06:26+0800",
    comments = "version: 1.5.0.Beta2, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserVo1 toVo1(User user) {
        if ( user == null ) {
            return null;
        }

        UserVo1.UserVo1Builder userVo1 = UserVo1.builder();

        userVo1.id( user.getId() );
        userVo1.name( user.getName() );
        userVo1.createTime( user.getCreateTime() );
        userVo1.updateTime( user.getUpdateTime() );

        return userVo1.build();
    }

    @Override
    public User vo1ToUser(UserVo1 userVo1) {
        if ( userVo1 == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userVo1.getId() );
        user.name( userVo1.getName() );
        user.createTime( userVo1.getCreateTime() );
        user.updateTime( userVo1.getUpdateTime() );

        return user.build();
    }

    @Override
    public UserVo2 toVo2(User user) {
        if ( user == null ) {
            return null;
        }

        UserVo2.UserVo2Builder userVo2 = UserVo2.builder();

        userVo2.id( user.getId() );
        userVo2.name( user.getName() );
        userVo2.createTime( user.getCreateTime() );

        return userVo2.build();
    }

    @Override
    public UserVo3 toVo3(User user) {
        if ( user == null ) {
            return null;
        }

        UserVo3.UserVo3Builder userVo3 = UserVo3.builder();

        if ( user.getId() != null ) {
            userVo3.id( String.valueOf( user.getId() ) );
        }
        userVo3.name( user.getName() );
        if ( user.getUpdateTime() != null ) {
            userVo3.updateTime( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( user.getUpdateTime() ) );
        }

        userVo3.createTime( com.gavin.mapstruct.utils.DateTransform.strToDate(user.getCreateTime()) );

        return userVo3.build();
    }

    @Override
    public User vo3ToUser(UserVo3 userVo3) {
        if ( userVo3 == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        if ( userVo3.getId() != null ) {
            user.id( Integer.parseInt( userVo3.getId() ) );
        }
        user.name( userVo3.getName() );
        if ( userVo3.getCreateTime() != null ) {
            user.createTime( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( userVo3.getCreateTime() ) );
        }
        if ( userVo3.getUpdateTime() != null ) {
            user.updateTime( LocalDateTime.parse( userVo3.getUpdateTime() ) );
        }

        return user.build();
    }

    @Override
    public UserVo4 toVO4(User user) {
        if ( user == null ) {
            return null;
        }

        UserVo4.UserVo4Builder userVo4 = UserVo4.builder();

        if ( user.getId() != null ) {
            userVo4.userId( String.valueOf( user.getId() ) );
        }
        userVo4.userName( user.getName() );
        userVo4.createTime( user.getCreateTime() );
        if ( user.getUpdateTime() != null ) {
            userVo4.updateTime( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( user.getUpdateTime() ) );
        }

        return userVo4.build();
    }

    @Override
    public User vo4ToUser(UserVo4 userVo3) {
        if ( userVo3 == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.createTime( userVo3.getCreateTime() );
        if ( userVo3.getUpdateTime() != null ) {
            user.updateTime( LocalDateTime.parse( userVo3.getUpdateTime() ) );
        }

        return user.build();
    }

    @Override
    public UserEnumVo toEnumVO(UserEnum userEnum) {
        if ( userEnum == null ) {
            return null;
        }

        UserEnumVo.UserEnumVoBuilder userEnumVo = UserEnumVo.builder();

        userEnumVo.id( userEnum.getId() );
        userEnumVo.name( userEnum.getName() );
        if ( userEnum.getUserTypeEnum() != null ) {
            userEnumVo.userTypeEnum( userEnum.getUserTypeEnum().name() );
        }

        return userEnumVo.build();
    }

    @Override
    public UserEnum enumVOToUser(UserEnumVo userEnumVo) {
        if ( userEnumVo == null ) {
            return null;
        }

        UserEnum.UserEnumBuilder userEnum = UserEnum.builder();

        userEnum.id( userEnumVo.getId() );
        userEnum.name( userEnumVo.getName() );
        if ( userEnumVo.getUserTypeEnum() != null ) {
            userEnum.userTypeEnum( Enum.valueOf( UserTypeEnum.class, userEnumVo.getUserTypeEnum() ) );
        }

        return userEnum.build();
    }
}
