package demo;

import com.github.zuihou.model.RemoteData;
import com.github.zuihou.remotedata.annonation.RemoteField;

import java.util.List;

/**
 * 注解 @RemoteField 使用例子
 */
public class RemoteTestDO {
    /**
     * 根据 remoteUpdateUser.key 查询 userServiceImpl.findUserXxx 方法，
     * 并注入到 remoteUpdateUser.data
     */
    @RemoteField(api = "userServiceImpl", method = "findUserXxx")
    protected RemoteData<Long, UserTe> remoteUpdateUser;
    /**
     * 根据 type3 查询 dictionaryItemServiceImpl.findDictionaryItem 方法，
     * 并注入到 type3
     */
    @RemoteField(api = "dictionaryItemServiceImpl", method = "findDictionaryItem")
    protected String type3;
    /**
     * 根据 key(BOSHI) 查询 dictionaryItemServiceImpl.findDictionaryItem 方法，
     * 并注入到 type3
     */
    @RemoteField(key = "BOSHI", api = "dictionaryItemServiceImpl", method = "findDictionaryItem")
    protected String type4;
    /**
     * 递归查询
     */
    @RemoteField
    protected DictionaryItemTe dictionaryItem;
    /**
     * 递归查询
     */
    @RemoteField
    protected List<DictionaryItemTe> dictionaryItems;
    private Long id;
    /**
     * 根据 dictionaryCodeAndName.key 查询 dictionaryItemServiceImpl.findDictionaryItem 方法，
     * 并注入到 dictionaryCodeAndName.data
     */
    @RemoteField(api = "dictionaryItemServiceImpl", method = "findDictionaryItem")
    private RemoteData<String, String> dictionaryCodeAndName;

}

class UserTe {

}

class DictionaryItemTe {
    /**
     * 根据 dictionaryCodeAndName.key 查询 dictionaryItemServiceImpl.findDictionaryItem 方法，
     * 并注入到 dictionaryCodeAndName.data
     */
    @RemoteField(api = "dictionaryItemServiceImpl", method = "findDictionaryItem")
    private RemoteData<String, String> dictionaryCodeAndName;

    /**
     * 注意： 严禁循环依赖！！！！！！！！！！
     * 注意： 严禁循环依赖！！！！！！！！！！
     * 注意： 严禁循环依赖！！！！！！！！！！
     */
//    @RemoteField
    private RemoteTestDO error;
}
