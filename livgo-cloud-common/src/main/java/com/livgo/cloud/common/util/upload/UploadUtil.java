package com.livgo.cloud.common.util.upload;

import com.livgo.cloud.common.Const;
import com.livgo.cloud.common.util.file.FileUtil;
import com.livgo.cloud.common.util.lang.UUIDUtil;
import com.livgo.cloud.common.util.pk.PKUtil;
import com.livgo.cloud.common.util.sys.SysUtil;
import com.livgo.cloud.common.util.valid.ValidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Description:上传文件工具类
 * Author:     gaocl
 * Date:       2017/12/20
 * Version:    V1.0.0
 * Update:     更新说明
 */
public final class UploadUtil {
    private final static Logger logger = LoggerFactory.getLogger(UploadUtil.class);

    /**
     * 上传文件
     * 请自行判断文件有效性
     *
     * @param file 文件
     * @param path 存储目录
     * @return
     * @throws IOException
     */
    public static boolean upload(MultipartFile file, String path) throws IOException {

        if (ValidUtil.isEmpty(file)) {
            return false;
        }

        String suffix = FileUtil.getSuffix(file);
        String fileName = createFileName(suffix);
        return upload(file, path, fileName);
    }

    /**
     * 上传文件
     * 请自行判断文件有效性
     *
     * @param file     文件
     * @param path     存储目录
     * @param fileName 指定文件名
     * @return
     * @throws IOException
     */
    public static boolean upload(MultipartFile file, String path, String fileName) throws IOException {

        if (ValidUtil.isEmpty(file)) {
            return false;
        }

        FileUtil.createDir(path);

        String fpath = path + SysUtil.FILE_SEPRATOR + fileName;
        File f = new File(fpath);
        file.transferTo(f);
        return true;
    }

    /**
     * 上传文件
     * 请自行判断文件有效性
     *
     * @param is       输入流
     * @param path     存储目录
     * @param fileName 文件名
     * @return
     * @throws IOException
     */
    public static boolean upload(InputStream is, String path, String fileName) throws IOException {
        if (ValidUtil.isEmpty(path)) {
            return false;
        }

        FileUtil.createDir(path);

        String fpath = path + SysUtil.FILE_SEPRATOR + fileName;
        File f = new File(fpath);
        FileUtil.write(f, is);
        return true;
    }

    /**
     * 生成随机文件名
     *
     * @return
     */
    public static String createFileName() {
        return UUIDUtil.get32UUID();
    }

    /**
     * 生成指定后缀的随机文件名
     *
     * @param suffix 后缀，不带.
     * @return
     */
    public static String createFileName(String suffix) {
        return createFileName() + Const.SUFFIX_SEPRATOR + suffix;
    }

    /**
     * 生成指定后缀的有序文件名
     *
     * @param suffix  后缀，不带.
     * @param seqFlag 是否有序
     * @return
     */
    public static String createFileName(String suffix, boolean seqFlag) {
        if (seqFlag) {
            return PKUtil.createID20() + Const.SUFFIX_SEPRATOR + suffix;
        }
        return createFileName() + Const.SUFFIX_SEPRATOR + suffix;
    }
}
