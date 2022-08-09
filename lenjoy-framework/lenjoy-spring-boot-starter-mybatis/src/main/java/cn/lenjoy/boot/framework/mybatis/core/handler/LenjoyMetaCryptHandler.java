package cn.lenjoy.boot.framework.mybatis.core.handler;

import cn.lenjoy.boot.framework.common.util.crypt.MCryptUtils;
import cn.lenjoy.boot.framework.common.util.string.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description: 乐享自动实现数据加解密注入表单属性
 * 通过在字段属性中通过 @TableField(typeHandler = LenjoyMetaCryptHandler.class) 方式进行注解实现
 *
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 08 07 星期日
 * @version: 1.0.0
 */
@Slf4j
@SuppressWarnings("unused")
public class LenjoyMetaCryptHandler extends BaseTypeHandler<String> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        try {
            if (StringUtils.isNotBlank(s)) {
                preparedStatement.setString(i, MCryptUtils.encrypt(s));
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        } catch (Exception e) {
            log.error("LenjoyMetaCryptHandler encrypt error, preparedStatement:{},i: {}, s: {}", preparedStatement, i, s, e);
        }
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String resStr = resultSet.getString(s);
        try {
            if (StringUtils.isNotBlank(resStr)) {
                resStr = MCryptUtils.decrypt(resStr);
            }
        } catch (Exception e) {
            log.error("LenjoyMetaCryptHandler decrypt error, resultSet:{}, s: {}", resultSet, s, e);
        }

        return resStr;
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String resStr = resultSet.getString(i);
        try {
            if (StringUtils.isNotBlank(resStr)) {
                resStr = MCryptUtils.decrypt(resStr);
            }
        } catch (Exception e) {
            log.error("LenjoyMetaCryptHandler decrypt error, resultSet:{}, i: {}", resultSet, i, e);
        }
        return resStr;
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String resStr = callableStatement.getString(i);
        try {
            if (StringUtils.isNotBlank(resStr)) {
                resStr = MCryptUtils.decrypt(resStr);
            }
        } catch (Exception e) {
            log.error("LenjoyMetaCryptHandler decrypt error, callableStatement:{}, i: {}", callableStatement, i, e);
        }
        return resStr;
    }
}
