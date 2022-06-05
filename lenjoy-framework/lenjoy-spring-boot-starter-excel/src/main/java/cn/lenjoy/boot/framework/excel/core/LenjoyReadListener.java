package cn.lenjoy.boot.framework.excel.core;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @description: ReadListener 模板读取类
 * 通过回调，内存回收
 * 批次缓存并操作数据
 *
 * @author: lenjoy's bincloud,mvpzhou
 * @date: Create By lenjoy's bincloud,mvpzhou on 2022 06 05 星期日
 * @version: 1.0.0
 */
@Slf4j
public abstract class LenjoyReadListener<T> implements ReadListener<T> {

    /**
     * 批次处理数据条数
     */
    private static final int BATCH_COUNT = 500;

    /**
     * 处理数据总条数
     */
    private int totalCount = 0;

    /**
     * 批次处理数据缓存
     */
    private List<T> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    @Override
    public void invoke(T data, AnalysisContext context) {
        log.info("解析一条数据: {}", JSON.toJSONString(data));
        cachedDataList.add(data);
        // 批次操作，防止OOM
        if (cachedDataList.size() >= BATCH_COUNT) {
            // 批次操作数据
            operateData();
            // 清理缓存数据
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 批次操作数据
        operateData();
        log.info("解析所有数据成功");
    }

    /**
     * 代理操作
     */
    private void operateData() {
        log.info("{}条数据,开始操作数据", cachedDataList.size());
        invokeMethod(cachedDataList);
        log.info("操作一条数据成功");
    }

    /**
     * 数据操作，每一批次数据操作
     * @param cachedDataList 批次缓存数据列表
     */
    public abstract void invokeMethod(List<T> cachedDataList);

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getCachedDataList() {
        return cachedDataList;
    }

    public void setCachedDataList(List<T> cachedDataList) {
        this.cachedDataList = cachedDataList;
    }
}
