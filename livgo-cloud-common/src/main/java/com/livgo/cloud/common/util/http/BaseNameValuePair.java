package com.livgo.cloud.common.util.http;

import org.apache.http.NameValuePair;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

import java.io.Serializable;

/**
 * Description:
 * Author:     gaocl
 * Date:       2016/12/15
 * Version:     V1.0.0
 * Update:     更新说明
 */
public class BaseNameValuePair implements NameValuePair, Cloneable, Serializable {

    private final static long serialVersionUID = -6437800749411518984L;

    private final String name;
    private final String value;

    public BaseNameValuePair(final String name, final String value) {
        super();
        this.name = Args.notNull(name, "Name");
        this.value = value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        // don't call complex default formatting for a simple toString

        if (this.value == null) {
            return name;
        }
        final int len = this.name.length() + 1 + this.value.length();
        final StringBuilder buffer = new StringBuilder(len);
        buffer.append(this.name);
        buffer.append("=");
        buffer.append(this.value);
        return buffer.toString();
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof NameValuePair) {
            final BaseNameValuePair that = (BaseNameValuePair) object;
            return this.name.equals(that.name)
                    && LangUtils.equals(this.value, that.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.name);
        hash = LangUtils.hashCode(hash, this.value);
        return hash;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
