import com.livgo.cloud.common.util.date.DateUtil;
import com.livgo.cloud.common.util.tip.TipUtil;
import org.junit.Test;

/**
 * Description:
 * Author:     gaocl
 * Date:       2017/12/21
 * Version:    V1.0.0
 * Update:     更新说明
 */
public class TipUtilTest {

    @Test
    public void test() {
        long beginTime = DateUtil.getCurTimeMillis();
        System.out.println(TipUtil.get("tip.demo.key"));
        long endTime = DateUtil.getCurTimeMillis();
        System.out.println("耗时：" + (endTime - beginTime));
    }

}
