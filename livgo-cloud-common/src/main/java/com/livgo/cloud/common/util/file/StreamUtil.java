package com.livgo.cloud.common.util.file;

import com.livgo.cloud.common.Const;
import com.livgo.cloud.common.util.valid.ValidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * 流相关的操作方法封装
 */
public final class StreamUtil {
    private final static Logger logger = LoggerFactory.getLogger(StreamUtil.class);

    /**
     * Read an input stream into a string
     */
    public final static String streamToString(InputStream is) throws IOException {
        try {
            StringBuffer out = new StringBuffer();
            byte[] b = new byte[Const.BUFFER_SIZE];
            for (int n; (n = is.read(b)) != -1; ) {
                out.append(new String(b, 0, n));
            }
            return out.toString();
        } finally {
            if (ValidUtil.isNotEmpty(is)) {
                is.close();
            }
        }
    }

    /**
     * Read an input stream into a byte[]
     */
    public final static byte[] stream2Byte(InputStream is) throws IOException {
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            int len = 0;
            byte[] b = new byte[Const.BUFFER_SIZE];
            while ((len = is.read(b, 0, b.length)) != -1) {
                baos.write(b, 0, len);
            }
            byte[] buffer = baos.toByteArray();
            return buffer;
        } finally {
            if (ValidUtil.isNotEmpty(is)) {
                is.close();
            }
            if (ValidUtil.isNotEmpty(baos)) {
                baos.close();
            }
        }

    }

    /**
     * @方法功能 InputStream 转为 byte
     */
    public final static byte[] inputStream2Byte(InputStream is) throws IOException {
        try {
            int count = 0;
            while (count == 0) {
                count = is.available();
            }
            byte[] b = new byte[count];
            is.read(b);
            return b;
        } finally {
            if (ValidUtil.isNotEmpty(is)) {
                is.close();
            }
        }
    }

    /**
     * @return InputStream
     * @throws Exception
     * @方法功能 byte 转为 InputStream
     */
    public final static InputStream byte2InputStream(byte[] b) {
        return new ByteArrayInputStream(b);
    }

    /**
     * 将流另存为文件
     */
    public final static void streamSaveAsFile(InputStream is, File outfile) throws IOException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(outfile);
            byte[] buffer = new byte[Const.BUFFER_SIZE];
            int len;
            while ((len = is.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
        } finally {
            if (ValidUtil.isNotEmpty(is)) {
                is.close();
            }
            if (ValidUtil.isNotEmpty(fos)) {
                fos.close();
            }
        }
    }


}
