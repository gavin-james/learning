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
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-14T11:24:27+0800",
    comments = "version: 1.5.0.Beta2, compiler: javac, environment: Java 1.8.0_312 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserVo1 toVo1(User user) {
        if ( user == null ) {
            return null;
        }

        UserVo1 userVo1 = new UserVo1();

        userVo1.setId( user.getId() );
        userVo1.setName( user.getName() );
        userVo1.setCreateTime( user.getCreateTime() );
        userVo1.setUpdateTime( user.getUpdateTime() );

        return userVo1;
    }

    @Override
    public User vo1ToUser(UserVo1 userVo1) {
        if ( userVo1 == null ) {
            return null;
        }

        User user = new User();

        user.setId( userVo1.getId() );
        user.setName( userVo1.getName() );
        user.setCreateTime( userVo1.getCreateTime() );
        user.setUpdateTime( userVo1.getUpdateTime() );

        return user;
    }

    @Override
    public UserVo2 toVo2(User user) {
        if ( user == null ) {
            return null;
        }

        UserVo2 userVo2 = new UserVo2();

        userVo2.setId( user.getId() );
        userVo2.setName( user.getName() );
        userVo2.setCreateTime( user.getCreateTime() );

        return userVo2;
    }

    @Override
    public UserVo3 toVo3(User user) {
        if ( user == null ) {
            return null;
        }

        UserVo3 userVo3 = new UserVo3();

        if ( user.getId() != null ) {
            userVo3.setId( String.valueOf( user.getId() ) );
        }
        userVo3.setName( user.getName() );
        if ( user.getUpdateTime() != null ) {
            userVo3.setUpdateTime( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( user.getUpdateTime() ) );
        }

        userVo3.setCreateTime( com.gavin.mapstruct.utils.DateTransform.strToDate(user.getCreateTime()) );

        return userVo3;
    }

    @Override
    public User vo3ToUser(UserVo3 userVo3) {
        if ( userVo3 == null ) {
            return null;
        }

        User user = new User();

        if ( userVo3.getId() != null ) {
            user.setId( Integer.parseInt( userVo3.getId() ) );
        }
        user.setName( userVo3.getName() );
        if ( userVo3.getCreateTime() != null ) {
            user.setCreateTime( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( userVo3.getCreateTime() ) );
        }
        if ( userVo3.getUpdateTime() != null ) {
            user.setUpdateTime( LocalDateTime.parse( userVo3.getUpdateTime() ) );
        }

        return user;
    }

    @Override
    public UserVo4 toVO4(User user) {
        if ( user == null ) {
            return null;
        }

        UserVo4 userVo4 = new UserVo4();

        if ( user.getId() != null ) {
            userVo4.setUserId( String.valueOf( user.getId() ) );
        }
        userVo4.setUserName( user.getName() );
        userVo4.setCreateTime( user.getCreateTime() );
        if ( user.getUpdateTime() != null ) {
            userVo4.setUpdateTime( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( user.getUpdateTime() ) );
        }

        return userVo4;
    }

    @Override
    public User vo4ToUser(UserVo4 userVo3) {
        if ( userVo3 == null ) {
            return null;
        }

        User user = new User();

        user.setCreateTime( userVo3.getCreateTime() );
        if ( userVo3.getUpdateTime() != null ) {
            user.setUpdateTime( LocalDateTime.parse( userVo3.getUpdateTime() ) );
        }

        return user;
    }

    @Override
    public UserEnumVo toEnumVO(UserEnum userEnum) {
        if ( userEnum == null ) {
            return null;
        }

        UserEnumVo userEnumVo = new UserEnumVo();

        userEnumVo.setId( userEnum.getId() );
        userEnumVo.setName( userEnum.getName() );
        if ( userEnum.getUserTypeEnum() != null ) {
            userEnumVo.setUserTypeEnum( userEnum.getUserTypeEnum().name() );
        }

        return userEnumVo;
    }

    @Override
    public UserEnum enumVOToUser(UserEnumVo userEnumVo) {
        if ( userEnumVo == null ) {
            return null;
        }

        UserEnum userEnum = new UserEnum();

        userEnum.setId( userEnumVo.getId() );
        userEnum.setName( userEnumVo.getName() );
        if ( userEnumVo.getUserTypeEnum() != null ) {
            userEnum.setUserTypeEnum( Enum.valueOf( UserTypeEnum.class, userEnumVo.getUserTypeEnum() ) );
        }

        return userEnum;
    }
}
