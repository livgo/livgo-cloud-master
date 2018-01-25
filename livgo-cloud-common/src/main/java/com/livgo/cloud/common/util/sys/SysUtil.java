package com.livgo.cloud.common.util.sys;

import com.livgo.cloud.common.util.date.DateUtil;
import com.livgo.cloud.common.util.log.LogUtil;
import com.livgo.cloud.common.util.valid.ValidUtil;
import com.sun.management.OperatingSystemMXBean;
import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * Description:系统工具类
 * Author:     gaocl
 * Date:       2017/12/20
 * Version:    V1.0.0
 * Update:     更新说明
 */
public final class SysUtil extends SystemUtils {
    private final static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    /***** Java运行时环境信息 *****/
    // Java 运行时环境规范名称
    public final static String SPECIFICATION_NAME = System.getProperty("java.specification.name");
    // Java 运行时环境版本
    public final static String VERSION = System.getProperty("java.version");
    // Java 运行时环境规范版本
    public final static String SPECIFICATION_VERSION = System.getProperty("java.specification.version");
    // Java 运行时环境供应商
    public final static String VENDOR = System.getProperty("java.vendor");
    // Java 运行时环境规范供应商
    public final static String SPECIFICATION_VENDOR = System.getProperty("java.specification.vendor");
    // Java 供应商的 URL
    public final static String VENDOR_URL = System.getProperty("java.vendor.url");
    // Java 安装目录
    public final static String HOME = System.getProperty("java.home");
    // 加载库时搜索的路径列表
    public final static String LIBRARY_PATH = System.getProperty("java.library.path");
    // 默认的临时文件路径
    public final static String TMPDIR = System.getProperty("java.io.tmpdir");
    // 要使用的 JIT 编译器的名称
    public final static String COMPILER = System.getProperty("java.compiler");
    // 一个或多个扩展目录的路径
    public final static String EXT_DIRS = System.getProperty("java.ext.dirs");

    /***** Java虚拟机信息 *****/
    // Java 虚拟机实现名称
    public final static String JVM_NAME = System.getProperty("java.vm.name");
    // Java 虚拟机规范名称
    public final static String JVM_SPECIFICATION_NAME = System.getProperty("java.vm.specification.name");
    // Java 虚拟机实现版本
    public final static String JVM_VERSION = System.getProperty("java.vm.version");
    // Java 虚拟机规范版本
    public final static String JVM_SPECIFICATION_VERSION = System.getProperty("java.vm.specification.version");
    // Java 虚拟机实现供应商
    public final static String JVM_VENDEOR = System.getProperty("java.vm.vendor");
    // Java 虚拟机规范供应商
    public final static String VM_SPECIFICATION_VENDOR = System.getProperty("java.vm.specification.vendor");
    // Java 虚拟机编码
    public final static String JVM_ENCODING = System.getProperty("file.encoding");
    // Java 虚拟机临时目录
    public final static String JVM_TEMPDIR = System.getProperty("java.io.tmpdir");

    /***** Java类信息 *****/
    // Java 类格式版本号
    public final static String CLASS_VERSION = System.getProperty("java.class.version");
    // Java 类路径
    public final static String CLASS_PATH = System.getProperty("java.class.path");

    /***** OS信息 *****/
    // 操作系统的名称
    public final static String OS_NAME = System.getProperty("os.name");
    // 操作系统的架构
    public final static String OS_ARCH = System.getProperty("os.arch");
    // 操作系统的版本
    public final static String OS_VERSION = System.getProperty("os.version");
    // 操作系统类型
    public final static String SUN_DESKTOP = System.getProperty("sun.desktop");
    // 文件分隔符（在 UNIX 系统中是“/”）
    public final static String FILE_SEPRATOR = System.getProperty("file.separator");
    // 路径分隔符（在 UNIX 系统中是“:”）
    public final static String PATH_SEPRATOR = System.getProperty("path.separator");
    // 行分隔符（在 UNIX 系统中是“\n”）
    public final static String LINE_SEPRATOR = System.getProperty("line.separator");

    /***** 用户信息 *****/
    // 用户的账户名称
    public final static String USER_NAME = System.getProperty("user.name");
    // 用户的主目录
    public final static String USER_HOME = System.getProperty("user.home");
    // 用户的当前工作目录
    public final static String USER_DIR = System.getProperty("user.dir");
    // 用户的国家
    public final static String USER_COUNTRY = System.getProperty("user.country") == null ? System.getProperty("user.region") : System.getProperty("user.country");
    // 用户的语种
    public final static String USER_LANGUAGE = System.getProperty("user.language");
    // 用户的时区
    public final static String USER_TIMEZONE = System.getProperty("user.timezone");

    //主机IP
    public static String HOST_IP;
    //主机名
    public static String HOST_NAME;
    private static OperatingSystemMXBean osMXBean;
    private final static int kb = 1024;

    static {
        try {

            InetAddress addr = InetAddress.getLocalHost();
            HOST_NAME = addr.getHostName();
            Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface netint : Collections.list(nets)) {
                if (null != netint.getHardwareAddress()) {
                    List<InterfaceAddress> list = netint.getInterfaceAddresses();
                    for (InterfaceAddress interfaceAddress : list) {
                        InetAddress ip = interfaceAddress.getAddress();
                        if (ip instanceof Inet4Address) {
                            HOST_IP += interfaceAddress.getAddress().toString();
                        }
                    }
                }
            }
            HOST_IP = HOST_IP.replaceAll("null", "");

            osMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        } catch (Exception e) {
            LogUtil.error(logger, e);
        }
    }


    /**
     * 总物理内存
     */
    public final static long totalMem() {
        if (ValidUtil.isNotEmpty(osMXBean)) {
            return osMXBean.getTotalPhysicalMemorySize() / kb;
        }
        return 0;
    }

    /**
     * 已使用的物理内存
     */
    public final static long usedMem() {
        if (ValidUtil.isNotEmpty(osMXBean)) {
            return (osMXBean.getTotalPhysicalMemorySize() - osMXBean.getFreePhysicalMemorySize()) / kb;
        }
        return 0;
    }

    /**
     * JVM内存总量
     */
    public final static long JVMTotalMem() {
        return Runtime.getRuntime().totalMemory() / kb;
    }

    /**
     * JVM空闲内存量
     */
    public final static long JVMFreeMem() {
        return Runtime.getRuntime().freeMemory() / kb;
    }

    /**
     * JVM使用最大内存量
     */
    public final static long JVMMaxMem() {
        return Runtime.getRuntime().maxMemory() / kb;
    }

    /**
     * 获取当前进程 PID
     *
     * @return 当前进程 ID
     */
    public static long getCurrentPID() {
        return Long.parseLong(ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);
    }


    /**
     * 添加系统属性
     *
     * @param key
     * @param value
     */
    public static void setProperty(String key, String value) {
        System.setProperty(key, value);
    }

    /**
     * 获取系统属性
     *
     * @param key
     * @return
     */
    public static String getProperty(String key) {
        return System.getProperty(key);
    }
}
