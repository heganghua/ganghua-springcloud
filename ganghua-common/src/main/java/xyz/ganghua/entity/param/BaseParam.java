package xyz.ganghua.entity.param;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;
import xyz.ganghua.entity.po.BasePo;

import java.util.Date;

@Data
public class BaseParam<T extends BasePo> {

    private Date createdTimeStart;
    private Date createdTimeEnd;

    /**
     * 基础查询条件
     *
     * @return QueryWrapper<T>
     */
    public QueryWrapper<T> build() {

        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge(null != this.createdTimeStart, "created_time", this.createdTimeStart)
                .le(null != this.createdTimeEnd, "created_time", this.createdTimeEnd);
        return queryWrapper;
    }
}
